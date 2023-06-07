package com.Twitter.TwitterApp;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Tweet> tweetList;

    public User(String name, List<Tweet> tweetList) {
        this.name = name;
        this.tweetList = tweetList;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tweet> getTweetList() {
        if (this.tweetList == null) {
            this.tweetList = new ArrayList<>();
        }

        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
}