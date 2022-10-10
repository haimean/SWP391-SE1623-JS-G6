/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nguye
 */
public class ProductForUser {
     private int proId;
    private Category category;
    private String proName;
    private String proDes;
    private String proOrigin;
    private int proQuantity;
    private double proPrice;
    private boolean proStatus;
//    private String proImg;
    private int proViewNumber;

    public ProductForUser() {
    }

    public ProductForUser(int proId, Category category, String proName, String proDes, String proOrigin, int proQuantity, double proPrice, boolean proStatus, int proViewNumber) {
        this.proId = proId;
        this.category = category;
        this.proName = proName;
        this.proDes = proDes;
        this.proOrigin = proOrigin;
        this.proQuantity = proQuantity;
        this.proPrice = proPrice;
        this.proStatus = proStatus;
        this.proViewNumber = proViewNumber;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public String getProOrigin() {
        return proOrigin;
    }

    public void setProOrigin(String proOrigin) {
        this.proOrigin = proOrigin;
    }

    public int getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public boolean isProStatus() {
        return proStatus;
    }

    public void setProStatus(boolean proStatus) {
        this.proStatus = proStatus;
    }

    public int getProViewNumber() {
        return proViewNumber;
    }

    public void setProViewNumber(int proViewNumber) {
        this.proViewNumber = proViewNumber;
    }
    
    
}
