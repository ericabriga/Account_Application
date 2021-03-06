import java.util.HashMap;

import com.google.gson.Gson;

public class Service {
	//static int count =1;
	static HashMap<String,Account> listAccount = new HashMap <String,Account> ();
	
	public boolean addAccount (Account account) {
		Account exists = listAccount.get(account.getAccountNumber()); 
		if (exists != null) {
			return false;
		} else {
			listAccount.put(account.getAccountNumber(), account);
			return true;
		}
	}

	
	public Account getAccount (String number) {
		
		Account account = listAccount.get(number);
		if (account != null) {
			return account;
			//return account.getFirstName() + " " + account.getLastName() + " " + account.getAccountNumber();
		} else {
			return null;
		}
	}
	
	public String toJSon() {
		Gson gson = new Gson();
		String json = gson.toJson(listAccount);
		return json;
	}


	public int nameSearch(String firstname) {
		int count = 0;
		for(Account accounts : listAccount.values()) {
			if(accounts.getFirstName().equals(firstname)) {
				count++;
			}
		}
		return count;
	}

	public int nameSearch8(String firstname) {
		//So, we get the values from the hashmap
		return (int) listAccount.values().stream().filter(account -> account.getFirstName().equals(firstname)).count();
	}
 }