package repository;

import config.MysqlConfig;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<UserModel> findByEmailAndPassword(String email, String password) {
        Connection connection = null;
        List<UserModel> userModelList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users u WHERE u.email = ? and u.password = ?";
            //mở kết nối
            connection = MysqlConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                UserModel userModel = new UserModel();
                //Lấy giá trị của cột id
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullName(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));
                userModelList.add(userModel);
            }
        } catch (Exception e) {
            System.out.println("Error findByEmailAndPassword : " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối findByEmailAndPassword:  " + e.getMessage());
                }
            }
        }
        return userModelList;
    }

    public List<UserModel> findAll() {
        Connection connection = null;
        List<UserModel> userModelList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            //mở kết nối
            connection = MysqlConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                UserModel userModel = new UserModel();
                //Lấy giá trị của cột id
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullName(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));
                userModelList.add(userModel);
            }
        } catch (Exception e) {
            System.out.println("Error findByEmailAndPassword : " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối findByEmailAndPassword:  " + e.getMessage());
                }
            }
        }
        return userModelList;
    }
}
