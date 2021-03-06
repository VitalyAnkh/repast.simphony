/**
 * 
 */
package repast.simphony.batch.ssh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import repast.simphony.batch.BatchConstants;
import repast.simphony.batch.RunningStatus;
import repast.simphony.util.FileUtils;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

/**
 * Copies copies any failure and warn status messages from a remote
 * to a specified directory. 
 * 
 * @author Nick Collier
 */
public class RemoteStatusCopier {
  
  public void run(RemoteSession remote, String remoteDir, String outDir) throws StatusException {
    SSHSession session = null;
    try {
      session = SSHSessionFactory.getInstance().create(remote);
      List<File> filesToCopy = new ArrayList<File>();
      for (int i = 1; i <= remote.getInstances(); i++) {
        RunningStatus status = remote.getStatus(i);
        if (status != RunningStatus.OK) {
          String dir = new File(remoteDir,  BatchConstants.INSTANCE_DIR_PREFIX + i).getPath().replace("\\", "/");
          List<String> ls = session.listRemoteDirectory(dir);
          for (String fname : ls) {
            // check the filename and ignore the path
            File f = new File(fname);
            if (f.getName().startsWith(RunningStatus.FAILURE.toString()) || f.getName().startsWith(RunningStatus.WARN.toString())) {
              filesToCopy.add(f);
            }
          }
        }
      }
      
      //String tmp = System.getProperty("java.io.tmpdir");
      Path tmp = Files.createTempDirectory(null);
      List<File> copiedFiles = session.copyFilesFromRemote(tmp.toFile().getPath(), filesToCopy, false);
      String prefix = remote.getUser() + "_" + remote.getHost();
      for (File file : copiedFiles) {
        String fname = file.getName();
        String status = fname.contains(RunningStatus.FAILURE.toString()) ? "_failure" : "_warn";
        int instance = Integer.parseInt(fname.substring(fname.indexOf("_") + 1, fname.length()));
        File newFile = new File(outDir, prefix + "_" + instance + status + ".txt");
        FileUtils.copyFile(file, newFile);
      }
      
    } catch (SftpException e) {
      String msg = String.format("Error while copying instance status files from %s", remote.getId());
      throw new StatusException(msg, e);
      
    } catch (JSchException e) {
      String msg = String.format("Error while creating connection to %s", remote.getId());
      throw new StatusException(msg, e);
   
    } catch (IOException e) {
      String msg = String.format("Error copying status files from temporary directory to %s", outDir);
      throw new StatusException(msg, e);
      
    } finally {
      if (session != null) session.disconnect();
    }
  }

}
