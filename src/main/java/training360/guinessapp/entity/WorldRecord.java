package training360.guinessapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.entity.Recorder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "worldrecords")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double value;

    private String unitOfMeasure;

    private LocalDate date;

    private Long oldRecorderId;

    @ManyToOne
    private Recorder recorder;

    public WorldRecord(String description, double value, String unitOfMeasure, LocalDate date, Long oldRecorderId) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.date = date;
        this.oldRecorderId = oldRecorderId;
    }
}
