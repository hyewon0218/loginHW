package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class LoginDVO {
	private static LoginDVO l_dao;
	
	private LoginDVO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");//6jar
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}
	
	
	public static LoginDVO getInstance() {
		if(l_dao==null ) {
		  l_dao=new LoginDVO();
			
		}//end if
		return l_dao;
	}//getInstance
	
	
	
	private Connection getConn() throws SQLException {
		//2. 
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		Connection con=DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	
	public String login(LoginVO lvo)throws SQLException {
		LoginView lv=new LoginView();
		String adminName="";
//		boolean flag = false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
//		String getPass = null;
		
		try {
			con=getConn();
			String login="SELECT EMAIL FROM SIMPLE_LOGIN WHERE ID=? AND PASSWORD=?";

			pstmt=con.prepareStatement(login);
			
			pstmt.setString(1, lvo.getId());
			pstmt.setString(2, lvo.getPass());

			rs=pstmt.executeQuery();
			if(rs.next()) {
				adminName=rs.getString("EMAIL");
			}
//			if(rs.next()) {
//				getPass=rs.getString("password");
//				 if (getPass.equals(lv.getJpfPw())) {
//                     flag = true;
//				 }
//
//			}
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return adminName;

//		return flag;
	}
	
	/**
	 * 사용자 정보를 추가하는 일 
	 * @param lav
	 * @throws SQLException
	 */
	public boolean insertLunch(UserInfoVO uivo)throws SQLException {
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;;
		
		try {
			con=getConn();
			
			StringBuilder insertLogin=new StringBuilder();
			insertLogin.append("insert into simple_login")
			.append("(id,password,tel,email)")
			.append("values(?,?,?,?)");
			pstmt=con.prepareStatement(insertLogin.toString());

			pstmt.setString(1, uivo.getId());
			pstmt.setString(2, uivo.getPassword());
			pstmt.setString(3, uivo.getTel());
			pstmt.setString(4, uivo.getEmail());

			int cnt=pstmt.executeUpdate();///////////////////////////////////
			
		}finally {

			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return flag;
	}//insertLunch
	/**
	 * DB에 추가된 모든 사용자 목록 조회 
	 * @return
	 * @throws SQLException
	 */
	public List<UserInfoVO> selectLunchList() throws SQLException{
		List<UserInfoVO> list=new ArrayList<UserInfoVO>(); 
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {		
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch=
					"select id,password,tel,email from simple_login";
			pstmt=con.prepareStatement(selectLunch);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			UserInfoVO uivo=null;
			while(rs.next()) {
				uivo=new UserInfoVO(rs.getString("id"), rs.getString("password"), rs.getString("tel"), rs.getString("email"));
				list.add(uivo);
			}
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return list;
		}//selectLunchList


//	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(lv, "DB에서 문제가 발생했습니다.");
//	}
	
}
