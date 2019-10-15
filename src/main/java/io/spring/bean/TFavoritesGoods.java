package io.spring.bean;


import java.sql.Date;

public class TFavoritesGoods {

  private int id;
  private int idGoods;
  private int idUser;
  private Date timeCreate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdGoods() {
    return idGoods;
  }

  public void setIdGoods(int idGoods) {
    this.idGoods = idGoods;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public Date getTimeCreate() {
    return timeCreate;
  }

  public void setTimeCreate(Date timeCreate) {
    this.timeCreate = timeCreate;
  }
}
