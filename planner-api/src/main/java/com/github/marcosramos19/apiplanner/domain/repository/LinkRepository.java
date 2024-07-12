package com.github.marcosramos19.apiplanner.domain.repository;

import com.github.marcosramos19.apiplanner.domain.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LinkRepository extends JpaRepository<Link, UUID> {
    public List<Link> findByTripId(UUID tripId);

}
