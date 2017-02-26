package zhk;

import departments.Hr;
import departments.Sale;
import departments.SaleTeamBonus;
import bonus.Bonus;
import bonus.PeopleBonus;
import bonus.TeamBonus;

public class Test {
	public static void main(String[] args){
		Bonus bonus = new PeopleBonus(new Hr());
		bonus.computerBonus();
		bonus=new PeopleBonus(new Sale());
		bonus.computerBonus();
//		bonus=new TeamBonus(new HrPerpleBonus());
//		bonus.computerBonus();
//		bonus=new TeamBonus(new SaleTeamBonus());
//		bonus.computerBonus();
		
	}
}
