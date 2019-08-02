package academy.view;

import academy.controller.AcademyController;

public class StartView {

	public static void main(String[] args) {
		AcademyController controller = AcademyController.getInstance();
		
		System.out.println("************선택 가능 과목 LIST GET************");
		controller.getAllSubjects();
		
		System.out.println("************서울 소재 선택 과목 학원 LIST GET************");
		controller.getSpecificSubAcademies("토익");
		
		System.out.println("************특정 지역구 내 학원 LIST GET************");
		controller.getSpecificLocAcademies("토익", "강남구");
		
		System.out.println("************등록 희망 학생 명단************");
		controller.getAllStudents();
	}
}
