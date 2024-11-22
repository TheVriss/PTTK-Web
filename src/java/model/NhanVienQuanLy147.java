/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MY PC
 */
public class NhanVienQuanLy147  extends ThanhVien147{
    int manv;
    String ten;
    int idthanhvien;
    public NhanVienQuanLy147() {
    }

    public int getIdthanhvien() {
        return idthanhvien;
    }

    public void setIdthanhvien(int idthanhvien) {
        this.idthanhvien = idthanhvien;
    }

    public NhanVienQuanLy147(int manv, String ten,int idthanhvien) {
        this.manv = manv;
        this.ten = ten;
        this.idthanhvien=idthanhvien;
    }

    

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
}
