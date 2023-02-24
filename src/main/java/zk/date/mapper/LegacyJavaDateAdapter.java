package zk.date.mapper;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LegacyJavaDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    public static final Logger log = LoggerFactory.getLogger(LegacyJavaDateAdapter.class);
    private DateFormat simpleDateFormat;

    public LegacyJavaDateAdapter() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dateToParse = json.getAsString();

        try {
            return simpleDateFormat.parse(dateToParse);
        } catch (ParseException e) {
            logAndPrint("Failed to parse the Date string: " + dateToParse);
            return null;
        }
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(simpleDateFormat.format(src));
    }

    private static void logAndPrint(String message) {
        System.out.println(message);
        log.info(message);
    }
}
