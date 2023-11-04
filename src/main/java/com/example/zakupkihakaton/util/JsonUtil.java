package com.example.zakupkihakaton.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JsonUtil {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Convert an object to its JSON representation.
     *
     * @param object The object to be converted to JSON.
     * @return A JSON string representing the object.
     * @throws JsonProcessingException If there's an error during JSON serialization.
     */
    public String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * Convert an object to its JSON representation with pretty formatting.
     *
     * @param object The object to be converted to JSON.
     * @return A pretty-printed JSON string representing the object.
     * @throws JsonProcessingException If there's an error during JSON serialization.
     */
    public String toPrettyJson(Object object) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public String convertToCurl(HttpServletRequest request) {
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> headerNames = request.getHeaderNames();
        List<String> headers = Collections.list(headerNames);

        // Создаем строку curl-запроса
        StringBuilder curlCommand = new StringBuilder("curl");

        // Добавляем метод запроса
        curlCommand.append(" -X ").append(method);

        // Добавляем URL
        curlCommand.append(" \\'").append(url).append("\\'");

        // Добавляем параметры запроса (если есть)
        if (!parameterMap.isEmpty()) {
            String parameters = parameterMap.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + String.join(",", entry.getValue()))
                    .collect(Collectors.joining("&"));
            curlCommand.append(" -d '").append(parameters).append("'");
        }

//        // Добавляем заголовки запроса
//        for (String header : headers) {
//            String headerValue = request.getHeader(header);
//            curlCommand.append(" -H '").append(header).append(": ").append(headerValue).append("'");
//        }

        return curlCommand.toString();
    }
}