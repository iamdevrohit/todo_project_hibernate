package mappingDemo.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delegates")
public class Delegate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegate_id", nullable = false)
    private Long delegateId;

    @Column(name = "delegate_name", nullable = false)
    private String delegateName;

    @ManyToMany
    @JoinTable(name ="join_delegate_event",
            joinColumns = {@JoinColumn(name = "delegateId")},
            inverseJoinColumns = {@JoinColumn(name = "eventId")})
    private List<Event> events=new ArrayList<>();

    public Long getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(Long delegateId) {
        this.delegateId = delegateId;
    }

    public String getDelegateName() {
        return delegateName;
    }

    public void setDelegateName(String delegateName) {
        this.delegateName = delegateName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
