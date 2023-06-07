package com.Twitter.TwitterApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByTweet(Tweet tweet);

    List<Comment> findAllByTweet_User(User user);
}