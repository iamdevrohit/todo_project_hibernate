package mappingDemo.onetomany;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private double itemId;

    @Column(name = "item_total")
    private double itemTotal;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    //@JoinColumn(name ="cart_id", nullable=false)
    private Cart cart;

    public Items(long id, double itemId, double itemTotal, int quantity, Cart cart) {
        super();
        this.id = id;
        this.itemId = itemId;
        this.itemTotal = itemTotal;
        this.quantity = quantity;
        this.cart = cart;
    }

    public Items() {
        super();
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getItemId() {
        return itemId;
    }

    public void setItemId(double itemId) {
        this.itemId = itemId;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Items [id=" + id + ", itemId=" + itemId + ", itemTotal=" + itemTotal + ", quantity=" + quantity
                + ", cart=" + cart + "]";
    }
}
