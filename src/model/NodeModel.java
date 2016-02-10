package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Marijn Scholtens
 * This is the nodemodel that contains a list of all current nodes
 * The node at index 0 is always the home-node (current node)
 */
public class NodeModel extends Observable {
	
	public static final int HOME = 0;
	public static final int AWAY = 1;
	public static final int FARAWAY = 2;
	public static final int OFFLINE = 3;
	public static final int HOMENODE = 0;
	ArrayList<Node> nodes;
	
	public NodeModel() {		
		nodes = new ArrayList<Node>();
		nodes.add(new Node(HOME));
		nodes.get(HOMENODE).setNodeModel(this);
		setChanged();
		notifyObservers();
	}
	
	public void addAwayNode() {
		nodes.add(new Node(AWAY));
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public Node getHomeNode() {
		return nodes.get(HOMENODE);
	}
}
