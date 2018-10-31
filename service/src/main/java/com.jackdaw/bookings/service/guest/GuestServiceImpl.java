package com.jackdaw.bookings.service.guest;

import com.jackdaw.bookings.dto.GuestDto;
import com.jackdaw.bookings.model.Guest;
import com.jackdaw.bookings.model.Room;
import com.jackdaw.bookings.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestServiceImpl implements GuestService {
    private GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public GuestDto create(GuestDto guest) {
        Guest newGuest = new Guest(0, guest.getFirstName(), guest.getSurname(), guest.getCellphoneNumber(), guest.getEmail().toLowerCase());
        return guestRepository.save(newGuest).toDto();
    }

    @Override
    public List<GuestDto> get() {
        List<Guest> guests = guestRepository.findAll();
        return guests.stream().map(guest -> guest.toDto()).collect(Collectors.toList());
    }

    @Override
    public GuestDto find(int guestId) {
        Optional<Guest> guest = guestRepository.findById(guestId);
        return guest.isPresent() ? guest.get().toDto(): null;
    }
}
