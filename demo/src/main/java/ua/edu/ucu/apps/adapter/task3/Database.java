package ua.edu.ucu.apps.adapter.task3;

import lombok.Getter;

public class Database extends БазаДаних{
    public String getUserData(){
        return отриматиДаніКористувача();
    }

    public String  getStaticData(){
        return отриматиСтатистичніДані();
    }
}
