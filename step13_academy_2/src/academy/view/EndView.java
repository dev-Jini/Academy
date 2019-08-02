package academy.view;

import java.util.ArrayList;

public class EndView {

	//모든 프로젝트 출력
	public static void allListsView(ArrayList academies){
		int length = academies.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("학원 정보:  - " + academies.get(index));
			}
		}
	}
	
	//예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}
	
	public static void successView(String message) {
		System.out.println(message);	
	}
}
