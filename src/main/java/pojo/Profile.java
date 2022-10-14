package pojo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;


    @Column(name = "LAST_LOGIN", nullable = false)
    private Timestamp last_login;

    @Column(name = "LAST_PASSWORD_CHANGE", nullable = false)
    private Timestamp last_password_change;

    @Column(name = "EMAIL", nullable = false,unique = true)
    private  String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Timestamp last_login) {
        this.last_login = last_login;
    }

    public Timestamp getLast_password_change() {
        return last_password_change;
    }

    public void setLast_password_change(Timestamp last_password_change) {
        this.last_password_change = last_password_change;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile(Long id, Timestamp last_login, Timestamp last_password_change, String email, String password) {
        this.id = id;
        this.last_login = last_login;
        this.last_password_change = last_password_change;
        this.email = email;
        this.password = password;
    }

    public Profile(Timestamp last_login, Timestamp last_password_change, String email, String password) {
        this.last_login = last_login;
        this.last_password_change = last_password_change;
        this.email = email;
        this.password = password;
    }

    public Profile(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Profile() {
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", last_login=" + last_login +
                ", last_password_change=" + last_password_change +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
