import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
//import java.io.IOException;
import java.util.Scanner;

public class MatriceEntiere {
	
	//declaration des entiers du nombre de lignes et du nombre de colonnes
	private int ligne, colonne;
	
	//declaration d'un tableau a deux dimensions qui represente la matrice
	private int[][] matrice ;
	
	//premier constructeur qui sert juste a donner le nombre de lignes et de colonnes
	public MatriceEntiere(int ligne, int colonne) {
		this.ligne=ligne;
		this.colonne = colonne;
		this.matrice= new int[ligne][colonne];
	}
	
	//declaration du second constructeur qui va initialiser la matrice avec les caracteres 
	//trouvés dans le fichier
	// si on utilise un "File fichier" il y a un probleme de lecture donc on utilise in String a la place
	// le constructeur leve une exception si le fichier n'est pas trouvé (quand on a utiliser File fichier
	// a chaque fois l'exception est levée
	public MatriceEntiere(String fichier) throws FileNotFoundException {
		
		try {
		
			
			BufferedReader buff = new BufferedReader(new FileReader(new File(fichier)));
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(buff);
			
			int line = sc.nextInt();
			int col = sc.nextInt();
			
			matrice = new int[line][col];
			
			
			
			for(int i=0;i<line; i++) {
				for(int j=0; j< col; j++) {
					if(sc.hasNextInt()) {
						matrice[i][j] = sc.nextInt();
					}
					else {
						sc.next();
						matrice[i][j] = sc.nextInt();
					}
					
				}
			}
			this.colonne = col;
			this.ligne = line;
			/*buff.close();*/
		
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("le fichier est introuvable");
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
	}
	
	//constructeur qui ne sert a rien je vais surement le virer
	
	public MatriceEntiere(int[][] matrice) {
		super();
		this.matrice = matrice;
	}
	
	// retourne le tavleau a deux dimensions représentant la matrice
	
	public int[][] getMatrice(){
		return matrice;
	}
	
	// methode getElem qui retourne la case (i,j) du tableau a deux dimensions
	public int getElem(int i, int j) {
		return matrice[i][j];
	}
	
	//methode qui sert a initialiser la case (i,j) du tableau a deux dimensions avec la valeur val
	
	public void setElem(int i, int j, int val) {
		matrice[i][j] = val;
	}
	
	// retourne la nombre de colonnes de la matrice
	public int getColonne() {
		return colonne;
	}
	
	// retourne le nombre de lignes de la matrice
	public int getLigne() {
		return ligne;
	}
	
	// methode toString surchargée
	// permet un affichage du tableau a deux dimensions sous forme de matrice
	@Override
	public String toString() {
		
		String chaine = "";
		
		for(int i=0; i< getLigne(); i++) {
			for(int j=0; j< getColonne(); j++) {
				chaine += getElem(i,j);
			}
			chaine += "\n";
		}
		
		return chaine;
	}
	
	// methode qui permet de faire un affichage autre que le toString comme demandé dans le sujet
	//fait la meme chose que le toString (meme code)
	
	public void affiche() {
		String chaine = "";
		
		for(int i=0; i< getLigne(); i++) {
			for(int j=0; j< getColonne(); j++) {
				chaine += getElem(i,j);
				chaine += " ";
 			}
			chaine += "\n";
		}
		
		System.out.println(chaine);
	}
	
	// initialise le nombre de ligne de la matrice avec l'entier nombre
	
	public void setLigne(int nombre) {
		this.ligne = nombre;
	}
	
	// initialise le nombre de colonnes de la matrice avec l'entier nombre
	
	public void setColonne(int nombre) {
		this.colonne = nombre;
	}
	
	// methode qui initialise toutes les valeurs de la matrices a zero
	public void initZero() {
		for(int i=0; i< getLigne(); i++) {
			for(int j=0; j< getColonne() ;j++) {
				setElem(i,j,0);
			}
		}
	}
	
	// methode qui sert a calculer la transposée de la matrice
	
	public void transposé(){
		
		int nouvLigne = getColonne();
		int nouvCol = getLigne();
		//String mat= "";
		
		int[][] matrix = new int[nouvLigne][nouvCol];
		
		for(int i=0; i<nouvLigne; i++) {
			for(int j=0; j<nouvCol; j++) {
				matrix[i][j] = matrice[j][i];
				//mat += matrix[i][j];
			}
			//mat += "\n";
			
		}
		
		setLigne(nouvLigne);
		setColonne(nouvCol);
		
		matrice = new int[nouvLigne][nouvCol];
		matrice = matrix;
		
	}
	
	// methode qui sert a reinitialiser le nombre de lignes et colonnes de la matrice 
	// apres utilisation de la methode de la transposée
	// Attention : bien utiliser cette methode après l'utilisation de la mthode transposée pour avoir 
	// les bonnes valeurs du nombre de lignes et colonnes si on veut faire d'autres calculs sur la 
	// matrice originale
	public void reinitLigneCol() {
		
		int ligne = getLigne();
		
		setLigne(getColonne());
		setColonne(ligne);
		
		if((getLigne() == 3) &&(getColonne() == 4)) {
			System.out.println("reinit faite");
		}
		else
		{
			System.out.println("echec");
		}
		
		
	}
	
	// methode qui calcule l'addition de deux matrices
	// la valeur de retour est un tableau a deux dimensions
	// prend en parametres deux matricesEntieres mat1 et mat2
	// la methode leve une exception si la taille des matrice ne concorde pas
	/*
	 * Attention : vu que la valeur de retour et un tableau a deux dimensions, on ne peut pas appliquer 
	 * les methodes toString() et affiche(). On doit donc boucler et stocker les valeurs dans un String pour
	 * faire l'affichage.
	 * Methode utilisée avec des tableaux
	 */
	
	public static int[][] additionMatrices(MatriceEntiere mat1, MatriceEntiere mat2) throws TaillesNonConcordantesException{
		
		// condition de verification sur la taille des matrices
		// leve une exception si la taille ne concorde pas
		if(!(mat1.getLigne() == mat2.getLigne() && mat1.getColonne() == mat2.getColonne())) {
			throw new TaillesNonConcordantesException();
		}else {
			//initialisation de la matrice finale pour stocker l'addition des deux matrices
			int[][] matFinale = new int[mat1.getLigne()][mat1.getColonne()];
			
			// on recupere la valeur des cases des matrices et on les additionne
			for(int i=0; i<mat1.getLigne();i++) {
				for(int j=0; j< mat1.getColonne(); j++) {
					matFinale[i][j] = mat1.getElem(i, j) + mat2.getElem(i, j);
				}
			}
			
			// on retourne matFinale qui est la matrice finale
			
			return matFinale;
		}
		
	}
	
	public MatriceEntiere somme(MatriceEntiere matrice)	throws TaillesNonConcordantesException{
		/*teste si les deux matrice on les meme dimension*/
		if(this.ligne!=matrice.getLigne() && this.colonne!=matrice.getColonne()){
			throw new TaillesNonConcordantesException();
		}
		
		MatriceEntiere somme = new MatriceEntiere(this.getLigne(),this.getColonne());
		
		for(int i=0;i<getLigne();i++) {
			for(int j=0; j<getColonne(); j++) {
				somme.matrice[i][j] = this.matrice[i][j] + matrice.matrice[i][j];
			}
		}
		return somme;
		
		
	}
	
	public MatriceEntiere produit(MatriceEntiere matrice) throws TaillesNonConcordantesException{
		if(this.ligne != matrice.getColonne()) {
			throw new TaillesNonConcordantesException();
		}
		else
		{
			MatriceEntiere produit = new MatriceEntiere(matrice.getColonne(), getLigne());
			int prod =0;
			for(int i=0; i< produit.getLigne(); i++) {
				for(int j=0; j< produit.getColonne(); j++) {
					for(int k=0; k< this.getColonne(); k++) {
						prod+= this.matrice[i][k] + matrice.matrice[k][j];
						
					}
					produit.matrice[i][j] = prod;
					prod=0;
				}
			}
			return produit;
		}
		
	}
	
	// methode qui multiplie deux matrices entre elles
	/*
	 * meme principe que pour l'addition
	 */
	
	public static int[][] multiplicationMatrices(MatriceEntiere mat1, MatriceEntiere mat2) throws TaillesNonConcordantesException{
		
		// condition pour verifier la taille des matrices
		if(!(mat1.getColonne() == mat2.getLigne())){
			throw new TaillesNonConcordantesException();
		}
		else {
			// init du tableau a deux dimensions qui va stocker les valeurs de la multiplication des matrices
			int[][] matFinale = new int[mat1.getLigne()][mat2.getColonne()];
			
			// on applique la formule donnée pour la multiplication de deux matrices
			for(int k=0; k< mat1.getColonne(); k++) {
				
				for(int i=0; i< mat1.getLigne(); i++) {
					for(int j=0; j< mat2.getColonne(); j++) {
						
						matFinale[i][j] += mat1.getElem(i, k) * mat2.getElem(k, j);
					}
				}
			}
			
			// on retourne matFinale qui est le resultat de la multiplication des deux matrices
			return matFinale;
		}
	}
	
	/*
	 * methode qui va calculer le produit scalaire entre un entier scalaire et la matrice
	 */
	public void produitScalaire(int scalaire) {
		
		for(int i=0; i<getLigne(); i++) {
			for(int j=0; j< getColonne(); j++) {
				matrice[i][j] *= scalaire;
			}
		}
		
	}
	
	// methode main utilisée pour les tests
	/*
	 * La totalité des methodes marchent. 
	 */
	
	public static void main(String [] args) throws FileNotFoundException, TaillesNonConcordantesException {
		
		try { 
		
		MatriceEntiere matrice = new MatriceEntiere("matrice.txt");
		MatriceEntiere matrice2 = new MatriceEntiere("matrice2.txt");
		
		MatriceEntiere matFinale2 = new MatriceEntiere(matrice.getLigne(), matrice.getColonne());
		matFinale2 = matrice.produit(matrice2);
		matFinale2.affiche();
		
	

		
		int[][] matFinale = new int[matrice.getLigne()][matrice.getColonne()];
		
		
		try {
		matFinale = additionMatrices(matrice, matrice2);
		
		matFinale = multiplicationMatrices(matrice, matrice2);
		
		String res = "";
		
		for(int i=0; i< matFinale.length; i++) {
			for(int j=0; j< matFinale[0].length; j++) {
				res += matFinale[i][j];
				res += " ";
			}
			res += "\n";
		}
		
		System.out.println(res);
		
		}catch(TaillesNonConcordantesException t) {
			t.getMessage();
		}
				
		
		//matrice2.affiche();
		//matrice.transposé();
		//matrice.affiche();
		//matrice.reinitLigneCol();
		//matrice.affiche();
		
		
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
	
