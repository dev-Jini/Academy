package academy.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import academy.model.dto.AcademyDTO;

public class NaverSearchMap {
	
	private static NaverSearchMap instance = new NaverSearchMap();
	private NaverSearchMap() { }
	public static NaverSearchMap getInstance() {
		return instance;
	}
	
	public static ArrayList<AcademyDTO> getAcademy(String query) {
		String clientId = "ZANQ8mprp4o9wkxQ67HS";
		String clientSecret = "KdD44dmocQ";
		String displayN ="30";        				  // 10(�⺻��), 30(�ִ�)
		String start ="1";            				  // 1(�⺻��), 1000(�ִ�)
		String sort="comment";       				  // sort ���� �ɼ�: random(���絵��), comment(ī��/��α� ���� ���� ��)
		JSONArray jsonitems_array = null;
		ArrayList<AcademyDTO> academies = null;
		String sb_name = query.substring(3);
		long total = 31;
		
		String apiURL ="https://openapi.naver.com/v1/search/local";
		
		try {
			for(int i = 1; i < total; i+=30) {
				start = String.valueOf(i);
				String text = URLEncoder.encode(query, "UTF-8");
				
				String postParams ="query="+text+"&display="+displayN+"&start="+start+"&sort="+sort;
				URL url = new URL(apiURL + "?" + postParams);
		        HttpURLConnection con = (HttpURLConnection)url.openConnection();
		        con.setRequestMethod("GET");
		        con.setRequestProperty("X-Naver-Client-Id", clientId);
		        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		        
		        int responseCode = con.getResponseCode();
		        
		        Object obj;
		        
		        JSONParser parser = new JSONParser();
		        
		        if (responseCode == 200) {
					System.out.println("�����ڵ� " + responseCode + " �߻�");
					Thread.sleep(200);							// ���� ����
					obj = parser.parse(new InputStreamReader(con.getInputStream(), "utf-8"));
					
				} else { 		// ���� �߻��� ���� ó��
					System.out.println("Error" + responseCode + " �߻�");
					obj = parser.parse(new InputStreamReader(con.getErrorStream(), "utf-8"));
				}
		        
		        JSONObject jsonObject = (JSONObject) obj;
		        
		        total = (long) jsonObject.get("total");
//		        System.out.println(jsonObject.toJSONString()); //��ü ���
		        if(jsonitems_array == null) {
			        jsonitems_array = (JSONArray) jsonObject.get("items");
		        } else {
		        	jsonitems_array.addAll((JSONArray) jsonObject.get("items"));
		        }
			}
			academies = new ArrayList<AcademyDTO>();
			for (int j = 0; j < jsonitems_array.size(); j++) { 	
	        	JSONObject jsonobjectitems = ((JSONObject)jsonitems_array.get(j));
	        	academies.add(new AcademyDTO(jsonobjectitems.get("title").toString(), jsonobjectitems.get("link").toString(), 
	        			jsonobjectitems.get("telephone").toString(), jsonobjectitems.get("address").toString(), sb_name));
	        }
			
		}catch(Exception e)
		{
			
		}
		return academies;
	}
}


