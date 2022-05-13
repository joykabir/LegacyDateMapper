package zk.date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import zk.date.beans.TrainPassenger;
import zk.date.mapper.DateDeserializer;
import zk.date.mapper.DateSerializer;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .create();


        TrainPassenger passenger = new TrainPassenger("TestPassenger", "07000001111", "Test address 1",
                new Date("May 3, 2022 3:43:47 PM"), new Date("June 3, 2022 3:43:47 PM"), "91919191SE",
                "D12", "Stockholm", "Kumla");

        String serializedDate = gson.toJson(passenger);
        System.out.println("To JSON string: " + serializedDate);

        TrainPassenger passenger1 = gson.fromJson(serializedDate, TrainPassenger.class);
        System.out.println("From JSON string: " + passenger1.toString());
    }
}
