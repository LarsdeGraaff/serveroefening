package be.vdab;

/**
 * Created by jeansmits on 24/06/15.
 */
public class OrderItem {
    private String product;
    private int aantal;
    private double prijs;

    public OrderItem(String product, int aantal, double prijs) {
        this.product = product;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    public String getProduct() {
        return product;
    }


    public int getAantal() {
        return aantal;
    }

    public double getPrijs() {
        return prijs;
    }

    public double getTotal() {
        return prijs * aantal;
    }

}
