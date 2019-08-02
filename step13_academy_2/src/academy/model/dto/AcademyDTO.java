package academy.model.dto;

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
	private double sb_no;
	
	public AcademyDTO(String title, String sitelink, String contact, String address, String sb_name) {
		this.title = title;
		this.sitelink = sitelink;
		this.contact = contact;
		this.address = address;
		this.sb_name = sb_name;
	}
	
	public AcademyDTO(double academy_id, String title, String sitelink, String contact, String address, String sb_name) {
		this.academy_id = academy_id;
		this.title = title;
		this.sitelink = sitelink;
		this.contact = contact;
		this.address = address;
		this.sb_name = sb_name;
	}
	
	public AcademyDTO(double academy_id, String title, String sitelink, String contact, String address, double sb_no) {
		this.academy_id = academy_id;
		this.title = title;
		this.sitelink = sitelink;
		this.contact = contact;
		this.address = address;
		this.sb_no = sb_no;
	}
	
	
	
	@Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("�п� ID : ");
	      builder.append((int)academy_id);
	      builder.append("    �п� �̸� : ");
	      builder.append(title);
	      builder.append("\t\t ����Ʈ : ");
	      builder.append(sitelink);
	      builder.append("\t ����ó : ");
	      builder.append(contact);
	      builder.append("\t �ּ�: ");
	      builder.append(address);
	      builder.append("\t ���� ��ȣ : ");
	      builder.append(sb_name);
	      return builder.toString();
	}
	
}
