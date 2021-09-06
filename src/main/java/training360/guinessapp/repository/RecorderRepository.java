package training360.guinessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.guinessapp.entity.Recorder;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {
}
