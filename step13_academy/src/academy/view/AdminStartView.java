package academy.view;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import academy.api.NaverSearchMap;
import academy.controller.AdminController;
import academy.model.dto.AcademyDTO;

public class AdminStartView {

	public static void main(String[] args) {
		AdminController controller = AdminController.getInstance();
		NaverSearchMap naver = NaverSearchMap.getInstance();
		
		ArrayList<AcademyDTO> academies1 = naver.getAcademy("서울 복싱");
		ArrayList<AcademyDTO> academies2 = naver.getAcademy("서울 주짓수");
		ArrayList<AcademyDTO> academies3 = naver.getAcademy("서울 크로스핏");
		
		
		System.out.println("************Academy 정보 ADD ALL************");
		controller.addAllAcademy(academies1);
		controller.addAllAcademy(academies2);
		controller.addAllAcademy(academies3);
	}
}
