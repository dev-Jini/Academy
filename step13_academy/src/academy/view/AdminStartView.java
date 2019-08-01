package academy.view;

import org.json.simple.JSONArray;

import academy.api.NaverSearchMap;
import academy.controller.AdminController;

public class AdminStartView {

	public static void main(String[] args) {
		AdminController controller = AdminController.getInstance();
		NaverSearchMap naver = NaverSearchMap.getInstance();
		JSONArray jsonitems_array = naver.getAcademy("화서역 커피");
		
		System.out.println("************Academy 정보 ADD************");
		controller.addAllAcademy(jsonitems_array);
	}
}
