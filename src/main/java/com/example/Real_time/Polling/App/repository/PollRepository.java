package com.example.Real_time.Polling.App.repository;

import com.example.Real_time.Polling.App.model.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends MongoRepository<Poll, String> {

}
