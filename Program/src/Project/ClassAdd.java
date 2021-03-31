package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ClassAdd {
	private String ClassCode;//�����ڵ带 ���� ����
	private String ClassName;
	private String Teacher;
	
	Member member = new Member();
	
	public ClassAdd() {
		super();
	}

	public String getClassCode() {
		return ClassCode;
	}
	public void setClassCode(String classCode) {
		ClassCode = classCode;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}

	//���� ��� ����ϴ� �޼���
	public void printList() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
			
			String sql = "SELECT ClassCode, ClassName, Teacher FROM Classlist";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String ClassCode = rs.getString("ClassCode");
				String ClassName = rs.getString("ClassName");
				String Teacher = rs.getString("Teacher");
				
				System.out.format("%s | %s | %s \n", ClassCode, Teacher, ClassName);
			}
			st.close();
		} catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
	} //end of printlist()
	
	//�����͸� ������ �޼���
	public void sendData() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
			
			String sql = "SELECT ClassName FROM classlist WHERE ClassCode=" + "\'"+ClassCode+"\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String ClassName = null;
			if(rs.next()) {
				ClassName = rs.getString(1);
			}
			
			//�����ڵ带 ���� �α����� �л��ڵ� �÷� ���� �ִ´�
			
			String sql_L1 = "SELECT Count(*) FROM stuclasslist WHERE StuNum=" + "\'"+member.getStuNum()+"\' AND list_1 <> " + "\'"+"\'";
			Statement stE1 = con.createStatement();
			ResultSet rsE1 = st.executeQuery(sql_L1);
			int empty = 0;
			if(rsE1.next()) {
				empty = rsE1.getInt(1);
			}
			String sql_L2 = "SELECT Count(*) FROM stuclasslist WHERE StuNum=" + "\'"+member.getStuNum()+"\' AND list_2 <> " + "\'"+"\'";
			Statement stE2 = con.createStatement();
			ResultSet rsE2 = st.executeQuery(sql_L2);
			int empty2 = 0;
			if(rsE2.next()) {
				empty2 = rsE2.getInt(1);
			}
			String sql_L3 = "SELECT Count(*) FROM stuclasslist WHERE StuNum=" + "\'"+member.getStuNum()+"\' AND list_3 <> " + "\'"+"\'";
			Statement stE3 = con.createStatement();
			ResultSet rsE3 = st.executeQuery(sql_L3);
			int empty3 = 0;
			if(rsE3.next()) {
				empty3 = rsE3.getInt(1);
			}
			
			//���� �߰��� ��, �������� ������ 3������
			//3�� �ʰ� ��û�� �޼��� ����
			
			if(empty == 0) { //ù��° ������ ��������� empty=0
				String list_1 = "UPDATE stuclasslist SET list_1=" + "\'"+ClassName+"\'"
					+ " WHERE StuNum =" + "\'"+member.getStuNum()+"\'";
				Statement stL_1 = con.createStatement();
				stL_1.executeUpdate(list_1);
				st.close();
			}else if(empty2 == 0){ //�ι�° ������ ��������� empty2=0
				String list_2 = "UPDATE stuclasslist SET list_2=" + "\'"+ClassName+"\'"
					+ " WHERE StuNum =" + "\'"+member.getStuNum()+"\'";
				Statement stL_2 = con.createStatement();
				stL_2.executeUpdate(list_2);
				st.close();
			}else if(empty3 == 0) { //����° ������ ��������� empty3=0
				String list_3 = "UPDATE stuclasslist SET list_3=" + "\'"+ClassName+"\'"
					+ " WHERE StuNum =" + "\'"+member.getStuNum()+"\'";
				Statement stL_3 = con.createStatement();
				stL_3.executeUpdate(list_3);
				st.close();
			}else {
				System.out.println("�� �̻� ��û�� �� �����ϴ�. �����ڿ��� �����ϼ���.");
				st.close();
			}
			stE1.close();
			stE2.close();
			stE3.close();
			
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}	
	} //end of sendData()
	
	//���� ��������� �����ִ� �޼ҵ�
	public void ShowMy() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
			
			//�й��� ���� �÷��� �ִ� ���� ���
			String sql = "SELECT * FROM stuClasslist WHERE StuNum =" + "\'" + member.getStuNum() + "\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				for(int i = 2; i < 5; i++) { //2=? 1���� �ϸ� �й��� ��µǾ
					String list = rs.getString(i); //���� ��� ���
						if(list == null) { //���������
							list = " "; //����ִ� �״�� ���
						}
					System.out.format((i-1) + ". %s \n", list);
				}
			}
			st.close();
		} catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
	} //end of showmy()
}
