package org.cedacri.spring.scheduleservice.repositories;

import org.cedacri.spring.scheduleservice.domain.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
