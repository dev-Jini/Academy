package academy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademyStudentDTO {
	private double academy_id;
	private String title;
	private String sitelink;
	private String contact;
	private String address;
	private double sb_no;
	private int st_id;
	private String st_name;
	private String gender;
	
	
	public AcademyStudentDTO(int st_id, String st_name, String gender, double academy_id, String title, String sitelink,
			String contact, String address, double sb_no) {
		this.st_id = st_id;
		this.st_name = st_name;
		this.gender = gender;
		this.academy_id = academy_id;
		this.title = title;
		this.sitelink = sitelink;
		this.contact = contact;
		this.address = address;
		this.sb_no = sb_no;
	}
}
