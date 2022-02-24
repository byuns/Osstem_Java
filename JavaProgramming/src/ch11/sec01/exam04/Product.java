package ch11.sec01.exam04;

public class Product {
	private int num;
	private String company;
	private String productName;
	private int price;
	
	
	Product(int num,String company, String productName,int price){
		this.num = num;
		this.company = company;
		this.productName = productName;
		this.price = price;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Product) {
			Product product = (Product)object;
			if(num == product.num && productName.equals(product.productName)){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		
		return num + productName.hashCode();
	}
	@Override
	public String toString() {
		return (num + ", " +  company.toString() + ", " + productName.toString() + ", " + price );
	}

}
