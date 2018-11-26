package exo4;

public class Salle {
	
	private int nbRangs;
	private int nbPlacesParRang;
	private boolean[][] placesLibres;
	private int capacite;
	
	public Salle(int nbRangs, int nbPlacesParRang) {
		this.nbRangs = nbRangs;
		this.nbPlacesParRang = nbPlacesParRang;
		
		placesLibres = new boolean[nbRangs][nbPlacesParRang];
		capacite = nbRangs * nbPlacesParRang;
		
		for(int i=0; i<nbRangs; i++) {
			for(int j=0; j< nbPlacesParRang; j++) {
				placesLibres[i][j] = true;
			}
		}
	}
	
	public boolean capaciteOk(int n) {
		
		if(capacite > n) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int nContiguesAuRangI(int n , int i) {
		
		int cpt =0;
		int debut = -1 ;
		
		for(int j=0; cpt <n && j < nbPlacesParRang  ; j++) {
			
			if(placesLibres[i][j] == false) {
				cpt =0;
				debut =-1;
			}
			else {
				cpt ++;
				if(debut == -1) {
					debut =j;
				}
			}
		}
		return debut;
	}
	
	
	public boolean reserverContigues(int n) {
		int i;
		int debut =-1;
		
		for(i=0; i< nbRangs && debut != -1; i++){
			debut = nContiguesAuRangI(n, i);
		}
		
		i--;
		
		if(debut != -1) {
			capacite -=n;
			while(n> 0) {
				placesLibres[i][debut] = false;
				debut ++;
				n--;
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public synchronized boolean reserver(int n) {
		if(!capaciteOk(n)) {
			return  false;
		}
		
		if(!reserverContigues(n)) {
			for(int i=0; i< nbRangs && n>0; i++) {
				for(int j = 0; j< nbPlacesParRang && n>0; j++) {
					if(placesLibres[i][j]) {
						placesLibres[i][j] = false;
						n--;
					}
				}
			}
		}
		return true;
	}
	
	public synchronized boolean reserverGroupe(Groupe p) {
		
		if(capaciteOk(p.getNb())) {
			reserver(p.getNb());
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getNbRangs() {
		return nbRangs;
	}
	
	public int getNbPlacesParRang() {
		return nbPlacesParRang;
	}
	
	public boolean getPlace(int i, int j) {
		return placesLibres[i][j];
	}
	
	public int getCapacite() {
		return capacite;
	}
	
	@Override
	public String toString() {
		
		String res = "";
		
		for(int i=0; i< nbRangs; i++) {
			for(int j=0; j< nbPlacesParRang; j++) {
				if(placesLibres[i][j]) {
					res += 1;
				}
				else {
					res += 0;
				}
			}
			res += "\n";
		}
		
		return res;
	}

}
