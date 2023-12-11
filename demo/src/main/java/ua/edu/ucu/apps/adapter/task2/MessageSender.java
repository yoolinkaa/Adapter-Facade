package ua.edu.ucu.apps.adapter.task2;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageSender {
    @Getter
    private List<Client> receivers;

    public MessageSender(){
        receivers = new ArrayList<>();
    }

    public void addReceiver(Client user){
        receivers.add(user);
    }

    public void removeReceiver(Client user){
        receivers.remove(user);
    }

    public void send(String text, Client user, Country country){
        if (user.getCountry().equals(country.toString()) && user.getLastActiveTime().compareTo(LocalDate.now()) == 0){
            user.receiveMessage(text);
        }
    }

    public void sendAll(String text, Country country){
        for (Client user: receivers){
            send(text, user, country);
        }
    }
}
