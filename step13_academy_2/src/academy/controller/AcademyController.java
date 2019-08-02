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
			EndView.successView("Academy Add ����");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add �õ� ����");
		}
	}
	
	// ��� �п� �˻� ����
	public void getAllAcademies(){
		ArrayList<AcademyDTO> allAcademies = null;
		try{
			allAcademies = service.getAllAcademies();		
			EndView.successView("=================== ��� ��ī���� �˻� ���� ===================");
			EndView.allListsView(allAcademies);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}
	
	// Ư�� ���� �п� �˻� ����
	public void getSpecificSubAcademies(String sb_name){
		ArrayList<AcademyDTO> specificAcademies = null;
		try{
			specificAcademies = service.getSpecificAcademies(sb_name);		
			EndView.successView("=================== Ư�� ���� ��ī���� �˻� ���� ===================");
			EndView.allListsView(specificAcademies);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("Ư�� ���� ������Ʈ �˻��� ���� �߻�");
		}
	}
	
	// Ư�� ������ �� �п� �˻� ����
	public void getSpecificLocAcademies(String sb_name, String loc) {
		ArrayList<AcademyDTO> specificAcademies2 = null;
		try{
			specificAcademies2 = service.getSpecificAcademies2(sb_name, loc);		
			EndView.successView("=================== Ư�� ���� & ������ �� ��ī���� �˻� ���� ===================");
			EndView.allListsView(specificAcademies2);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("��� ���� & ������ �� ��ī���� �˻��� ���� �߻�");
		}
	}
	
	// ��� ���� �˻� ����
	public void getAllSubjects(){
		ArrayList<SubjectDTO> allSubjects = null;
		try{
			allSubjects = service.getAllSubjects();		
			EndView.successView("=================== ��� ��ī���� �˻� ���� ===================");
			EndView.allListsView(allSubjects);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}
	
	// ��� �л� �˻� ����
	public void getAllStudents(){
		ArrayList<StudentDTO> allStudents = null;
		try{
			allStudents = service.getAllStudents();	
			EndView.successView("=================== ��� ��ī���� �˻� ���� ===================");
			EndView.allListsView(allStudents);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}
	
}
