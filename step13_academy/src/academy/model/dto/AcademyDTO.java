package academy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademyDTO {
	private double academy_id;
	private String title;
	private String sitelink;
	private String contact;
	private String address;
}
