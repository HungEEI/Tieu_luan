package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ChonPhongView;

public class PhongThiController implements ActionListener{
	
	private ChonPhongView chonPhongView;
	
	
	public PhongThiController(ChonPhongView chonPhongView) {
		this.chonPhongView = chonPhongView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		
		if(cm.equals("Lấy phòng thi")) {
			this.chonPhongView.showDaTa();
		}else if(cm.equals("Lấy phòng")) {
			this.chonPhongView.showDaTa();
		}
		
	}

}
