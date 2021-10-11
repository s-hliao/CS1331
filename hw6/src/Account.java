 import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Account {
    private List<Transaction> pastTransactions;

    public Account(List<Transaction> pastTransactions) {
        this.pastTransactions = pastTransactions;
    }

    public Transaction getTransaction(int n) {
        return pastTransactions.get(n);
    }

    public List<Transaction> findTransactionsByPredicate(
            Predicate<Transaction> predicate) {
        List<Transaction> result = new ArrayList<Transaction>();
        for (Transaction transaction : pastTransactions) {
            if (predicate.test(transaction)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public List<Transaction> findTransactionsByAmount(double amount) {
        List<Transaction> result = new ArrayList<Transaction>();
        for (Transaction transaction : pastTransactions) {
            if (transaction.getAmount() == amount) {
                result.add(transaction);
            }
        }
        return result;
    }

    public List<Transaction> getWithdrawals() {
        return findTransactionsByPredicate((Transaction transaction) -> {
            return transaction.getType() == TransactionType.WITHDRAWAL;
        });
    }

    public List<Transaction> getDeposits() {
        return findTransactionsByPredicate(new Predicate<Transaction>() {
            public boolean test(Transaction transaction) {
                return transaction.getType() == TransactionType.DEPOSIT;
            }
        });
    }

    public List<Transaction> getTransactionsWithCommentLongerThan(int length) {
        return findTransactionsByPredicate((Transaction transaction) -> {
            return transaction.hasComment()
                    && transaction.getComment().length() > length;
        });
    }

    public List<Transaction> getTransactionsWithComment() {
        return findTransactionsByPredicate((Transaction::hasComment));
    }

    public List<Transaction> getPastTransactions() {
        return pastTransactions;
    }
}
