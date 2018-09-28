package com.usoft.suntg.client.web;

import com.usoft.suntg.entity.SearchRequest;
import com.usoft.suntg.entity.SearchResponse;
import com.usoft.suntg.entity.SearchServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchServiceGrpc.SearchServiceBlockingStub searchService;

    @GetMapping
    public List<Long> searchId() {
        List<Long> ids = new ArrayList<Long>();
        SearchRequest.Builder requestBuilder = SearchRequest.newBuilder();
        requestBuilder.setKeyword("aaa");
        requestBuilder.setPageNumber(1);
        requestBuilder.setPageSize(10);
        SearchResponse response = searchService.searchIds(requestBuilder.build());
        return response.getContentList();
    }

}
