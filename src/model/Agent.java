package model;

import java.awt.Point;
import java.util.ArrayList;

import main.AgentConstants;
import plugins.FindBugsAgent;

/**
 * @author Marijn Scholtens
 * This is the agent class, which is abstract since an agent is either actor or deamon.
 * Additionally there are two static deamon agents, agentmanager and userinterface
 */
public abstract class Agent implements AgentConstants {

	protected String name;
	protected boolean mainType;
	protected int subType;
	protected boolean status = ENABLED;
	protected String file;
	protected ArrayList<String> outputData = new ArrayList<String>();
	
	public Agent() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public String getFile() {
		return file;
	}
	
	public ArrayList<String> getOutputData() {
		return outputData;
	}
	
	public void clearOutput() {
		outputData.clear();
	}
	
	public void enableAgent() {
		status = ENABLED;
	}
	
	public void disableAgent() {
		status = DISABLED;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setActor() {
		mainType = ACTOR;
	}
	
	public void setDeamon() {
		mainType = DEAMON;
	}
	
	public void setAgentManager() {
		mainType = DEAMON;
		subType = AGENTMANAGER;
	}
	
	public void setUserInterface() {
		mainType = DEAMON;
		subType = USERINTERFACE;
	}
	
	public void setFindBugs() {
		mainType = ACTOR;
		subType = FINDBUGS;
	}
	
	public void setCustomDeamon() {
		mainType = DEAMON;
		subType = CUSTOM;
	}
	
	public void setCustomActor() {
		mainType = ACTOR;
		subType = CUSTOM;
	}
	
	public boolean getMainType() {
		return mainType;
	}
	
	public int getSubType() {
		return subType;
	}
	
	public void runAgent() {
		switch(subType) {
		case FINDBUGS: ((FindBugsAgent)this).runFindBugsAgent(); break;
		}
	}
	
	public boolean contains(Point p, int index, int drawX, int drawY, int recWidth) {
		double pointX = p.getX();
		double pointY = p.getY();
		double leftX = (double)drawX;
		double upY = (double)drawY;
		double recHeight = (double)fontSpace;
		double agentIndex = (double)index;
		upY += (agentIndex-1) * recHeight;
		double rightX = leftX + recWidth;
		double bottomY = upY + recHeight;
		
		// check if selected point is within the rectangle starting from (leftX, upY) with width 'width' and height space
		if((pointX > leftX && pointX < rightX) && (pointY > upY && pointY < bottomY)) {
			return true;
		} else {
			return false;
		}
	}
}
