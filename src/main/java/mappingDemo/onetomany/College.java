package mappingDemo.onetomany;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id", nullable = false)
    private Long collegeId;


    @Column(name = "college_name", nullable = false)
    private String collegeName;


    @OneToMany(targetEntity = Student.class,mappedBy = "college",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> collegeStudents;


    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<Student> getCollegeStudents() {
        return collegeStudents;
    }

    public void setCollegeStudents(List<Student> collegeStudents) {
        this.collegeStudents = collegeStudents;
    }
}
