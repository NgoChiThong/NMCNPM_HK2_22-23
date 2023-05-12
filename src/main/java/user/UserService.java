package user;

import DB.JDBiConnector;
import org.jdbi.v3.core.Jdbi;

import java.math.BigInteger;
import java.sql.Timestamp;

public class UserService {

    public void updateMoney(Integer userId, Integer money) {
        new UserDAO().updateMoney(userId, money);
    }

    public User get(int id) {
        return new UserDAO().get(id);
    }

    public User create(User u){
        return JDBiConnector.get().withHandle(handle -> {
             handle.createUpdate("INSERT INTO users (created_at, name,email,pass) " +
                            "VALUES (:created_at,:name,:email,:pass)")
                    .bindBean(u).execute();
            return u;
        });
    }


}
