package com.example.Real_time.Polling.App.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Document(collection = "poll")
public class Poll {
    @Id
    private String id;
    private String question;
    private Map<String, Integer> options;
}
