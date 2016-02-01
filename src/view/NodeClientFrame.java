package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Marijn Scholtens
 * Here we initialize the frame of the nodeclient and build the panel
 */
@SuppressWarnings("serial")
public class NodeClientFrame extends JFrame {
	
	private AgentPanel agentPanel;
	private NodePanel nodePanel;
	private AbstractAction quitNodesAction;
	private AbstractAction viewAgentsAction;
	private AbstractAction viewNodesAction;
	private AbstractAction showAboutAction;
	
	private JPanel contentPane;
	private CardLayout cardLayout;
	private final int width = 600;
	private final int height = 600;
	
	public NodeClientFrame() {
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
    	
    	agentPanel = new AgentPanel();
    	contentPane.add(agentPanel, "Agent Panel");
    	nodePanel = new NodePanel();
    	contentPane.add(nodePanel, "Node Panel");
    	
    	initActions();
    	
    	JMenuBar menuBar = new JMenuBar();
    	JMenu menu1 = new JMenu("File");
    	JMenu menu2 = new JMenu("View");
    	JMenu menu3 = new JMenu("Help");
    	menuBar.add(menu1);
    	menuBar.add(menu2);
    	menuBar.add(menu3);
    	
    	menu1.add(this.quitNodesAction);
    	menu2.add(this.viewAgentsAction);
    	menu2.add(this.viewNodesAction);
    	menu3.add(this.showAboutAction);
    	
    	this.setJMenuBar(menuBar);    	
    	this.setContentPane(contentPane);
    	this.setVisible(true);
    }
	
	private void initActions() {
		
		this.quitNodesAction = new AbstractAction("Quit") {
		    public void actionPerformed(ActionEvent arg0) {
		    	System.exit(0);
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
}
