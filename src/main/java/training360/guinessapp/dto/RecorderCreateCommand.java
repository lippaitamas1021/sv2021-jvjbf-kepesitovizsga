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
public class RecorderCreateCommand {

    @NotNull
    @NotBlank(message = "nem lehet üres")
    private String name;

    @NotNull
    @Past(message = "múltbeli dátumnak kell lennie")
    private LocalDate dateOfBirth;
}
