# test-grpc-parent
Spring-boot 集成grpc的demo项目

## 项目结构说明
包含以下3个项目
* test-grpc-api 用于定义proto接口文件，并通过maven插件，将proto文件转为为对应的java文件，并封装为jar包
* test-grpc-server 引入test-grpc-api的jar包，并实现其grpc接口，作为服务提供方
* test-grpc-client 引入test-grpc-api的jar包，通过通道调用声明接口的bean，通过bean实现grpc调用

## 启动方式
1. test-grpc-api mvn install 生成对应的api的jar包
2. test-grpc-server 项目启动，开启服务端
3. test-grpc-client 项目启动，开启客户端
4. 访问 ```http://localhost:8081/search``` 接口实现会调用grpc接口
