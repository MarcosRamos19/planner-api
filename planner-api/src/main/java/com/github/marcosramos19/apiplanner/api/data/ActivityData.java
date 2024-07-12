package com.github.marcosramos19.apiplanner.api.data;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityData(UUID id, String title, LocalDateTime occurs_at) {
}
