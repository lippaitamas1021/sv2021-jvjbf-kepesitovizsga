package training360.guinessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.guinessapp.entity.WorldRecord;

public interface WorldRecordRepository extends JpaRepository<WorldRecord, Long> {
}
