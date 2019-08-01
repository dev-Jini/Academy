package academy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import academy.model.dto.StudentDTO;
import academy.model.util.DBUtil;

public class StudentDAO {
	
	public static boolean addStudent(StudentDTO student) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into student values(st_id.nextval, ?, ?, ?");
			pstmt.setString(1, student.getSt_name());
			pstmt.setString(2, student.getGender());
			pstmt.setDouble(3, student.getPhoneNumber());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
