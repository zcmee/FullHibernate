package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Instant created;
    private Instant updated;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
//    @JoinColumn(name="product_id") //bedziemy posiadac cyklicznosc wywołan
    private List<Review> reviews;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", reviews=" + reviews +
                '}';
    }
}
