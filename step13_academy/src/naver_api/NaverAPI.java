package naver_api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class NaverAPI {
   
   public static boolean addAcademy(JSONArray jsonitems_array) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      try{
         con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "test", "test");
         
          for (int i = 0; i < jsonitems_array.size(); i++) {    
            JSONObject jsonobjectitems = ((JSONObject)jsonitems_array.get(i));
            pstmt = con.prepareStatement("insert into academy values(academy_id.nextval, ?, ?, ?, ?)");
            pstmt.setString(1, jsonobjectitems.get("title").toString());
            pstmt.setString(2, jsonobjectitems.get("link").toString());
            pstmt.setString(3, jsonobjectitems.get("telephone").toString());
            pstmt.setString(4, jsonobjectitems.get("address").toString());

            System.out.println("----------------------------------");
            int result = pstmt.executeUpdate();
            
            if(result != 1){
               return true;
            }
          }
         

      }finally{
         try {
            if (pstmt != null) {
               pstmt.close();
               pstmt = null;
            }
            if (con != null) {
               con.close();
               con = null;
            }
         } catch (SQLException s) {
            s.printStackTrace();
         }
      }
      return false;
   }
   
   public static JSONArray getAcademy(String query) {
      String clientId = "ZANQ8mprp4o9wkxQ67HS";
      String clientSecret = "KdD44dmocQ";
      String displayN ="30";          //10(�⺻��), 30(�ִ�)
      String start ="1";              //1(�⺻��), 1000(�ִ�)
      String sort="comment";          //sort ���� �ɼ�: random(���絵��), comment(ī��/��α� ���� ���� ��)
      JSONArray jsonitems_array = null;
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
               obj = parser.parse(new InputStreamReader(con.getInputStream(), "utf-8"));
            } else {       // ���� �߻��� ���� ó��
               System.out.println("Error" + responseCode + " �߻�");
               obj = parser.parse(new InputStreamReader(con.getErrorStream(), "utf-8"));
            }
              
              JSONObject jsonObject = (JSONObject) obj;
              
              total = (long) jsonObject.get("total");
//              System.out.println(jsonObject.toJSONString()); //��ü ���
              if(jsonitems_array == null) {
                 jsonitems_array = (JSONArray) jsonObject.get("items");
              } else {
                 jsonitems_array.addAll((JSONArray) jsonObject.get("items"));
              }
              
//              for (int j = 0; j < jsonitems_array.size(); j++) {    
//                 JSONObject jsonobjectitems = ((JSONObject)jsonitems_array.get(j));
////                 System.out.println("academy_id : " + (i+j) );
//                 System.out.println(jsonobjectitems.get("title"));
//                 System.out.println(jsonobjectitems.get("link"));
//                 System.out.println(jsonobjectitems.get("address"));
//                 System.out.println(jsonobjectitems.get("telephone"));
////                 System.out.println(jsonobjectitems.get("description"));
////                 System.out.println(jsonobjectitems.get("roadAddress"));
////                 System.out.println(jsonobjectitems.get("category"));
//                 
//                 System.out.println("----------------------------------");
//              }
         }
      }catch(Exception e)
      {
         
      }
      return jsonitems_array;
   }
   
   public static void main(String[] args) {
      JSONArray jsonitems_array = getAcademy("ȭ���� Ŀ��");
      try {
         addAcademy(jsonitems_array);
      } catch (SQLException e) {
         e.printStackTrace();
      }
//       for (int i = 0; i < jsonitems_array.size(); i++) {    
//         JSONObject jsonobjectitems = ((JSONObject)jsonitems_array.get(i));
//         System.out.println("id" + (i+1));
//         System.out.println(jsonobjectitems.get("title"));
//         System.out.println(jsonobjectitems.get("link"));
//         System.out.println(jsonobjectitems.get("address"));
//         System.out.println(jsonobjectitems.get("telephone"));
//         
//         System.out.println("----------------------------------");
//       }   
   }

}