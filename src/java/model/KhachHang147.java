/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author MY PC
 */
public class KhachHang147 extends  ThanhVien147{
        public String ten ,diachi , sdt ;
        public int makh,idthanhvien;

    public KhachHang147() {
    }

    public int getIdthanhvien() {
        return idthanhvien;
    }

    public void setIdthanhvien(int idthanhvien) {
        this.idthanhvien = idthanhvien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }


    public KhachHang147( int makh,String ten, String diachi, String sdt,int idthanhvien) {
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.makh = makh;
        this.idthanhvien=idthanhvien;
    }
     public Object[] toObject(){
        return new Object[]{
            makh,ten,diachi,sdt
        };
    }   
}
