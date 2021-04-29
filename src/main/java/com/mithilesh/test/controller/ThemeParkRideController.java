package com.mithilesh.test.controller;

import com.mithilesh.test.entity.ThemeParkRide;
import com.mithilesh.test.repository.ThemeParkRideRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class ThemeParkRideController {

    private final ThemeParkRideRepo themeParkRideRepo;

    public ThemeParkRideController(ThemeParkRideRepo themeParkRideRepo) {
        this.themeParkRideRepo = themeParkRideRepo;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides() {
        return themeParkRideRepo.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRidesById(@PathVariable long id) {
        return themeParkRideRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideRepo.save(themeParkRide);
    }
}
