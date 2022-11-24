package database;

import java.util.List;

import model.Thong_tin;

public class ThongTinService {

	private ThongTinDao thongTinDao;
	
	public ThongTinService() {
		thongTinDao = new ThongTinDao();
	}
	
	public List<Thong_tin> getAllThong_tins(){
		return thongTinDao.getAllThong_tins();
	}
	
}
