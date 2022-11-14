package mappingDemo.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @ManyToMany
    @JoinTable(name ="join_delegate_event",
            joinColumns = {@JoinColumn(name = "eventId")},
            inverseJoinColumns = {@JoinColumn(name = "delegateId")})
    private List<Delegate> delegates=new ArrayList<>();


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Delegate> getDelegates() {
        return delegates;
    }

    public void setDelegates(List<Delegate> delegates) {
        this.delegates = delegates;
    }
}
