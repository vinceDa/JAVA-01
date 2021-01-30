## 作业

1. （必做）整合你上次作业的httpclient/okhttp；

   ​	在[HttpHandler](https://github.com/vinceDa/JavaCourseCodes/blob/main/02nio/nio01/src/main/java/java0/nio01/netty/HttpHandler.java)中将value的获取方式修改为自定义实现的client获取(49行)

2. （可选）:使用netty实现后端http访问（代替上一步骤）；

   ​	后续补充

3. （必做）实现过滤器 ~

   - 自定义过滤器[MyHttpRequestFilter](https://github.com/vinceDa/JavaCourseCodes/blob/main/02nio/nio02/src/main/java/io/github/kimmking/gateway/filter/MyHttpRequestFilter.java)、[MyHttpResponseFilter](https://github.com/vinceDa/JavaCourseCodes/blob/main/02nio/nio02/src/main/java/io/github/kimmking/gateway/filter/MyHttpResponseFilter.java)
   - 在[HttpInboundHandler](https://github.com/vinceDa/JavaCourseCodes/blob/main/02nio/nio02/src/main/java/io/github/kimmking/gateway/inbound/HttpInboundHandler.java)、[HttpOutboundHandler](https://github.com/vinceDa/JavaCourseCodes/blob/main/02nio/nio02/src/main/java/io/github/kimmking/gateway/outbound/httpclient4/HttpOutboundHandler.java)中分别调用自定义的过滤器实现相关功能

4. （可选）：实现路由

   后续补充