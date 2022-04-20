package test.idomsoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paths")
public class Path {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fromWhere")
    private String fromWhere;

    @Column(name = "toWhere")
    private String toWhere;

    @Column(name = "numberOfTransportedPassengers")
    private int numberOfTransportedPassengers;

    @Column(name = "kilometreStance")
    private int kilometreStance;

    @Column(name = "driverName")
    private String driverName;

    @ManyToOne
    @JoinColumn(name = "itinerary_id", referencedColumnName = "id")
    private Itinerary itinerary;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "endDate")
    private Date endDate;

}
