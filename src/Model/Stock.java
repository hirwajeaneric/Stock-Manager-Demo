package Model;

/**
 *
 * @author hirwa
 */
public class Stock {
    private String type;
    private String name;
    private String quantity;
    private String quality;
    private String price;
    private String entryDate;

    public Stock() {
    }

    public Stock(String type, String name, String quantity, String quality, String price, String entryDate) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.quality = quality;
        this.price = price;
        this.entryDate = entryDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
    
    
}
