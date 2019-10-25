package supermarket.product;

import org.javamoney.moneta.Money;


public class Watermelon extends Product {

	public Watermelon() {
		super("Watermelon", Money.of(0.80,Product.CURRENCY_CODE));
	}

}
