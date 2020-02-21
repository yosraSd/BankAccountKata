package transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import compte.Compte;

public class TransactionCompte {
	private Compte acc;
	private String date;
	private long rib;
	private float amount;
	private String trType;
	private static Map<Long, ArrayList> transactionDB = new HashMap<Long, ArrayList>();
	private List<TransactionCompte> trList;
	// get current date in this format
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();

	public TransactionCompte() {
		super();
	}

	public TransactionCompte(long rib) {
		super();
	}

	public TransactionCompte(long rib, float amount, String trType) {
		super();
		this.date = dtf.format(now);
		this.rib = rib;
		this.amount = amount;
		this.trType = trType;
	}

	// save transaction
	public void saveTransaction() {
		trList= new ArrayList<>();
		trList.add(this);
		if (transactionDB.containsKey(rib)) {
			List<TransactionCompte> tmpTr = null;
			transactionDB.get(rib).add(this);
		} else {
			transactionDB.put(rib, (ArrayList) trList);
		}

	}

	// print all transaction of a specific account 
	public void seeAllTransactions(long rib){
		if (transactionDB.containsKey(rib)) {
			// print the array containing all transactions of the specific client
			System.out.println("transactions: ");
			for (Map.Entry<Long, ArrayList> entry : transactionDB.entrySet()) {
				for(Entry<Long, ArrayList> t: transactionDB.entrySet()){
  					for(Object elem: t.getValue()){
 						System.out.println("Rib : " + entry.getKey() + " Transaction  : " + elem.toString()); 							

 					}
				}
			}


		} else {
			System.out.println("No transactions were made");
		}
		
	}

	@Override
	public String toString() {
		return " [  Transaction type : " + trType + ", amount= " + amount + " on the " + date+ "]";
	}
}
