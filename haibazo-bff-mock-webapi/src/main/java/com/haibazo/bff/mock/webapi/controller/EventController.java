package com.haibazo.bff.mock.webapi.controller;

import com.haibazo.bff.mock.webapi.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/its-rct/v1")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/track-event")
    public String trackEvent() {
        eventService.trackEvent();
        return "Event tracked!";
    }
}