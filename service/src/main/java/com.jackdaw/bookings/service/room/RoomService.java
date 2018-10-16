package com.jackdaw.bookings.service.room;

import com.jackdaw.bookings.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto create(RoomDto room);

    List<RoomDto> get();

    RoomDto find(int roomId);
}
