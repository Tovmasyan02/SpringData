package SpringDataAll.Entitys;

import SpringDataAll.Enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="ORDERSTATUS",nullable = false)
    private OrderStatus orderStatus;

    @OneToOne(optional = false)
    @JoinColumn(name="ADVERTISEMENTID")
    private Advertisement advertisement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
