package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Member {//ȸ�� 
	private static String StuNum;//�й��� �����ڵ� ����� ���� ��������ȭ
	private String UserName;
	private String UserID;
    private String UserPW;
    private String PwCheck;
    private int Department;
    
	public Member() {
		super();
	}
	
	public String getStuNum() {
		return StuNum;
	}
	public void setStuNum(String stuNum) {
		StuNum = stuNum;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserPW() {
		return UserPW;
	}
	public void setUserPW(String userPW) {
		UserPW = userPW;
	}
	public String getPwCheck() {
		return PwCheck;
	}
	public void setPwCheck(String pwCheck) {
		PwCheck = pwCheck;
	}
	public int getDepartment() {
		return Department;
	}
	public void setDepartment(int department) {
		Department = department;
	}
	
    public void sendData(){
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
				
			String sql = "INSERT INTO member (StuNum,UserName, UserID, UserPW, Department) values ("
					+ "\'"+StuNum+"\'," + "\'"+UserName+"\'," +"\'"+UserID+"\',"
					+ "\'"+UserPW+"\'," + "\'"+Department+"\')";  
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("====================");
		}catch(Exception e) {
			System.out.println("ȸ�����Կ� �����Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
		}
	}
		
	public void sendData_list() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
				
			String sql = "INSERT INTO stuclasslist (StuNum) values (" + "\'"+StuNum+"\')";  
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("ȸ�����Կ� �����߽��ϴ�!");
			System.out.println("====================");
		}catch(Exception e) {
			System.out.println("ȸ�����Կ� �����Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
			System.out.println(e.getMessage());
		}
	}
}