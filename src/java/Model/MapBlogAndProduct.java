/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PiPi
 */
public class MapBlogAndProduct {

    private int id;
    private int blogId;
    private int productId;

    public MapBlogAndProduct() {
    }

    public MapBlogAndProduct(int id, int blogId, int productId) {
        this.id = id;
        this.blogId = blogId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "MapBlogAndProduct{" + "id=" + id + ", blogId=" + blogId + ", productId=" + productId + '}';
    }

}
