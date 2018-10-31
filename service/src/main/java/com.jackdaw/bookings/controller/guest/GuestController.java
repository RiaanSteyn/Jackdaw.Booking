package com.jackdaw.bookings.controller.guest;

import com.jackdaw.bookings.dto.GuestDto;
import com.jackdaw.bookings.service.guest.GuestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("v1/guests")
@Api(value = "v1/guests", description = "Operations on guests")
public class GuestController {
    private GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create a new guest", response = GuestDto.class)
    @ApiResponses({@ApiResponse(code = 400, message = "Invalid guest info supplied")})
    public Callable<ResponseEntity<GuestDto>> create(@RequestBody final GuestDto guest) {
        return () -> {
            final GuestDto newGuest = service.create(guest);
            return ResponseEntity.ok(newGuest);
        };
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get guests", response = GuestDto.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "Guests not found") })
    public Callable<ResponseEntity<List<GuestDto>>> get() {
        return () -> {
            final List<GuestDto> guestDtoList = service.get();
            return ResponseEntity.ok(guestDtoList);
        };
    }



    @RequestMapping(value = "/{guestId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get guest", response = GuestDto.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "Guest not found") })
    public Callable<ResponseEntity<GuestDto>> find(@PathVariable int guestId) {
        return () -> {
            final GuestDto guest = service.find(guestId);
            return ResponseEntity.ok(guest);
        };
    }
}
