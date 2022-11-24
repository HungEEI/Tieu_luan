package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.TimeController;

import javax.swing.JButton;

public class TimeView extends JFrame {
	private JTable table_time;
	private JButton btn_ngay;

	public TimeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new JPanel();	
		setSize(500, 351);
		setResizable(false);
		this.setLocation(369, 209);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ActionListener action = new TimeController(this);
		
		JLabel lblChnGiThi = new JLabel("Chọn giờ thi - ngày thi");
		lblChnGiThi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChnGiThi.setBounds(120, 10, 245, 34);
		getContentPane().add(lblChnGiThi);
		
		JPanel panel_time = new JPanel();
		panel_time.setBounds(10, 59, 666, 294);
		getContentPane().add(panel_time);
		panel_time.setLayout(null);
		
		table_time = new JTable();
		table_time.setBackground(Color.WHITE);
		table_time.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_time.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ng\u00E0y thi", "Gi\u1EDD thi", "Chọn"
			}
		));
		table_time.getColumnModel().getColumn(0).setPreferredWidth(200);
		table_time.getColumnModel().getColumn(1).setPreferredWidth(200);
		
		table_time.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_time.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(table_time);
		scrollPane.setBounds(0, 0, 479, 209);
		panel_time.add(scrollPane);
		
		btn_ngay = new JButton("Lấy ngày");
		btn_ngay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_ngay.setBounds(184, 219, 95, 28);
		btn_ngay.addActionListener(action);
		panel_time.add(btn_ngay);
		
		
		this.setVisible(true);
	}
	
	
}
