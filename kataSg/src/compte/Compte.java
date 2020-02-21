package compte;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Compte {
	private String cltName;
	private String cltLastName;
	private String date;
	private long rib;
	private float amount;
	private float balance;

	// will represent the compte DB table
	private static List<Compte> compteDB = new ArrayList<>();

	// get current date in this format
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();

	public Compte() {
		super();
	}

	public Compte(String cltName, String cltLastName, long rib) {
		super();
		this.cltName = cltName;
		this.cltLastName = cltLastName;
		this.rib = rib;
		this.date = dtf.format(now);
		this.amount = 0;
		this.balance = 0;
		// create the account and save it
		saveAccount();
	}

	// save account to the DB in this case compteDB
	public void saveAccount() {
		compteDB.add(this);
	}

	// return the clt account if the account exists
	public Compte getClientCompte(long rib) {
 		for (Compte cp : compteDB) {
			if (cp.getRib() == rib) {
 				return cp;
			}
		}
		return null;
	}

	// getters, setters and toString
	public String getCltName() {
		return cltName;
	}

	public void setCltName(String cltName) {
		this.cltName = cltName;
	}

	public String getCltLastName() {
		return cltLastName;
	}

	public void setCltLastName(String cltLastName) {
		this.cltLastName = cltLastName;
	}

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public DateTimeFormatter getDtf() {
		return dtf;
	}

	public void setDtf(DateTimeFormatter dtf) {
		this.dtf = dtf;
	}

	@Override
	public String toString() {
		return "Account :Full Name =" + cltName + " " + cltLastName + ". Account cration date=" + date + ", rib=" + rib
				+ ", amount=" + amount + ", balance=" + balance  ;
	}

}
