package academy.view;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import academy.api.NaverSearchMap;
import academy.controller.AcademyController;
import academy.model.dto.AcademyDTO;

public class StartView {

	public static void main(String[] args) {
		AcademyController controller = AcademyController.getInstance();
//		NaverSearchMap naver = NaverSearchMap.getInstance();
//		
//		ArrayList<AcademyDTO> academies1 = naver.getAcademy("���� ���п� ����ȸȭ");
//		ArrayList<AcademyDTO> academies2 = naver.getAcademy("���� ���п� ����");
		
		System.out.println("************Academy ���� ADD ALL************");
//		controller.addAllAcademy("���� ���п� ����ȸȭ");
		controller.addAllAcademy("���� ���п� ����");
	}
}
