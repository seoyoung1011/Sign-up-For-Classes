package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql ����̹� ȣ��
			String url = "jdbc:mysql://localhost:3306/javaproject";//DB �ּ� Ȯ��
			Connection con = DriverManager.getConnection(url, "root", "mirim");//DB ����
			
			//ID,PW Ȯ���� ���� dowhile��
			int dowhilenum = 0;
			do {
				System.out.print("���̵� �Է��ϼ��� : ");
				member.setUserID(scan.next());
			
				System.out.print("��й�ȣ�� �Է��ϼ��� : ");
				member.setUserPW(scan.next());
			
				//ID, PW ��ġ���� Ȯ��
				String sql = "SELECT Count(*) FROM member WHERE UserID=" + "\'"+member.getUserID()+"\'" + " AND UserPW = " 
						+ "\'"+member.getUserPW()+"\'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				int rowcnt = 0;
				if(rs.next()) {
					rowcnt = rs.getInt(1);
				}
				if(rowcnt == 0){
					System.out.println("�߸��� ID �Ǵ� �н����� �Դϴ�.");
				}else {
					dowhilenum = 1;
					st.close();
				}
			}while(dowhilenum == 0);
			
			String sql_Num = "SELECT StuNum FROM member WHERE UserID=" + "\'"+member.getUserID()+"\'";
			Statement st_Num = con.createStatement();
			ResultSet rs_Num = st_Num.executeQuery(sql_Num);
			String stuNum = null;
			if(rs_Num.next()) {
				stuNum = rs_Num.getString(1);
			}
			member.setStuNum(stuNum);
			st_Num.close();
			
			System.out.println("=====================");
			System.out.println("�α��ο� �����Ͽ����ϴ�!");
			System.out.println("=====================");
			//ȯ���ϴ� ��� �̸��� �ҷ����� ����
			String sql = "SELECT UserName FROM member WHERE StuNum=" + "\'"+member.getStuNum()+"\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String name = null;
			if(rs.next()) {
				name = rs.getString(1);
			}
			System.out.println(name+"�� ȯ���մϴ�.");
			
			
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
		
	}

}