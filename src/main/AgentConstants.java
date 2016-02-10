package main;

public interface AgentConstants {
	
	// agentmanager and userinterface are static agents and cannot be removed or readded
	public static final boolean ENABLED = true;
	public static final boolean DISABLED = false;
	public static final boolean ACTOR = true;
	public static final boolean DEAMON = false;	
	public static final int AGENTMANAGER = 0;
	public static final int USERINTERFACE = 1;
	public static final int CUSTOMDEAMON = 0;
	public static final int CUSTOMACTOR = 1;
	public static final int FINDBUGS = 2;
	public static final int LOWESTAGENT = 0;
	public static final int HIGHESTAGENT = 2;
	public static final int CUSTOM = 100;
	
	public static final int fontSize = 14;
	public static final int fontSpace = 17;
	public static final String fontType = "Arial";
	public static final int recWidth = 30;
	public static final int workingX = 300;
	public static final int workingY = 80;
}
