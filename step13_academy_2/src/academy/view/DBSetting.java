package academy.view;

import academy.controller.AcademyController;

public class DBSetting {
	public static void main(String[] args) {
		AcademyController controller = AcademyController.getInstance();
		
		System.out.println("************Academy ���� GET ALL************");
		controller.addAllAcademies("���� ����ȸȭ");
		controller.addAllAcademies("���� ����");
		controller.addAllAcademies("���� �߱���");
//		controller.addAllAcademies("���� �䰡");
		controller.addAllAcademies("���� ����");
//		controller.addAllAcademies("���� ������");
//		controller.addAllAcademies("���� ũ�ν���");
//		controller.addAllAcademies("���� ���α׷����п�");
		// ���ϴ� ��� �п� ���� ũ�Ѹ�
	}
}
