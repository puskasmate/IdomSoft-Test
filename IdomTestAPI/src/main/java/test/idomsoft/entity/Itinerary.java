package test.idomsoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itineraries" )
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "startDate")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "startStance")
    private int startStance;

    @Column(name = "distance")
    private int distance;

    @Column(name = "price")
    private float price;

    @Column(name = "sumOfPassengers")
    private int sumOfPassengers;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itinerary", orphanRemoval = true)
    private List<Path> paths;

}
