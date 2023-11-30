package zk.date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zk.date.mapper.JavaDateAdapter;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaDateAdapterTest {
	private static Gson gson;

	@Before
	public void setup() {
		gson = new GsonBuilder().registerTypeAdapter(Date.class, new JavaDateAdapter()).create();
	}

	@Test
	public void test_Serialize() {
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.MAY, 12, 8, 30, 30, 3123123);
		Date date = Date.from(localDateTime.toInstant(ZoneOffset.UTC));
		String s = gson.toJson(date);
		Assert.assertEquals("2015-05-12T08:30:30.003Z", JsonParser.parseString(s).getAsString());
	}

	@Test
	public void test_Deserialize() {
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.MAY, 12, 8, 30, 30, 3123123);
		Date date = Date.from(localDateTime.toInstant(ZoneOffset.UTC));
		String s = gson.toJson(date);
		Date deserialized = gson.fromJson(s, Date.class);

		Assert.assertNotNull(deserialized);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datetime = LocalDateTime.ofInstant(deserialized.toInstant(), ZoneId.of("UTC")).format(dateTimeFormatter);
		Assert.assertEquals("2015-05-12 08:30:30", datetime);
	}
}
