import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.adapter.task2.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestTask2 {
    private FacebookUser facebookUser;
    private FacebookClient facebookClient;
    private TwitterUser twitterUser;
    private TwitterClient twitterClient;

    @BeforeEach
    public void init() {
        facebookUser = new FacebookUser("bob@fbmail.com", Country.USA, LocalDate.now());
        facebookClient = new FacebookClient(facebookUser);
        twitterUser = new TwitterUser("alice@fbmail.com", "Ukraine", LocalDate.now().toString());
        twitterClient = new TwitterClient(twitterUser);
    }

    @Test
    public void testFacebookUser() {
        Assertions.assertInstanceOf(String.class, facebookUser.getEmail());
        Assertions.assertInstanceOf(Country.class, facebookUser.getUserCountry());
        Assertions.assertInstanceOf(LocalDate.class, facebookUser.getGetUserActiveTime());
    }

    @Test
    public void testFacebookClient() {
        Assertions.assertInstanceOf(String.class, facebookClient.getEmail());
        Assertions.assertInstanceOf(String.class, facebookClient.getCountry());
        Assertions.assertInstanceOf(LocalDate.class, facebookClient.getLastActiveTime());
        Assertions.assertEquals(new ArrayList<>(), facebookClient.getReceivedMessages());
    }

    @Test
    public void testTwitterUser() {
        Assertions.assertInstanceOf(String.class, twitterUser.getUserMail());
        Assertions.assertInstanceOf(String.class, twitterUser.getCountry());
        Assertions.assertInstanceOf(String.class, twitterUser.getLastActiveTime());
    }

    @Test
    public void testTwitterClient() {
        Assertions.assertInstanceOf(String.class, twitterClient.getEmail());
        Assertions.assertInstanceOf(String.class, twitterClient.getCountry());
        Assertions.assertInstanceOf(LocalDate.class, twitterClient.getLastActiveTime());
        Assertions.assertEquals(new ArrayList<>(), twitterClient.getReceivedMessages());
    }

    @Test
    public void testLogin() {
        Client olesTwitter = Login.login("twitter");
        Assertions.assertEquals("Ukraine", olesTwitter.getCountry());
        Assertions.assertInstanceOf(LocalDate.class, olesTwitter.getLastActiveTime());

        Client olesFacebook = Login.login("facebook");
        Assertions.assertEquals("Ukraine", olesFacebook.getCountry());
        Assertions.assertInstanceOf(LocalDate.class, olesFacebook.getLastActiveTime());

        Assertions.assertThrows(IllegalArgumentException.class, () -> Login.login("instagram"));
    }

    @Test
    public void testMessageSender() {
        MessageSender messageSender = new MessageSender();
        messageSender.addReceiver(facebookClient);
        messageSender.addReceiver(twitterClient);

        Assertions.assertEquals(2, messageSender.getReceivers().size());

        messageSender.send("hello to USA", facebookClient, Country.USA);

        Assertions.assertEquals(facebookClient.getCountry(), Country.USA.toString());
        Assertions.assertEquals(facebookClient.getLastActiveTime(), LocalDate.now());
        Assertions.assertEquals("hello to USA", facebookClient.getReceivedMessages().get(0));

        messageSender.sendAll("only for ukrainians :)", Country.Ukraine);

        Assertions.assertEquals(Country.Ukraine.toString(), twitterClient.getCountry());
        Assertions.assertEquals(LocalDate.now(), twitterClient.getLastActiveTime());
        Assertions.assertEquals(twitterClient.getReceivedMessages().get(0), "only for ukrainians :)");
        Assertions.assertEquals(1, facebookClient.getReceivedMessages().size());
    }

}
