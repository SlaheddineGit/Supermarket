package supermarket.product;
import org.javamoney.moneta.Money;




public class Apple extends Product {

	
	

	public Apple() {
		super("Apple", Money.of(0.20,Product.CURRENCY_CODE));
	}

}
