package com.aditi.insight.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat formatter = new SimpleDateFormat(GlobalConstants.ISO_DATE_PATTERN);
        String format = formatter.format(date);
        generator.writeString(format);
		
	}

}
