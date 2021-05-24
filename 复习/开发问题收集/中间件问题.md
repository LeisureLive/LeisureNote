

### 一、ES highLevelClient设置timeout无效。

原因：ES官方说这个参数是查询超过timeout是返回部分结果，但这个参数经常会不起作用

解法：

1、transportClinet 的prepareSearch可以设置超时时间，类似于java的异步任务，未处理完抛出异常

2、自己封装下highLevelClient的调用，放到异步线程池中调用，使用get(timeout)获取Future结果，超时会抛出异常



