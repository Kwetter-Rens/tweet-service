package com.kwetter.tweetservice.controllers;

import com.kwetter.tweetservice.models.Tweet;
import com.kwetter.tweetservice.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/tweets")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }


    @PostMapping()
    public ResponseEntity<Tweet> postTweet(@RequestBody Tweet tweet) {
        return this.tweetService.postTweet(tweet);
    }

    @GetMapping()
    public ResponseEntity<List<Tweet>> getAllTweets() {
        return this.tweetService.getAll();
    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable int tweetId) {
        return this.tweetService.getTweetById(tweetId);
    }

    @GetMapping("/gettweets/{userIds}")
    public List<Tweet> getTweetsByUserIds(@PathVariable List<Long> userIds) {
        return tweetService.getTweetsByUserIds(userIds);
    }

    @GetMapping("/test")
    public String test() {
        return "test from TweetService";
    }
}
