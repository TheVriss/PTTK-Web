/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author MY PC
 */
public class LichHen147 {
        public int id,idkhachhang;
        public java.sql.Timestamp thoigian;
        String ten ,sdt , diachi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi= diachi;
    }
    public LichHen147() {
    }

    public LichHen147(Timestamp thoigian, int idkhachhang) {
        this.id = 9999;
        this.idkhachhang = idkhachhang;
        this.thoigian = thoigian;
    }
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(int idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }
         public Object[] toObject(){
        return new Object[]{
            id,thoigian,idkhachhang,ten,sdt,diachi
        };
    }   
}
