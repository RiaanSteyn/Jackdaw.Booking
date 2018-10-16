package com.jackdaw.bookings.service.room;

import com.jackdaw.bookings.dto.RoomDto;
import com.jackdaw.bookings.model.Room;
import com.jackdaw.bookings.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(final RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto create(RoomDto room) {
        Room newRoom = new Room(0, room.getDescription(), room.getPrice(), room.getBeds());
        return roomRepository.save(newRoom).toDto();
    }

    @Override
    public List<RoomDto> get() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(room -> room.toDto()).collect(Collectors.toList());
    }

    @Override
    public RoomDto find(int roomId) {
        Room room = roomRepository.findOne(roomId);
        return room != null ? room.toDto(): null;
    }
}
