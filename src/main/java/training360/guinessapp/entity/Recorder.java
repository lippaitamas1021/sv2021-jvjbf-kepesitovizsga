package training360.guinessapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "recorders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "recorder", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private List<WorldRecord> worldRecordList;

    public Recorder(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public void addRecord(WorldRecord worldRecord) {
        worldRecordList.add(worldRecord);
        worldRecord.setRecorder(this);
    }
}
