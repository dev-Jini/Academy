package academy.view;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import academy.api.NaverSearchMap;
import academy.controller.AdminController;
import academy.model.dto.AcademyDTO;

public class AdminStartView {

	public static void main(String[] args) {
		AdminController controller = AdminController.getInstance();
//		NaverSearchMap naver = NaverSearchMap.getInstance();
//		
//		ArrayList<AcademyDTO> academies1 = naver.getAcademy("서울 어학원 영어회화");
//		ArrayList<AcademyDTO> academies2 = naver.getAcademy("서울 어학원 토익");
		
		System.out.println("************Academy 정보 ADD ALL************");
//		controller.addAllAcademy("서울 어학원 영어회화");
		controller.addAllAcademy("서울 어학원 토익");
	}
}
