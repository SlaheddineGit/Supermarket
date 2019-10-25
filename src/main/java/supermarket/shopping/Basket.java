package supermarket.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.javamoney.moneta.Money;

import supermarket.product.Product;

public class Basket {

	private List<Product> products = new ArrayList<Product>();
	private Money price =  Money.of(0,Product.CURRENCY_CODE);
	
	public void addProduct(Product product) {
		if(product != null){
			getProducts().add(product);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

}
