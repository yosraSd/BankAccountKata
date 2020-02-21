package main;

import compte.Compte;
import service.ServiceCompte;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte cp= new  Compte("John", "Snow", 51236);
		Compte acc= new  Compte("ellen", "degenourous", 12336);
System.out.println(cp.toString());
		ServiceCompte sr = new ServiceCompte();
		sr.deposit(cp.getRib(), 300);
		sr.withdraw(cp.getRib(), 1000);
//		sr.accountTransactions(cp.getRib());
		sr.deposit(acc.getRib(), 3000);
		sr.withdraw(acc.getRib(), 1000);
		sr.accountTransactions(acc.getRib());
	}

}
