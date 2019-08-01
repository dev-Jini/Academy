package academy.view;

import org.json.simple.JSONArray;

import academy.api.NaverSearchMap;
import academy.controller.AdminController;

public class AdminStartView {

	public static void main(String[] args) {
		AdminController controller = AdminController.getInstance();
		NaverSearchMap naver = NaverSearchMap.getInstance();
		JSONArray jsonitems_array = naver.getAcademy("ȭ���� Ŀ��");
		
		System.out.println("************Academy ���� ADD************");
		controller.addAllAcademy(jsonitems_array);
	}
}
