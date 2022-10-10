package Model;
 
/**
 *
 * @author MrTuan
 */
public class Product {

    private int id, categoryID;
    private String name, description, original;
    private int quantity;
    private double price;
    private boolean status;
    private int viewNumber;
    private String Create_at, Update_at;

    public Product() {
    }

    public Product(int id, int categoryID, String name, String description, String original, int quantity, double price, boolean status, int viewNumber, String Create_at, String Update_at) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.original = original;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.viewNumber = viewNumber;
        this.Create_at = Create_at;
        this.Update_at = Update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public String getCreate_at() {
        return Create_at;
    }

    public void setCreate_at(String Create_at) {
        this.Create_at = Create_at;
    }

    public String getUpdate_at() {
        return Update_at;
    }

    public void setUpdate_at(String Update_at) {
        this.Update_at = Update_at;
    }

    @Override
    public String toString() {
        return "DAO{" + "id=" + id + ", categoryID=" + categoryID + ", name=" + name + ", description=" + description + ", original=" + original + ", quantity=" + quantity + ", price=" + price + ", status=" + status + ", viewNumber=" + viewNumber + ", Create_at=" + Create_at + ", Update_at=" + Update_at + '}';
    }
}
