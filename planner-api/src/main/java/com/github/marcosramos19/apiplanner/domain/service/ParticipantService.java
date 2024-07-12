package com.github.marcosramos19.apiplanner.domain.service;

import com.github.marcosramos19.apiplanner.api.data.ParticipantData;
import com.github.marcosramos19.apiplanner.api.representationmodel.response.ParticipantCreateResponse;
import com.github.marcosramos19.apiplanner.domain.model.Participant;
import com.github.marcosramos19.apiplanner.domain.model.Trip;
import com.github.marcosramos19.apiplanner.domain.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip) {
        List<Participant> participants = participantsToInvite.stream()
                .map(email -> new Participant(email, trip)).toList();

        this.repository.saveAll(participants);
        System.out.println(participants.get(0).getId());

    }

    public void triggerConfirmationEmailToParticipants(UUID tripID){

    }

    public void triggerConfirmationEmailToParticipant(String email){

    }

    public ParticipantCreateResponse registerParticipantsToEvent(String email, Trip trip) {
        Participant newParticipant = new Participant(email, trip);
        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }
    public List<ParticipantData> getAllParticipantsFromEvent(UUID tripId) {
        return this.repository.findByTripId(tripId).stream()
                .map(participant -> new ParticipantData(participant.getId(), participant.getName(), participant.getEmail(),participant.getIsConfirmed())).toList();
    }

}
