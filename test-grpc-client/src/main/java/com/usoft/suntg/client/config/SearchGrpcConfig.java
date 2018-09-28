package com.usoft.suntg.client.config;

import com.usoft.suntg.entity.SearchServiceGrpc;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Finance，sso GRPC Client 连接配置
 *
 * @author: wangdy
 * @date: 2018-08-22 17:57
 */
@Configuration
public class SearchGrpcConfig {

	/**
	 * 接口连接超时时间,单位毫秒
	 */
	public final static CallOptions.Key<Integer> CO_KEY_CONNECTION_TIMEOUT = CallOptions.Key.of("COKey_ConnectionTimeout", 0);
	@Value("${search.grpc.host}")
	private String searchGrpcHost;
	@Value("${search.grpc.port}")
	private int searchGrpcPort;


	@Bean(name = "searchManagedChannel")
	public ManagedChannel getFinManagedChannel() {
		return ManagedChannelBuilder.forAddress(searchGrpcHost, searchGrpcPort).usePlaintext().build();
	}

	@Bean(name = "searchServiceBlockingStub")
	public SearchServiceGrpc.SearchServiceBlockingStub getServiceGrpcServiceBlockingStub(@Qualifier("searchManagedChannel") ManagedChannel managedChannel) {
		SearchServiceGrpc.SearchServiceBlockingStub searchServiceBlockingStub =
				SearchServiceGrpc.newBlockingStub(managedChannel).withOption(CO_KEY_CONNECTION_TIMEOUT, 5000);
		return searchServiceBlockingStub;
	}

}
