package transaction;

import DB.JDBiConnector;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class TransactionDAO {

    public List<Transaction> getAll() {

        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM transactions")
                    .mapToBean(Transaction.class)
                    .list();
        });

    }

    public Integer save(Transaction transaction) {
        transaction.setCreated_at(new Timestamp(System.currentTimeMillis()));
        transaction.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        return JDBiConnector.get().withHandle(handle -> {
            Object ob = handle.createUpdate("INSERT INTO transactions (money, categoryId, note, started_at,created_at,updated_at,userId) VALUES (:money, :categoryId, :note, :started_at,:created_at,:updated_at,:userId)")
                    .bind("money", transaction.getMoney())
                    .bind("categoryId", transaction.getCategoryId())
                    .bind("note", transaction.getNote())
                    .bind("started_at", transaction.getStarted_at())
                    .bind("created_at", transaction.getCreated_at())
                    .bind("userId", transaction.getUserId())
                    .bind("updated_at", transaction.getUpdated_at())
                    .executeAndReturnGeneratedKeys("id").mapToMap().findOnly().get("generated_key");
            return ((BigInteger) ob).intValue();
        });
    }


}
