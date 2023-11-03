# heima_news

一新闻后端项目，包括app端，自媒体端和管理员端。app端用户可以浏览新闻并使用关键字搜索文章，自媒体端可以保存素材和发布文章，管理员可以对用户和文章进行管理。

下载到本地：
```cmd
git clone https://github.com/oeainsaotia/heima_news.git
```

使用以下开源框架：
* Glide 图片加载库 https://github.com/google/gson

* GSON Google提供的JSON与Java对象转换类库 https://github.com/bumptech/glide

* okhttp 网络框架 https://github.com/square/okhttp

以及少量Android自带组件，具体见build.gradle

## 进度条：75%
已做: 

1.环境搭载(Nacos,Minio,Redis,Kafka...)

2.项目基本模块(common,service,gateway...)

3.nacos注册微服务和配置中心

4.使用gateway网关进行权限校验,负载均衡

5.实现app端接口

6.实现自媒体端口

7.实现管理员端口

8.feign远程调用实现文章发布即审核

9.Kafka实现文章上下架通知

9.elasticsearch实现app搜索功能

10.mongodb实现历史信息查看

11.
