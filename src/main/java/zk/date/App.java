package zk.date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import zk.date.beans.TrainPassenger;
import zk.date.mapper.JavaDateAdapter;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        //Test object deserialization containing date
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JavaDateAdapter()).create();

        TrainPassenger passenger = new TrainPassenger("TestPassenger", "07000001111", "Test address 1",
                new Date("May 3, 2022 3:43:47 PM"), new Date("May 4, 2022 3:43:47 PM"), UUID.randomUUID().toString(),
                "D12", "Stockholm", "Kumla");
        String serializedObject = gson.toJson(passenger);
        System.out.println("TO JSON string# : " + serializedObject);

        TrainPassenger javaObject = gson.fromJson(serializedObject, TrainPassenger.class);
        System.out.println("FROM JSON string# : " + javaObject.toString());
        System.out.println(Instant.now().toEpochMilli());
    }
}