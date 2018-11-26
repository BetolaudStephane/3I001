package exo4;

public class Groupe implements Runnable{
	
	private int nb;
	private static int cpt =0;
	private Salle salle;
	public int id;
	private Object mutex = new Object();
	
	public Groupe(int nb,Salle salle) {
		
		synchronized (mutex) {
			this.nb = nb;
			this.salle = salle;
			id = cpt++;
		}
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// la classe a besoin de la methode reserver
		salle.reserverGroupe(this);
	}
	
	public int getNb() {
		return nb;
	}
	
	public int getId() {
		return id;
	}
	
	public void cancel(int n) {
		nb -= n;
	}
	
	public void cancelAll() {
		nb =0;
	}
	
	
	
	public String toString() {
		return "Groupe numéro :" + id +"contenant : " + nb + "spéctateurs";
	}
	
	
	
	
	

}
