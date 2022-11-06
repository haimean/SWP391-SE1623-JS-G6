package Model;

import java.sql.Timestamp;

/**
 *
 * @author MrTuan
 */
public class Product {

    private int id, categoryID;
    private String name;
    private String description;
    private String original;
    private int quantity;
    private double price;
    private boolean status;
    private int viewNumber;
    private Timestamp create_at;
    private Timestamp update_at;
    private String proImg;

    public Product() {
    }

    public Product(int id, int categoryID, String name, String description, String original, int quantity, double price) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.original = original;
        this.quantity = quantity;
        this.price = price;
    }

    
    public Product(int id, int categoryID, String name, String description, String original, int quantity, double price, boolean status, int viewNumber, Timestamp create_at, Timestamp update_at, String proImg) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.original = original;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.viewNumber = viewNumber;
        this.create_at = create_at;
        this.update_at = update_at;
        this.proImg = proImg;
    }

    public Product(int categoryID, String name, String description, String original, int quantity, double price, boolean status) {
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.original = original;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Product(int id, int categoryId, String name, String description, String origin, int quantity, double price, boolean b, int viewNumber) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.original = original;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.viewNumber = viewNumber;
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

    public boolean getStatus() {
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

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", categoryID=" + categoryID + ", name=" + name + ", description=" + description + ", original=" + original + ", quantity=" + quantity + ", price=" + price + ", status=" + status + ", viewNumber=" + viewNumber + ", create_at=" + create_at + ", update_at=" + update_at + ", proImg=" + proImg + '}';
    }

    
}
