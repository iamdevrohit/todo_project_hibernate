package mappingDemo.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid", nullable = false)
    private Long transactionid;


    @Column(name = "transactionTime")
    private Date date;

    @Column(name = "amount")
    private int amount;


    public Long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Transactions{" +
                "transactionid=" + transactionid +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
