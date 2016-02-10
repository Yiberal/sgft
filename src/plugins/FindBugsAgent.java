package plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import model.ActorAgent;

public class FindBugsAgent extends ActorAgent {
	
	String input;
	ArrayList<String> output = new ArrayList<String>();
	
	public FindBugsAgent(String name, String file) {
		setFindBugs();
		setName(name);
		setFile(file);
	}
	
	public void runFindBugsAgent() {
		
		if(selectInput()) {
			runFindBugs();
			parseXMLFB();
			//output = outputFindBugs();
		}
		//output = "Look ma, I found a relic!";
		//setOutputData(output);
		
		// analyseOutput(output);
		// monitorOutput(output);
	}
	
	public boolean selectInput() {
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
    	setInput(file);
    	return true;
	}
	
	public void setInput(String file) {
		input = file;
	}
	
	public void clearOutput() {
		output.clear();
	}
	
	public void runFindBugs() {		
		try {
			Process process = new ProcessBuilder(file, "-textui", input).start();
			//Process process = new ProcessBuilder(file, "-textui", "-xml:withMessages", input).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
		    while ((line = br.readLine()) != null) {
		      outputData.add(line);
		      // output.add(line);
		      System.out.println(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parseXMLFB() {
		
	}
}
