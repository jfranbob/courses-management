package com.jfranbob.coursesmanagement.domain.school;

import java.util.UUID;

public record School(
        UUID id,
        String name,
        String country,
        String website,
        String email,
        String phone,
        String address
) {
}
