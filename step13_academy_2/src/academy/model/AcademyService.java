package academy.model;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import academy.api.NaverSearchMap;
import academy.model.dto.AcademyDTO;
import academy.model.dto.StudentDTO;
import academy.model.dto.SubjectDTO;

public class AcademyService {

	private static AcademyService instance = new AcademyService();
	private AcademyService() { }
	public static AcademyService getInstance() {
		return instance;
	}
	
	private NaverSearchMap naver = NaverSearchMap.getInstance();
	
	public boolean addAllAcademy(String query) throws SQLException {
		JSONArray jsonItems_array = null;
		ArrayList<AcademyDTO> academies = null;
		
		jsonItems_array = naver.getAcademy(query);
		String sb_name = query.substring(7);
		
		academies = new ArrayList<AcademyDTO>();
		for (int i = 0; i < jsonItems_array.size(); i++) { 	
        	JSONObject jsonobjectitems = ((JSONObject)jsonItems_array.get(i));
        	academies.add(new AcademyDTO(jsonobjectitems.get("title").toString(), jsonobjectitems.get("link").toString(), 
        			jsonobjectitems.get("telephone").toString(), jsonobjectitems.get("address").toString(), sb_name));
        }
		
		return AcademyDAO.addAllAcademy(academies);
	}
	
	//Academy - CRUD
//	public static void notExistAcademy(String academyTitle) {
//		AcademyDTO 
//	}
	
//	//새로운 academy 저장
//	public static boolean addAllAcademy(ArrayList<AcademyDTO> academies) throws SQLException{
//		return AcademyDAO.addAllAcademy(academies);
//	}
	
	public static ArrayList<AcademyDTO> getAllAcademies() throws SQLException{
		return AcademyDAO.getAllAcademies();
	}
	public static ArrayList<AcademyDTO> getSpecificAcademies(String sb_name) throws SQLException{
		return AcademyDAO.getSpecificAcademies(sb_name);
	}
	public static ArrayList<AcademyDTO> getSpecificAcademies2(String sb_name, String loc) throws SQLException{
		return AcademyDAO.getSpecificAcademies2(sb_name, loc);
	}
	public static ArrayList<SubjectDTO> getAllSubjects() throws SQLException{
		return SubjectDAO.getAllSubject();
	}
	public static ArrayList<StudentDTO> getAllStudents() throws SQLException{
		return StudentDAO.getAllStudents();
	}
	
	
}
