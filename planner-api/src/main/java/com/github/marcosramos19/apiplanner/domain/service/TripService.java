package com.github.marcosramos19.apiplanner.domain.service;

import com.github.marcosramos19.apiplanner.domain.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;


}
