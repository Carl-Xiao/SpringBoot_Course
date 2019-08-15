package com.xiao.main;

import com.xiao.proto.bean.GreeterGrpc;
import com.xiao.proto.bean.HelloGreeter;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Carl-Xiao 2019-08-15
 */
public class GrpcServer {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    public static void main(String[] args) throws IOException {
        int port = 8082;
        Server server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        try {
            if (server != null) {
                server.awaitTermination();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        @Override
        public void sayHello(HelloGreeter.HelloRequest req, StreamObserver<HelloGreeter.HelloReply> responseObserver) {
            HelloGreeter.HelloReply reply = HelloGreeter.HelloReply.newBuilder().setMessage("Hello I received").build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }


}
