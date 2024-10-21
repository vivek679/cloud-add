package com.learning.userservice.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    /**
     * This method is used to reade profiles file stored in `src/main/resources/`
     *
     * @param filePath filepath
     * @param type Type T
     * @return List of Type T
     * @param <T> Type
     */
    public static <T> List<T> loadDataFromJson(String filePath, Type type) {
        ClassLoader classLoader = Utils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filePath);

        if (inputStream == null) {
            logger.info("File not found: {}", filePath);
            return new ArrayList<>(); // Ensure you return the new list here
        }

        try (Reader reader = new InputStreamReader(inputStream)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            logger.error("Error while reading/processing json file");
            throw new RuntimeException(e.getMessage());
        }
    }

}
