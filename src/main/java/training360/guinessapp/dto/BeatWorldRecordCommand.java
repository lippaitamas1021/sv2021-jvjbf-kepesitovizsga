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
public class BeatWorldRecordCommand {

    @NotNull
    private Long id;

    @NotNull
    private double value;

    @NotNull
    @NotBlank(message = "nem lehet üres")
    private String description;

    @NotNull
    @NotBlank(message = "nem lehet üres")
    private String unitOfMeasure;

    @NotNull
    @Past(message = "múltbeli dátumnak kell lennie")
    private LocalDate date;

    @NotNull
    private Long oldRecorderId;

    public BeatWorldRecordCommand(Long id, double value) {
        this.id = id;
        this.value = value;
    }
}
