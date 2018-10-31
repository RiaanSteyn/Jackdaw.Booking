package com.jackdaw.bookings.service.guest;

import com.jackdaw.bookings.dto.GuestDto;

import java.util.List;

public interface GuestService {
    GuestDto create(GuestDto guest);

    List<GuestDto> get();

    GuestDto find(int guestId);
}
