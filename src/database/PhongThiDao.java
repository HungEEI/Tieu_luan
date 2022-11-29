package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Thong_tin;

public class PhongThiDao {

public List<Thong_tin> getAllThong_tins(){
		
		List<Thong_tin> thong_tins = new ArrayList<Thong_tin>();
		
		Connection connection = JDBCUtil.getConnection();
		
		String sql = " SELECT * FROM danh_sach_phong";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);
			
			while(rs.next()) {
				Thong_tin tt = new Thong_tin();
				
				tt.setsTT(rs.getInt(1));
				tt.setMaHP(rs.getString(2));
				tt.setTenHP(rs.getString(3));
				tt.setSoSV(rs.getInt(4));
				tt.setHinhThuc(rs.getString(5));
				tt.setPhong(rs.getString(6));
		
				thong_tins.add(tt);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return thong_tins;
			
		
	}
	
}
