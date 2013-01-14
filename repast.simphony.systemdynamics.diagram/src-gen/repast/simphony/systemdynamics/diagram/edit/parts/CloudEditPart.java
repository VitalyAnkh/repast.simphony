package repast.simphony.systemdynamics.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import repast.simphony.systemdynamics.diagram.edit.policies.CloudItemSemanticEditPolicy;
import repast.simphony.systemdynamics.diagram.providers.SystemdynamicsElementTypes;

/**
 * @generated
 */
public class CloudEditPart extends ShapeNodeEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 2002;

  /**
   * @generated
   */
  protected IFigure contentPane;

  /**
   * @generated
   */
  protected IFigure primaryShape;

  /**
   * @generated
   */
  public CloudEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CloudItemSemanticEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  /**
   * @generated
   */
  protected LayoutEditPolicy createLayoutEditPolicy() {
    org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

      protected EditPolicy createChildEditPolicy(EditPart child) {
        EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (result == null) {
          result = new NonResizableEditPolicy();
        }
        return result;
      }

      protected Command getMoveChildrenCommand(Request request) {
        return null;
      }

      protected Command getCreateCommand(CreateRequest request) {
        return null;
      }
    };
    return lep;
  }

  /**
   * @generated
   */
  protected IFigure createNodeShape() {
    return primaryShape = new CloudFigure();
  }

  /**
   * @generated
   */
  public CloudFigure getPrimaryShape() {
    return (CloudFigure) primaryShape;
  }

  /**
   * @generated
   */
  protected NodeFigure createNodePlate() {
    DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(12, 12);
    return result;
  }

  /**
   * Creates figure for this edit part.
   * 
   * Body of this method does not depend on settings in generation model
   * so you may safely remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */
  protected NodeFigure createNodeFigure() {
    NodeFigure figure = createNodePlate();
    figure.setLayoutManager(new StackLayout());
    IFigure shape = createNodeShape();
    figure.add(shape);
    contentPane = setupContentPane(shape);
    return figure;
  }

  /**
   * Default implementation treats passed figure as content pane.
   * Respects layout one may have set for generated figure.
   * @param nodeShape instance of generated figure class
   * @generated
   */
  protected IFigure setupContentPane(IFigure nodeShape) {
    return nodeShape; // use nodeShape itself as contentPane
  }

  /**
   * @generated
   */
  public IFigure getContentPane() {
    if (contentPane != null) {
      return contentPane;
    }
    return super.getContentPane();
  }

  /**
   * @generated
   */
  protected void setForegroundColor(Color color) {
    if (primaryShape != null) {
      primaryShape.setForegroundColor(color);
    }
  }

  /**
   * @generated
   */
  protected void setBackgroundColor(Color color) {
    if (primaryShape != null) {
      primaryShape.setBackgroundColor(color);
    }
  }

  /**
   * @generated
   */
  protected void setLineWidth(int width) {
    if (primaryShape instanceof Shape) {
      ((Shape) primaryShape).setLineWidth(width);
    }
  }

  /**
   * @generated
   */
  protected void setLineType(int style) {
    if (primaryShape instanceof Shape) {
      ((Shape) primaryShape).setLineStyle(style);
    }
  }

  /**
   * @generated
   */
  public List<IElementType> getMARelTypesOnSource() {
    ArrayList<IElementType> types = new ArrayList<IElementType>(2);
    types.add(SystemdynamicsElementTypes.Rate_4003);
    types.add(SystemdynamicsElementTypes.InfluenceLink_4004);
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
    LinkedList<IElementType> types = new LinkedList<IElementType>();
    if (targetEditPart instanceof repast.simphony.systemdynamics.diagram.edit.parts.CloudEditPart) {
      types.add(SystemdynamicsElementTypes.Rate_4003);
    }
    if (targetEditPart instanceof StockEditPart) {
      types.add(SystemdynamicsElementTypes.Rate_4003);
    }
    if (targetEditPart instanceof VariableEditPart) {
      types.add(SystemdynamicsElementTypes.InfluenceLink_4004);
    }
    if (targetEditPart instanceof repast.simphony.systemdynamics.diagram.edit.parts.CloudEditPart) {
      types.add(SystemdynamicsElementTypes.InfluenceLink_4004);
    }
    if (targetEditPart instanceof StockEditPart) {
      types.add(SystemdynamicsElementTypes.InfluenceLink_4004);
    }
    if (targetEditPart instanceof Variable2EditPart) {
      types.add(SystemdynamicsElementTypes.InfluenceLink_4004);
    }
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
    LinkedList<IElementType> types = new LinkedList<IElementType>();
    if (relationshipType == SystemdynamicsElementTypes.Rate_4003) {
      types.add(SystemdynamicsElementTypes.Cloud_2002);
      types.add(SystemdynamicsElementTypes.Stock_2003);
    } else if (relationshipType == SystemdynamicsElementTypes.InfluenceLink_4004) {
      types.add(SystemdynamicsElementTypes.Variable_2001);
      types.add(SystemdynamicsElementTypes.Cloud_2002);
      types.add(SystemdynamicsElementTypes.Stock_2003);
      types.add(SystemdynamicsElementTypes.Variable_2004);
    }
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMARelTypesOnTarget() {
    ArrayList<IElementType> types = new ArrayList<IElementType>(2);
    types.add(SystemdynamicsElementTypes.Rate_4003);
    types.add(SystemdynamicsElementTypes.InfluenceLink_4004);
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMATypesForSource(IElementType relationshipType) {
    LinkedList<IElementType> types = new LinkedList<IElementType>();
    if (relationshipType == SystemdynamicsElementTypes.Rate_4003) {
      types.add(SystemdynamicsElementTypes.Cloud_2002);
      types.add(SystemdynamicsElementTypes.Stock_2003);
    } else if (relationshipType == SystemdynamicsElementTypes.InfluenceLink_4004) {
      types.add(SystemdynamicsElementTypes.Variable_2001);
      types.add(SystemdynamicsElementTypes.Cloud_2002);
      types.add(SystemdynamicsElementTypes.Stock_2003);
      types.add(SystemdynamicsElementTypes.Variable_2004);
    }
    return types;
  }

  /**
   * @generated
   */
  public class CloudFigure extends Ellipse {

    /**
     * @generated
     */
    public CloudFigure() {
      this.setLineStyle(Graphics.LINE_DASH);
      this.setPreferredSize(new Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(12)));
      this.setMaximumSize(new Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(12)));
      this.setMinimumSize(new Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(12)));
    }

  }

}