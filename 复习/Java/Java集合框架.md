#### 1、ArrayList和LinkedList的区别(并发安全？底层数据结构?适用场景？)

ArrayList基于数组，每次扩容1.5倍加一(右移一位加上原值). LinkedList基于双向链表，可当做Queue Deque Stack使用，不用Java提供的Stack

LinkedList实现Queue，尾部写add/offer 头部查element/peek 头部取poll/remove,一般使用offer peek poll,不会抛出异常,当做Stack时，有push pop peek



#### 2、ArrayList和Vector的区别（线程安全，扩容策略），为什么用ArrayList取代Vector?

Vector线程安全，方法都加了synchronized，每次扩容1倍

arrayList线程不安全，效率更高，每次扩1.5倍



#### 3、HashMap和HashTable的区别 (并发安全，存储null key和null value，初始容量和扩容，底层结构)

HashMap初始容量默认16，给定大小时会扩充为2的幂次方，扩容时每次2倍，底层使用数组链表，JDK1.8之后链表长度大于8时会转为红黑树存储提升搜索效率，可存储null key和value，线程不安全。扩容和初始化都为2的倍数因为了取模的时候方便计算

HashTable初始默认11，指定大小时直接使用指定大小，每次扩容为2n+1,底层数组链表没有红黑树优化，不能存储null key和value，方法基本都用synchronized修饰，单线程时需要在同步上耗时



#### 4、HashMap的底层实现，JDK1.8的优化，长度为什么是2的整数次幂？

底层使用数组链表，计算key的hash值后取模插入数组指定位置，每次插入链表的头部(为了避免遍历找尾)，1.8优化了链表长度大于8时采用红黑树存储，加快查询，长度为2的整数次幂是为了hash取模快速计算在数组中的位置 ，hash函数为 key==null?0:(h = key.hashCode()) ^ (h >>> 16);



#### 5、JDK1.7 HashMap多线程操作为什么就会导致死循环? JDK1.8呢？

两个线程put时同时触发了resize就可能会将链表构成环。因为一个线程构建好newTable后，另一个再transfer的时候用头插法，在数组的一个index上形成了循环链表。 这样get一个不存在的元素时，可能会在环状链表中一直循环无法结束。

1.8改为尾插法，避免了死循环，但还是不建议在并发中使用。



#### 6、ConcurrentHashMap和HashTable的区别，JDK1.7 1.8下的ConcurrentHashMap不同之处

ConcurrentHashMap 1.7采用分段锁Segment extents ReentrantLock,Segment数组中的每个Segment包含一个HashEntry数组存放数据，写时先通过key的hash定位到Segment，获取Segment的锁后再写入 ,读不需要加锁，很高效，但会有弱一致性问题

1.8 采用CAS和Synchorize对，插入数组位置没有元素时用CAS，失败则自旋保证成功，否则使用Synchronized对要插入数组位置的头结点Node对象加锁

改进原因：分段锁通过ReentrantLock实现，需要维护AQS队列消耗额外内存。Synchronized jvm内部支持，并进行了锁自旋等优化。



#### 7、LinkHashMap比HashMap多了什么功能，结构有什么不同？

LinkedHashMap的key可以按插入有序或者访问有序，结构上多增加了一个双向链表，用于存储插入顺序或者访问顺序，按访问有序时，新put的或者get的Entry，会调整到尾部。

linkedHashMap可以用来实现LRU缓存，它有一个removeEldestEntry()方法，默认实现是直接返回false，即不限制大小，我们可以继承linkedHashMap重写这个方法，改为返回size>maxEntries，这样当容量达到我们设置的限制时就会删除最近最久未被访问的键值对，即删除双向链表的头结点



#### 8、ArrayDeque实现原理？为什么插入删除比LinkedList实现的Deque还要快？两种Deque适用于什么情况？

ArrayDeque基于循环数组实现，初始化空间时和HashMap类似，也是2的次幂，为了方便计算tail(指向下个空位)，因此操作头尾节点很快，但操作中间的节点就不如LinkedList了。

LinkedList基于双向链表实现



#### 9、PriorityQueue原理，应用

原理：内部使用堆实现，元素存储不是完全有序，但逐个出队是能获得有序的结果(默认从小到大)，元素需要实现Comparable或者构造是传入Comparator

应用:求topK，求中值

