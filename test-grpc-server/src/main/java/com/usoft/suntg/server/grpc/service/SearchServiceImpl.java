package com.usoft.suntg.server.grpc.service;

import com.usoft.suntg.entity.SearchRequest;
import com.usoft.suntg.entity.SearchResponse;
import com.usoft.suntg.entity.SearchServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * searchService grpc server demo
 * @author suntg
 */
@GRpcService
public class SearchServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void searchIds(SearchRequest request, StreamObserver<SearchResponse> responseObserver) {
        logger.info("grpc server excute, pageSize: {}, pageNumber: {}, keyword: {}.", request.getPageSize(), request.getPageNumber(), request.getKeyword());
        SearchResponse.Builder builder = SearchResponse.newBuilder();
        builder.setTotalElements(2322);
        builder.setPageNumber(request.getPageNumber());
        builder.setPageSize(request.getPageSize());
        IntStream.range(0, request.getPageSize()).forEach(i -> builder.addContent(System.currentTimeMillis()));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
