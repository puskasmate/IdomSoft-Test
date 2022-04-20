package test.idomsoft.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryRequest {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    private int startStance;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private Long car_id;

}
