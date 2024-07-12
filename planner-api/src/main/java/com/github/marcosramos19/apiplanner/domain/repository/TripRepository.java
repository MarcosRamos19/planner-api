package com.github.marcosramos19.apiplanner.domain.repository;

import com.github.marcosramos19.apiplanner.domain.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository <Trip, UUID> {
}
