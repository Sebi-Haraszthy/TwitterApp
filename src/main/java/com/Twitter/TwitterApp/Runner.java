package com.Twitter.TwitterApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private CommentService commentService;
    private UserService userService;
    private TweetService tweetService;

    public Runner(@Autowired CommentService commentService, @Autowired UserService userService, @Autowired TweetService tweetService) {
        this.commentService = commentService;
        this.userService = userService;
        this.tweetService = tweetService;
    }

    @Override
    public void run(String... args) {
        //testing CREATE operations
        User user1 = new User();
        user1.setName("sebi");
        userService.saveUser(user1);
        Tweet tweet1 = new Tweet();
        tweet1.setText("hello");
        User editedUser = userService.addTweetToUser(tweet1, user1);
        Comment comment1 = new Comment();
        comment1.setText("I like you");
        Tweet foundTweet = tweetService.findByText("hello");
        Tweet editedTweet = tweetService.addCommentToTweet(foundTweet, comment1);

        //testing READ operations
        System.out.println("All comment by tweet: " + commentService.findAllByTweet(editedTweet));
        System.out.println("All comment by tweet: " + commentService.findAllByUser(editedUser));

        //testing UPDATE operations
        User user2 = new User();
        user2.setName("jasmi");
        User savedUser = userService.saveUser(user2);
        savedUser.setName("diana");
        User updatedUser = userService.updateUser(savedUser);

        //testing DELETE operations
        tweetService.deleteAllCommentsFromTweet(editedTweet);
        userService.deleteAllTweetsFromUser(editedUser);
        userService.deleteUser(editedUser);
    }
}