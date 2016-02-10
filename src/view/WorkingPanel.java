package view;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import controller.WorkingController;
import main.AgentConstants;
import model.Agent;
import model.NodeModel;

/**
 * @author Marijn Scholtens
 * This is the working panel on which user interaction is performed
 */
@SuppressWarnings("serial")
public class WorkingPanel extends JPanel implements Observer, AgentConstants {
	
	private NodeModel nodeModel = null;
	private WorkingController workingController;
	private int fontSize = 14;
	private String fontType = "Arial";
	
	public WorkingPanel(NodeModel nodeModel) {
		setNodeModel(nodeModel);
		workingController = new WorkingController(nodeModel);
		setWorkingController(workingController);
	}
	
	public void setWorkingController(WorkingController mousec) {
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
		int i;
		
		String workerMainText = "Working Panel:";
		g.setFont(new Font(fontType, Font.PLAIN, fontSize));
		g.drawString(workerMainText, x, y);
		
		ArrayList<Agent> agents = nodeModel.getHomeNode().getAgentModel().getAgents();
		if(!agents.isEmpty()) {
			g.setFont(new Font(fontType, Font.BOLD, fontSize));
			y = 60;
			x = 30;
			g.drawString("ID", x, y);
			x = 60;
			g.drawString("Agent Name", x, y);
			x = 300;
			g.drawString("Run", x, y);
		
			g.setFont(new Font(fontType, Font.PLAIN, fontSize));
			y = 80;
			i = 1;
			
			for(Agent element : agents) {
				x = 30;
				g.drawString((i + "."), x, y);
				x = 60;
				g.drawString(element.getName(), x, y);
				x = 300;
				if(element.getSubType() >= 2) {
					g.drawString("RUN", x, y);
				}				
				y += fontSpace;
				++i;
			}
			
			x = 30;
			y += fontSpace;
			for(Agent element : agents) {
				if(!element.getOutputData().isEmpty()) {
					for(String line : element.getOutputData()) {
						g.drawString(line, x, y);
						y += fontSpace;
					}
				}
			}
		}		
	}
	
	public void update(Observable arg0, Object arg1) {
    	repaint();
    }
}
