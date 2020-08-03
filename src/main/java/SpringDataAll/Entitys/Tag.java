package SpringDataAll.Entitys;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="TAGS")
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME",unique = true,nullable = false)
    private String name;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name="advs_tags",
            joinColumns = {@JoinColumn(name="TAGID")},
            inverseJoinColumns = {@JoinColumn(name="ADVID")}
    )
    private Set<Advertisement> tags=new HashSet<>();

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

    public Set<Advertisement> getTags() {
        return tags;
    }

    public void setTags(Set<Advertisement> tags) {
        this.tags = tags;
    }
}
