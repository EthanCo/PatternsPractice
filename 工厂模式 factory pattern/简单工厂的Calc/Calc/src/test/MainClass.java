package test;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		//1.接收客户端(控制台)输入
		System.out.println("----计算机程序----");
		System.out.println("输入第一个操作数");
		Scanner scanner = new Scanner(System.in);
		String strNum1 = scanner.nextLine();

		System.out.println("输入运算符");
		String oper = scanner.nextLine();

		System.out.println("输入第二个操作符");
		String strNum2 = scanner.nextLine();

		//2.进行运算
		double result = 0;
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);

		Operation operation = OperationFactory.getOperation(oper);
		operation.setNum1(num1);
		operation.setNum2(num2);
		result = operation.getResult();

		//3.返回结果
		System.out.println(strNum1 + oper + strNum2 + "=" + result);
	}
}
