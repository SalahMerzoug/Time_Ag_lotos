package cup.example.expression;

//import org.graphstream.graph.Graph;
//import org.graphstream.graph.implementations.SingleGraph;

public class TAtom extends AST{

//	public static int END=0;
	public TAtom(String a) {
		super(a,TYPE.node);
		profondeur=1;
		formula=a;
		addEND();
	}
	public TAtom(String a,int time) {
		super(a,TYPE.node,time);
		profondeur=1;
		formula=a;
		addEND();
	}
	public TAtom(String a,TYPE t) {
		super(a,t);
		profondeur=0;
		formula=a;
	}
	public TAtom(String a,int time,TYPE t) {
		super(a,t,time);
		profondeur=1;
		formula=a;
		addEND();
	}
}
