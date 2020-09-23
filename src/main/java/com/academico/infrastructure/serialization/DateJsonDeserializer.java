package com.academico.infrastructure.serialization;

import java.util.Date;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.academico.infrastructure.helper.DateHelper;

@JsonComponent
public class DateJsonDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        return DateHelper.stringToDate(treeNode.toString().replace("\"", ""));
    }
}