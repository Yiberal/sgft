package controller;

import java.awt.event.MouseAdapter;
import model.NodeModel;

/**
 * @author Marijn Scholtens
 * The nodecontroller is used for simulating the nodes
 */
public class NodeController extends MouseAdapter {
	
	private NodeModel nodeModel;
	
	public NodeController(NodeModel nodeModel) {
		this.nodeModel = nodeModel;
	}
}
