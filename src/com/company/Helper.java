package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Helper {

    ObjectMapper mapper = new ObjectMapper();
    static List<Words> word;

    public List<Words> getList() throws Exception {
        String jsonInput = FileUtils.readFileToString(new File("res\\dictionary.json"), StandardCharsets.UTF_8);
        word = mapper.readValue(jsonInput, new TypeReference<List<Words>>() {
        });

        return word;
    }
}
