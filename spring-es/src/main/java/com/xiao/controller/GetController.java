package com.xiao.controller;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
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
        GetRequest getRequest = new GetRequest(
                "twitter_latest",
                "1");
        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse.getSource();
    }

    /**
     * @return 创建索引
     */
    @GetMapping(value = "createIndex")
    public String createIndex() {
        CreateIndexRequest request = new CreateIndexRequest("twitter");
        //使用默认的setting配置
        Settings.Builder builder = Settings.builder();
        //不支持这 得单独使用analyzeApi
//        builder.put("analysis", "{\n" +
//                "            \"analyzer\" : {\n" +
//                "                \"ik\" : {\n" +
//                "                    \"tokenizer\" : \"ik_max_word\"\n" +
//                "                }\n" +
//                "            }");
        request.settings(builder);
        String mapping = "{\n" +
                "        \"properties\": {\n" +
                "            \"user\": {\n" +
                "                \"type\": \"keyword\"},\n" +
                "            \"tag\" : { \"type\" : \"keyword\" },\n" +
                "            \"age\" : { \"type\" : \"byte\" },\n" +
                "            \"post_date\" : { \"type\" : \"date\" },\n" +
                "            \"message\" : { \"type\" : \"text\" },\n" +
                "             \"content\": {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"analyzer\": \"ik_max_word\"\n" +
                "                        }\n" +
                "        }\n" +
                "    }";
        request.mapping(mapping, XContentType.JSON);
        CreateIndexResponse createIndexResponse = null;
        try {
            createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createIndexResponse.toString();
    }

    /**
     * @return 删除索引
     */
    @GetMapping(value = "deleteIndex")
    public boolean deleteIndex() {
        DeleteIndexRequest request = new DeleteIndexRequest("twitter");
        try {
            AcknowledgedResponse deleteIndexResponse = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);

            return deleteIndexResponse.isAcknowledged();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * @return 插入数据
     */
    @GetMapping(value = "postIndex")
    public int postIndex() {
        IndexRequest indexRequest = new IndexRequest("twitter_v2");
        String content = "{\n" +
                "\"content\":\"中国产小型无人机的“对手”来了，俄微型拦截导弹便宜量又多\"\n" +
                "}";
        indexRequest.source(content, XContentType.JSON);
        try {
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            return indexResponse.status().getStatus();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
    /**
     * @return 插入数据
     */
    @GetMapping(value = "search")
    public String search() {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            SearchHit searchHit = hits.getHits()[0];
            return searchHit.getSourceAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "暂无数据";
    }


}
