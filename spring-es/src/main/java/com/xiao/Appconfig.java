package com.xiao;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class Appconfig {
    @Bean
    public RestHighLevelClient restHighLevelClient() throws UnknownHostException {
//        InetSocketTransportAddress node = new InetSocketTransportAddress(n);
//        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        client.addTransportAddress(node);
//        Settings settings = Settings.builder()
//                .put("client.transport.sniff", true).build();
//        Client client = new PreBuiltTransportClient(settings)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));

        return client;
    }
}
