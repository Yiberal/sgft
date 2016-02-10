package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.AgentConstants;
import model.NodeModel;

/**
 * @author Marijn Scholtens
 * Here we initialize the frame of the nodeclient and build the panel
 */
@SuppressWarnings("serial")
public class NodeClientFrame extends JFrame implements AgentConstants {
	
	private String agentName;
	private int agentType;
	private String agentFile;
	
	private AgentPanel agentPanel;
	private NodePanel nodePanel;
	private WorkingPanel workingPanel;
	private AbstractAction newNodesAction;
	private AbstractAction saveNodesAction;
	private AbstractAction loadNodesAction;
	private AbstractAction quitNodesAction;
	private AbstractAction addAgentAction;
	private AbstractAction removeAgentAction;
	private AbstractAction addNodeAction;
	private AbstractAction removeNodeAction;
	private AbstractAction viewAgentsAction;
	private AbstractAction viewNodesAction;
	private AbstractAction viewWorkingAction;
	private AbstractAction showAboutAction;
	
	private JPanel contentPane;
	private CardLayout cardLayout;
	private final int width = 700;
	private final int height = 700;
	private NodeModel nodeModel;
	
	public NodeClientFrame(NodeModel nodeModel) {
		this.nodeModel = nodeModel;
		initGUI();
	}
	
	private void initGUI() {
    	this.setFocusable(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(width, height);
    	this.setResizable(false);
    	this.setTitle("Software Governance Framework Tool");
    	
    	contentPane = new JPanel();
    	contentPane.setBackground(Color.decode("#B6B6B6"));
    	cardLayout = new CardLayout();
    	contentPane.setLayout(cardLayout);
    	
    	agentPanel = new AgentPanel(nodeModel.getHomeNode().getAgentModel());
    	contentPane.add(agentPanel, "Agent Panel");
    	nodePanel = new NodePanel(nodeModel);
    	contentPane.add(nodePanel, "Node Panel");
    	workingPanel = new WorkingPanel(nodeModel);
    	contentPane.add(workingPanel, "Working Panel");
    	cardLayout.show(contentPane, "Working Panel");
    	
    	initActions();
    	
    	JMenuBar menuBar = new JMenuBar();
    	JMenu menu1 = new JMenu("File");
    	JMenu menu2 = new JMenu("Agents");
    	JMenu menu3 = new JMenu("Nodes");
    	JMenu menu4 = new JMenu("View");
    	JMenu menu5 = new JMenu("Help");
    	menuBar.add(menu1);
    	menuBar.add(menu2);
    	menuBar.add(menu3);
    	menuBar.add(menu4);
    	menuBar.add(menu5);
    	
    	menu1.add(this.newNodesAction);
    	menu1.add(this.saveNodesAction);
    	menu1.add(this.loadNodesAction);
    	menu1.add(this.quitNodesAction);
    	menu2.add(this.addAgentAction);
    	menu2.add(this.removeAgentAction);
    	menu3.add(this.addNodeAction);
    	menu3.add(this.removeNodeAction);
    	menu4.add(this.viewAgentsAction);
    	menu4.add(this.viewNodesAction);
    	menu4.add(this.viewWorkingAction);
    	menu5.add(this.showAboutAction);
    	
    	this.setJMenuBar(menuBar);    	
    	this.setContentPane(contentPane);
    	this.setVisible(true);
    }
	
	private void initActions() {
		
		this.newNodesAction = new AbstractAction("New") {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		this.saveNodesAction = new AbstractAction("Save") {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		this.loadNodesAction = new AbstractAction("Load") {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		this.quitNodesAction = new AbstractAction("Quit") {
		    public void actionPerformed(ActionEvent arg0) {
		    	System.exit(0);
		    }
		};
		
		this.addAgentAction = new AbstractAction("Add Agent") {
			public void actionPerformed(ActionEvent arg0) {
				selectType();
				giveAgentName();
				if(specifyFile()) {
					nodeModel.getHomeNode().getAgentModel().addAgent(agentType, agentName, agentFile);
				}
			}
		};
		
		this.removeAgentAction = new AbstractAction("Remove Agent") {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		this.addNodeAction = new AbstractAction("Add Node") {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		this.removeNodeAction = new AbstractAction("Remove Node") {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		this.viewAgentsAction = new AbstractAction("Show Agents") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Agent Panel");
			}
		};
		
		this.viewNodesAction = new AbstractAction("Show Nodes") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Node Panel");
			}
		};
		
		this.viewWorkingAction = new AbstractAction("Show Worker") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Working Panel");
			}
		};
		
		this.showAboutAction = new AbstractAction("About") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Software Governance Framework Tool\n\n"
						+ "Dummy Application for Agent testing\n\n"
						+ "Created by Marijn Scholtens s2344173\n\n"
						+ "BSc Project Semester 2, 2015/2016.");
			}
		};
		
		/* Short keys for the Action objects */
		// this.quitAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_Q);
		// this.newGameAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		// this.mainMenuAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_M);
		// this.pauseResumeAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
	}
	
	private void selectType() {
		int type = -1;
		while(type < LOWESTAGENT || type > HIGHESTAGENT) {
			type = Integer.parseInt(JOptionPane.showInputDialog("Enter the profile number (" 
												+ LOWESTAGENT + "-" + HIGHESTAGENT + ") where\n"
				+ "0 = custom deamon\n"
				+ "1 = custom actor\n"
				+ "2 = findbugs\n", 0));
		}
		agentType = type;
	}
	
	private void giveAgentName() {
		String name = null;
    	while(name == null) {
    		name = JOptionPane.showInputDialog("Enter an Agent Name", null);
    	}
    	agentName = name;
	}
	
	private boolean specifyFile() {
		String file = null;
    	while(file == null) {
    		JFileChooser selectfile = new JFileChooser();
    		int lf = selectfile.showOpenDialog(selectfile);
    		if(lf == JFileChooser.APPROVE_OPTION) {
    			file = selectfile.getSelectedFile().toString();
    		} else if(lf == JFileChooser.CANCEL_OPTION) {
    			return false;
    		}
    	}
    	agentFile = file;
    	return true;
	}
}
