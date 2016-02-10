package model;

/**
 * @author Marijn Scholtens
 * This is an actoragent, i.e. agents that can be invoked for metrics and code analysis
 */
public class ActorAgent extends Agent {
	
	public ActorAgent() {}
	
	public ActorAgent(String name, String file) {
		setActor();
		setName(name);
		setFile(file);
	}
}
