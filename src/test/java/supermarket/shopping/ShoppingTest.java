package supermarket.shopping;

import static junit.framework.Assert.*;

import java.util.stream.Collectors;

import org.javamoney.moneta.Money;
import org.junit.Test;

import supermarket.exception.InValidBasketException;
import supermarket.product.Apple;
import supermarket.product.Orange;
import supermarket.product.Product;
import supermarket.product.Watermelon;

public class ShoppingTest {

	@Test
	public void testConstructBasket() {
		Shopping shopping = new Shopping();
		String[] args = { "A2", "O5", "W4" };
		Basket basket = shopping.constructBasket(args);
		assertNotNull("testConstructBasket null basket",basket);
		assertEquals("testConstructBasket basket size <> 3",basket.getProducts().size(), 3);
		
		int appleQuantity = basket.getProducts().stream().filter(x -> x instanceof Apple).collect(Collectors.toList()).get(0).getQuantity();
		assertEquals("testConstructBasket wrong apple quantity",appleQuantity, 2);
	}

	@Test(expected= IllegalArgumentException.class)
	public void testConstructBasketThrowIllegalArgumentException() {
		Shopping shopping = new Shopping();
		String[] args = { "B2", "C5"};
		Basket basket = shopping.constructBasket(args);
	}
	
	@Test
	public void testCalculateTolalPrice() throws InValidBasketException {
		Apple apple = new Apple();
		apple.setQuantity(2);

		Orange orange = new Orange();
		orange.setQuantity(5);

		Watermelon watermelon = new Watermelon();
		watermelon.setQuantity(4);

		Basket basket = new Basket();
		basket.addProduct(apple);
		basket.addProduct(orange);
		basket.addProduct(watermelon);

		Shopping shopping = new Shopping();

		shopping.calculateTolalPrice(basket);

		assertEquals(Money.of(5.30, Product.CURRENCY_CODE),basket.getPrice());
		assertEquals("testCalculateTolalPrice apple wrong quantity",4, apple.getQuantity());
		assertEquals("testCalculateTolalPrice watermelon wrong quantity",4, watermelon.getQuantity());
		assertEquals("testCalculateTolalPrice orange wrong quantity",5, orange.getQuantity());
		
		assertEquals("testCalculateTolalPrice apple wrong total price",Money.of(0.40, Product.CURRENCY_CODE), apple.getTotalPrice());
		assertEquals("testCalculateTolalPrice watermelon wrong total price",Money.of(2.40, Product.CURRENCY_CODE), watermelon.getTotalPrice());
		assertEquals("testCalculateTolalPrice orange wrong total price",Money.of(2.50, Product.CURRENCY_CODE), orange.getTotalPrice());
		

	}

	@Test(expected= InValidBasketException.class)
	public void testCalculateTolalPriceThrowException() throws InValidBasketException {
		Shopping shopping = new Shopping();
		shopping.calculateTolalPrice(null);
	}
	

}
