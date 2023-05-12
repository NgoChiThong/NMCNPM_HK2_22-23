package transaction;

import constant.CategoryType;
import user.UserService;

import java.util.List;

public class TransactionService {

    private final TransactionDAO dao = new TransactionDAO();
    private final UserService serviceUser = new UserService();

    public List<Transaction> getAll() {
        return dao.getAll();
    }

    public Integer save(Transaction transaction) {
        if (transaction._getCategory().getType().equals(CategoryType.THU.toString())) {
            serviceUser.updateMoney(transaction.getUserId(), transaction._getUser().getMoney() + transaction.getMoney());
        } else if (transaction._getCategory().getType().equals(CategoryType.CHI.toString())) {
            serviceUser.updateMoney(transaction.getUserId(), transaction._getUser().getMoney() - transaction.getMoney());
        } else if (transaction._getCategory().getType().equals(CategoryType.VAY.toString())) {
            serviceUser.updateMoney(transaction.getUserId(), transaction._getUser().getMoney() - transaction.getMoney());
        }
        return dao.save(transaction);


    }

}
