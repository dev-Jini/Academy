package academy.view;

import academy.controller.AcademyController;
import academy.model.dto.StudentDTO;

public class StartView {

	public static void main(String[] args) {
		
		AcademyController controller = AcademyController.getInstance();
		
//		System.out.println("************���� ���� ���� LIST GET************");
//		controller.getAllSubjects();
//		
//		System.out.println("************���� ���� ���� ���� �п� LIST GET************");
//		controller.getSpecificSubAcademies();
//		
//		System.out.println("************Ư�� ������ �� �п� LIST GET************");
//		controller.getSpecificLocAcademies();
//		
//		System.out.println("************��� ��� �л� LIST GET************");
//		controller.getAllStudents();
//		
//		System.out.println("************Ư�� �л� ���� GET************");
//		controller.getStudent();
//		
//		controller.addStudent(new StudentDTO(1, "�̸�", "M"));
		
//	      
//		System.out.println("************Ư�� �л� ���� öȸ************");
//	    controller.deleteStudent(54);
//	    controller.getAllStudents();
		
		System.out.println("************�п��� �Ҽӵ� ��� �л� ����Ʈ ��ü ���************");
		controller.getAllAcademyStudents();
		
		System.out.println("************�п� ���� �л� ����************");
	    controller.updateStudent(25, 345);
	    controller.getAllStudents();
		
		System.out.println("************Ư�� �п��� �Ҽӵ� ������ ���************");
		controller.getAcademyStudents(350);
	}
}
 