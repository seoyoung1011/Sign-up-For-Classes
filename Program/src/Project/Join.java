package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Join {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Member Join = new Member();
		
		//�̸� �Է�
		System.out.println("===================");
		System.out.print("�̸��� �Է��ϼ��� : ");
		Join.setUserName(scan.next());
		
		//ID �Է�
		System.out.println("===================");
		int dowhilenum = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
		
			do {
				System.out.print("ID�� �Է��ϼ��� : ");
				Join.setUserID(scan.next());
				String sql = "SELECT Count(*) FROM member WHERE UserID=" 
						+ "\'"+Join.getUserID()+"\'"; //������ ���̺��� �Է��� ���̵� �ϳ��� ������
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql); //rs�� count 1
				int rowcnt = 0;
				if(rs.next()) {
					rowcnt = rs.getInt(1);
				}
				if(rowcnt == 0){ //���� ������
					dowhilenum = 1; //while���� ����������
					st.close(); //mysql���� �ݴ´�
				}else{ //rs�� ���� �ϳ��� ������
					System.out.println("�ߺ��� ���̵� �Դϴ�. �ٽ� �Է����ּ���");
				}
			} while(dowhilenum == 0); //�ٽ� while���� ������
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
		
		
		//PW �Է�
		while(dowhilenum == 1) {
			System.out.println("===================");
			System.out.print("��й�ȣ�� �Է��ϼ��� : ");
			Join.setUserPW(scan.next());
			System.out.print("��й�ȣ�� �� �� �� �Է��ϼ��� : ");
			Join.setPwCheck(scan.next());
			if(Join.getUserPW().equals(Join.getPwCheck())){
				dowhilenum+=1;
			}else{
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ� �ٽ� �Է����ּ���");
			}
		}
		
		//�а� �Է�
		System.out.println("===================");
		System.out.println("1 : ���̵�����Ʈ����� | 2 : ���̵�����ַ�ǰ� | 3 : ���̵������ΰ�");
		System.out.print("�а��� �Է��ϼ���(��ȣ��) : ");
		Join.setDepartment(scan.nextInt());
		
		//�й� �Է�
		System.out.println("===================");
		System.out.print("�й��� �Է��ϼ��� : ");
		Join.setStuNum(scan.next());
		
		Join.sendData();
		Join.sendData_list();
		
	}
	
}
		
