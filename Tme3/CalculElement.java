package Exo3;



public class CalculElement implements Runnable{

	
	MatriceEntiere m;
	private static MatriceEntiere m1, m2;
	int i,j,k;
	
	
	public CalculElement(MatriceEntiere m, MatriceEntiere m1, MatriceEntiere m2, int i, int j) {
		this.m=m;
		this.m1=m1;
		this.m2=m2;
		this.i=i;
		this.j=j;
		
		try {
		
			this.k = m.produitLigneColonne(m1,i,m2,j);
		}
		catch(TaillesNonConcordantesException e) {
			e.getMessage();
		}
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		m.setElem(i,j,k);
	}
	
	

}
