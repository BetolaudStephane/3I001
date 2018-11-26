import graphic.*;
import java.awt.Point;


public class DessineLigne2 implements Runnable{

	private Point p1;
	private Point p2;
	private Window fenetre;

	public DessineLigne2(Window fenetre,Point p1, Point p2){
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

		DessineLigne2 ligne1 = new DessineLigne2(fenetre, p1, p2);
		Thread t1 = new Thread(ligne1);
		DessineLigne2 ligne2 = new DessineLigne2(fenetre, p2, p3);
		Thread t2 = new Thread(ligne2);
		DessineLigne2 ligne3 = new DessineLigne2(fenetre, p3, p1);
		Thread t3 = new Thread(ligne3);

		//try{
			
			t1.start();
			//t1.join();
			t2.start();
			//t2.join();
			t3.start();
		//}catch(InterruptedException e){
		//	e.getMessage();
		//}
	}
}
