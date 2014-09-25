import java.util.Date;
/* 
 * Simulates a credit card
 */
public class CreditCard {
	private long cardNum;
	private Date expiration;
	
	/*
	 * Constructs a Credit Card
	 * @param cardNum the cards number
	 * @param expiration the date the card expires
	 */
	public CreditCard(long cardNum, Date expiration)
	{
		this.cardNum = cardNum;
		this.expiration = expiration;
	}
	/*
	 *  Gets the card number
	 *  @returns the cards the number
	 */
	public long getCardNum()
	{
		return cardNum;
	}
	/*
	 * Gets the cards Expiration Date
	 * @returns the cards's Expiration
	 */
	public Date getExpiration()
	{
		return expiration;
	}
}	