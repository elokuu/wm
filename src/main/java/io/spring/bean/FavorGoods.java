package io.spring.bean;

import java.sql.Date;

public class FavorGoods {
    private String name;
    private String title;
    private double price;
    private Date time_create;
    private String path;
    private String img_name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Date getTime_create() {
        return time_create;
    }

    public void setTime_create(Date time_create) {
        this.time_create = time_create;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FavorGoods{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", time_create=" + time_create +
                ", path='" + path + '\'' +
                ", img_name='" + img_name + '\'' +
                '}';
    }
}
