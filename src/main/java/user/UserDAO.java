package user;

import DB.JDBiConnector;

public class UserDAO {
    public void updateMoney(Integer userId, Integer money) {
        JDBiConnector.get().useHandle(handle -> {
            handle.createUpdate("UPDATE users SET money = :money WHERE id = :id")
                    .bind("money", money)
                    .bind("id", userId)
                    .execute();
        });
    }

    public User get(int id){

     return   JDBiConnector.get().withHandle(handle -> {

          return  handle.createQuery("select * from users WHERE id = :id")
                    .bind("id", userId)
                    .mapToBean(User.class)
                    .execute();

        })

    }

}
