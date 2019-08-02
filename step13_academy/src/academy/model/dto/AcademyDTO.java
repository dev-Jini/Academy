package academy.model.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademyDTO  {
	private double academy_id;
	private String title;
	private String sitelink;
	private String contact;
	private String address;
	private String sb_name;
	
	public AcademyDTO(String title, String sitelink, String contact, String address, String sb_name) {
		this.title = title;
		this.sitelink = sitelink;
		this.contact = contact;
		this.address = address;
		this.sb_name = sb_name;
	}
	
	public AcademyDTO(int academy_id, AcademyDTO academy) {
		this.academy_id = (double) academy_id;
		this.sitelink = academy.getSitelink();
		this.contact = academy.getContact();
		this.address = academy.getAddress();
		this.sb_name = academy.getSb_name();
	}
}
