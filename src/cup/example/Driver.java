package cup.example;

import java_cup.runtime.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.util.cumulative.GraphSpells;


class Driver {

	public static void main(String[] args) throws Exception {
		//java.io.Reader r = new java.io.FileReader("input.txt");
		Parser parser = new Parser();
		parser.parse();
		
	}	
	
}