package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import connection.DBConnection;

public class CustomerDao {
	public static void RegisterCustomer (Customer c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into customer (name,contact,address,email,password) value (?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setLong(2, c.getContact());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getPasswordString());
			pst.executeUpdate();
			System.out.println("customer registered");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Customer loginCustomer(Customer c) {
		Customer c1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customer where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getEmail());
			pst.setString(2, c.getPasswordString());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				c1 = new Customer();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setContact(rs.getLong("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPasswordString(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c1;
	}
	public static Customer getCustomerByID(int ID) {
		Customer c1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "select * from customer where ID=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, ID);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				c1 = new Customer();
				c1.setId(rs.getInt("ID"));
				c1.setName(rs.getString("Name"));
				c1.setContact(rs.getLong("Contact"));
				c1.setAddress(rs.getString("Address"));
				c1.setEmail(rs.getString("Email"));
				c1.setPasswordString(rs.getString("Password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}
	public static Customer checkEmailForRegistration(String Email) {
		Customer c1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customer where Email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, Email);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				c1 = new Customer();
				c1.setId(rs.getInt("ID"));
				c1.setName(rs.getString("Name"));
				c1.setContact(rs.getLong("Contact"));
				c1.setAddress(rs.getString("Address"));
				c1.setEmail(rs.getString("Email"));
				c1.setPasswordString(rs.getString("Password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}
	public static List<Customer> getAllCustomers(){
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from customer";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Customer c1 = new Customer();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setContact(rs.getLong("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPasswordString(rs.getString("password"));
				list.add(c1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void updateProfile(Customer c) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "update customer set Name=?, Contact=?, Address=?, Email=? where ID=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, c.getName());
			pst.setLong(2, c.getContact());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setInt(5, c.getId());

			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkOldPassword(int ID, String OP) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "select * from customer where ID=? and Password=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, ID);
			pst.setString(2, OP);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void changePassword(int ID, String NP) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "update customer set Password=? where ID=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, NP);
			pst.setInt(2, ID);
			pst.executeUpdate();
			System.out.println("password Changed.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String Email) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "select * from customer where Email=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, Email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void changeNewPassword(String Email, String NP) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "update customer set Password=? where Email=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, NP);
			pst.setString(2, Email);
			pst.executeUpdate();
			System.out.println("Password Changed Succesfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteCustomer(int ID) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "delete from Customer where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, ID);
			pst.executeUpdate();
			System.out.println("Data Deleted by Admin Succesfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

