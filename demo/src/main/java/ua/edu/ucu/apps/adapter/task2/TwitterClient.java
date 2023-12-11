package ua.edu.ucu.apps.adapter.task2;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TwitterClient implements Client {
    private final TwitterUser user;
    @Getter
    private List<String> receivedMessages;

    public TwitterClient(TwitterUser user) {
        this.user = user;
        this.receivedMessages = new ArrayList<>();
    }

    @Override
    public String getEmail() {
        return user.getUserMail();
    }

    @Override
    public String getCountry() {
        return user.getCountry().toString();
    }

    @Override
    public LocalDate getLastActiveTime() {
        return LocalDate.parse(user.getLastActiveTime());
    }
    @Override
    public void receiveMessage(String text){
        receivedMessages.add(text);
    }
}
