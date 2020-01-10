# Netty

官网是这样介绍[Netty](https://netty.io/ "Netty官网")的：

>Netty is an asynchronous event-driven network application framework 
for rapid development of maintainable high performance protocol servers & clients.

可以看出其是一个异步的事件驱动的网络应用框架，可用来快速开发可维护的高性能的面向协议的服务器和客户端。

###网络编程的进化

早期的网络编程是基于复杂的C语言套接字库的。Java早期在*java.net*中提供了封装本地套接字库的阻塞函数，
从JDK1.4开始又在*java.nio*中提供了对非阻塞I/O的支持。直接使用Java API在高并发等复杂场景下
仍旧繁琐且容易出错，而Netty就是为快速开发可维护的高性能的网络应用而生的。

###ByteBuf