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
			System.out.print("1. ���� ��� ���   |  2. ���� ��û    |  3. �� ���� ��� ��ȸ    |   4. �α׾ƿ�  => ");
			int button = scan.nextInt();
			switch(button) {
			case 1: {
				System.out.println("====���� ���====");
				ca1.printList();
				System.out.println();
				}break;
			case 2: {
				System.out.print("������û�� ������ �ڵ带 �Է��Ͻÿ�: ");
				ca1.setClassCode(scan.next());
				ca1.sendData();
				}break;
			case 3: {
				System.out.println("ȸ������ ���� ����� �ҷ��ɴϴ�...");
				ca1.ShowMy();
				}break;
			case 4: {
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				dowhilenum = 1;
				}break;
			}
		}while(dowhilenum == 0);
		
	}

}
