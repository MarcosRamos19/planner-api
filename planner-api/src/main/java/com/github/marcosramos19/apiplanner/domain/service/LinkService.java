package com.github.marcosramos19.apiplanner.domain.service;

import com.github.marcosramos19.apiplanner.api.data.LinkData;
import com.github.marcosramos19.apiplanner.api.representationmodel.requestpayload.LinkRequestPayload;
import com.github.marcosramos19.apiplanner.api.representationmodel.response.LinkResponse;
import com.github.marcosramos19.apiplanner.domain.model.Link;
import com.github.marcosramos19.apiplanner.domain.model.Trip;
import com.github.marcosramos19.apiplanner.domain.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;
    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip) {
        Link newLink = new Link(payload.title(), payload.url(), trip);

        this.repository.save(newLink);

        return new LinkResponse(newLink.getId());


    }

    public List<LinkData> getAllLinksFromId(UUID tripId) {
        return this.repository.findByTripId(tripId).stream()
                .map(link -> new LinkData(link.getId(),link.getTitle(), link.getUrl())).toList();
    }
}
