package academy.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import academy.model.AcademyService;
import academy.model.dto.AcademyDTO;
import academy.view.EndView;

public class AdminController {
	private static AdminController instance = new AdminController();
	private AdminController() { }
	public static AdminController getInstance() {
		return instance;
	}
	
	private AcademyService service = AcademyService.getInstance();
	
	public void addAllAcademy(String query) {
		try {
			service.addAllAcademy(query);
			EndView.successView("Academy Add 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("Academy Add 시도 실패");
		}
	}
}
