package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TimeView;

public class TimeController implements ActionListener{
	
private TimeView timeView;
	
	public TimeController(TimeView timeView) {
		this.timeView = timeView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		
		if(cm.equals("Lấy ngày")) {
			this.timeView.showDaTa();
		}else if(cm.equals("Lưu")) {
			this.timeView.CapNhatTimeDaChon();
		}else if(cm.equals("Chọn")) {
			this.timeView.getThong_tinDangChon();
			this.timeView.CapNhatTimeDaChon();
		}
		
	}

}
