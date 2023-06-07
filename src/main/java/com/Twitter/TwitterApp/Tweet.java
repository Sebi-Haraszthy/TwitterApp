package com.Twitter.TwitterApp;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String text;
    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    List<Comment> commentList;

    public Tweet(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Tweet() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getCommentList() {
        if (this.commentList == null) {
            this.commentList = new ArrayList<>();
        }

        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}