package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordCreateCommand {

    @NotNull
    @NotBlank(message = "must not be blank")
    private String description;

    @NotNull
    private double value;

    @NotNull
    @NotBlank
    private String unitOfMeasure;

    @NotNull
    @Past(message = "múltbeli dátumnak kell lennie")
    private LocalDate date;

    @NotNull
    private Long oldRecorderId;
}
