package com.github.marcosramos19.apiplanner.domain.repository;

import com.github.marcosramos19.apiplanner.domain.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {

    List<Participant> findByTripId(UUID id);
}
