package view;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import controller.NodeController;
import model.NodeModel;

/**
 * @author Marijn Scholtens
 * This is the nodepanel on which we draw our objects, like the list of nodes
 * Also we create a nodemodel that keeps track of the constellation of nodes
 * And we create a nodescontroller for panel adaptations
 */
@SuppressWarnings("serial")
public class NodePanel extends JPanel implements Observer {
	
	private NodeModel nodeModel = null;
	private NodeController nodeController;
	private int fontSize = 14;
	private String fontType = "Arial";
	
	public NodePanel(NodeModel nodeModel) {
		setNodeModel(nodeModel);
		nodeController = new NodeController(nodeModel);
		setNodeController(nodeController);
	}
	
	public void setNodeController(NodeController mousec) {
		this.addMouseListener(mousec);
		this.addMouseMotionListener(mousec);
	}
	
	public void setNodeModel(NodeModel nodeModel) {
		if(this.nodeModel != null) {
			this.nodeModel.deleteObserver(this);
		}
		this.nodeModel = nodeModel;
		this.nodeModel.addObserver(this);
	}
	
	public NodeModel getNodeModel() {
		return nodeModel;
	}
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		int x = 30;
		int y = 30;
		
		String nodeMainText = "Nodes:";
		g.setFont(new Font(fontType, Font.PLAIN, fontSize));
		g.drawString(nodeMainText, x, y);
	}
	
	public void update(Observable arg0, Object arg1) {
    	repaint();
    }
}
