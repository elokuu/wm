package io.spring.bean;

import java.sql.Date;

public class MyTask {

    private String title;
    private double price;
    private int id_user;
    private String name;
    private Date time_create;
    private Date time_completion;
    private int state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime_create() {
        return time_create;
    }

    public void setTime_create(Date time_create) {
        this.time_create = time_create;
    }

    public Date getTime_completion() {
        return time_completion;
    }

    public void setTime_completion(Date time_completion) {
        this.time_completion = time_completion;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", id_user=" + id_user +
                ", name='" + name + '\'' +
                ", time_create=" + time_create +
                ", time_completion=" + time_completion +
                ", state=" + state +
                '}';
    }
}
