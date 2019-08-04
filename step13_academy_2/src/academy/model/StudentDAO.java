package academy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import academy.model.dto.StudentDTO;
import academy.model.util.DBUtil;

public class StudentDAO {
	
	// 저장
	public static boolean addStudent(StudentDTO student) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into student values(st_id.nextval, ?, ?");
			pstmt.setString(1, student.getSt_name());
			pstmt.setString(2, student.getGender());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 수정  -- 점검 필요
	public static boolean updateStudent(int st_id, Object obj) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			if(obj instanceof String) {
				if(((String) obj).length() == 1) {
					pstmt = con.prepareStatement("update student set gender = ? where st_id = ?");
					pstmt.setString(1, obj.toString());
					pstmt.setInt(2, st_id);
				} else {
					pstmt = con.prepareStatement("update student set st_name = ? where st_id = ?");
					pstmt.setString(1, obj.toString());
					pstmt.setInt(2, st_id);
				}
			} else {
				pstmt = con.prepareStatement("update student set academy_id = ? where st_id = ?");
				pstmt.setDouble(1, (Integer) obj);
				pstmt.setInt(2, st_id);
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
	public static boolean deleteStudent(int st_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from student where st_id = ?");
			pstmt.setDouble(1, st_id);
			
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
	public static StudentDTO getStudent(int st_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		StudentDTO student = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from student where st_id = ?");
			pstmt.setDouble(1, st_id);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				student = new StudentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return student;
	}
	
	// 모두 검색
	public static ArrayList<StudentDTO> getAllStudents() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<StudentDTO> students = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from student");
			
			students = new ArrayList<StudentDTO>();
			while(rset.next()) {
				students.add(new StudentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return students;
	}
	
}
