package test;

public class OperationFactory {
	public static Operation getOperation(String oper){
		if ("+".equals(oper)) {
			return new AddOperation();
		}else if("-".equals(oper)){
			return new SubtractionOperation();
		}
		return null;
	}
}
