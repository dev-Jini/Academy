	package academy.model;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import academy.api.NaverSearchMap;
import academy.model.dto.AcademyDTO;
import academy.model.dto.AcademyStudentDTO;
import academy.model.dto.StudentDTO;
import academy.model.dto.SubjectDTO;

public class AcademyService {

	private static AcademyService instance = new AcademyService();
	private AcademyService() { }
	public static AcademyService getInstance() {
		return instance;
	}
	
	private NaverSearchMap naver = NaverSearchMap.getInstance();
	
	// Academy
	public boolean addAllAcademy(String query) throws SQLException {
		JSONArray jsonItems_array = null;
		ArrayList<AcademyDTO> academies = null;
		
		jsonItems_array = naver.getAcademy(query);
		String sb_name = query.substring(3);
		
		academies = new ArrayList<AcademyDTO>();
		for (int i = 0; i < jsonItems_array.size(); i++) { 	
        	JSONObject jsonobjectitems = ((JSONObject)jsonItems_array.get(i));
        	academies.add(new AcademyDTO(jsonobjectitems.get("title").toString(), jsonobjectitems.get("link").toString(), 
        			jsonobjectitems.get("telephone").toString(), jsonobjectitems.get("address").toString(), sb_name));
        }
		return AcademyDAO.addAllAcademies(academies);
	}
	
	public static ArrayList<AcademyDTO> getAllAcademies() throws SQLException{
		return AcademyDAO.getAllAcademies();
	}
	public static ArrayList<AcademyDTO> getSpecificAcademies(String sb_name) throws SQLException{
		return AcademyDAO.getSpecificAcademies(sb_name);
	}
	public static ArrayList<AcademyDTO> getSpecificAcademies2(String sb_name, String loc) throws SQLException{
		return AcademyDAO.getSpecificAcademies2(sb_name, loc);
	}
	public static AcademyDTO getAcademy(double academy_id) throws SQLException {
		return AcademyDAO.getAcademy(academy_id);
	}
	public static boolean addAcademy(AcademyDTO academy) throws SQLException {
		return AcademyDAO.addAcademy(academy);
	}
	public static boolean updateAcademy(double academy_id, String title) throws SQLException {
		return AcademyDAO.updateAcademy(academy_id, title);
	}
	public static boolean deleteAcademy(double academy_id) throws SQLException {
		return AcademyDAO.deleteAcademy(academy_id);
	}
	
	// Student
	public static ArrayList<StudentDTO> getAllStudents() throws SQLException{
		return StudentDAO.getAllStudents();
	}
	public static StudentDTO getStudent(int st_id) throws SQLException {
		return StudentDAO.getStudent(st_id);
	}
	public static boolean addStudent(StudentDTO student) throws SQLException {
		return StudentDAO.addStudent(student);
	}
	public static boolean updateStudent(int st_id, Object obj) throws SQLException {
	      return StudentDAO.updateStudent(st_id, obj);
	}
	public static boolean deleteStudent(int st_id) throws SQLException {
	      return StudentDAO.deleteStudent(st_id);
	}
	
	// Subject
	public static ArrayList<SubjectDTO> getAllSubjects() throws SQLException{
		return SubjectDAO.getAllSubject();
	}
	public static SubjectDTO getSubject(int sb_no) throws SQLException {
		return SubjectDAO.getSubject(sb_no);
	}
	public static boolean addSubject(SubjectDTO subject) throws SQLException {
		return SubjectDAO.addSubject(subject);
	}
	public static boolean updateSubject(int sb_no, String sb_name) throws SQLException {
		return SubjectDAO.updateSubject(sb_no, sb_name);
	}
	public static boolean deleteSubject(int sb_no) throws SQLException {
		return SubjectDAO.deleteSubject(sb_no);
	}
	
	// AcademyStudnet
	public static ArrayList<AcademyStudentDTO> getAllAcadmeyStudents() throws SQLException {
		return AcademyStudentDAO.getAllAcademyStudents();
	}
	public static ArrayList<AcademyStudentDTO> getAcademyStudents(double academy_id) throws SQLException {
		return AcademyStudentDAO.getAcademyStudents(academy_id);
	}
}
