package com.kwetter.tweetservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Document("tweets")
@Data
@AllArgsConstructor
public class Tweet {
    @Id
    private ObjectId tweetId;
    private Date creationTime;
    private String content;
    private Long userId;
}