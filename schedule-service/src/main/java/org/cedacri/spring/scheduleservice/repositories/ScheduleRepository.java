package org.cedacri.spring.scheduleservice.repositories;

import org.cedacri.spring.scheduleservice.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
