package test;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		//1.���տͻ���(����̨)����
		System.out.println("----���������----");
		System.out.println("�����һ��������");
		Scanner scanner = new Scanner(System.in);
		String strNum1 = scanner.nextLine();

		System.out.println("���������");
		String oper = scanner.nextLine();

		System.out.println("����ڶ���������");
		String strNum2 = scanner.nextLine();

		//2.��������
		double result = 0;
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);

		Operation operation = OperationFactory.getOperation(oper);
		operation.setNum1(num1);
		operation.setNum2(num2);
		result = operation.getResult();

		//3.���ؽ��
		System.out.println(strNum1 + oper + strNum2 + "=" + result);
	}
}
