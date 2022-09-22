package pkg2;

import java.io.Serializable;

public class Product implements Serializable {
    public String Id;
    public String title;
    public int quantity;
    public double price;

    public Product(String id, String title, int quantity, double price) {
        this.Id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    
	public Product() {

	}


	public void setId(String id) {
		Id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return Id + "   |   " + title + "   |   " + quantity + "   |   " + price;
    }

}
