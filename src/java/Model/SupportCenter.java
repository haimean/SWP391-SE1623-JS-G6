/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author PiPi
 */
public class SupportCenter {

    private int id;
    private Date createdAt;
    private Date updatedAt;
    private String question;
    private String answer;
    private String name;
    private int typeId;

    public SupportCenter() {
    }

    public SupportCenter(int id, String question, String answer, int typeId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.typeId = typeId;
    }

    public SupportCenter(Date createdAt, Date updatedAt, String question, String answer, int typeId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.question = question;
        this.answer = answer;
        this.typeId = typeId;
    }

    public SupportCenter(int id, Date createdAt, Date updatedAt, String question, String answer, String name,
            int typeId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.question = question;
        this.answer = answer;
        this.name = name;
        this.typeId = typeId;
    }

    public SupportCenter(int id, Date createdAt, Date updatedAt, String question, String answer, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.question = question;
        this.answer = answer;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "SupportCenter{" + "id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", question="
                + question + ", answer=" + answer + ", name=" + name + ", typeId=" + typeId + '}';
    }
}
