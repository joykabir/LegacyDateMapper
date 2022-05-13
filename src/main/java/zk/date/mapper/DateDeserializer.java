package zk.date.mapper;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateDeserializer implements JsonDeserializer<Date> {

    public static final Logger log = LoggerFactory.getLogger(DateDeserializer.class);
    protected SimpleDateFormat simpleDateFormat;

    public DateDeserializer() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dateToParse = json.getAsJsonPrimitive().getAsString();

        try {
            return simpleDateFormat.parse(dateToParse);
        } catch (ParseException e) {
            log.info("Failed to pare the date string: " + dateToParse);
            return null;
        }
    }
}
