package com.kwetter.tweetservice.repositories;

import com.kwetter.tweetservice.models.Tweet;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, Integer> {
    List<Tweet> findAllByUserIdIn(List<String> userIds);

    @Modifying
    @Query("{ 'userId': ?0 }")
    void updateTweetsByUserId(String auth0userId, Update update);
}
