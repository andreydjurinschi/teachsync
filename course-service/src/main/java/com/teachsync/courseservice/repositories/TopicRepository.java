package com.teachsync.courseservice.repositories;

import com.teachsync.courseservice.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> { }
