/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author nguye
 */
public class Blog {
    
    private int  id;
    private int  viewNumber;
    private String  title;
    private String  description;
    Date create_at;
    Date update_at;
    

    public Blog() {
    }

    public Blog(int id, String title, String description, Date create_at, Date update_at, int viewNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.create_at = create_at;
        this.update_at = update_at;
        this.viewNumber = viewNumber;
    }
    
    public Blog(int id, String title, String description, int viewNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        
        this.viewNumber = viewNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }
    
     
    
}

