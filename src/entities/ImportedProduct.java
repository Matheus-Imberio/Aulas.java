package entities;

public class ImportedProduct extends Product {
	private double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}

	public double totalPrice() {
		return this.getPrice() + customsFee;
	}

	@Override
	public String priceTag() {
		return this.getName() + " $" + String.format("%.2f",this.totalPrice()) + "( Customs Fee: $" + customsFee + ")";
	}
}
