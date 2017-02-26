package Visitor;

import domain.EightAbateMemeber;
import domain.NineAbateMemeber;
import domain.NoAbateMemeber;
import domain.SevenAbateMemeber;

public class Visitor {
	public double visit(NoAbateMemeber noAbateMemeber){
		return noAbateMemeber.doComputer();
	}
	public double visit(NineAbateMemeber nineAbateMemeber){
		return nineAbateMemeber.doComputer();
	}
	public double visit(EightAbateMemeber eightAbateMemeber){
		return eightAbateMemeber.doComputer();
	}
	public double visit(SevenAbateMemeber sevenAbateMemeber){
		return sevenAbateMemeber.doComputer();
	}
}
