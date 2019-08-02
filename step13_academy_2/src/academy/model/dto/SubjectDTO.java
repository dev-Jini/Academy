package academy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
	private int sb_no;
	private String sb_name;
	
	@Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("과목 번호 : ");
	      builder.append(sb_no);
	      builder.append("\t과목 이름 : ");
	      builder.append(sb_name);
	   
	      return builder.toString();
	}
	
}
