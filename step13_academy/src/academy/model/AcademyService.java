package academy.model;

import java.sql.SQLException;
import java.util.ArrayList;

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
	//새로운 academy 저장
	public static boolean addAllAcademy(ArrayList<AcademyDTO> academies) throws SQLException{
		return AcademyDAO.addAllAcademy(academies);
	}
	
}
