package com.example.Real_time.Polling.App.controller;

import com.example.Real_time.Polling.App.model.Poll;
import com.example.Real_time.Polling.App.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MessageController {
    @Autowired
    private final PollService pollService;

    public MessageController(PollService pollService) {
        this.pollService = pollService;
    }

    @MessageMapping("/votes")
    @SendTo("/topic/polls")
    public ResponseEntity<Poll> vote(@RequestParam String option) {
        String pollId = "671e50c4ef8321242babcb2f";
        Optional<Poll> poll = pollService.vote(pollId, option);

        return poll.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
