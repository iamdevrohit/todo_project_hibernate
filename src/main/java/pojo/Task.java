package pojo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;


    @Column(name = "ITEM", nullable = false)
    private  String item;



    @Column(name = "END_DATE", nullable = false)
    private Timestamp end_date;



    @Column(name = "USER_ID", nullable = false)
    private Long user_id;


    @Column(name = "STATUS", nullable = false)
    private  int status;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Task() {
    }

    public Task(String item, Timestamp end_date, Long user_id, int status) {
        this.item = item;
        this.end_date = end_date;
        this.user_id = user_id;
        this.status = status;
    }

    public Task(Long id, String item, Timestamp end_date, Long user_id, int status) {
        this.id = id;
        this.item = item;
        this.end_date = end_date;
        this.user_id = user_id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", end_date=" + end_date +
                ", user_id=" + user_id +
                ", status=" + status +
                '}';
    }
}
