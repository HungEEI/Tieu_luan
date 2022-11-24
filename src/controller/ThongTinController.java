package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.JDBCUtil;
import view.MainView;
import view.TimeView;

public class ThongTinController implements ActionListener{
	
	private MainView mainView;
	public ThongTinController(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		
		if(cm.equals("Thoát")) {
			this.mainView.dispose();
		}else if(cm.equals("Chọn giờ thi")) {
			new TimeView();
		}else if(cm.equals("Load tệp tin")) {
			this.mainView.showDaTa();
		}
		
	}

}
