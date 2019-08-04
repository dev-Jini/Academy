package academy.controller;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;

import academy.model.AcademyDAO;
import academy.model.AcademyService;
import academy.model.dto.AcademyDTO;
import academy.model.dto.AcademyStudentDTO;
import academy.model.dto.StudentDTO;
import academy.model.dto.SubjectDTO;
import academy.view.EndView;

public class AcademyController {
	private static AcademyController instance = new AcademyController();
	private AcademyController() { }
	public static AcademyController getInstance() {
		return instance;
	}

	Scanner scan;
	
	private AcademyService service = AcademyService.getInstance();
	
	// Academy
	// NAVER 지도 API로부터 검색어(query)기준 모든 정보 DB에 저장
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
	
	// <추가 구현> 특정 과목 학원 검색 로직
	public void getSpecificSubAcademies(){
		ArrayList<AcademyDTO> specificAcademies = null;
		String sb_name = null;
		
		scan = new Scanner(System.in);
		System.out.println("희망 과목명을 입력해주세요: ");
		sb_name = scan.nextLine();
		
		try{
			specificAcademies = service.getSpecificAcademies(sb_name);		
			EndView.successView("=================== 특정 과목 아카데미 검색 성공 ===================");
			EndView.allListsView(specificAcademies);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("특정 과목 프로젝트 검색시 에러 발생");
		}
	}
	
	// <추가 구현> 특정 지역구 내 학원 검색 로직
	public void getSpecificLocAcademies() {
		ArrayList<AcademyDTO> specificAcademies2 = null;
		String sb_name = null;
		String loc = null;
		
		try{
			scan = new Scanner(System.in);
			System.out.println("희망 과목명을 입력해주세요: ");
			sb_name = scan.nextLine();
			System.out.println("희망 지역 이름을 입력해주세요: ");
			loc = scan.nextLine();
			
			specificAcademies2 = service.getSpecificAcademies2(sb_name, loc);		
			EndView.successView("=================== 특정 과목 & 지역구 내 아카데미 검색 성공 ===================");
			EndView.allListsView(specificAcademies2);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 과목 & 지역구 내 아카데미 검색시 에러 발생");
		}
	}
	
	// 특정 학원 검색
	public void getAcademy() {
		AcademyDTO academy = null;
		double academy_id = 0.0;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("찾고자 하는 학원 ID를 입력해 주세요: ");
			academy_id = scan.nextDouble();
			academy = service.getAcademy(academy_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		EndView.listView(academy);
	}
	public void addAcademy(AcademyDTO academy) {
		try {
			service.addAcademy(academy);
			EndView.successView("=================== Academy Add 성공 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add 에러 발생");
		}
	}
	public void updateAcademy(double academy_id, String title) {
		try {
			service.updateAcademy(academy_id, title);
			EndView.successView("=================== Academy Update 성공 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add 에러 발생");
		}
	}
	public void deleteAcademy(double academy_id) {
		try {
			service.deleteAcademy(academy_id);
			EndView.successView("=================== Academy Add 성공 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add 에러 발생");
		}
	}
	
	// Student
	// 모든 학생 검색 로직
	public void getAllStudents(){
		ArrayList<StudentDTO> allStudents = null;
		try{
			allStudents = service.getAllStudents();	
			EndView.successView("=================== 모든 학생 명단 검색 성공 ===================");
			EndView.allListsView(allStudents);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("모든 학생 명단 검색시 에러 발생");
		}
	}
	
	// 특정 학생 검색
	public void getStudent() {
		StudentDTO student = null;
		int st_id = 0;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("찾고자 하는 학생의 학번을 입력해주세요: ");
			st_id = scan.nextInt();
			
			student = service.getStudent(st_id);
			EndView.successView("=================== 특정 학생 명단 검색 성공 ===================");
			EndView.listView(student);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 학생 명단 검색시 에러 발생");
		}
	}
	
	// 학생 추가
	public void addStudent(StudentDTO student) {
		try {
			service.addStudent(student);
			EndView.successView("=================== Student Add 성공 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Student Add 시도 실패");
		}
	}
	
	// 특정 학생 학원 변경
	public void updateStudent(int st_id, Object obj) {
		try {
			service.updateStudent(st_id, obj);
			EndView.successView("=================== 특정 학생 학원 변경 완료 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 학생 학원 변경시 에러");
		}
	}
	   
	// 특정 학생 삭제
	public void deleteStudent(int st_id) {
		try {
			service.deleteStudent(st_id);
			EndView.successView("=================== 특정 학생 수강 철회 완료 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 학생 수강 철회시 에러");
		}
	}

	// Subject
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
	// 특정 과목 검색
	public void getSubject() {
		SubjectDTO subject = null;
		int sb_no = 0;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("찾고자 하는 과목의 번호를 입력해주세요: ");
			sb_no = scan.nextInt();
			
			subject = service.getSubject(sb_no);
			EndView.successView("=================== 특정 과목 검색 성공 ===================");
			EndView.listView(subject);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 학원 명단 검색시 에러 발생");
		}
	}
	
	// 과목 추가
	public void addSubject(SubjectDTO subject) {
		try {
			service.addSubject(subject);
			EndView.successView("=================== Subject Add 성공 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Subject Add 시도 실패");
		}
	}
	
	// 특정 과목 이름 변경
	public void updateSubject(int sb_no, String sb_name) {
		try {
			service.updateSubject(sb_no, sb_name);
			EndView.successView("=================== 특정 과목 이름 변경 완료 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 과목 이름 변경시 에러");
		}
	}
	   
	// 특정 학생 삭제
	public void deleteSubject(int sb_no) {
		try {
			service.deleteSubject(sb_no);
			EndView.successView("=================== 특정 과목 제거 완료 ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 과목 제거시 에러");
		}
	}
	
	// AcademyStudnet
	public void getAllAcademyStudents() {
		ArrayList<AcademyStudentDTO> getAllAcademyStudents = null;
		try {
			getAllAcademyStudents = AcademyService.getAllAcadmeyStudents();
			EndView.successView("=================== 학원에 소속된 모든 수강생 출력 완료 ===================");
			EndView.allListsView(getAllAcademyStudents);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("학원에 소속된 모든 수강생 출력시 에러");
		}      
	}
	public void getAcademyStudents(double academy_id) {
		ArrayList<AcademyStudentDTO> getAcademyStudents = null;
		try {
			getAcademyStudents = AcademyService.getAcademyStudents(academy_id);
			EndView.successView("=================== 특정 학원 수강생 출력 완료 ===================");
			EndView.allListsView(getAcademyStudents);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("특정 학원 수강생 출력시 에러");
		}
	}
}
