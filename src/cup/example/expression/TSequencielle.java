package cup.example.expression;

public class TSequencielle extends AST {
	
	public TSequencielle(AST e1,AST e2) {
		
		if(e1.ID.contains("[]"))
			e1=gast;
		if(e2.ID.contains("[]"))
			e2=gast;
		this.T=TYPE.sequence;
		label.put(">>",">>P"+getIndex());
		formula=label.toString();
		ID =e1.formula+">>"+e2.formula;
		ELEMENTS.put(ID, this);
		graph.addNode(ID).setAttribute("ui.label",label.values() );
		Infos ts= new Infos();
		//infoschildren.putAll(e2.infoschildren);
		if(e1.children.size()>=1){
			labels.putAll(e1.labels);
			children.addAll(e1.children);
			labelsEdgets.putAll(e1.labelsEdgets);
			for (AST ast : e1.children) {
				if(ast.ID=="STOP"&&graph.getNode("STOP")==null) {
					new TAtom("STOP",TYPE.stop);
				}
				graph.addEdge(ID+ast.ID, ID, ast.ID, true).setAttribute("ui.label",e1.labelsEdgets.get(ast.ID) );
				 ts= new Infos();
				ts.time=e1.infoschildren.get(ast.ID).time;
				infoschildren.put(ast.ID,ts);
			     labelsEdgets.put(ast.ID,e1.labelsEdgets.get(ast.ID));
			}
			if (graph.getNode(e1.ID) != null && (!(e1.ID.equals(StaticElements.STOP)))) {
				graph.removeNode(e1.ID);
			}
		}else{
			labels.put(e1.ID,e1.label);
			children.add(e1);
			labelsEdgets.put(e1.ID,"");
			graph.addEdge(ID+e1.ID, ID, e1.ID, true).setAttribute("ui.label","" );
			
			//labelsEdgets.put(e1.ID,e1.labelsEdgets.get(ast.ID));
		}
		if(e2.children.size()>=1) {
			children.addAll(e2.children);
			labels.putAll(e2.labels);
			labelsEdgets.putAll(e1.labelsEdgets);
			for (AST ast : e2.children) {
				if (ast.ID == "STOP" && graph.getNode("STOP") == null) {
					new TAtom("STOP", TYPE.stop);
				}
				if (graph.getEdge(ID + ast.ID) == null)
					graph.addEdge(ID + ast.ID, ID, ast.ID, true).setAttribute("ui.label", e2.labelsEdgets.get(ast.ID));
				 ts= new Infos();
				 ts.time=e2.infoschildren.get(ast.ID).time;;
				infoschildren.put(ast.ID,ts);
			   labelsEdgets.put(ast.ID,e2.labelsEdgets.get(ast.ID));
			}

			if (graph.getNode(e2.ID) != null && (!e2.ID.equals(StaticElements.STOP))) {
				graph.removeNode(e2.ID);
			}
		}else{
			labels.put(e2.ID,e2.label);
			children.add(e2);
			labelsEdgets.put(e2.ID,"");
			graph.addEdge(ID+e2.ID, ID, e2.ID, true).setAttribute("ui.label","" );
			
		  // labelsEdgets.put(ast.ID,e2.labelsEdgets.get(ast.ID));
		}
		 gast=this;
	}
  
}
