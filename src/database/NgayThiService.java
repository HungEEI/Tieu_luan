package database;

import java.util.List;

import model.Thong_tin;

public class NgayThiService {

private NgayThiDao ngayThiDao;
	
	public NgayThiService() {
		ngayThiDao = new NgayThiDao();
	}
	
	public List<Thong_tin> getAllThong_tins(){
		return ngayThiDao.getAllThong_tins();
	}
	
	
}
