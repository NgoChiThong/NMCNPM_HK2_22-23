package user;

public class UserService {

    public void updateMoney(Integer userId, Integer money) {
        new UserDAO().updateMoney(userId, money);
    }

    public User get(int id) {
        return new UserDAO().get(id);
    }
}
