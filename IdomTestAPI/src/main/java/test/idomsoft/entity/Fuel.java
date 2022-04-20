package test.idomsoft.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fuel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fuelType")
    private String fuelType;

    @Column(name = "price")
    private int price;

    @JsonIgnore
    @OneToMany(mappedBy = "fuel")
    private List<Car> cars;

    public Fuel(Long id, String fuelType, int price) {
        this.id = id;
        this.fuelType = fuelType;
        this.price = price;
    }
}
