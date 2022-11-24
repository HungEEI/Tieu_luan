package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import controller.ThongTinController;
import database.ThongTinService;
import model.Thong_tin;
import model.thongTinModel;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame {

	public JTable table;
	private JPanel panel_file;
	private JButton btn_load;
	
	ThongTinService thongTinService;

	public MainView() {
		
		init();
		thongTinService = new ThongTinService();
		
	}
	
	public void init() {
		
		new thongTinModel();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 39, 1218, 662);
		getContentPane().add(tabbedPane);
		setSize(1232, 740);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		ActionListener actionListener = new ThongTinController(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Trang chính", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMO CHƯƠNG TRÌNH SẮP XẾP LỊCH THI");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(284, 307, 645, 59);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thuật toán tô màu đồ thị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(490, 376, 214, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\Logo-VNU - Copy.png"));
		lblNewLabel_2.setBounds(0, 80, 437, 237);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\logo-hus.png"));
		lblNewLabel_3.setBounds(985, 10, 165, 269);
		panel.add(lblNewLabel_3);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.setBackground(Color.RED);
		btn_thoat.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\Actions-window-close-icon.png"));
		btn_thoat.setForeground(Color.RED);
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_thoat.setBounds(0, 0, 144, 59);
		btn_thoat.addActionListener(actionListener);
		panel.add(btn_thoat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Chức năng", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 1213, 84);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(0, 0, 859, 84);
		panel_3.add(toolBar_1);
		
		btn_load = new JButton("Load tệp tin");
		btn_load.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\Documents-icon.png"));
		btn_load.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_load.addActionListener(actionListener);
		toolBar_1.add(btn_load);
		
		JButton btn_nhom = new JButton("Chọn nhóm");
		btn_nhom.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\people-2-icon.png"));
		btn_nhom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar_1.add(btn_nhom);
		
		JButton btn_chon_phong = new JButton("Chọn phòng");
		btn_chon_phong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_chon_phong.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\Home-icon.png"));
		toolBar_1.add(btn_chon_phong);
		
		JButton btn_time = new JButton("Chọn giờ thi");
		btn_time.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\time-icon.png"));
		btn_time.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_time.addActionListener(actionListener);
		toolBar_1.add(btn_time);
			
		JButton btn_lich = new JButton("Xếp lịch");
		btn_lich.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\Calendar-icon.png"));
		btn_lich.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar_1.add(btn_lich);
		
			
		JButton btn_xuat_file = new JButton("Xuất file excel");
		btn_xuat_file.setIcon(new ImageIcon("D:\\CodeJava\\Lich_Thi\\imgs\\ms-excel-icon.png"));
		btn_xuat_file.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar_1.add(btn_xuat_file);
		
		panel_file = new JPanel();
		panel_file.setBackground(Color.WHITE);
		panel_file.setBounds(10, 94, 1193, 572);
		panel_1.add(panel_file);
		panel_file.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"STT", "Mã học phần", 
//				"Tên học phần", "số tín chỉ", "Số sinh viên", "Hình thức", 
//				"Thời lượng", "Ngày thi", "Giờ thi", 
//				"Phòng", "Lớp", "Nhóm"
//			}
//		));
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.setRowHeight(30);
//		table.getColumnModel().getColumn(0).setPreferredWidth(51);
//		table.getColumnModel().getColumn(1).setPreferredWidth(100);
//		table.getColumnModel().getColumn(2).setPreferredWidth(150);
//		table.getColumnModel().getColumn(3).setPreferredWidth(90);
//		table.getColumnModel().getColumn(4).setPreferredWidth(80);
//		table.getColumnModel().getColumn(5).setPreferredWidth(120);
//		table.getColumnModel().getColumn(6).setPreferredWidth(100);
//		table.getColumnModel().getColumn(7).setPreferredWidth(100);
//		table.getColumnModel().getColumn(8).setPreferredWidth(100);
//		table.getColumnModel().getColumn(9).setPreferredWidth(100);
//		table.getColumnModel().getColumn(10).setPreferredWidth(100);
//		table.getColumnModel().getColumn(11).setPreferredWidth(100);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 1193, 572);
		panel_file.add(scrollPane);
		
		
		this.setVisible(true);
	}
	
//	SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");
	
	public void showDaTa() {
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		tableModel.addColumn("STT");
		tableModel.addColumn("Mã học phần");
		tableModel.addColumn("Tên học phần");
		tableModel.addColumn("Số tín chỉ");
		tableModel.addColumn("Số sinh viên");
		tableModel.addColumn("Hình thức");
		tableModel.addColumn("Thời lượng");
		tableModel.addColumn("Ngày thi");
		tableModel.addColumn("Giờ thi");
		tableModel.addColumn("Phòng");
		tableModel.addColumn("Lớp");
		tableModel.addColumn("Nhóm");
		
		List<Thong_tin> tts = thongTinService.getAllThong_tins();
		
		for(Thong_tin tt : tts) {
			tableModel.addRow(new Object[] {
					tt.getsTT(), tt.getMaHP(), tt.getTenHP(), tt.getSoTin(),
					tt.getSoSV(), tt.getHinhThuc(),tt.getThoiLuong(), tt.getNgay(),
					tt.getGioThi(), tt.getPhong(), tt.getLop(), tt.getNhom()
			});
		}
							
	}	
	
}
