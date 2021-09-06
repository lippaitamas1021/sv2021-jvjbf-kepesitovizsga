package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordDto {

    private Long id;

    private String description;

    private double value;

    private String unitOfMeasure;

    private LocalDate dateOfRecord;

    private Long oldRecorderId;

    private String recorderName;

    public WorldRecordDto(String description, double value, String unitOfMeasure, LocalDate dateOfRecord, Long oldRecorderId) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.oldRecorderId = oldRecorderId;
    }
}
