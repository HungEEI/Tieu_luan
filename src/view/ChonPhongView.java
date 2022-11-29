package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.PhongThiController;
import database.PhongThiService;
import model.Thong_tin;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ChonPhongView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	PhongThiService phongThiService;
	private JButton btn_layPhong;

	public ChonPhongView() {
		init();
		
		phongThiService = new PhongThiService();
	}

	
		public void init() {
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 676, 333);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setResizable(false);
			this.setLocation(369, 215);
			
			ActionListener ac = new PhongThiController(this);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 44, 662, 219);
			contentPane.add(panel);
			panel.setLayout(null);
			
			table = new JTable();
			table.setBackground(Color.WHITE);
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 0, 642, 209);
			panel.add(scrollPane);
			
			JLabel lblNewLabel = new JLabel("Chọn phòng thi");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(291, 10, 142, 24);
			contentPane.add(lblNewLabel);
			
			btn_layPhong = new JButton("Lấy phòng");
			btn_layPhong.addActionListener(ac);
			btn_layPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btn_layPhong.setBounds(10, 14, 96, 21);
			contentPane.add(btn_layPhong);
			
			JButton btn_chon = new JButton("Chọn");
			btn_chon.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btn_chon.setBounds(21, 265, 85, 21);
			contentPane.add(btn_chon);
			
			this.setVisible(true);
		}
		
		public void showDaTa() {
			
			DefaultTableModel tableModel = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table.setModel(tableModel);
			table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 14 ));
			table.setRowHeight(30);
			tableModel.addColumn("STT");
			tableModel.addColumn("Mã học phần");
			tableModel.addColumn("Tên học phần");
			tableModel.addColumn("Số sinh viên");
			tableModel.addColumn("Hình thức");
			tableModel.addColumn("Phòng");
			
			
			List<Thong_tin> tts = phongThiService.getAllThong_tins();
			
			for(Thong_tin tt : tts) {
				tableModel.addRow(new Object[] {
						tt.getsTT(), tt.getMaHP(), tt.getTenHP(),tt.getSoSV(),
						tt.getHinhThuc(),tt.getPhong()
				});
			}
								
		}	
}
