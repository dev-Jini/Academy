package academy.view;

import academy.controller.AcademyController;

public class StartView {

	public static void main(String[] args) {
		
		AcademyController controller = AcademyController.getInstance();
		
		System.out.println("************선택 가능 과목 LIST GET************");
		controller.getAllSubjects();
		
		System.out.println("************서울 소재 선택 과목 학원 LIST GET************");
		controller.getSpecificSubAcademies("프로그래밍학원");
		
		System.out.println("************특정 지역구 내 학원 LIST GET************");
		controller.getSpecificLocAcademies("프로그래밍학원", "서초구");
//		
//		System.out.println("************등록 희망 학생 명단************");
//		controller.getAllStudents();
	}
}
 