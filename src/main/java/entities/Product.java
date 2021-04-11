package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
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

    @OneToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name ="attribute_id")}
    )
    private List<Attribute> attributes = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", price=" + price +
                ", type=" + type +
                ", attributes=" + attributes +
                '}';
    }
    
}