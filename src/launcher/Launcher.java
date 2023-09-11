package launcher;

import gui.SimplePresentationScreen;
import entities.Student;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student agustin = new Student(130039, "Kuhn", "Agustin", "agustinkiihn@gmail.com", 
            			"https://github.com/AgustinKuhn", "Sesion Egresados (20).png");
            	SimplePresentationScreen p = new SimplePresentationScreen(agustin);
            	p.setVisible(true);
            }
        });
    }
}