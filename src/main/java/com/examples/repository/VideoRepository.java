package com.examples.repository;

import com.examples.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
    List<Video> findByNameContainingOrDescriptionContaining (String name, String description);
}
