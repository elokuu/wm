package io.spring.bean;

import java.sql.Date;

public class Task {
    private Integer id;
    private Integer id_user;
    private String title;
    private Integer type;
    private Integer quota;
    private String describe;
    private String contact;
    private Date time_create;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getTime_create() {
        return time_create;
    }

    public void setTime_create(Date time_create) {
        this.time_create = time_create;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", quota=" + quota +
                ", describe='" + describe + '\'' +
                ", contact='" + contact + '\'' +
                ", time_create=" + time_create +
                ", state=" + state +
                '}';
    }
}
