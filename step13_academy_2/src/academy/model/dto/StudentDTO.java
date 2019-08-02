package academy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private int st_id;
	private String st_name;
	private String gender;
	private double academy_id;
	
	@Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("������ ID : ");
	      builder.append(st_id);
	      builder.append("\t������ ���� : ");
	      builder.append(st_name);
	      builder.append("\t ���� : ");
	      builder.append(gender);
	      builder.append("\t �Ҽ� �п� id: ");
	      builder.append((int)academy_id);
	      
	      return builder.toString();
	}

	public StudentDTO(int st_id, String st_name, String gender) {
		this.st_id = st_id;
		this.st_name = st_name;
		this.gender = gender;
	}
}
