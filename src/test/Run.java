package test;

import javax.swing.UIManager;

import view.HelloView;
import view.MainView;

public class Run {
	public static void main(String[] args) {		
			
		try {			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//new HelloView();
			new MainView();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
}
