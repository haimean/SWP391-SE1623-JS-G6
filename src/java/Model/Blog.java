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
    private String  image;
    private String  content;
    private String create_at;
    private String update_at;
    private int  userId;


    public Blog() {
    }

    public Blog(int id, String title, String description, int viewNumber,   String image, String  content, String create_at, String update_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.viewNumber = viewNumber;
         this.image = image;
        this.content = content;
        this.create_at = create_at;
        this.update_at = update_at;
       
    }

    public Blog(int id, String title, String description, String image, String content) {
this.id = id;
        this.title = title;
        this.description = description;
         this.image = image;
        this.content = content;
    }

    public Blog(String title, String description, String url, String content, int userId) {
        this.title = title;
        this.description = description;
         this.image = image;
        this.content = content;
        this.userId = userId;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }
    
    public Blog(int id, String title, String description, int viewNumber, String image, String  content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.viewNumber = viewNumber;
        this.image = image;
        this.content = content;
    }
    public Blog(int id, String title, String description, String image, String  content, String create_at, String update_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.content = content;
        this.create_at = create_at;
        this.update_at = update_at;
    }
    public Blog(String title, String description, String image, String  content) {
 
        this.title = title;
        this.description = description;
        this.image = image;
        this.content = content;
    }
    public Blog(int id, String title, String description, String  content) {
        this.id = id;
        this.title = title;
        this.description = description;
      this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
     
    
}

