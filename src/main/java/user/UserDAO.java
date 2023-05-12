package user;

import DB.JDBiConnector;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.HandleCallback;

public class UserDAO {
    public void updateMoney(Integer userId, Integer money) {
        JDBiConnector.get().useHandle(handle -> {
            handle.createUpdate("UPDATE users SET money = :money WHERE id = :id")
                    .bind("money", money)
                    .bind("id", userId)
                    .execute();
        });
    }

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
                                        "select * from users WHERE email = ? AND pass = ? " )
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
}
