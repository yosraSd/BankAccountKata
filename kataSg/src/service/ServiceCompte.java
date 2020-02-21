package service;

import compte.Compte;
import transaction.TransactionCompte;

public class ServiceCompte {
	Compte cm= new Compte();

	public void deposit(long rib, float amountD) {
		Compte cltCompte = cm.getClientCompte(rib);
		if (cltCompte != null) {
			System.out.println(cltCompte.getRib());

			float currAmount = cltCompte.getAmount();
			cltCompte.setAmount(amountD + currAmount);
			cltCompte.setBalance(amountD + currAmount);
			System.out.println("Transaction was made with sucess. New amount " + cltCompte.getAmount() + " new balance "
					+ cltCompte.getBalance());
			// create a transaction and save it
			TransactionCompte tr = new TransactionCompte(rib, amountD, "deposit");
			tr.saveTransaction();
		} else{
			System.out.println("Transaction failed, please check your credentials");

		}

	}

	public void withdraw(long rib, float amountW) {

		Compte cltCompte = cm.getClientCompte(rib);
		if (cltCompte != null) {
			float currAmount = cltCompte.getAmount();
			// check if the amount to be withdrew exceeds the current amount
			if (currAmount <= amountW) {
				float oldBalance = cltCompte.getBalance();
				float tmpBalance = oldBalance + (currAmount - amountW);
				System.out.println(tmpBalance);
				cltCompte.setBalance(tmpBalance);
				cltCompte.setAmount(0);
			} else {
				if (currAmount > amountW) {
					float tmpamount = currAmount - amountW;
					cltCompte.setAmount(tmpamount);
					float oldBalance = cltCompte.getBalance();
					cltCompte.setBalance(oldBalance-amountW);
				}
			}
			// ccreate a transaction and save it
			TransactionCompte tr = new TransactionCompte(rib, amountW, "withdraw");
			tr.saveTransaction();
			System.out.println("Transaction was made with sucess. New amount " + cltCompte.getAmount() + " new balance "
					+ cltCompte.getBalance());
		} else{
			System.out.println("Transaction failed, please check your credentials");

		}

	}
	
	public void accountTransactions(long rib){
		TransactionCompte tr = new TransactionCompte(rib);
		tr.seeAllTransactions(rib);
	}
}
