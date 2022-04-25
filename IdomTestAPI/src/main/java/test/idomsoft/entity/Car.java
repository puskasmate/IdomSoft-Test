package test.idomsoft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars" )
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "licensePlateNumber")
    private String licensePlateNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "numberOfPassengers")
    private int numberOfPassengers;

    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private int year;

    @Column(name = "consumption")
    private Float consumption;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Itinerary> itineraries;

    @ManyToOne
    @JoinColumn(name = "fuel_id", referencedColumnName = "id")
    private Fuel fuel;

    public Car(Long id, String licensePlateNumber, String model, int numberOfPassengers, String colour, int year, Float consumption, Fuel fuel) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.model = model;
        this.numberOfPassengers = numberOfPassengers;
        this.color = colour;
        this.year = year;
        this.consumption = consumption;
        this.fuel = fuel;
    }
}
