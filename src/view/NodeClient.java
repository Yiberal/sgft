package view;

/**
 * @author Marijn Scholtens
 * This is the main class of the node client where the client is started and the frame launched
 */
public class NodeClient {
	
	public NodeClient() {
		new NodeClientFrame();
	}

	public static void main(String[] args) {
		new NodeClient();
	}

}
