package academy.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import academy.api.NaverSearchMap;
import academy.model.dto.AcademyDTO;

public class AcademyService implements Comparator<AcademyDTO> {

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
		
		academies = sortAcademy(academies);
		
		return AcademyDAO.addAllAcademy(academies);
	}
	
	public ArrayList<AcademyDTO> sortAcademy(ArrayList<AcademyDTO> academies) {
		ArrayList<AcademyDTO> academiseSorted = new ArrayList<AcademyDTO>();
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
	
	
	
	
	@Override
	public int compare(AcademyDTO o1, AcademyDTO o2) {
		return o2.getTitle().compareTo(o1.getTitle());
	}
	
}
