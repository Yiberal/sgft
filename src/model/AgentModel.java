package model;
import java.util.ArrayList;
import java.util.Observable;

import main.AgentConstants;
import plugins.FindBugsAgent;
import view.UserInterface;

/**
 * @author Marijn Scholtens
 * This is the agentmodel that contains a list of all current agents
 * Also keeps track of several other model properties
 * Create here new agents when adding a new agent and add to the list
 */
public class AgentModel extends Observable implements AgentConstants {
	
	private ArrayList<Agent> agents;
	private NodeModel nodeModel;
	
	public AgentModel() {
		agents = new ArrayList<Agent>();		
		setChanged();
		notifyObservers();
	}
	
	public void setNodeModel(NodeModel nodeModel) {
		this.nodeModel = nodeModel;
		agents.add(new AgentManager(nodeModel));
		agents.add(new UserInterface(nodeModel));
	}
	
	public ArrayList<Agent> getAgents() {
		return agents;
	}
	
	public void addActorAgent(String name, String file) {
		agents.add(new ActorAgent(name, file));
	}
	
	public void addDeamonAgent(String name, String file) {
		agents.add(new DeamonAgent(name, file));
	}
	
	public void addFindBugsAgent(String name, String file) {
		agents.add(new FindBugsAgent(name, file));
	}
	
	public void addAgent(int type, String name, String file) {
		switch(type) {
		case CUSTOMDEAMON: addDeamonAgent(name, file); break;
		case CUSTOMACTOR: addActorAgent(name, file); break;
		case FINDBUGS: addFindBugsAgent(name, file); break;
		}
	}
	
	public void purgeOutputs() {
		for(Agent element : agents) {
			element.clearOutput();
		}
	}
}
