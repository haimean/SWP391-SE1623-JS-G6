/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author haimi
 */
public class Message {

    private int id;
    private int userSenderId;
    private int userReceiverId;
    private String content;
    private Date Create_at, Update_at;

    public Message() {
    }

    public Message(int id, int userSenderId, int userReceiverId, String content, Date Create_at, Date Update_at) {
        this.id = id;
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
        this.content = content;
        this.Create_at = Create_at;
        this.Update_at = Update_at;
    }

    public Message(int userSenderId, int userReceiverId, String content) {
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserSenderId() {
        return userSenderId;
    }

    public void setUserSenderId(int userSenderId) {
        this.userSenderId = userSenderId;
    }

    public int getUserReceiverId() {
        return userReceiverId;
    }

    public void setUserReceiverId(int userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_at() {
        return Create_at;
    }

    public void setCreate_at(Date Create_at) {
        this.Create_at = Create_at;
    }

    public Date getUpdate_at() {
        return Update_at;
    }

    public void setUpdate_at(Date Update_at) {
        this.Update_at = Update_at;
    }


}
