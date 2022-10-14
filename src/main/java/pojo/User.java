package pojo;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {


//         "    COUNT_TASK int NOT NULL, " +
//
//                 "    PROFILE_EMAIL VARCHAR(250) NOT NULL, " +
//                 "    FOREIGN KEY (PROFILE_EMAIL)  " +
//                 "    REFERENCES PROFILE (EMAIL), " +
//
//                 "    PROFILE_ID INT NOT NULL, " +
//                 "    FOREIGN KEY (PROFILE_ID)  " +
//                 "    REFERENCES PROFILE (ID)" +
//                 ")";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "PROFILE_ID",referencedColumnName = "ID")
    private Profile profile_id;


    @Column(name = "PROFILE_EMAIL", nullable = false)
    private String profile_email;


    @Column(name = "COUNT_TASK", nullable = false)
    private int count_task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Profile profile_id) {
        this.profile_id = profile_id;
    }

    public String getProfile_email() {
        return profile_email;
    }

    public void setProfile_email(String profile_email) {
        this.profile_email = profile_email;
    }

    public int getCount_task() {
        return count_task;
    }

    public void setCount_task(int count_task) {
        this.count_task = count_task;
    }

    public User() {
    }

    public User(Profile profile_id, String profile_email, int count_task) {
        this.profile_id = profile_id;
        this.profile_email = profile_email;
        this.count_task = count_task;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", profile_id=" + profile_id +
                ", profile_email='" + profile_email + '\'' +
                ", count_task=" + count_task +
                '}';
    }
}
