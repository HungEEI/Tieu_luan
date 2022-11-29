package database;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XuatExcel {
	
	JDBCUtil data = new JDBCUtil();
	
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	
	public void fillData(JTable table) {
		DefaultTableModel model = new DefaultTableModel(new String[] {
				
				"STT","Mã học phần","Tên học phần","Số tín chỉ","Số sinh viên",
				"Hình thức","Thời lượng","Ngày thi","Giời thi","Phòng","Lớp",
				
		}, 0);
		
		try {
			
			conn = JDBCUtil.getConnection();
			stmt= conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM danh_sach_thong_tin");
			while(rs.next()) {
				int sTT = rs.getInt("STT");
				String maHP = rs.getString("Mã học phần");
				String tenHP = rs.getString("Tên học phần");
				int soTin = rs.getInt("Số tín chỉ");
				int soSV = rs.getInt("Số sinh viên");
				String hinhThuc = rs.getString("Hình thức");
				String thoiLuong = rs.getString("Thời lượng");
				Date ngay = rs.getDate("Ngày thi");
				String gioThi = rs.getString("Giờ thi");
				String phong = rs.getString("Phòng");
				String lop = rs.getString("Lớp");
				
				model.addRow(new Object[] {
						"STT","Mã học phần","Tên học phần","Số tín chỉ","Số sinh viên",
						"Hình thức","Thời lượng","Ngày thi","Giời thi","Phòng","Lớp"
				});
			}
			
		}catch(SQLException sqle) {
			System.out.println(sqle);
		}
	
	}
	
	public void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
	
	
	public void exportExcel(JTable table) {
		
	try {
		
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.showSaveDialog(table);
		File saveFile = jFileChooser.getSelectedFile();
		
		if(saveFile != null) {
			saveFile = new File(saveFile.toString() + ".xlsx");
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("danh_sach_thong_tin");
			Row rowCol = sheet.createRow(0);
			
			for(int i = 0; i < table.getColumnCount(); i++) {
				Cell cell = rowCol.createCell(i);
				cell.setCellValue(table.getColumnName(i));
			}
			
			for(int j = 0; j < table.getColumnCount(); j++) {
				Row row = sheet.createRow(j+1);
				for(int k = 0; k < table.getColumnCount(); k++) {
					Cell cell = row.createCell(k);
					if(table.getValueAt(j, k) != null) {
						cell.setCellValue(table.getValueAt(j, j).toString());
					}
				}
			}
			FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
			wb.write(out);
			wb.close();
			out.close();
			openFile(saveFile.toString());
			
		}else {
			JOptionPane.showMessageDialog(null, "Errol");
		}
		
	}catch(FileNotFoundException e) {
		System.out.println(e);
	}catch(IOException io) {
		System.out.println(io);
	}
	
	
    }
}
