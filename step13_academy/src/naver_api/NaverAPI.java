package naver_api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NaverAPI {

	public static void main(String[] args) {
		
		String clientId = "ZANQ8mprp4o9wkxQ67HS";
		String clientSecret = "KdD44dmocQ";
		String query = "서울 요가";
		String displayN ="30";          //10(기본값), 30(최대)
		String start ="1";              //1(기본값), 1000(최대)
		String sort="comment";          //sort 정렬 옵션: random(유사도순), comment(카페/블로그 리뷰 개수 순)
		
		String apiURL ="https://openapi.naver.com/v1/search/local";
		
		try {
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
				obj = parser.parse(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else { // 에러 발생시 예외 처리
				obj = parser.parse(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
	        
	        JSONObject jsonObject = (JSONObject) obj;
	        System.out.println(jsonObject.toJSONString()); //전체 출력
	        JSONArray jsonitems_array = (JSONArray) jsonObject.get("items");
	        
	        for (int i = 0; i < jsonitems_array.size(); i++) { 	
	        	JSONObject jsonobjectitems = ((JSONObject)jsonitems_array.get(i));
	        	System.out.println(jsonobjectitems.get("title"));
	        	System.out.println(jsonobjectitems.get("link"));
	        	System.out.println(jsonobjectitems.get("address"));
	        	System.out.println(jsonobjectitems.get("telephone"));
	        	
	        	System.out.println("----------------------------------");
	        }
	        
		}catch(Exception e)
		{
			
		}
	}

}