package view;
import model.DeamonAgent;
import model.NodeModel;

public class UserInterface extends DeamonAgent {

	public UserInterface(NodeModel nodeModel) {
		setName("User Interface");
		setUserInterface();
		new NodeClientFrame(nodeModel);
	}
}
