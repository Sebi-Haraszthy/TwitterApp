package com.Twitter.TwitterApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    private CommentRepository commentRepository;
    private TweetRepository tweetRepository;

    public TweetService(@Autowired CommentRepository commentRepository, @Autowired TweetRepository tweetRepository) {
        this.commentRepository = commentRepository;
        this.tweetRepository = tweetRepository;
    }

    public Tweet findByText(String text) {
        return tweetRepository.findByText(text);
    }

    public Tweet addCommentToTweet(Tweet tweet, Comment comment) {
        comment.setTweet(tweet);
        tweet.getCommentList().add(comment);

        return tweetRepository.save(tweet);
    }

    public void deleteAllCommentsFromTweet(Tweet tweet) {
        commentRepository.deleteAll(tweet.getCommentList());
    }
}