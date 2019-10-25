package supermarket.product;
import java.util.Currency;
import java.util.Locale;

import org.javamoney.moneta.Money;




public class Product {

	private String name;
	private Money price;
	private int quantity;
	private Money totalPrice;
	public static final String CURRENCY_CODE = Currency.getInstance(Locale.UK).getCurrencyCode();
	
	
	public Product(String name, Money price) {
		this.name = name;
		this.price = price;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Money getPrice() {
		return price;
	}
	public void setPrice(Money price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Money getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Money totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
