package SpringDataAll.Entitys;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="SUBJECTS")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",unique = true,nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},
        fetch = FetchType.LAZY)
    private Set<Advertisement> advertisementSet=new HashSet<>();

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

    public Set<Advertisement> getAdvertisementSet() {
        return advertisementSet;
    }

    public void setAdvertisementSet(Set<Advertisement> advertisementSet) {
        this.advertisementSet = advertisementSet;
    }
}
