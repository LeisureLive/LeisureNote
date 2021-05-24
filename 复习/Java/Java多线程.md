#### 1、什么是进程，什么是线程，进程与线程之间的关系，优缺点。

进程可认为是程序一次执行的过程，是拥有资源拥有的基本单位，线程是比进程更小的执行单位，是进程中的一个执行流程，CPU调度的基本单位。

进程之间相互独立，数据共享只能通过内核实现，开销大，但一个进程挂了不会影响另一个进程。一个进程的多个线程除了自己独有的寄存器和栈，数据和堆内存是可以共享的，切换开销小，对于web服务每个请求一个线程处理可以简化模型。



#### 2、进程怎么调度的，线程和进程同时存在的时候呢？

进程调度根据进程的类型(交互式、批处理、实时)来选择不同的调度算法。

线程的调度，取决于支持的是内核级线程还是用户级线程。

对于用户级线程，内核不知道线程的存在，就给了进程很大的自主权。内核只是调度进程，进程中的调度程序选择哪个线程来运行。

对于内核级线程，线程的调度就交给了系统完成



#### 3、进程通信⽅式，线程通信方式

进程通信，目的是交换数据

管道/有名管道、信号、消息队列、共享内存、信号量、套接字

管道是半双工通信方式，数据同一时间只能单向流动，需要有亲缘关系的进程间才能通信

有名管道也是半双工，但可以让没有亲缘关系的进程通信

线程通信一般是为了同步，没有用于交换数据的通信机制

1）锁机制包含互斥锁 条件变量 读写锁

2）信号量



#### 4、程序计数器为什么私有，虚拟机栈和本地方法栈呢

计数器私有是为了线程切换后能恢复正确的位置，栈私有是为了线程中局部变量不被别的线程访问到



#### 5、线程的生命周期和状态，对中断怎么响应，wait和sleep的区别

1）NEW,RUNNABLE,TERMINAL,BLOCK,WAIT,TIME-WATTING。

  Block标识在等待锁进入同步块

  WAIT,TIME-WATTING 标识线程在等待某个条件或超时：调用sleep join wait(seconds)

2）interrupt：对NEW/TERMINAL无效果，对RUNNABLE只是设置标志位，对于BLOCK设置标志位，需要获取锁才能响应中断，对WATING/TIME-WAITING抛出异常，清空标志位

3）wait和sleep都可以暂停线程运行，让出cpu。前者用于线程间交互，需要其他线程调用同一个对象调用notify才可能被唤醒，sleep用于暂停线程，可以指定一段时间后自动苏醒，wait释放锁，sleep不释放

4）threadA.join() 实质上就是调用wait(0)，方法被synchronized修饰，调用的线程进入阻塞状态，直到A线程结束才调用notify释放锁



#### 6、synchronized的作用，加到实例方法、静态方法、代码块上有什么不同，HashTable这类方法上加了synchronized的容器还有什么问题？wait和notify作用

作用:解决竞态条件(非原子操作能像原子操作以样不受其他线程干扰)，保证内存可见性

特点：可重入、内存可见、同步阻塞，可能死锁

实例方法锁的是实例对象，静态方法锁的是类对象(作用于所有实例),代码块需要指定锁的目标

synchronized容器的问题:复合操作先get在set不安全，一个线程迭代一个线程遍历会抛异常

协作:通过synchronized块中才能使用wait/notify，可以是两个线程分别打印奇偶数等



#### 7、CAS的基本类型，原理，FiledUpdater原理

AtomicInteger、AtomicBoolean、AtomicLong、AtomicReference、AtomicIntegerArray、AtomicLongArray、AtomicReferenceArray

原理是乐观锁，比较后更新CompareAndSet，对于ABA问题可以使用AtomicStampedReference

FiledUpdater不需要对象中字段声明为atomic，使用反射更新对象中的字段。



#### 8、volatile和synchronize的区别，显式锁和synchronized的区别

- **volatile关键字**是线程同步的**轻量级实现**，所以**volatile性能肯定比synchronized关键字要好**。但是**volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块**。synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，**实际开发中使用 synchronized 关键字的场景还是更多一些**。

- **多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞**

- **volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证。**

- **volatile关键字主要用于解决变量在多个线程之间的可见性，而 synchronized关键字解决的是多个线程之间访问资源的同步性。**

- Volatile 和 synchronized 都可以禁止指令重排序

  

显式锁和synchronized：都可重入 保证内存可见性 解决竟态条件

显式锁支持非阻塞(tryLock失败不等待，直接返回false，避免死锁)，可以公平调度，可以响应中断(synchronized等待的线程需要获取到锁才能响应中断)，可以限时、避免死锁(tryLock加超时)，可以绑定多个条件。

性能上，1.6之后对synchronized做了jvm上的优化，性能不在是选择的瓶颈.



#### 9、ReenTrantLock原理，Condition原理

ReentrantLock依赖CAS(获取锁时)，等待时使用LockSupport.park,等待队列基于AQS(保存当前获取锁的线程/锁的数量和一个等待队列)

Condition创建时实际新建一个ConditionObject，是AQS的内部类，内部也有一个队列表示条件等待队列，可以直接访问AQS的锁等待队列。条件等待队列满足或者超时后会放到锁等待队列中。


#### 10、自旋锁、偏向锁、重量级锁、轻量级锁

自旋锁：当CAS失败是不阻塞，而是循环再次尝试获取锁，即让CPU做一点无用功而不是切换到其他线程(切换会在用户态切到内核态时将线程的局部变量表，寄存器等值传给内核保存起来，再切到其他线程的用户态，消耗CPU处理时间)，当超过等待时间还没有获取到锁就停止自旋进入阻塞状态，1.6开始默认开启，JDK1.7后由JVM控制。

**锁主要存在四种状态**，依次是：无锁状态、偏向锁状态、轻量级锁状态、重量级锁状态，他们会随着竞争的激烈而逐渐升级。注意锁可以升级不可降级，这种策略是为了提高获得锁和释放锁的效率。锁对象的头部有一个markWork，不同量级的锁内容不同。

偏向锁，偏向于第一个访问锁的线程，如果在运行过程中，同步锁只有一个线程访问，不存在多线程争用的情况，则线程是不需要触发同步的，在无竞争环境下，把整个同步都消除，CAS也不做。这种情况下，就会给线程加一个偏向锁。运行过程中，遇到了其他线程抢占锁，则持有偏向锁的线程会被挂起，JVM会消除它身上的偏向锁，将锁恢复到标准的轻量级锁。适用于始终只有一个线程执行同步块

重量级锁 即获取到锁的线程才能执行同步块，没有获取到的线程阻塞

轻量级锁 在无竞争的情况下使用CAS操作去消除同步使用的互斥量



#### 11、ThreadLocal原理，存在的问题

TheadLocal使用的是Thread类中的内部类ThreadLocalMap,每个线程维护了自己的ThreadLocalMap, key为荣引用类型的ThreadLocal,值为对应的value。

问题：垃圾回收时很快回收了弱引用的key，但value没被回收，可能内存泄露。考虑到这种情况，ThreadLocalMap在set get remove方法中会清理key为null的entry

threadLocal配合线程池使用时不及时清理，会保留到下个执行任务，带来错误



#### 12、线程池的参数含义，为什么不建议使用默认的Executors，参数该如何配置

1、需要关注corePoolSize maxPoolSize workerQueue handler

2、cachedThreadPool, 无界队列+ Integer.MAX_VALUE的核心线程数，没有空闲线程就无限创建

​    singleThreadPool，核心和最大线程数为1，只能串行

​    fixedThreadPool, 无界队列 + 固定核心线程数，适用于限流

3、对于IO密集型的可以设置核心线程为2*CPU，也可以根据流量tps 乘以 可容忍最大延时。

最好的做法是将线程池参数配置在apollo，监听到修改后动态调整线程池参数。

4、线程池初始创建时没有核心线程，可以调用preStartCoreThread创建一个核心线程进行预热