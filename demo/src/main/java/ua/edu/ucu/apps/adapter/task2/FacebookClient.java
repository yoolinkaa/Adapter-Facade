package ua.edu.ucu.apps.adapter.task2;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacebookClient implements Client {
    private final FacebookUser user;
    @Getter
    private List<String> receivedMessages;

    public FacebookClient(FacebookUser user) {
        this.user = user;
        this.receivedMessages = new ArrayList<>();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getCountry() {
        return user.getUserCountry().toString();
    }

    @Override
    public LocalDate getLastActiveTime() {
        return user.getGetUserActiveTime();
    }
    @Override
    public void receiveMessage(String text){
        receivedMessages.add(text);
    }
}
