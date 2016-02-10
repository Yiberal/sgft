package view;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Agent;
import model.AgentModel;
import controller.AgentController;
import main.AgentConstants;

/**
 * @author Marijn Scholtens
 * This is the agentpanel on which we draw our objects, like the list of agents
 * Also we create an agentmodel that keeps track of the constellation of agents
 * And we create an agentcontroller for panel adaptations
 */
@SuppressWarnings("serial")
public class AgentPanel extends JPanel implements Observer, AgentConstants {
	
	private AgentModel agentModel = null;
	private AgentController agentController;
	
	public AgentPanel(AgentModel agentModel) {
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
	
	public AgentModel getAgentModel() {
		return agentModel;
	}
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		int x = 30;
		int y = 30;
		int i;
		
		// paint overhead
		String agentMainText = "Agents:";
		g.setFont(new Font(fontType, Font.PLAIN, fontSize));
		g.drawString(agentMainText, x, y);
		
		// paint agents
		ArrayList<Agent> agents = agentModel.getAgents();
		if(!agents.isEmpty()) {
			g.setFont(new Font(fontType, Font.BOLD, fontSize));
			y = 60;
			x = 30;
			g.drawString("ID", x, y);
			x = 60;
			g.drawString("Agent Name", x, y);
			x = 300;
			g.drawString("Maintype", x, y);
			x = 380;
			g.drawString("Subtype", x, y);
			x = 500;
			g.drawString("Remove?", x, y);
			x = 580;
			g.drawString("Enable/Disable", x, y);
		
			g.setFont(new Font(fontType, Font.PLAIN, fontSize));
			y = 80;
			i = 1;
			for(Agent element : agents) {
				x = 30;
				g.drawString((i + "."), x, y);
				x = 60;
				g.drawString(element.getName(), x, y);
				x = 300;
				if(element.getMainType() == ACTOR) {
					g.drawString("Actor", x, y);
				} else {
					g.drawString("Deamon", x, y);
				}
				x = 380;
				switch(element.getSubType()) {
					case AGENTMANAGER: g.drawString("Agent Manager", x, y); break;
					case USERINTERFACE: g.drawString("User Interface", x, y); break;
					case FINDBUGS: g.drawString("FindBugs", x, y); break;
					case CUSTOM: g.drawString("Custom", x, y); break;
				}
				x = 500;
				g.drawString("X", x, y);
				x = 580;
				if(element.getStatus()) {
					g.drawString("Disable", x, y);
				} else {
					g.drawString("Enable", x, y);
				}
				++i;
				y += fontSpace;
			}
		}
	}
	
	public void update(Observable arg0, Object arg1) {
    	repaint();
    	
    }
}
