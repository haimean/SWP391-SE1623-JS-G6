/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MrTuan
 */
public class Product {

   private String id;
    private int categoryID;
    private String name, description, original;
    private int quantity;
    private double price;
    private boolean status;
    private int viewNumber;
    private String create, update;

    public Product() {
    }

    public Product(String id, int categoryID, String name, String description, String original, int quantity, double price, boolean status, int viewNumber, String create, String update) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.original = original;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.viewNumber = viewNumber;
        this.create = create;
        this.update = update;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", categoryID=" + categoryID + ", name=" + name + ", description=" + description + ", original=" + original + ", quantity=" + quantity + ", price=" + price + ", status=" + status + ", viewNumber=" + viewNumber + ", create=" + create + ", update=" + update + '}';
    }
}
