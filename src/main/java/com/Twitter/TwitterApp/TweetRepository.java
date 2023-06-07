package com.Twitter.TwitterApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
    Tweet findByText(String text);
}