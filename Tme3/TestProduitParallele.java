package Exo3;

import java.io.FileNotFoundException;

public class TestProduitParallele {
	
	public static void main(String[] args) throws TaillesNonConcordantesException{
		
		try {
		
		MatriceEntiere m1 = new MatriceEntiere("donnees_produit1.txt");
		MatriceEntiere m2 = new MatriceEntiere("donnees_produit2.txt");
		MatriceEntiere m = new MatriceEntiere(m1.getNbLignes(), m2.getNbColonnes());
		
		for(int i=0; i< m.getNbLignes(); i++) {
			for(int j=0; i< m.getNbColonnes(); j++) {
				
				Thread t = new Thread(new CalculElement(m,m1,m2,i,j));
				t.start();
			}
		}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
			
	}

}
