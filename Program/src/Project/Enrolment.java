package Project;

import java.util.Scanner;

public class Enrolment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		ClassAdd ca1 = new ClassAdd();
		
		int dowhilenum = 0;
		do {
			System.out.println("=====================");
			System.out.print("1. 수업 목록 출력   |  2. 수강 신청    |  3. 내 수강 목록 조회    |   4. 로그아웃  => ");
			int button = scan.nextInt();
			switch(button) {
			case 1: {
				System.out.println("====수업 목록====");
				ca1.printList();
				System.out.println();
				}break;
			case 2: {
				System.out.print("수강신청할 수업의 코드를 입력하시오: ");
				ca1.setClassCode(scan.next());
				ca1.sendData();
				}break;
			case 3: {
				System.out.println("회원님의 수업 목록을 불러옵니다...");
				ca1.ShowMy();
				}break;
			case 4: {
				System.out.println("로그아웃 되었습니다.");
				dowhilenum = 1;
				}break;
			}
		}while(dowhilenum == 0);
		
	}

}
