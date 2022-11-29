package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.TimeController;
import database.NgayThiService;
import database.ThongTinService;
import model.Thong_tin;

import javax.swing.JButton;

public class TimeView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_time;
	private JButton btn_ngay;
	
	NgayThiService ngayThiService;
	ThongTinService thongTinService;
	
	private JButton btnNewButton;
	private JButton btn_chon;

	public TimeView() {
		init();
		
		ngayThiService = new NgayThiService();
	}
	
	public void init() {
		
		setBounds(100, 100, 450, 300);
		new JPanel();	
		setSize(500, 351);
		setResizable(false);
		this.setLocation(369, 209);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ActionListener action = new TimeController(this);
		
		JLabel lblChnGiThi = new JLabel("Chọn giờ thi - ngày thi");
		lblChnGiThi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChnGiThi.setBounds(169, 10, 245, 34);
		getContentPane().add(lblChnGiThi);
		
		JPanel panel_time = new JPanel();
		panel_time.setBounds(10, 59, 666, 294);
		getContentPane().add(panel_time);
		panel_time.setLayout(null);
		
		table_time = new JTable();
		table_time.setBackground(Color.WHITE);
		table_time.setFont(new Font("Tahoma", Font.PLAIN, 12));		
		
		JScrollPane scrollPane = new JScrollPane(table_time);
		scrollPane.setBounds(0, 0, 479, 212);
		panel_time.add(scrollPane);
		
		btn_chon = new JButton("Chọn");
		btn_chon.addActionListener(action);
		btn_chon.setBounds(10, 222, 85, 21);
		panel_time.add(btn_chon);
		
		btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(action);
		btnNewButton.setBounds(376, 222, 85, 21);
		panel_time.add(btnNewButton);
		
		btn_ngay = new JButton("Lấy ngày");
		btn_ngay.setBounds(10, 16, 95, 28);
		getContentPane().add(btn_ngay);
		btn_ngay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_ngay.addActionListener(action);
		
		
		this.setVisible(true);
	}
	
	SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");
	
	public void showDaTa() {
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_time.setModel(tableModel);
		table_time.setRowHeight(30);
		table_time.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 15 ));
		
		tableModel.addColumn("Ngày thi");
		tableModel.addColumn("Giờ thi");
		
		List<Thong_tin> tts = ngayThiService.getAllThong_tins();
		
		for(Thong_tin tt : tts) {
			tableModel.addRow(new Object[] {					
					date_Format.format(tt.getNgay()), tt.getGioThi()
			});
		}
							
	}	
	
	public void getThong_tinDangChon() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table_time.getModel();
		int row = table_time.getSelectedRow();
		
		java.util.Date ngay = null;
		
		try {
			ngay = date_Format.parse(tableModel.getValueAt(row, 0) + "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gioThi = tableModel.getValueAt(row, 1) + "";
		

	}
	
	public void CapNhatTimeDaChon() {
	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
