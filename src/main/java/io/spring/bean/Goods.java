package io.spring.bean;

public class Goods {

  private long id;
  private long idUser;
  private String title;
  private String type;
  private long quota;
  private double price;
  private String describe;
  private java.sql.Timestamp timeCreate;
  private long state;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getIdUser() {
    return idUser;
  }

  public void setIdUser(long idUser) {
    this.idUser = idUser;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getQuota() {
    return quota;
  }

  public void setQuota(long quota) {
    this.quota = quota;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }


  public java.sql.Timestamp getTimeCreate() {
    return timeCreate;
  }

  public void setTimeCreate(java.sql.Timestamp timeCreate) {
    this.timeCreate = timeCreate;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
