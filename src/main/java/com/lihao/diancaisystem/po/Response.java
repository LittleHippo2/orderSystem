package com.lihao.diancaisystem.po;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@JsonSerialize(
        using = Response.Builder.class
)
public interface Response {

    String getCode();

    String getMessage();

    Optional<Map<String , Object>> getFields();


    Optional<Object> getData();

    class Builder extends JsonSerializer<Response> {
        private static final Logger logger = LoggerFactory.getLogger(Response.Builder.class);
        private static final String CODE_KEY = "result";
        private static final String MESSAGE_KEY = "message";
        private static final String DATA_KEY = "data";

        public Builder(){

        }

        public void serialize(Response response, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)throws IOException, JsonProcessingException {
            logger.debug("Start serialize Response: {}", response);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("result", response.getCode());
            jsonGenerator.writeStringField("message", response.getMessage());
            if (response.getData().isPresent()) {
                jsonGenerator.writeObjectField("data", response.getData().get());
            }

            if (response.getFields().isPresent()) {
                Map<String, Object> fields = (Map)response.getFields().get();
                fields.forEach((k, v) -> {
                    try {
                        jsonGenerator.writeObjectField(k, v);
                    } catch (IOException var4) {
                        var4.printStackTrace();
                    }

                });
            }

            jsonGenerator.writeEndObject();
            logger.debug("Finished serialize Response", response);
        }

    }
}
