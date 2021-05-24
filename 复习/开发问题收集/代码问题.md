## 一、CPU占用高排查

1、寻找服务的进程号

​	ps -ef|grep 服务名

2、找出进程内占cpu较高的线程号

   top -Hp  进程号

3、线程号转16进制

​    printf "%x\n" 线程号

4、打印cpu高的线程号的堆栈

   jstack 进程号 | grep  线程号

5、根据堆栈找到占用cpu高的类及方法进行优化





## 二、OOM排查

1、jmap heap 进程号，打印jvm内存分配

2、jmap -histo:live 进程号 | more 打印存活对象的信息，并按照所占内存大小排序

3、设置了-XX:+HeapDumpOnOutOfMemoryError参数，当发生OOM后就会生成java_pid42868.hprof文件

4、使用 jmap -dump:format=b,file=/app/dump.hprod 1 也可以生成dump文件

5、使用eclipse mat工具分析文件



java heap space 按上面的方法排查，最常见

GC overhead limit exceeded  垃圾回收效果极差，98%的时间进行垃圾回收，而只得到2%可用的内存。

Permgen space 、 Metaspace：永久代、元空间内存不够，需要调整jvm参数

Unable to create new native thread：系统内存耗尽，不能分配新线程内存或创建线程数超过了系统限制

Out of swap space：虚拟交换区空间不足，调整jvm

Direct buffer memory：堆外内存不足， 一般是一些NIO操作出现内存泄露



