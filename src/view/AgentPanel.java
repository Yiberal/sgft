package view;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.AgentModel;
import controller.AgentController;

/**
 * @author Marijn Scholtens
 * This is the agentpanel on which we draw our objects, like the list of agents
 * Also we create an agentmodel that keeps track of the constellation of agents
 * And we create an agentcontroller for panel adaptations
 */
@SuppressWarnings("serial")
public class AgentPanel extends JPanel implements Observer {
	
	private AgentModel agentModel = null;
	private AgentController agentController;
	private int fontSize = 14;
	private String fontType = "Arial";
	
	public AgentPanel() {
		agentModel = new AgentModel();
		setAgentModel(agentModel);
		agentController = new AgentController(agentModel);
		setAgentController(agentController);
	}
	
	public void setAgentController(AgentController mousec) {
		this.addMouseListener(mousec);
		this.addMouseMotionListener(mousec);
	}
	
	public void setAgentModel(AgentModel agentModel) {
		if(this.agentModel != null) {
			this.agentModel.deleteObserver(this);
		}
		this.agentModel = agentModel;
		this.agentModel.addObserver(this);
	}
	
	public AgentModel getDeviceModel() {
		return agentModel;
	}
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		int x = 30;
		int y = 30;
		
		String agentMainText = "Agents:";
		g.setFont(new Font(fontType, Font.PLAIN, fontSize));
		g.drawString(agentMainText, x, y);
	}
	
	public void update(Observable arg0, Object arg1) {
    	repaint();
    }
}
