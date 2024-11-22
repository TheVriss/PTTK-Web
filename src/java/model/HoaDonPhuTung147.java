/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;


public class HoaDonPhuTung147 {
        int id ;
        float tongtien;
        int tblnhacungcap147id,tblnhanvienkho147id;
        java.sql.Timestamp thoigian;

    public HoaDonPhuTung147() {
    }

    public HoaDonPhuTung147(int id, float tongtien, int tblnhacungcap147id, int tblnhanvienkho147id, Timestamp thoigian) {
        this.id = id;
        this.tongtien = tongtien;
        this.tblnhacungcap147id = tblnhacungcap147id;
        this.tblnhanvienkho147id = tblnhanvienkho147id;
        this.thoigian = thoigian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public int getTblnhacungcap147id() {
        return tblnhacungcap147id;
    }

    public void setTblnhacungcap147id(int tblnhacungcap147id) {
        this.tblnhacungcap147id = tblnhacungcap147id;
    }

    public int getTblnhanvienkho147id() {
        return tblnhanvienkho147id;
    }

    public void setTblnhanvienkho147id(int tblnhanvienkho147id) {
        this.tblnhanvienkho147id = tblnhanvienkho147id;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }
        
        
}
