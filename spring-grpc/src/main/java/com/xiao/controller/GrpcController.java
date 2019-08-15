package com.xiao.controller;

import com.xiao.proto.bean.GreeterGrpc;
import com.xiao.proto.bean.HelloGreeter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl-Xiao 2019-08-15
 */
@RestController
public class GrpcController {
    @GetMapping
    public String sayHello() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8082).usePlaintext(true)
                .build();
        GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(managedChannel);

        HelloGreeter.HelloReply response = blockingStub.sayHello(HelloGreeter.HelloRequest.newBuilder().setName("hello python").build());

        return response.getMessage();
    }

}
