package academy.view;

import academy.controller.AcademyController;

public class DBSetting {
	public static void main(String[] args) {
		AcademyController controller = AcademyController.getInstance();
		
		System.out.println("************Academy 정보 GET ALL************");
		controller.addAllAcademies("서울 영어회화");
		controller.addAllAcademies("서울 토익");
		controller.addAllAcademies("서울 중국어");
//		controller.addAllAcademies("서울 요가");
		controller.addAllAcademies("서울 복싱");
//		controller.addAllAcademies("서울 주짓수");
//		controller.addAllAcademies("서울 크로스핑");
//		controller.addAllAcademies("서울 프로그래밍학원");
		// 원하는 모든 학원 정보 크롤링
	}
}
