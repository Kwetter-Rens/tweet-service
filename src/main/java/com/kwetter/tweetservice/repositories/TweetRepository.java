package com.kwetter.tweetservice.repositories;

import com.kwetter.tweetservice.models.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, Integer> {

}
