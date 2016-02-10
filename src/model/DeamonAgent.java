package model;

/**
 * @author Marijn Scholtens
 * This is a deamonagent, i.e. agents that can be invoked for supportive purposes
 */
public class DeamonAgent extends Agent {

	public DeamonAgent() {}
	
	public DeamonAgent(String name, String file) {
		setDeamon();
		setName(name);
		setFile(file);
	}
}
