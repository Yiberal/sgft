package main;

import model.NodeModel;

/**
 * @author Marijn Scholtens
 * This is the main class of the node client where the client is started and the node model created
 */
public class NodeClient {
	
	public NodeClient() {
		new NodeModel();
	}

	public static void main(String[] args) {
		new NodeClient();
	}

}
