package academy.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import academy.api.NaverSearchMap;
import academy.controller.AdminController;
import academy.model.AcademyDAO;
import academy.model.AcademyService;
import academy.model.dto.AcademyDTO;

public class UserStartView {

	public static void main(String[] args) throws SQLException {
		AdminController controller = AdminController.getInstance();
		NaverSearchMap naver = NaverSearchMap.getInstance();
//		
//		ArrayList<AcademyDTO> academies1 = naver.getAcademy("서울 어학원 영어회화");
		JSONArray academies2 = naver.getAcademy("서울 어학원 토익");
		ArrayList<AcademyDTO> academies = new ArrayList<AcademyDTO>();
		academies = addAllAcademy1("서울 어학원 토익", academies2);
		
		for(AcademyDTO aca : academies) {
			System.out.println(aca.toString());
		}
	}
	
	
	
	private NaverSearchMap naver = NaverSearchMap.getInstance();
	
	public static ArrayList<AcademyDTO> addAllAcademy1(String query, JSONArray jsonItems_array) throws SQLException {
		ArrayList<AcademyDTO> academies = null;
		ArrayList<AcademyDTO> academiesS = null;
		String sb_name = query.substring(7);
		
		academies = new ArrayList<AcademyDTO>();
		for (int i = 0; i < jsonItems_array.size(); i++) { 	
        	JSONObject jsonobjectitems = ((JSONObject)jsonItems_array.get(i));
        	academies.add(new AcademyDTO(jsonobjectitems.get("title").toString(), jsonobjectitems.get("link").toString(), 
        			jsonobjectitems.get("telephone").toString(), jsonobjectitems.get("address").toString(), sb_name));
        }
		
//		return academies;
		academiesS = new ArrayList<>();
		academiesS = sortAcademy(academies);
		
		return academiesS;
	}
	
	public static ArrayList<AcademyDTO> sortAcademy(ArrayList<AcademyDTO> academies) {
		ArrayList<AcademyDTO> academiseSorted = new ArrayList<>();
		AcademyService comparator = AcademyService.getInstance();
		Collections.sort(academies, comparator);
		for (int j = 0; j < academies.size(); j++) {
			academiseSorted.add(new AcademyDTO(j, academies.get(j)));
		}
		
		return academiseSorted;
	}
	
	//Academy - CRUD
//	public static void notExistAcademy(String academyTitle) {
//		AcademyDTO 
//	}
	
//	//새로운 academy 저장
//	public static boolean addAllAcademy(ArrayList<AcademyDTO> academies) throws SQLException{
//		return AcademyDAO.addAllAcademy(academies);
//	}
	

	
}
