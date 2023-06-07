package com.Twitter.TwitterApp;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String text;
    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    public Comment(String text) {
        this.text = text;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}