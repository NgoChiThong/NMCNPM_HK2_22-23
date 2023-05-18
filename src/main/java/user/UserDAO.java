package user;

import DB.DBConnect;
import DB.JDBiConnector;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.HandleCallback;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    //    public static Map<String, User> mapUser = loadUsername();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void updateMoney(Integer userId, Integer money) {
        JDBiConnector.get().useHandle(handle -> {
            handle.createUpdate("UPDATE users SET money = :money WHERE id = :id")
                    .bind("money", money)
                    .bind("id", userId)
                    .execute();
        });
    }
//    public void editUser(Integer id, String name, String email, String avatar){
//        JDBiConnector.get().useHandle(handle -> {
//            handle.createUpdate("UPDATE users SET id =?, name=?, email=?, avatar=?")
//                    .bind("id", id)
//                    .bind("name", name)
//                    .bind("email", email)
//                    .bind("avatar", avatar)
//                    .execute();
//        });
//    }


    public User get(int id) {

        return JDBiConnector.get().withHandle(handle -> {

            return handle.createQuery("select * from users WHERE id = :id")
                    .bind("id", id)
                    .mapToBean(User.class).one();

        });

    }

    //    public User getUser(String users, String password) {
//
//        return JDBiConnector.get().withHandle(handle -> {
//            return handle.createQuery("select * from users WHERE email = ? AND pass = ? ")
//                    .bind(0, users)
//                    .bind(1, password)
//                    .mapToBean(User.class).first();
//
//        });
//
//    }
    public User getUser(String users, String password) {
        try {
            return JDBiConnector.get().withHandle(new HandleCallback<User, Exception>() {
                public User withHandle(Handle handle) throws Exception {
                    try {
                        return handle.createQuery(
                                        "select * from users WHERE email = ? AND pass = ? ")
                                .bind(0, users)
                                .bind(1, password)
                                .mapToBean(User.class).first();
                    } catch (IllegalStateException exception) {
                        return null;
                    }

                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateProfile(String name, String pass, String email, int id) {
        Statement statement = DBConnect.getInstance().get();
        if (statement != null) {
            try {
                String sql = "UPDATE `users` SET name = ? , email = ? , pass = ? where id = ?";
                PreparedStatement ps = statement.getConnection().prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, pass);
                ps.setInt(4, id);
                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("lỗi kết nối");
        }
    }
}
