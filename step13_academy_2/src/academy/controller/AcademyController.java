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
	// NAVER ���� API�κ��� �˻���(query)���� ��� ���� DB�� ����
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
	
	// <�߰� ����> Ư�� ���� �п� �˻� ����
	public void getSpecificSubAcademies(){
		ArrayList<AcademyDTO> specificAcademies = null;
		String sb_name = null;
		
		scan = new Scanner(System.in);
		System.out.println("��� ������� �Է����ּ���: ");
		sb_name = scan.nextLine();
		
		try{
			specificAcademies = service.getSpecificAcademies(sb_name);		
			EndView.successView("=================== Ư�� ���� ��ī���� �˻� ���� ===================");
			EndView.allListsView(specificAcademies);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("Ư�� ���� ������Ʈ �˻��� ���� �߻�");
		}
	}
	
	// <�߰� ����> Ư�� ������ �� �п� �˻� ����
	public void getSpecificLocAcademies() {
		ArrayList<AcademyDTO> specificAcademies2 = null;
		String sb_name = null;
		String loc = null;
		
		try{
			scan = new Scanner(System.in);
			System.out.println("��� ������� �Է����ּ���: ");
			sb_name = scan.nextLine();
			System.out.println("��� ���� �̸��� �Է����ּ���: ");
			loc = scan.nextLine();
			
			specificAcademies2 = service.getSpecificAcademies2(sb_name, loc);		
			EndView.successView("=================== Ư�� ���� & ������ �� ��ī���� �˻� ���� ===================");
			EndView.allListsView(specificAcademies2);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("��� ���� & ������ �� ��ī���� �˻��� ���� �߻�");
		}
	}
	
	// Ư�� �п� �˻�
	public void getAcademy() {
		AcademyDTO academy = null;
		double academy_id = 0.0;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("ã���� �ϴ� �п� ID�� �Է��� �ּ���: ");
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
			EndView.successView("=================== Academy Add ���� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add ���� �߻�");
		}
	}
	public void updateAcademy(double academy_id, String title) {
		try {
			service.updateAcademy(academy_id, title);
			EndView.successView("=================== Academy Update ���� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add ���� �߻�");
		}
	}
	public void deleteAcademy(double academy_id) {
		try {
			service.deleteAcademy(academy_id);
			EndView.successView("=================== Academy Add ���� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add ���� �߻�");
		}
	}
	
	// Student
	// ��� �л� �˻� ����
	public void getAllStudents(){
		ArrayList<StudentDTO> allStudents = null;
		try{
			allStudents = service.getAllStudents();	
			EndView.successView("=================== ��� �л� ��� �˻� ���� ===================");
			EndView.allListsView(allStudents);
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("��� �л� ��� �˻��� ���� �߻�");
		}
	}
	
	// Ư�� �л� �˻�
	public void getStudent() {
		StudentDTO student = null;
		int st_id = 0;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("ã���� �ϴ� �л��� �й��� �Է����ּ���: ");
			st_id = scan.nextInt();
			
			student = service.getStudent(st_id);
			EndView.successView("=================== Ư�� �л� ��� �˻� ���� ===================");
			EndView.listView(student);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� �л� ��� �˻��� ���� �߻�");
		}
	}
	
	// �л� �߰�
	public void addStudent(StudentDTO student) {
		try {
			service.addStudent(student);
			EndView.successView("=================== Student Add ���� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Student Add �õ� ����");
		}
	}
	
	// Ư�� �л� �п� ����
	public void updateStudent(int st_id, Object obj) {
		try {
			service.updateStudent(st_id, obj);
			EndView.successView("=================== Ư�� �л� �п� ���� �Ϸ� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� �л� �п� ����� ����");
		}
	}
	   
	// Ư�� �л� ����
	public void deleteStudent(int st_id) {
		try {
			service.deleteStudent(st_id);
			EndView.successView("=================== Ư�� �л� ���� öȸ �Ϸ� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� �л� ���� öȸ�� ����");
		}
	}

	// Subject
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
	// Ư�� ���� �˻�
	public void getSubject() {
		SubjectDTO subject = null;
		int sb_no = 0;
		
		try {
			scan = new Scanner(System.in);
			System.out.println("ã���� �ϴ� ������ ��ȣ�� �Է����ּ���: ");
			sb_no = scan.nextInt();
			
			subject = service.getSubject(sb_no);
			EndView.successView("=================== Ư�� ���� �˻� ���� ===================");
			EndView.listView(subject);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� �п� ��� �˻��� ���� �߻�");
		}
	}
	
	// ���� �߰�
	public void addSubject(SubjectDTO subject) {
		try {
			service.addSubject(subject);
			EndView.successView("=================== Subject Add ���� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Subject Add �õ� ����");
		}
	}
	
	// Ư�� ���� �̸� ����
	public void updateSubject(int sb_no, String sb_name) {
		try {
			service.updateSubject(sb_no, sb_name);
			EndView.successView("=================== Ư�� ���� �̸� ���� �Ϸ� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� ���� �̸� ����� ����");
		}
	}
	   
	// Ư�� �л� ����
	public void deleteSubject(int sb_no) {
		try {
			service.deleteSubject(sb_no);
			EndView.successView("=================== Ư�� ���� ���� �Ϸ� ===================");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� ���� ���Ž� ����");
		}
	}
	
	// AcademyStudnet
	public void getAllAcademyStudents() {
		ArrayList<AcademyStudentDTO> getAllAcademyStudents = null;
		try {
			getAllAcademyStudents = AcademyService.getAllAcadmeyStudents();
			EndView.successView("=================== �п��� �Ҽӵ� ��� ������ ��� �Ϸ� ===================");
			EndView.allListsView(getAllAcademyStudents);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("�п��� �Ҽӵ� ��� ������ ��½� ����");
		}      
	}
	public void getAcademyStudents(double academy_id) {
		ArrayList<AcademyStudentDTO> getAcademyStudents = null;
		try {
			getAcademyStudents = AcademyService.getAcademyStudents(academy_id);
			EndView.successView("=================== Ư�� �п� ������ ��� �Ϸ� ===================");
			EndView.allListsView(getAcademyStudents);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Ư�� �п� ������ ��½� ����");
		}
	}
}
