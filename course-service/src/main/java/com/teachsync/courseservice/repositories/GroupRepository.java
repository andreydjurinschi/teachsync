package com.teachsync.courseservice.repositories;

import com.teachsync.courseservice.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query(value = "select * from GROUPS g " +
            "left join PUBLIC.GROUP_COURSES GC on g.ID = GC.GROUP_ID " +
            "where g.ID = :group_id", nativeQuery = true)
    Group findWithCourses(@Param("group_id") Long group_id);
}
