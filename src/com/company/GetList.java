package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import static com.company.Main.*;

public class GetList {

    public Map<String, Object> getList() throws Exception{
        String path = "C:\\Users\\Radhika\\IdeaProjects\\Word Dictionary\\res\\data\\dictionary.json";
        wordMap = new ObjectMapper().readValue(Paths.get(path).toFile(), HashMap.class);

        return wordMap;
    }

}
