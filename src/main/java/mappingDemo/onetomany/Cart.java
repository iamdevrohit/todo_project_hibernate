package mappingDemo.onetomany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "customer_name")
    private String customerName;

    //@OneToMany(mappedBy = "cart")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "item_cart")
    private Set<Items> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", total=" + total + ", customerName=" + customerName + ", items=" + items + "]";
    }

    public Cart(long id, double total, String customerName, Set<Items> items) {
        super();
        this.id = id;
        this.total = total;
        this.customerName = customerName;
        this.items = items;
    }

    public Cart() {
        super();
    }
}
