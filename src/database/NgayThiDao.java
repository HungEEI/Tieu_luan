package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Thong_tin;

public class NgayThiDao {

public List<Thong_tin> getAllThong_tins(){
		
		List<Thong_tin> thong_tins = new ArrayList<Thong_tin>();
		
		Connection connection = JDBCUtil.getConnection();
		
		String sql = " SELECT * FROM danh_sach_gio_thi";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);
			
			while(rs.next()) {
				Thong_tin tt = new Thong_tin();
				
				tt.setNgay(rs.getDate(1));
				tt.setGioThi(rs.getString(2));
		
				thong_tins.add(tt);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return thong_tins;
					
	}
	
}
