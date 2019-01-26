package br.com.peixeurbano.store.commons;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Custom DateTime Serializer JSON
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class CustomDateTimeSerializer extends StdSerializer<Date> {

	private static final long serialVersionUID = 5028248959051075628L;

	// private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy
	// hh:mm:ss");

	public CustomDateTimeSerializer() {
		this(null);
	}

	public CustomDateTimeSerializer(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeNumber(value.getTime() / 1000);
		// gen.writeString(formatter.format(value));
	}
}
