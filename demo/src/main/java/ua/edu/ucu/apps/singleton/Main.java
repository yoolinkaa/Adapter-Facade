package ua.edu.ucu.apps.singleton;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Yaroslav", "ya.prytula", 18);
        user.save();
    }
}
