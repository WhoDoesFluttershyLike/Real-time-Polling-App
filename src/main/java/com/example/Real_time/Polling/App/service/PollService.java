package com.example.Real_time.Polling.App.service;

import com.example.Real_time.Polling.App.model.Poll;
import com.example.Real_time.Polling.App.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PollService {
    @Autowired
    private final PollRepository pollRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public PollService(PollRepository pollRepository, SimpMessagingTemplate messagingTemplate) {
        this.pollRepository = pollRepository;
        this.messagingTemplate = messagingTemplate;
    }
    public Poll create(Poll poll){
       return pollRepository.save(poll);
    }

    public Optional<Poll> vote(String pollId, String option) {
        Optional<Poll> pollOptional = pollRepository.findById(pollId);

        if (pollOptional.isPresent()) {
            Poll poll = pollOptional.get();
            poll.getOptions().put(option, poll.getOptions().getOrDefault(option, 0) + 1);
            pollRepository.save(poll);

            // Broadcast updated poll data
            messagingTemplate.convertAndSend("/topic/polls/" + pollId, poll);

            return Optional.of(poll);
        }

        return Optional.empty();
    }
}
