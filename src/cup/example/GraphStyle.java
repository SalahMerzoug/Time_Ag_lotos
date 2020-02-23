package cup.example;




import org.graphstream.graph.Graph;

public class GraphStyle {
    public static void style(Graph graph){
        /* Display */
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

        String stylesheet = "node { fill-color: white;fill-mode: plain; size : 40px; stroke-color:"
        		+ " black;stroke-mode: plain;stroke-width: 2px;text-mode: normal ;text-background-mode:plain;text-visibility-mode:normal; }" +
                "edge { shape: line; arrow-size : 10px, 4px;shadow-width:25px }"
                + "node:clicked {	stroke-color: red;}"
                + "graph {" + 
                "						canvas-color: white;" + 
                "						fill-mode:plain;" + 
                "						fill-color: white, #EEEEEE;" + 
                "						padding: 30px;" + 
                "					}";
        // Data
        stylesheet = 
    		"graph {"+
    		"	canvas-color: white;"+
    		"	fill-mode: plain;"+
    		"	fill-color: white;"+
    		"	padding: 30px;"+
    		"}"+
    		"node {"+
    		"	shape: circle;"+
    		"	size: 25px;"+
    		"	fill-mode: plain;"+
    		"	fill-color: #0004;"+
    		"}"+
    		"node:clicked {"+
    		"	fill-color: #F004;"+
    		"}"+
    		"node:selected {"+
    		"	fill-color: #00F4;"+
    		"}"+
    		"node#A {"+
    		"	text-alignment: center;"+
    		"	text-color: #F00;"+
    		"}"+
    		"node#B {"+
    		"	text-alignment: at-left;"+
    		"	text-color: #0F0;"+
    		"}"+
    		"node#C {"+
    		"	text-alignment: at-right;"+
    		"	text-color: #00F;"+
    		"}"+
    		"node#D {"+
    		"	text-alignment: left;"+
    		"	text-color: #FA0;"+
    		"}"+
    		"node#E {"+
    		"	text-alignment: right;"+
    		"	text-color: #0FF;"+
    		"}"+
    		"node#F {"+
    		"	text-alignment: under;"+
    		"	text-color: #F0F;"+
    		"}"+
    		"node#G {"+
    		"	text-alignment: above;"+
    		"	text-color: #999;"+
    		"}"+
    		"edge {"+
    		"	fill-color: #0004;"+
    		"}"+
    		"edge#au { text-alignment: center; }"+
    		"edge#bv { text-alignment: at-left; }"+
    		"edge#cw { text-alignment: at-right; }"+
    		"edge#dx { text-alignment: left; }"+
    		"edge#ey { text-alignment: right; }"+
    		"edge#fz { text-alignment: under; }"+
    		"edge#gt { text-alignment: above; }"+
    		"edge#ij { text-alignment: along; }";
        graph.addAttribute("ui.stylesheet", stylesheet);

        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.quality");
    }
}
