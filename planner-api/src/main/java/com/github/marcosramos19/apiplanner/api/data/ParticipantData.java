package com.github.marcosramos19.apiplanner.api.data;

import java.util.UUID;

public record ParticipantData(UUID id, String name, String email, Boolean isConfirmed) {
}
