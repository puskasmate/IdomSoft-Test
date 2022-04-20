package test.idomsoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    private String licensePlateNumber;
    private String model;
    private int numberOfPassengers;
    private String colour;
    private int year;
    private Float consumption;
    private Long fuel_id;

}
