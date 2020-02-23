package cup.example.expression;



public class TExpression extends AST {
	
	public TExpression(String a,AST b,int min,int max) {
		super(a,b,TYPE.semi,min,max);
		
		profondeur=1+b.profondeur;
		
		formula=a+";"+b.formula;
	}
	public TExpression(String a,AST b,int min,int max,TYPE t,String localite) {

		super(a,b,t,min,max,localite);

		profondeur=1+b.profondeur;		
		formula=a+";"+b.formula;
	}
	public TExpression(String a,AST b,TYPE t,String localite) {
		super(a,b,t,localite);

		profondeur=1+b.profondeur;		
		formula=a+";"+b.formula;
	}
	public TExpression(String a,AST b,int time,TYPE t,String localite) {
		super(a,b,t,time,localite);

		profondeur=1+b.profondeur;		
		formula=a+";"+b.formula;
	}
	public TExpression(String a,AST b,int t) {
		super(a,b,TYPE.semi,t);
		
		profondeur=1+b.profondeur;
		
		formula=a+";"+b.formula;
	}
	public TExpression(AST a,AST b) {
		super();
		System.out.println(b);
		formula=a.formula+";"+b.formula;
		a.addfils(b);		
	}

}                                                              
