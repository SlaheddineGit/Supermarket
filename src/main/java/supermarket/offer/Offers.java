package supermarket.offer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


import supermarket.product.Product;

public enum Offers {

	APPLEOFFER("Apple",p -> {
								p.setTotalPrice( p.getPrice().multiply(p.getQuantity()));
								// buy one get one free ==> double the quantity
								p.setQuantity(p.getQuantity() * 2);
							}),
	WATERMELONOFFER("Watermelon",p -> {
										//calculate number of free watermelon = quantity / 3  
										int freeWatermelonNumber =  p.getQuantity()/3;
										int watermelonNumberToPay = p.getQuantity() - freeWatermelonNumber;
										p.setTotalPrice( p.getPrice().multiply(watermelonNumberToPay));
									  });
	
	private String productName;
	private Consumer<Product> offer;
	
	private Offers(String productName, Consumer<Product> offer) {
		this.productName = productName;
		this.offer = offer;
	}
	
	public static Consumer<Product> getOffer(String productName){
		List<Offers> offers = Arrays.stream(values()).filter(offer -> offer.productName.equals(productName)).collect(Collectors.toList());
		return offers.isEmpty()? null : offers.get(0).offer;
	}
}
