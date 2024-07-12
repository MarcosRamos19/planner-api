package com.github.marcosramos19.apiplanner.domain.service;

import com.github.marcosramos19.apiplanner.api.data.ActivityData;
import com.github.marcosramos19.apiplanner.api.representationmodel.requestpayload.ActivityRequestPayload;
import com.github.marcosramos19.apiplanner.api.representationmodel.response.ActivityResponse;
import com.github.marcosramos19.apiplanner.domain.model.Activity;
import com.github.marcosramos19.apiplanner.domain.model.Trip;
import com.github.marcosramos19.apiplanner.domain.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        this.repository.save(newActivity);

        return new ActivityResponse(newActivity.getId());


    }

    public List<ActivityData> getAllActivitiesFromId(UUID tripId) {
        return this.repository.findByTripId(tripId).stream()
                .map(activity -> new ActivityData(activity.getId(), activity.getTitle(), activity.getOccursAt())).toList();
    }
}
