package academy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private double st_id;
	private String st_name;
	private String gender;
	private int phoneNumber;
	private double academy_id;
	
	@Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("������ ID : ");
	      builder.append((int)st_id);
	      builder.append("\t������ ���� : ");
	      builder.append(st_name);
	      builder.append("\t ���� : ");
	      builder.append(gender);
	      builder.append("\t �޴��� ��ȣ: ");
	      builder.append(phoneNumber);
	      builder.append("\t �Ҽ� �п� id: ");
	      builder.append((int)academy_id);
	      
	      return builder.toString();
	}

	public StudentDTO(double st_id, String st_name, String gender, int phoneNumber) {
		super();
		this.st_id = st_id;
		this.st_name = st_name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}
}
