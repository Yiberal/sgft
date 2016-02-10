package model;

/**
 * @author Marijn Scholtens
 * This is a node which contains an agentmodel and a database
 * The node at index 0 is always the home-node (current node)
 */
public class Node {
	
	public static final int HOME = 0;
	public static final int AWAY = 1;
	public static final int FARAWAY = 2;
	public static final int OFFLINE = 3;
	private int location;
	private Database database;
	private AgentModel agentModel;
	private NodeModel nodeModel;
	
	public Node(int location) {
		this.location = location;
	}
	
	public void setNodeModel(NodeModel nodeModel) {
		this.nodeModel = nodeModel;
		if(location == HOME) {
			database = new Database();
			agentModel = new AgentModel();
			agentModel.setNodeModel(nodeModel);
		}
	}

	public int getLocation() {
		return location;
	}
	
	public AgentModel getAgentModel() {
		return agentModel;
	}
}
