package supermarket.product;

import org.javamoney.moneta.Money;


public class Orange extends Product {

	public Orange() {
		super("Orange", Money.of(0.50,Product.CURRENCY_CODE));
	}

}
