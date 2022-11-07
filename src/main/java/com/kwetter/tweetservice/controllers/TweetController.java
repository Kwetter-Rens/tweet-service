package com.kwetter.tweetservice.controllers;

import com.kwetter.tweetservice.models.Tweet;
import com.kwetter.tweetservice.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/post")
    public ResponseEntity<Tweet> postTweet(@RequestBody Tweet tweet) {
        return this.tweetService.save(tweet);
    }

    @GetMapping()
    public ResponseEntity<List<Tweet>> getAllTweets() {
        return this.tweetService.getAll();
    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable int tweetId) {
        return this.tweetService.getTweetById(tweetId);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}