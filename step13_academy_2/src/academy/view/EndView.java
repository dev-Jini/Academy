package academy.view;

import java.util.ArrayList;

public class EndView {

	// 모든 항목 출력
	public static void allListsView(ArrayList academies){
		int length = academies.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("학원 정보:  - " + academies.get(index));
			}
		}
	}
	
	// 특정 항목 출력
	public static void listView(Object obj) {
		System.out.println(obj);
	}
	
	// 예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}
	
	public static void successView(String message) {
		System.out.println(message);	
	}
}
