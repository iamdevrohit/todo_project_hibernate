package mappingDemo.onetoone.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "BiPersonDetail")
public class BiPersonDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_detail_id", nullable = false)
    private Long personDetailId;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "income", nullable = false)
    private Double income;

    @OneToOne(mappedBy = "personDetail",cascade = CascadeType.ALL)
    private BiPerson biPerson;

    public BiPerson getBiPerson() {
        return biPerson;
    }

    public void setBiPerson(BiPerson biPerson) {
        this.biPerson = biPerson;
    }

    public Long getPersonDetailId() {
        return personDetailId;
    }

    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
