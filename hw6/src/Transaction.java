import java.util.Optional;

public class Transaction {
    private TransactionType type;
    private double amount;
    private Optional<String> comment;
    
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        comment = Optional.empty();
    }
    
    public Transaction(TransactionType type, double amount, String comment) {
        this.type = type;
        this.amount = amount;
        this.comment = Optional.of(comment);
    }
    
    
    public TransactionType getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getComment() {
        return comment.get();
    }
    
    public boolean hasComment() {
        return !comment.isEmpty();
    }
    
    
}
