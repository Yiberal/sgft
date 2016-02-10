package model;

public class AgentManager extends DeamonAgent {
	
	/**
	 * @author Marijn Scholtens
	 * This is the static deamon agent AgentManager which manages all agents
	 */
	public AgentManager(NodeModel nodeModel) {
		setName("Agent Manager");
		setAgentManager();
	}
}
