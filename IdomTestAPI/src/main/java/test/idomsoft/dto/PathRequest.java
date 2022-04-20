package test.idomsoft.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathRequest {

    private String fromWhere;
    private String toWhere;
    private int kilometreStance;
    private int numberOfTransportedPassengers;
    private String driverName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private Long itinerary_id;
}
