package academy.controller;

import java.sql.SQLException;

import org.json.simple.JSONArray;

import academy.model.AcademyService;
import academy.view.EndView;

public class AdminController {
	private static AdminController instance = new AdminController();
	private AdminController() { }
	public static AdminController getInstance() {
		return instance;
	}
	
	private AcademyService service = AcademyService.getInstance();
	
	public void addAllAcademy(JSONArray jsonitems_array) {
		try {
			service.addAllAcademy(jsonitems_array);
			EndView.successView("Academy Add 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add 시도 실패");
		}
	}
}
