package cup.example.expression;

import java.util.ArrayList;

import org.graphstream.ui.view.Viewer;

import cup.example.GraphStyle;

public class TFormula {

  static AST graph = null;

    public TFormula(AST e) {
        GraphStyle.style(e.graph);
        Viewer viewer = new Viewer(e.graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        viewer.addDefaultView(true);
        viewer.enableAutoLayout();
        if (e == null) {
            graph = e.gast;
        } else {
            graph = e;
        }
    }
  public static boolean  IsEmpty()
  {
      return graph==null?true:false;
  }
          public static void Dijkstra() {
        int min = 1000;
        //int min1=1000;
        if (graph.children.size() > 0) {
            ArrayList<String> ls = new ArrayList<String>();
            ArrayList<String> ls1 = new ArrayList<String>();
            for (AST ast : graph.children) {
                if (!ast.children.isEmpty()) {
                    ArrayList<String> l = new ArrayList<String>();

                    /*
			   if(graph.labelsEdgets.get(ast.ID).equals(""))
			   {
				   System.out.println("<<<<>>>>");
				  if(ast.children.size()>0)
				  {
					
					 for(AST c:ast.children)
					 {
					   l=new ArrayList<String>(); 
					   l.add(ast.labelsEdgets.get(c.ID)+"--------->"+ast.labels.get(c.ID));
							   int calculchild=ast.infoschildren.get(c.ID).time+c.Dijkstra(l);
					  for(String k:l)
					   {
						   System.out.print(k+"\t");
					   }
					   System.out.println("  temps   :"+calculchild);
					  if(min1>calculchild)
					  {
						  min1=calculchild;
						  ls1=l;
					  }
					 }
					 
				  }
			   }
			   else
			   {*/
                    l = new ArrayList<String>();
                    l.add(graph.labelsEdgets.get(ast.ID) + "--------->" + graph.labels.get(ast.ID) + "time " + graph.infoschildren.get(ast.ID).time);
                    int calculchild = graph.infoschildren.get(ast.ID).time + ast.Dijkstra(l);
                    for (String k : l) {
                        System.out.print(k + "\t");
                    }
                    System.out.println("  time   :" + calculchild);
                    if (min >= calculchild) {
                        min = calculchild;
                        ls = l;
                    }
                }
                //   }
            }
         System.out.println(" Short path is :");
            for (String k : ls) {
                System.out.print(k + "\t");
            }
            System.out.println(" time  :" + min);
        } else {
            System.out.println("chldern:" + graph.children.size());
        }
    }
}
