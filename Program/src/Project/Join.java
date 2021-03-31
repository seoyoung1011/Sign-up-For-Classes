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
		
		//이름 입력
		System.out.println("===================");
		System.out.print("이름을 입력하세요 : ");
		Join.setUserName(scan.next());
		
		//ID 입력
		System.out.println("===================");
		int dowhilenum = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaproject";
			Connection con = DriverManager.getConnection(url, "root", "mirim");
		
			do {
				System.out.print("ID를 입력하세요 : ");
				Join.setUserID(scan.next());
				String sql = "SELECT Count(*) FROM member WHERE UserID=" 
						+ "\'"+Join.getUserID()+"\'"; //데이터 테이블에서 입력한 아이디가 하나라도 있으면
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql); //rs에 count 1
				int rowcnt = 0;
				if(rs.next()) {
					rowcnt = rs.getInt(1);
				}
				if(rowcnt == 0){ //값이 없으면
					dowhilenum = 1; //while문을 빠져나오고
					st.close(); //mysql문을 닫는다
				}else{ //rs에 값이 하나라도 있으면
					System.out.println("중복된 아이디 입니다. 다시 입력해주세요");
				}
			} while(dowhilenum == 0); //다시 while문을 돌린다
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
		
		
		//PW 입력
		while(dowhilenum == 1) {
			System.out.println("===================");
			System.out.print("비밀번호를 입력하세요 : ");
			Join.setUserPW(scan.next());
			System.out.print("비밀번호를 한 번 더 입력하세요 : ");
			Join.setPwCheck(scan.next());
			if(Join.getUserPW().equals(Join.getPwCheck())){
				dowhilenum+=1;
			}else{
				System.out.println("비밀번호가 일치하지 않습니다 다시 입력해주세요");
			}
		}
		
		//학과 입력
		System.out.println("===================");
		System.out.println("1 : 뉴미디어소프트웨어과 | 2 : 뉴미디어웹솔루션과 | 3 : 뉴미디어디자인과");
		System.out.print("학과를 입력하세요(번호로) : ");
		Join.setDepartment(scan.nextInt());
		
		//학번 입력
		System.out.println("===================");
		System.out.print("학번를 입력하세요 : ");
		Join.setStuNum(scan.next());
		
		Join.sendData();
		Join.sendData_list();
		
	}
	
}
		
