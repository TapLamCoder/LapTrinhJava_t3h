package chuDeDesignPattern;

public class QuickDeliveryStrategy implements DeliveryStrategy {

	@Override
	public void delivery() {
		System.out.print("Quick Delivery within 1 or 2 days with an additional charge of 1 Dollar");
	}
	
}