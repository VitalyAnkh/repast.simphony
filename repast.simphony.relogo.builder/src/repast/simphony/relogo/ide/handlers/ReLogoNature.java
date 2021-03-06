/**
 * 
 */
package repast.simphony.relogo.ide.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import repast.simphony.relogo.builder.Activator;

/**
 * ReLogo nature that loads the builder for ReLogo.
 * 
 * @author Nick Collier
 * @author jozik
 */
public class ReLogoNature implements IProjectNature {
  
  public static final String RELOGO_NATURE_ID = Activator.PLUGIN_ID + ".relogo_nature";
  
  private IProject project;

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#configure()
   */
  @Override
  public void configure() throws CoreException {
    IProjectDescription desc = project.getDescription();
    ICommand[] commands = desc.getBuildSpec();
    for (int i = 0; i < commands.length; ++i)
       if (commands[i].getBuilderName().equals(ReLogoBuilder.RELOGO_BUILDER))
          return;
    //add builder to project
    ICommand command = desc.newCommand();
    command.setBuilderName(ReLogoBuilder.RELOGO_BUILDER);
    ICommand[] nc = new ICommand[commands.length + 1];
    // Add it before other builders.
    System.arraycopy(commands, 0, nc, 1, commands.length);
    nc[0] = command;
    desc.setBuildSpec(nc);
    project.setDescription(desc, null);
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#deconfigure()
   */
  @Override
  public void deconfigure() throws CoreException {
    IProjectDescription desc = project.getDescription();
    ICommand[] commands = desc.getBuildSpec();
    List<ICommand> newCommands = new ArrayList<ICommand>();
    for (int i = 0; i < commands.length; ++i) {
       if (!commands[i].getBuilderName().equals(ReLogoBuilder.RELOGO_BUILDER)) {
         newCommands.add(commands[i]);
       }
    }
    //add all builders but the statechart builder to the project
    desc.setBuildSpec(newCommands.toArray(new ICommand[0]));
    project.setDescription(desc, null);
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#getProject()
   */
  @Override
  public IProject getProject() {
    return project;
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
   */
  @Override
  public void setProject(IProject project) {
    this.project = project;
  }
}
