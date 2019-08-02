package academy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import academy.model.dto.SubjectDTO;
import academy.model.util.DBUtil;

public class SubjectDAO {
   
   // 저장
   public static boolean addSubject(SubjectDTO subject) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("insert into subject values(sb_no.nextval, ?)");
         pstmt.setString(1, subject.getSb_name());
         
         int result = pstmt.executeUpdate();
         if(result == 1) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
      
   // 수정  과목 no를 활용해서 과목 이름, 카테고리 수정
   public static boolean updateSubject(int sb_no, String str, String str2) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         if(str2.equals("subject")) {
             pstmt = con.prepareStatement("update student set sb_name = ? where sb_no = ?");
             pstmt.setString(1, str);
             pstmt.setDouble(2, sb_no);
          } else if(str2.equals("category")) {
             pstmt = con.prepareStatement("update student set sb_category = ? where sb_no = ?");
             pstmt.setString(1, str);
             pstmt.setDouble(2, sb_no);
          } else {
        	  return false;
          }
         
         int result = pstmt.executeUpdate();
         if(result == 1) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
   
   // 삭제
   public static boolean deleteSubject(int sb_no) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("delete from subject where sb_no = ?");
         pstmt.setInt(1, sb_no);
         
         int result = pstmt.executeUpdate();
         if(result == 1) {
            return true;
         }
      } finally {
         DBUtil.close(con, pstmt);
      }
      return false;
   }
   
   // 특정 검색
   public static SubjectDTO getSubject(int sb_no) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      SubjectDTO subject = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("select * from subject where sb_no = ?");
         pstmt.setInt(1, sb_no);
         
         rset = pstmt.executeQuery();
         if(rset.next()) {
            subject = new SubjectDTO(rset.getInt(1), rset.getString(2));
         }
      } finally {
         DBUtil.close(con, pstmt, rset);
      }
      return subject;
   }
   
   // 모두 검색
   public static ArrayList<SubjectDTO> getAllSubject() throws SQLException {
      Connection con = null;
      Statement stmt = null;
      ResultSet rset = null;
      ArrayList<SubjectDTO> subjects = null;
      try {
         con = DBUtil.getConnection();
         stmt = con.createStatement();
         rset = stmt.executeQuery("select * from subject");
         
         subjects = new ArrayList<SubjectDTO>();
         while(rset.next()) {
            subjects.add(new SubjectDTO(rset.getInt(1), rset.getString(2)));
         }
      } finally {
         DBUtil.close(con, stmt, rset);
      }
      return subjects;
   }
}
