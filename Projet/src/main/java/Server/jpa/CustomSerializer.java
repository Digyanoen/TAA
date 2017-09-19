package Server.jpa;

import Server.Endpoint.ActivityName;
import Server.Model.Activity;
import Server.Model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomSerializer extends JsonSerializer<ActivityName> {

    @Override
    public void serialize(ActivityName act , JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        System.err.println("pass par la");
//     jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName(act.getName());
//        jsonGenerator.writeEndObject();

    }


}
