package zk.date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zk.date.mapper.JavaDateAdapter;
import zk.date.mapper.LegacyJavaDateAdapter;

import java.time.Instant;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.util.Date;

public class LegacyDateJsonAdapterTest {

    private static final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new LegacyJavaDateAdapter()).create();

    @Test
    public void testDateToJsonNew() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Date date = new Date(zonedDateTime.toEpochSecond() * 1000);
        String s = gson.toJson(date);
        Assert.assertNotNull(s);
        Assert.assertNotNull(JsonParser.parseString(s).getAsString());
    }

    @Test
    public void testDateToJson() {
        Date date = Date.from(Instant.now());
        String s = gson.toJson(date);
        Assert.assertNotNull(s);
        Assert.assertNotNull(JsonParser.parseString(s).getAsString());
    }

    @Test
    public void testDateToJson1() {
        // 2022-05-30T10:57:52.680Z
        // Epoch Milli: 1653908272680
        Date date = new Date(1653908272680L);
        String s = gson.toJson(date);
        Assert.assertEquals("2022-05-30T10:57:52.680Z", JsonParser.parseString(s).getAsString());
    }

    @Test
    public void testDateFromInstant() {
        long l = IsoChronology.INSTANCE.epochSecond(0001, Month.NOVEMBER.getValue(), 26, 8, 10, 20, ZoneOffset.UTC);
        Date date = Date.from(Instant.ofEpochSecond(l));
        String s = gson.toJson(date);
        Assert.assertNotNull(s);
    }
}
