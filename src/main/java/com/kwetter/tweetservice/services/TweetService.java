package com.kwetter.tweetservice.services;

import com.kwetter.tweetservice.models.Tweet;
import com.kwetter.tweetservice.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    private final TweetRepository tweetRepo;

    public TweetService(TweetRepository tweetRepo) {
        this.tweetRepo = tweetRepo;
    }


    public ResponseEntity<List<Tweet>> getAll() {
        List<Tweet> tweets = tweetRepo.findAll();
        return new ResponseEntity<>(tweets, new HttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity<Tweet> getTweetById(int tweetId) {
        return this.tweetRepo.findById(tweetId)
                .map(tweet -> new ResponseEntity<>(tweet, new HttpHeaders(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Tweet> save(Tweet tweet) {
        if(tweet.getContent().isBlank()) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        tweetRepo.save(tweet);
        return new ResponseEntity<>(tweet, new HttpHeaders(), HttpStatus.CREATED);
    }
}
