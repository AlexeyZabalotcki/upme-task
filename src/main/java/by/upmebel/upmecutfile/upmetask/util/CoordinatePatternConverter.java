package by.upmebel.upmecutfile.upmetask.util;

import by.upmebel.upmecutfile.upmetask.model.CoordinatePattern;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class CoordinatePatternConverter implements AttributeConverter<CoordinatePattern, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(CoordinatePattern attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting CoordinatePattern to String", e);
        }
    }

    @Override
    public CoordinatePattern convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, new TypeReference<CoordinatePattern>() {});
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting String to CoordinatePattern", e);
        }
    }
}