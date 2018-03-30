# Spittr（罐头）音乐网站
> 采用分布式应用架构，主要利用dubbo分布式服务框架、Spring MVC框架实现。
## 采用Maven多模块管理开发
> 主要模块分为：
* 通用模块 
* 专辑服务模块
* 歌单服务模块
* 歌手服务模块
* 单曲服务模块
* 用户服务模块
* Web调用服务模块

## 如何运行
以Linux或Mac Os操作系统为主：
> 前提条件：
* Jdk 1.8
* Tomcat 8
> 安装zookeeper（Download：http://www.apache.org/dyn/closer.cgi/zookeeper/）
> * `wget http://mirror.bit.edu.cn/apache/zookeeper/zookeeper-3.4.10/zookeeper-3.4.10.tar.gz`
> * `tar -zxvf zookeeper-3.4.10.tar.gz`
> * `cd zookeeper-3.4.10/bin`
> * `./zkServer.sh start` # 启动zookeeper

* 切换到该项目目录：`cd Dis-Arch-Spittr`
* `mvn package`

1、分别运行服务**提供者**：
* dubbox-Spittr-SingleMusic-core-Service-Povider-1.0-SNAPSHOT.jar
* dubbox-Spittr-Album-core-Service-Povider-1.0-SNAPSHOT.jar
* dubbox-Spittr-User-core-Service-Povider-1.0-SNAPSHOT.jar
* dubbox-Spittr-singer-core-Service-Povider-1.0-SNAPSHOT.jar
* ......
> e.g:
* `cd /dubbox-Spittr/dubbox-Spittr-Album/dubbox-Spittr-Album-core/target`
* `java -jar dubbox-Spittr-Album-core-Service-Povider-1.0-SNAPSHOT.jar`

2、运行服务**消费者**
* 运行**dubbox-Spittr-Web.war**即可。





