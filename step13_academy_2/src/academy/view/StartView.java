package academy.view;

import academy.controller.AcademyController;

public class StartView {

	public static void main(String[] args) {
		AcademyController controller = AcademyController.getInstance();
		
		System.out.println("************���� ���� ���� LIST GET************");
		controller.getAllSubjects();
		
		System.out.println("************���� ���� ���� ���� �п� LIST GET************");
		controller.getSpecificSubAcademies("����");
		
		System.out.println("************Ư�� ������ �� �п� LIST GET************");
		controller.getSpecificLocAcademies("����", "������");
		
		System.out.println("************��� ��� �л� ���************");
		controller.getAllStudents();
	}
}
