package com.teachsync.courseservice.repositories;

import com.teachsync.courseservice.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
