package academy.view;

import java.util.ArrayList;

public class EndView {

	// ��� �׸� ���
	public static void allListsView(ArrayList academies){
		int length = academies.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("�п� ����:  - " + academies.get(index));
			}
		}
	}
	
	// Ư�� �׸� ���
	public static void listView(Object obj) {
		System.out.println(obj);
	}
	
	// ���� ��Ȳ ���
	public static void showError(String message){
		System.out.println(message);		
	}
	
	public static void successView(String message) {
		System.out.println(message);	
	}
}
