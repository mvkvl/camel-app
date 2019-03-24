package task.integer.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.integer.model.SensorReport;

@Repository
public interface SensorReportRepository extends JpaRepository<SensorReport, Integer> {
}

