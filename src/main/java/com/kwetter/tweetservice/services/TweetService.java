package com.kwetter.tweetservice.services;

import com.kwetter.tweetservice.models.Tweet;
import com.kwetter.tweetservice.repositories.TweetRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    private final TweetRepository tweetRepo;

    final static Logger logger = LoggerFactory.getLogger(TweetService.class);

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

    public List<Tweet> getTweetsByUserIds(List<String> userIds) {
        return tweetRepo.findAllByUserIdIn(userIds);
    }

    public ResponseEntity<Tweet> postTweet(Tweet tweet) {
        if(tweet.getContent() != null && !tweet.getContent().isEmpty()) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        logger.info("Posting tweet: " + tweet);
        Tweet postedTweet = tweetRepo.save(tweet);
        return new ResponseEntity<>(postedTweet, new HttpHeaders(), HttpStatus.CREATED);
    }

    public void deleteUserFromTweets(String Auth0userId) {
        Update update = new Update();
        update.set("username", "deleted");
        update.unset("profilePicture");
        tweetRepo.updateTweetsByUserId(Auth0userId, update);
    }

    public String test() {
        String test = "test from TweetService NOW WITH CD!";
        logger.info(test);
        return test;
    }
}
