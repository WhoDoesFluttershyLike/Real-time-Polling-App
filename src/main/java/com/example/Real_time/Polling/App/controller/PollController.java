package com.example.Real_time.Polling.App.controller;

import com.example.Real_time.Polling.App.model.Poll;
import com.example.Real_time.Polling.App.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/polls")
public class PollController {
    @Autowired
    private final PollService pollService;
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }





    @PostMapping("/create")
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.create(poll);
    }

    @PostMapping("/{pollId}/vote")
    public ResponseEntity<Poll> vote(@PathVariable String pollId, @RequestParam String option) {
        Optional<Poll> poll = pollService.vote(pollId, option);

        return poll.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
