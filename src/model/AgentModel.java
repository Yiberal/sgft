package model;

import java.util.Observable;

/**
 * @author Marijn Scholtens
 * This is the agentmodel that contains a list of all current agents
 * Also keeps track of several other model properties
 * Create here new agents when adding a new agent and add to the list
 */
public class AgentModel extends Observable {
	
	public AgentModel() {
		setChanged();
		notifyObservers();
	}
}
