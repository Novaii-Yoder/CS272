/** Represents a transaction */
public class Transaction {
	private int number; /** number of shares in the transaction */
	private int price;  /** price per share in the transaction */
	private boolean sell; /** type of the transaction (true if "sell", 
	                              false if "buy") */
	
	/** Construct a Transaction with specified type, number, and price 
	*  Parameters:
	* 	s - type of transaction (true if it is a sell transaction, 
	*           false otherwise)
	*   n - number of shares
	*   p - price per share 
	*  Postcondition: This Transaction has been initialized with the 
	*   specified type (s), number (n), and price (p)
	*/
	public Transaction(boolean s, int n, int p) {
		sell = s;
		number = n;
		price = p;
	}
	
	/** Determines whether this Transaction is a sell transaction 
	 *  or not
	 * Returns: 
	 *  the type of this transaction (true if "sell", false if "buy")
	 */
	public boolean isSell() {
		return sell;
	}
	
	/** Get the number of shares of this Transaction
	 * Returns: the number of shares 
	 */
	public int getNumber() {
		return number;
	}
	
	/** Get the price per share of this Transaction
	 * Returns: the price per share 
	 */
	public int getPrice() {
		return price;
	}
	
	/** Change the number of shares in this Transaction 
	 * Parameter: newNumber - the new number of shares
	 * Postcondition: 
	 *  This Transaction's number of shares has been changed 
	 *  to the new number of shares (newNumber)
	 */
	public void changeNumber(int newNumber) {
		number = newNumber;
	}
	
	/** Returns a string representation of the transaction */
	public String toString(){
		if (sell)
			return ("Sell " + number + " at $" + price);
		else
			return ("Buy " + number + " at $" + price);
	}
}
