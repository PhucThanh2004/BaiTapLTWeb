package vn.iotstar.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;
import java.util.List;

//import javax.naming.spi.DirStateFactory.Result;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	
/*	public List<UserModel> findAll() {
		
		String sql ="Select * from [users]";

		List<UserModel> list = new ArrayList<>();

		try {
			conn = super.getConnection(); 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"), 
								rs.getString("email"), 
								rs.getString("password"), 
								rs.getString("fullname"),
								rs.getString("images"))); //Add vào
			}
			return list;

		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public UserModel findById(int id) {
			
		return null;
	}

	@Override
	
	public void insert(UserModel user) {
		String sql = "INSERT INTO [users](id, username, email, password, images, fullname) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conn = super.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getImages());
			ps.setString(6, user.getFullname());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}	
}
	
	
	
	
	public static void main(String[] args)
	{
		/*UserDaoImpl userDao = new UserDaoImpl();
		
		userDao.insert(new UserModel(2,"abc","abc@gmail.com","123","abcde",""));
		
		List<UserModel> list = userDao.findAll();
		
		for (UserModel user : list) {
			System.out.println(user);
		}*/
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUserName("trungnh"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql ="Select * from [users] where username = ?";
		try {
			
			
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
