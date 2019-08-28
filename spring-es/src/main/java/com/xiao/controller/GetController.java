package com.xiao.controller;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class GetController {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @GetMapping
    public Map get() {
//        GetResponse response = client.prepareGet("cc", "_doc", "1").get();
        GetRequest getRequest = new GetRequest(
                "cc",
                "1");
        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse.getSource();
    }
}
