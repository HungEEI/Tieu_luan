package database;

import java.util.List;

import model.Thong_tin;

public class PhongThiService {
	
private PhongThiDao phongThiDao;
	
	public PhongThiService() {
		phongThiDao = new PhongThiDao();
	}
	
	public List<Thong_tin> getAllThong_tins(){
		return phongThiDao.getAllThong_tins();
	}

}
