package chuDeDesignPattern;

public class StandardDeliveryStrategy implements DeliveryStrategy {
	@Override
	public void delivery() {
		System.out.print("Standard Delivery within 3 or 4 days, free of charge");
	}
}
