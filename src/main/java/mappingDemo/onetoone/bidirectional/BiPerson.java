package mappingDemo.onetoone.bidirectional;

import mappingDemo.onetoone.PersonDetail;
import javax.persistence.*;

@Entity
@Table(name = "BiPerson")
public class BiPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "person_name", nullable = false)
    private String personName;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_detail_fk")
    private BiPersonDetail personDetail;


    public BiPersonDetail getPersonDetail() {
        return personDetail;
    }

    public void setPersonDetail(BiPersonDetail personDetail) {
        this.personDetail = personDetail;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
