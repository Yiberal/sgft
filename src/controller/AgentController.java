package controller;

import java.awt.event.MouseAdapter;
import model.AgentModel;

/**
 * @author Marijn Scholtens
 * The agentcontroller is used for simulating the agents
 */
public class AgentController extends MouseAdapter {
	
	private AgentModel agentModel;
	
	public AgentController(AgentModel agentModel) {
		this.agentModel = agentModel;
	}
}
