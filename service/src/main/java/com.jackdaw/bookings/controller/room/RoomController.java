package com.jackdaw.bookings.controller.room;

import com.jackdaw.bookings.dto.RoomDto;
import com.jackdaw.bookings.service.room.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("v1/rooms")
@Api(value = "/rooms", description = "Operations on rooms")
public class RoomController {

    private RoomService service;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create a room", response = RoomDto.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "Invalid room supplied") })
    public Callable<ResponseEntity<RoomDto>> create(@RequestBody final RoomDto room) {
        return () -> {
            final RoomDto newRoom = service.create(room);
            return ResponseEntity.ok(newRoom);
        };
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get rooms", response = RoomDto.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "Rooms not found") })
    public Callable<ResponseEntity<List<RoomDto>>> get() {
        return () -> {
            final List<RoomDto> roomDtoList = service.get();
            return ResponseEntity.ok(roomDtoList);
        };
    }



    @RequestMapping(value = "/roomId", method = RequestMethod.GET)
    @ApiOperation(value = "Get rooms", response = RoomDto.class)
    @ApiResponses({ @ApiResponse(code = 400, message = "Rooms not found") })
    public Callable<ResponseEntity<RoomDto>> find(@PathVariable int roomId) {
        return () -> {
            final RoomDto room = service.find(roomId);
            return ResponseEntity.ok(room);
        };
    }
}
