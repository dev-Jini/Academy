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
		
		ArrayList<AcademyDTO> academies1 = naver.getAcademy("���� ����");
		ArrayList<AcademyDTO> academies2 = naver.getAcademy("���� ������");
		ArrayList<AcademyDTO> academies3 = naver.getAcademy("���� ũ�ν���");
		
		
		System.out.println("************Academy ���� ADD ALL************");
		controller.addAllAcademy(academies1);
		controller.addAllAcademy(academies2);
		controller.addAllAcademy(academies3);
	}
}
