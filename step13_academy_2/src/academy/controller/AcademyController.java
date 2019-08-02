package academy.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import academy.model.AcademyService;
import academy.model.dto.AcademyDTO;
import academy.model.dto.StudentDTO;
import academy.model.dto.SubjectDTO;
import academy.view.EndView;

public class AcademyController {
	private static AcademyController instance = new AcademyController();
	private AcademyController() { }
	public static AcademyController getInstance() {
		return instance;
	}
	
	private AcademyService service = AcademyService.getInstance();
	
	public void addAllAcademies(String query) {
		try {
			service.addAllAcademy(query);
			EndView.successView("Academy Add 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add 시도 실패");
		}
	}
	
	// 모든 학원 검색 로직
	public void getAllAcademies(){
		ArrayList<AcademyDTO> allAcademies = null;
		try{
			allAcademies = service.getAllAcademies();		
			EndView.successView("=================== 모든 아카데미 검색 성공 ===================");
			EndView.allListsView(allAcademies);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}
	
	// 특정 과목 학원 검색 로직
	public void getSpecificSubAcademies(String sb_name){
		ArrayList<AcademyDTO> specificAcademies = null;
		try{
			specificAcademies = service.getSpecificAcademies(sb_name);		
			EndView.successView("=================== 특정 과목 아카데미 검색 성공 ===================");
			EndView.allListsView(specificAcademies);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("특정 과목 프로젝트 검색시 에러 발생");
		}
	}
	
	// 특정 지역구 내 학원 검색 로직
	public void getSpecificLocAcademies(String sb_name, String loc) {
		ArrayList<AcademyDTO> specificAcademies2 = null;
		try{
			specificAcademies2 = service.getSpecificAcademies2(sb_name, loc);		
			EndView.successView("=================== 특정 과목 & 지역구 내 아카데미 검색 성공 ===================");
			EndView.allListsView(specificAcademies2);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 과목 & 지역구 내 아카데미 검색시 에러 발생");
		}
	}
	
	// 모든 과목 검색 로직
	public void getAllSubjects(){
		ArrayList<SubjectDTO> allSubjects = null;
		try{
			allSubjects = service.getAllSubjects();		
			EndView.successView("=================== 모든 아카데미 검색 성공 ===================");
			EndView.allListsView(allSubjects);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}
	
	// 모든 학생 검색 로직
	public void getAllStudents(){
		ArrayList<StudentDTO> allStudents = null;
		try{
			allStudents = service.getAllStudents();	
			EndView.successView("=================== 모든 아카데미 검색 성공 ===================");
			EndView.allListsView(allStudents);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}
	
}
