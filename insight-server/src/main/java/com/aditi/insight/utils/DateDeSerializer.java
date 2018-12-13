package com.aditi.insight.utils;

import java.io.IOException;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class DateDeSerializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext ctx)
			throws IOException, JsonProcessingException {

		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		if (node != null) {
			final String date = node.asText();
			DateTimeFormatter dtf = DateTimeFormat.forPattern(GlobalConstants.ISO_DATE_PATTERN);
			DateTime dateTime = dtf.parseDateTime(date);
			Date formattedDate = dateTime.toDate();
			return formattedDate;
		}
		return DateTime.now().toDate();

	}

}
