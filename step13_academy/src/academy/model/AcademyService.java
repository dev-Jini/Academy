package academy.model;

import java.sql.SQLException;

import org.json.simple.JSONArray;

import academy.model.dto.AcademyDTO;

public class AcademyService {

	private static AcademyService instance = new AcademyService();
	private AcademyService() { }
	public static AcademyService getInstance() {
		return instance;
	}
	
	//Academy - CRUD
//	public static void notExistAcademy(String academyTitle) {
//		AcademyDTO 
//	}
	//���ο� academy ����
	public static boolean addAcademy(JSONArray jsonitems_array) throws SQLException{
		return AcademyDAO.addAcademy(jsonitems_array);
	}
	
}
