package SpringDataAll.Entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ADVERTISEMENTS")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer budget;

    @Temporal(TemporalType.DATE)
    private Date deadline;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATEOFPUBLISHING")
    private Date dateOfPublishing;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name="advs_tags",
            joinColumns = {@JoinColumn(name="ADVID")},
            inverseJoinColumns = {@JoinColumn(name="TAGID")}
    )
    private Set<Tag> tags=new HashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name="SUBJECTID",nullable = false)
    private Subject subject;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ORDERID",nullable = true)
    private Order order;


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(Date dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
