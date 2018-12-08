/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author KIENDINH
 */
public class DAOBill extends DAO {
     public ArrayList<Model.Bill> getListSVSearched(String sql) {
        ArrayList<Model.Bill> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Model.Bill s = new Model.Bill();
//                s.setBillID(rs.getInt("ID"));
//                s.setMaSinhVien(rs.getString("MaSinhVien"));
//                s.setHoTenSinhVien(rs.getString("HoTenSinhVien"));
//                s.setGioiTinh(rs.getString("GioiTinh"));
//                s.setDiaChi(rs.getString("DiaChi"));
//                s.setEmail(rs.getString("Email"));
//                s.setMaLop(rs.getString("MaLop"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
