package academy.view;

import academy.controller.AcademyController;
import academy.model.dto.StudentDTO;

public class StartView {

	public static void main(String[] args) {
		
		AcademyController controller = AcademyController.getInstance();
		
//		System.out.println("************선택 가능 과목 LIST GET************");
//		controller.getAllSubjects();
//		
//		System.out.println("************서울 소재 선택 과목 학원 LIST GET************");
//		controller.getSpecificSubAcademies();
//		
//		System.out.println("************특정 지역구 내 학원 LIST GET************");
//		controller.getSpecificLocAcademies();
//		
//		System.out.println("************등록 희망 학생 LIST GET************");
//		controller.getAllStudents();
//		
//		System.out.println("************특정 학생 정보 GET************");
//		controller.getStudent();
//		
//		controller.addStudent(new StudentDTO(1, "이름", "M"));
		
//	      
//		System.out.println("************특정 학생 수강 철회************");
//	    controller.deleteStudent(54);
//	    controller.getAllStudents();
		
		System.out.println("************학원에 소속된 모든 학생 리스트 전체 출력************");
		controller.getAllAcademyStudents();
		
		System.out.println("************학원 변경 학생 정보************");
	    controller.updateStudent(25, 345);
	    controller.getAllStudents();
		
		System.out.println("************특정 학원에 소속된 수강생 출력************");
		controller.getAcademyStudents(350);
	}
}
 