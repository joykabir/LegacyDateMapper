package zk.date.mapper;

/*
java.util.Date has no concept of timezone. It simply holds time relative to epoch, which is Jan 1 1970 00:00:00 UTC.
Date is a model, separate from the view. When you display the date, the concept of timezone then is applied.
Date's toString() displays a human-readable date in the default timezone. You can either use a DateFormat to display a Date
in a different timezone (such as UTC), or change the JVM's default timezone.

This adapter formats a Java.util.Date to this format: "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
*/

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class JavaDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private DateTimeFormatter dateTimeFormatter;

    public JavaDateAdapter() {
        dateTimeFormatter = new DateTimeFormatterBuilder().appendInstant(3).toFormatter();
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // If input is in UTC, such as the Z (for Zulu) on the end, the Instant class can parse.
        // yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
        try {
            Instant instant = Instant.parse(json.getAsString());
            return Date.from(instant);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
        Instant instant = date.toInstant();
        return new JsonPrimitive(dateTimeFormatter.format(instant));
    }
}
