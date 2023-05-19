package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Seller;
import connection.DBConnection;

public class SellerDao {
	private static boolean flag;
	public static void insertSeller(Seller s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "insert into seller_table (name,contact,address,email,password) value(?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getPassword());
			pst.executeUpdate();
			System.out.println("data successfully inserted");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Seller loginSeller (Seller s) {
		Seller s1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "select * from seller_table where email=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rset = pst.executeQuery();
			if (rset.next()) {
				s1 = new Seller();
				s1.setId(rset.getInt("id"));
				s1.setName(rset.getString("name"));
				s1.setContact(rset.getLong("contact"));
				s1.setAddress(rset.getString("address"));
				s1.setEmail(rset.getString("email"));
				s1.setPassword(rset.getString("password"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s1;
	}
	public static Seller getSellerById(int id) {
		Seller s1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			ResultSet rSet = pst.executeQuery();
			if(rSet.next()) {
				s1 = new Seller();
				s1.setId(rSet.getInt("id"));
				s1.setName(rSet.getString("name"));
				s1.setContact(rSet.getLong("contact"));
				s1.setAddress(rSet.getString("address"));
				s1.setEmail(rSet.getString("email"));
				s1.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
		
	}
	public static void updateprofile (Seller s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "update seller_table set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static boolean CheckOldPassword(int id,String op) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller_table where id=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rset = pst.executeQuery();
			if (rset.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public static void changepassword(int id,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update seller_table set password=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller_table where email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	public static void changeNewPassword (String email, String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update seller_table set password=? where email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static List<Seller> getAllSellers(){
		List<Seller> list = new ArrayList<Seller>();
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from seller";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			ResultSet rSet = pst.executeQuery();
			while(rSet.next()) {
				Seller s1 = new Seller();
				s1.setId(rSet.getInt("id"));
				s1.setName(rSet.getString("name"));
				s1.setContact(rSet.getLong("contact"));
				s1.setAddress(rSet.getString("address"));
				s1.setEmail(rSet.getString("email"));
				s1.setPassword(rSet.getString("password"));
				list.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void deleteSeller(int id){
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="delete from seller where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


















