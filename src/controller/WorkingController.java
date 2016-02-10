package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import main.AgentConstants;
import model.Agent;
import model.NodeModel;

public class WorkingController extends MouseAdapter implements AgentConstants {
	
	private NodeModel nodeModel;
	
	public WorkingController(NodeModel nodeModel) {
		this.nodeModel = nodeModel;
	}
	
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		int index = 0;
		
			if(SwingUtilities.isLeftMouseButton(e) && !e.isConsumed()) {
				e.consume();
				for(Agent element : nodeModel.getHomeNode().getAgentModel().getAgents()) {
					if(element.contains(p, index, workingX, workingY, recWidth)) {
						nodeModel.getHomeNode().getAgentModel().purgeOutputs();
						element.runAgent();
					}
					++index;
				}
			}
			
		Component source = (Component)e.getSource();
		source.repaint();
	}
}
