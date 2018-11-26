import graphic.*;
import java.awt.Point;


public class DessineLigne extends Thread{

	private Point p1;
	private Point p2;
	private Window fenetre;

	public DessineLigne(Window fenetre,Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
		this.fenetre = fenetre;
	}
	
	public void run(){

		fenetre.plotLine(p1,p2);
	}

	public static void main(String[] args){
		
		Window fenetre = new Window(1000,1000, "Fenetre");	
		Point p1 = new Point(0,0);
		Point p2 = new Point(500,500);
		Point p3 = new Point(500,100);

		DessineLigne ligne1 = new DessineLigne(fenetre, p1, p2);
		//Thread t1 = new Thread(ligne1);
		DessineLigne ligne2 = new DessineLigne(fenetre, p2, p3);
		//Thread t2 = new Thread(ligne2);
		DessineLigne ligne3 = new DessineLigne(fenetre, p3, p1);
		//Thread t3 = new Thread(ligne3);

		//t1.start();
		//t2.start();
		//t3.start();
		ligne1.start();
		ligne2.start();
		ligne3.start();
	}
}
		
