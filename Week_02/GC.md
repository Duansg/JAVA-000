### 一、串行GC

##### 启动参数

java -XX:+UseSerialGC -Xms128m -Xmx128m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

#####  日志

```java
2020-10-28T15:33:48.934-0800: [GC (Allocation Failure) 2020-10-28T15:33:48.934-0800: [DefNew: 34526K->4352K(39296K), 0.0125657 secs] 34526K->13537K(126720K), 0.0126374 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T15:33:48.959-0800: [GC (Allocation Failure) 2020-10-28T15:33:48.959-0800: [DefNew: 39238K->4346K(39296K), 0.0089639 secs] 48424K->25190K(126720K), 0.0090274 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T15:33:48.979-0800: [GC (Allocation Failure) 2020-10-28T15:33:48.979-0800: [DefNew: 39290K->4349K(39296K), 0.0058759 secs] 60134K->35911K(126720K), 0.0059082 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T15:33:48.989-0800: [GC (Allocation Failure) 2020-10-28T15:33:48.989-0800: [DefNew: 39293K->4350K(39296K), 0.0073901 secs] 70855K->50354K(126720K), 0.0074213 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.004-0800: [GC (Allocation Failure) 2020-10-28T15:33:49.004-0800: [DefNew: 39085K->4351K(39296K), 0.0201256 secs] 85089K->61547K(126720K), 0.0201666 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2020-10-28T15:33:49.028-0800: [GC (Allocation Failure) 2020-10-28T15:33:49.028-0800: [DefNew: 39295K->4346K(39296K), 0.0060407 secs] 96491K->73397K(126720K), 0.0060705 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
2020-10-28T15:33:49.040-0800: [GC (Allocation Failure) 2020-10-28T15:33:49.040-0800: [DefNew: 38847K->4345K(39296K), 0.0086119 secs] 107898K->84742K(126720K), 0.0086770 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.053-0800: [GC (Allocation Failure) 2020-10-28T15:33:49.053-0800: [DefNew: 39289K->39289K(39296K), 0.0000286 secs]2020-10-28T15:33:49.053-0800: [Tenured: 80396K->87297K(87424K), 0.0150839 secs] 119686K->93002K(126720K), [Metaspace: 2700K->2700K(1056768K)], 0.0151542 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.074-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.074-0800: [Tenured: 87297K->87136K(87424K), 0.0123418 secs] 126501K->103510K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0123801 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.090-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.090-0800: [Tenured: 87136K->87359K(87424K), 0.0095021 secs] 126257K->109839K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0095447 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.102-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.102-0800: [Tenured: 87359K->86749K(87424K), 0.0144747 secs] 126516K->113391K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0145091 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.119-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.119-0800: [Tenured: 87188K->87188K(87424K), 0.0038525 secs] 126463K->117069K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0038871 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.126-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.126-0800: [Tenured: 87365K->87365K(87424K), 0.0032566 secs] 126660K->121034K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0032934 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.130-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.130-0800: [Tenured: 87365K->87365K(87424K), 0.0025651 secs] 126631K->122589K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0026003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.133-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.133-0800: [Tenured: 87365K->87121K(87424K), 0.0135699 secs] 126634K->119405K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0136027 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.148-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.148-0800: [Tenured: 87121K->87121K(87424K), 0.0017244 secs] 125973K->120888K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0017543 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.151-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.151-0800: [Tenured: 87121K->87121K(87424K), 0.0014659 secs] 126346K->123271K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0014938 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.153-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.153-0800: [Tenured: 87209K->87209K(87424K), 0.0018028 secs] 126503K->124769K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0018340 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.155-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.155-0800: [Tenured: 87335K->87177K(87424K), 0.0149930 secs] 126627K->123947K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0150296 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2020-10-28T15:33:49.170-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.170-0800: [Tenured: 87177K->87177K(87424K), 0.0019302 secs] 126258K->125342K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0019645 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.173-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.173-0800: [Tenured: 87285K->87285K(87424K), 0.0013794 secs] 126548K->125687K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0014063 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.175-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.175-0800: [Tenured: 87285K->87285K(87424K), 0.0017585 secs] 126420K->125791K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0017831 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.177-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.177-0800: [Tenured: 87285K->87214K(87424K), 0.0067822 secs] 126535K->124778K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0068126 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.184-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.184-0800: [Tenured: 87358K->87358K(87424K), 0.0016295 secs] 126579K->125338K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0016632 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.186-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.186-0800: [Tenured: 87358K->87358K(87424K), 0.0032125 secs] 126602K->125245K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0032425 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.190-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.190-0800: [Tenured: 87358K->87358K(87424K), 0.0017579 secs] 126410K->125373K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0017931 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.192-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.192-0800: [Tenured: 87358K->87347K(87424K), 0.0087833 secs] 126584K->124407K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0088194 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T15:33:49.201-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.201-0800: [Tenured: 87347K->87347K(87424K), 0.0026593 secs] 126528K->124726K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0026934 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.204-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.204-0800: [Tenured: 87347K->87347K(87424K), 0.0014836 secs] 126218K->125589K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0015089 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.206-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.206-0800: [Tenured: 87347K->87347K(87424K), 0.0012533 secs] 126618K->126451K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0012762 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.207-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.209-0800: [Tenured: 87347K->87323K(87424K), 0.0159902 secs] 126568K->125872K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0174733 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2020-10-28T15:33:49.225-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.225-0800: [Tenured: 87323K->87323K(87424K), 0.0029941 secs] 126195K->126195K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0030302 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T15:33:49.228-0800: [Full GC (Allocation Failure) 2020-10-28T15:33:49.228-0800: [Tenured: 87323K->87304K(87424K), 0.0110700 secs] 126195K->126176K(126720K), [Metaspace: 2701K->2701K(1056768K)], 0.0111026 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)
Heap
 def new generation   total 39296K, used 39018K [0x00000007b8000000, 0x00000007baaa0000, 0x00000007baaa0000)
  eden space 34944K, 100% used [0x00000007b8000000, 0x00000007ba220000, 0x00000007ba220000)
  from space 4352K,  93% used [0x00000007ba660000, 0x00000007baa5abb8, 0x00000007baaa0000)
  to   space 4352K,   0% used [0x00000007ba220000, 0x00000007ba220000, 0x00000007ba660000)
 tenured generation   total 87424K, used 87304K [0x00000007baaa0000, 0x00000007c0000000, 0x00000007c0000000)
   the space 87424K,  99% used [0x00000007baaa0000, 0x00000007bffe21d8, 0x00000007bffe2200, 0x00000007c0000000)
 Metaspace       used 2731K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
```

##### 解析

由上文日志可见，年轻代总大小为：39296K，年老代总大小为：87424K，堆大小为：126720K，一共发生了８次YGC，25次FGC。YGC耗时6ms-20ms不等，暂停时间10ms-20ms，在第8次YGC的时候，年轻代做了一次无效的YGC(DefNew: 39289K->39289K(39296K))，此时年轻代已没有可用空间，需要提前晋升到年老代，而年老代也没有了可用空间Tenured: 80396K->87297K(87424K)，则继续触发第1次FGC，可以看到FGC很频繁，有无效GC还有部分回收少量的对象，最后一次FGC(87323K->87304K(87424K)) 直到年老代无空间可用，继而发生了内存溢出，从下方的堆信息也能看出空间使用率，eden区高达100%，年老代99%。

### 二、并行GC

##### 启动参数

java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

##### 日志

````java
2020-10-28T23:09:11.073-0800: [GC (Allocation Failure) [PSYoungGen: 33280K->5118K(38400K)] 33280K->10855K(125952K), 0.0034140 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
2020-10-28T23:09:11.082-0800: [GC (Allocation Failure) [PSYoungGen: 37783K->5102K(38400K)] 43520K->23554K(125952K), 0.0108527 secs] [Times: user=0.02 sys=0.04, real=0.01 secs]
2020-10-28T23:09:11.101-0800: [GC (Allocation Failure) [PSYoungGen: 38382K->5104K(38400K)] 56834K->35320K(125952K), 0.0157343 secs] [Times: user=0.02 sys=0.02, real=0.01 secs]
2020-10-28T23:09:11.125-0800: [GC (Allocation Failure) [PSYoungGen: 38110K->5111K(38400K)] 68326K->46715K(125952K), 0.0046439 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
2020-10-28T23:09:11.134-0800: [GC (Allocation Failure) [PSYoungGen: 38331K->5105K(38400K)] 79935K->57751K(125952K), 0.0053140 secs] [Times: user=0.01 sys=0.02, real=0.01 secs]
2020-10-28T23:09:11.149-0800: [GC (Allocation Failure) [PSYoungGen: 38385K->5110K(19968K)] 91031K->70216K(107520K), 0.0079822 secs] [Times: user=0.01 sys=0.02, real=0.01 secs]
2020-10-28T23:09:11.159-0800: [GC (Allocation Failure) [PSYoungGen: 19958K->8623K(29184K)] 85064K->75356K(116736K), 0.0019416 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.164-0800: [GC (Allocation Failure) [PSYoungGen: 23242K->12408K(29184K)] 89975K->80187K(116736K), 0.0018847 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.169-0800: [GC (Allocation Failure) [PSYoungGen: 27233K->14310K(29184K)] 95012K->86164K(116736K), 0.0037762 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
2020-10-28T23:09:11.173-0800: [Full GC (Ergonomics) [PSYoungGen: 14310K->0K(29184K)] [ParOldGen: 71853K->77467K(87552K)] 86164K->77467K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0103150 secs] [Times: user=0.05 sys=0.01, real=0.01 secs]
2020-10-28T23:09:11.188-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->0K(29184K)] [ParOldGen: 77467K->82334K(87552K)] 92315K->82334K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0114221 secs] [Times: user=0.06 sys=0.01, real=0.01 secs]
2020-10-28T23:09:11.201-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->0K(29184K)] [ParOldGen: 82334K->87286K(87552K)] 97182K->87286K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0087810 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.212-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->4795K(29184K)] [ParOldGen: 87286K->87123K(87552K)] 102134K->91918K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0068692 secs] [Times: user=0.04 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.220-0800: [Full GC (Ergonomics) [PSYoungGen: 14559K->5785K(29184K)] [ParOldGen: 87123K->87472K(87552K)] 101682K->93258K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0077735 secs] [Times: user=0.06 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.229-0800: [Full GC (Ergonomics) [PSYoungGen: 14748K->9402K(29184K)] [ParOldGen: 87472K->86820K(87552K)] 102221K->96223K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0052446 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.234-0800: [Full GC (Ergonomics) [PSYoungGen: 14443K->11893K(29184K)] [ParOldGen: 86820K->86820K(87552K)] 101264K->98714K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0014590 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.236-0800: [Full GC (Ergonomics) [PSYoungGen: 14820K->12399K(29184K)] [ParOldGen: 86820K->86802K(87552K)] 101640K->99202K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0024965 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.239-0800: [Full GC (Ergonomics) [PSYoungGen: 14809K->12667K(29184K)] [ParOldGen: 86802K->86802K(87552K)] 101612K->99470K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013764 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.241-0800: [Full GC (Ergonomics) [PSYoungGen: 14751K->13816K(29184K)] [ParOldGen: 86802K->86802K(87552K)] 101554K->100619K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013846 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.242-0800: [Full GC (Ergonomics) [PSYoungGen: 14769K->13134K(29184K)] [ParOldGen: 86802K->87378K(87552K)] 101572K->100513K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0102108 secs] [Times: user=0.07 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.253-0800: [Full GC (Ergonomics) [PSYoungGen: 14319K->13406K(29184K)] [ParOldGen: 87378K->87140K(87552K)] 101698K->100546K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0056063 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.259-0800: [Full GC (Ergonomics) [PSYoungGen: 14799K->14498K(29184K)] [ParOldGen: 87140K->87122K(87552K)] 101939K->101621K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0041738 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.263-0800: [Full GC (Ergonomics) [PSYoungGen: 14776K->14498K(29184K)] [ParOldGen: 87122K->87122K(87552K)] 101899K->101621K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013816 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.264-0800: [Full GC (Ergonomics) [PSYoungGen: 14751K->13993K(29184K)] [ParOldGen: 87122K->87122K(87552K)] 101874K->101116K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0022657 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.267-0800: [Full GC (Ergonomics) [PSYoungGen: 14677K->14379K(29184K)] [ParOldGen: 87122K->87122K(87552K)] 101800K->101502K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013932 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.268-0800: [Full GC (Ergonomics) [PSYoungGen: 14574K->14091K(29184K)] [ParOldGen: 87122K->87122K(87552K)] 101697K->101214K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0012737 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.270-0800: [Full GC (Ergonomics) [PSYoungGen: 14554K->14091K(29184K)] [ParOldGen: 87122K->87122K(87552K)] 101677K->101214K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013000 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.271-0800: [Full GC (Ergonomics) [PSYoungGen: 14720K->13660K(29184K)] [ParOldGen: 87122K->87287K(87552K)] 101843K->100947K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0099552 secs] [Times: user=0.07 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.281-0800: [Full GC (Ergonomics) [PSYoungGen: 14837K->13707K(29184K)] [ParOldGen: 87287K->87287K(87552K)] 102124K->100995K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0015126 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.283-0800: [Full GC (Ergonomics) [PSYoungGen: 14461K->13671K(29184K)] [ParOldGen: 87287K->87287K(87552K)] 101748K->100959K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013375 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.285-0800: [Full GC (Ergonomics) [PSYoungGen: 14712K->13940K(29184K)] [ParOldGen: 87287K->87194K(87552K)] 102000K->101135K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0037656 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.289-0800: [Full GC (Ergonomics) [PSYoungGen: 14843K->13893K(29184K)] [ParOldGen: 87194K->87194K(87552K)] 102038K->101088K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013577 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T23:09:11.290-0800: [Full GC (Ergonomics) [PSYoungGen: 14782K->14363K(29184K)] [ParOldGen: 87194K->87137K(87552K)] 101977K->101500K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0033688 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.294-0800: [Full GC (Ergonomics) [PSYoungGen: 14754K->14652K(29184K)] [ParOldGen: 87137K->87137K(87552K)] 101891K->101789K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0014093 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.295-0800: [Full GC (Ergonomics) [PSYoungGen: 14652K->14652K(29184K)] [ParOldGen: 87333K->87333K(87552K)] 101985K->101985K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0013091 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T23:09:11.297-0800: [Full GC (Allocation Failure) [PSYoungGen: 14652K->14652K(29184K)] [ParOldGen: 87333K->87314K(87552K)] 101985K->101966K(116736K), [Metaspace: 2701K->2701K(1056768K)], 0.0064938 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
	at GCLogAnalysis.main(GCLogAnalysis.java:25)
Heap
 PSYoungGen      total 29184K, used 14848K [0x00000007bd580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 14848K, 100% used [0x00000007bd580000,0x00000007be400000,0x00000007be400000)
  from space 14336K, 0% used [0x00000007be400000,0x00000007be400000,0x00000007bf200000)
  to   space 14336K, 0% used [0x00000007bf200000,0x00000007bf200000,0x00000007c0000000)
 ParOldGen       total 87552K, used 87314K [0x00000007b8000000, 0x00000007bd580000, 0x00000007bd580000)
  object space 87552K, 99% used [0x00000007b8000000,0x00000007bd544878,0x00000007bd580000)
 Metaspace       used 2731K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
````

##### 解析

由上文日志可见，年轻代总大小为：29184K，年老代总大小为：87552K，堆大小为：116736K，一共发生了9次YGC，27次FGC。YGC耗时1ms-15ms不等，暂停时间0ms-10ms。FGC耗时1ms-15ms不等，暂停时间0ms-10ms。我们从第一次FGC ParOldGen: 71853K->77467K(87552K)，可以看出回收完成之后，可用内存并不多，直到最后一次FGC可以看出，87333K->87314K(87552K)，只回收了19K，回收前跟回收后的占比为：99%，可以看到年老代虽然已经回收但是剩下的可用空间已经很少了，程序运行下去，最终还是会不停的FGC，直到内存溢出。

### 三、CMS GC

##### 启动参数

java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

##### 日志

````java
2020-10-28T17:40:22.271-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.271-0800: [ParNew: 139776K->17472K(157248K), 0.0151714 secs] 139776K->39110K(506816K), 0.0152167 secs] [Times: user=0.03 sys=0.07, real=0.01 secs]
2020-10-28T17:40:22.316-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.316-0800: [ParNew: 157248K->17472K(157248K), 0.0200901 secs] 178886K->86320K(506816K), 0.0201273 secs] [Times: user=0.03 sys=0.09, real=0.02 secs]
2020-10-28T17:40:22.355-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.355-0800: [ParNew: 157248K->17467K(157248K), 0.0337719 secs] 226096K->133346K(506816K), 0.0338082 secs] [Times: user=0.23 sys=0.02, real=0.03 secs]
2020-10-28T17:40:22.406-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.406-0800: [ParNew: 157060K->17471K(157248K), 0.0301727 secs] 272939K->174653K(506816K), 0.0302060 secs] [Times: user=0.20 sys=0.02, real=0.03 secs]
2020-10-28T17:40:22.452-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.452-0800: [ParNew: 157247K->17469K(157248K), 0.0308984 secs] 314429K->219936K(506816K), 0.0309322 secs] [Times: user=0.21 sys=0.01, real=0.03 secs]
2020-10-28T17:40:22.483-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 202466K(349568K)] 222874K(506816K), 0.0002196 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.484-0800: [CMS-concurrent-mark-start]
2020-10-28T17:40:22.485-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
2020-10-28T17:40:22.485-0800: [CMS-concurrent-preclean-start]
2020-10-28T17:40:22.485-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.485-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T17:40:22.500-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.500-0800: [ParNew: 157245K->17471K(157248K), 0.0304107 secs] 359712K->269363K(506816K), 0.0304471 secs] [Times: user=0.21 sys=0.01, real=0.03 secs]
2020-10-28T17:40:22.551-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.551-0800: [ParNew: 157247K->17471K(157248K), 0.0259441 secs] 409139K->307237K(506816K), 0.0260018 secs] [Times: user=0.17 sys=0.02, real=0.02 secs]
2020-10-28T17:40:22.601-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.601-0800: [ParNew: 157247K->17470K(157248K), 0.0271041 secs] 447013K->354219K(506816K), 0.0271985 secs] [Times: user=0.17 sys=0.01, real=0.02 secs]
2020-10-28T17:40:22.628-0800: [CMS-concurrent-abortable-preclean: 0.004/0.142 secs] [Times: user=0.61 sys=0.04, real=0.14 secs]
2020-10-28T17:40:22.629-0800: [GC (CMS Final Remark) [YG occupancy: 20359 K (157248 K)]2020-10-28T17:40:22.629-0800: [Rescan (parallel) , 0.0028035 secs]2020-10-28T17:40:22.632-0800: [weak refs processing, 0.0000373 secs]2020-10-28T17:40:22.632-0800: [class unloading, 0.0004632 secs]2020-10-28T17:40:22.632-0800: [scrub symbol table, 0.0003753 secs]2020-10-28T17:40:22.632-0800: [scrub string table, 0.0001420 secs][1 CMS-remark: 336749K(349568K)] 357108K(506816K), 0.0039130 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T17:40:22.633-0800: [CMS-concurrent-sweep-start]
2020-10-28T17:40:22.634-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.634-0800: [CMS-concurrent-reset-start]
2020-10-28T17:40:22.634-0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.654-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.654-0800: [ParNew: 157246K->157246K(157248K), 0.0000173 secs]2020-10-28T17:40:22.654-0800: [CMS: 299879K->259182K(349568K), 0.0522069 secs] 457125K->259182K(506816K), [Metaspace: 2701K->2701K(1056768K)], 0.0522746 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-28T17:40:22.706-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 259182K(349568K)] 259706K(506816K), 0.0001625 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.707-0800: [CMS-concurrent-mark-start]
2020-10-28T17:40:22.708-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.708-0800: [CMS-concurrent-preclean-start]
2020-10-28T17:40:22.709-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.709-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T17:40:22.732-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.732-0800: [ParNew: 139776K->17467K(157248K), 0.0067570 secs] 398958K->307755K(506816K), 0.0068036 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.756-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.756-0800: [ParNew: 157243K->17470K(157248K), 0.0157361 secs] 447531K->351676K(506816K), 0.0157749 secs] [Times: user=0.10 sys=0.00, real=0.02 secs]
2020-10-28T17:40:22.772-0800: [CMS-concurrent-abortable-preclean: 0.002/0.063 secs] [Times: user=0.20 sys=0.00, real=0.07 secs]
2020-10-28T17:40:22.772-0800: [GC (CMS Final Remark) [YG occupancy: 17655 K (157248 K)]2020-10-28T17:40:22.772-0800: [Rescan (parallel) , 0.0010886 secs]2020-10-28T17:40:22.773-0800: [weak refs processing, 0.0000130 secs]2020-10-28T17:40:22.773-0800: [class unloading, 0.0002153 secs]2020-10-28T17:40:22.773-0800: [scrub symbol table, 0.0002947 secs]2020-10-28T17:40:22.774-0800: [scrub string table, 0.0001740 secs][1 CMS-remark: 334206K(349568K)] 351862K(506816K), 0.0018462 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.774-0800: [CMS-concurrent-sweep-start]
2020-10-28T17:40:22.775-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.775-0800: [CMS-concurrent-reset-start]
2020-10-28T17:40:22.775-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.790-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.790-0800: [ParNew: 157246K->157246K(157248K), 0.0000349 secs]2020-10-28T17:40:22.790-0800: [CMS: 334206K->301596K(349568K), 0.0651759 secs] 491452K->301596K(506816K), [Metaspace: 2701K->2701K(1056768K)], 0.0652650 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T17:40:22.856-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 301596K(349568K)] 302378K(506816K), 0.0001664 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.856-0800: [CMS-concurrent-mark-start]
2020-10-28T17:40:22.857-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.857-0800: [CMS-concurrent-preclean-start]
2020-10-28T17:40:22.858-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.858-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T17:40:22.881-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.881-0800: [ParNew: 139776K->17471K(157248K), 0.0068291 secs] 441372K->343912K(506816K), 0.0069078 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.889-0800: [CMS-concurrent-abortable-preclean: 0.001/0.031 secs] [Times: user=0.07 sys=0.00, real=0.03 secs]
2020-10-28T17:40:22.889-0800: [GC (CMS Final Remark) [YG occupancy: 23518 K (157248 K)]2020-10-28T17:40:22.889-0800: [Rescan (parallel) , 0.0003500 secs]2020-10-28T17:40:22.889-0800: [weak refs processing, 0.0000131 secs]2020-10-28T17:40:22.889-0800: [class unloading, 0.0002206 secs]2020-10-28T17:40:22.890-0800: [scrub symbol table, 0.0003753 secs]2020-10-28T17:40:22.890-0800: [scrub string table, 0.0001937 secs][1 CMS-remark: 326441K(349568K)] 349959K(506816K), 0.0012157 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T17:40:22.890-0800: [CMS-concurrent-sweep-start]
2020-10-28T17:40:22.891-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.891-0800: [CMS-concurrent-reset-start]
2020-10-28T17:40:22.891-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.912-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.912-0800: [ParNew: 157145K->157145K(157248K), 0.0000179 secs]2020-10-28T17:40:22.912-0800: [CMS: 325971K->324574K(349568K), 0.0513231 secs] 483116K->324574K(506816K), [Metaspace: 2701K->2701K(1056768K)], 0.0513955 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-28T17:40:22.963-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 324574K(349568K)] 324910K(506816K), 0.0002082 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.964-0800: [CMS-concurrent-mark-start]
2020-10-28T17:40:22.965-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.965-0800: [CMS-concurrent-preclean-start]
2020-10-28T17:40:22.966-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:22.966-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T17:40:22.990-0800: [GC (Allocation Failure) 2020-10-28T17:40:22.990-0800: [ParNew: 139776K->139776K(157248K), 0.0000215 secs]2020-10-28T17:40:22.990-0800: [CMS2020-10-28T17:40:22.990-0800: [CMS-concurrent-abortable-preclean: 0.001/0.025 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
 (concurrent mode failure): 324574K->332517K(349568K), 0.0505351 secs] 464350K->332517K(506816K), [Metaspace: 2701K->2701K(1056768K)], 0.0506117 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-28T17:40:23.064-0800: [GC (Allocation Failure) 2020-10-28T17:40:23.064-0800: [ParNew: 139776K->139776K(157248K), 0.0000222 secs]2020-10-28T17:40:23.064-0800: [CMS: 332517K->335860K(349568K), 0.0571355 secs] 472293K->335860K(506816K), [Metaspace: 2701K->2701K(1056768K)], 0.0572137 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T17:40:23.121-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 335860K(349568K)] 336079K(506816K), 0.0001809 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.121-0800: [CMS-concurrent-mark-start]
2020-10-28T17:40:23.123-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.123-0800: [CMS-concurrent-preclean-start]
2020-10-28T17:40:23.124-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.124-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T17:40:23.124-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.124-0800: [GC (CMS Final Remark) [YG occupancy: 15910 K (157248 K)]2020-10-28T17:40:23.124-0800: [Rescan (parallel) , 0.0011323 secs]2020-10-28T17:40:23.125-0800: [weak refs processing, 0.0000189 secs]2020-10-28T17:40:23.125-0800: [class unloading, 0.0002377 secs]2020-10-28T17:40:23.125-0800: [scrub symbol table, 0.0003889 secs]2020-10-28T17:40:23.126-0800: [scrub string table, 0.0002105 secs][1 CMS-remark: 335860K(349568K)] 351771K(506816K), 0.0020600 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.126-0800: [CMS-concurrent-sweep-start]
2020-10-28T17:40:23.126-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.127-0800: [CMS-concurrent-reset-start]
2020-10-28T17:40:23.127-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.150-0800: [GC (Allocation Failure) 2020-10-28T17:40:23.150-0800: [ParNew: 139776K->139776K(157248K), 0.0000236 secs]2020-10-28T17:40:23.150-0800: [CMS: 335387K->340570K(349568K), 0.0597635 secs] 475163K->340570K(506816K), [Metaspace: 2701K->2701K(1056768K)], 0.0598463 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T17:40:23.210-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 340570K(349568K)] 340714K(506816K), 0.0002707 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T17:40:23.210-0800: [CMS-concurrent-mark-start]
执行结束!共生成对象次数:8778
Heap
 par new generation   total 157248K, used 6005K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   4% used [0x00000007a0000000, 0x00000007a05dd5c8, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
  to   space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
 concurrent mark-sweep generation total 349568K, used 340570K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2707K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
````

##### 解析

由上文日志可见，在执行了5次YGC以后，CMS开始了第一个阶段初始化标记GC (CMS Initial Mark)，因为它没有含有concurrent的关键字，所以这个步骤是要STW的，但是它只用了不到1ms，因为它只标记了根对象所以是很快的。然后CMS进行了第二个阶段并发标记([CMS-concurrent-mark-start]-[CMS-concurrent-mark])，同样用了1ms，然后CMS进行了第三个阶段并发预清理([CMS-concurrent-preclean-start]-[CMS-concurrent-preclean: 0.000/0.000 secs])，CMS-concurrent-abortable-preclean为可终止的并发预清理，它很大程度的影响着下一个阶段的Final Remark的停顿，然后CMS进行了第四个阶段([GC (CMS Final Remark)])，它同样没有含有concurrent的关键字，所以这个步骤是要STW的，它暂停了用户线程10ms。然后CMS进行了第五个阶段并发清除([CMS-concurrent-sweep-start])，跟第六个阶段并发重置([CMS-concurrent-reset-start])。

##### 扩展（CMS Final Remark）

````java
2020-10-28T17:40:22.629-0800: [GC (CMS Final Remark) [YG occupancy: 20359 K (157248 K)]2020-10-28T17:40:22.629-0800: [Rescan (parallel) , 0.0028035 secs]2020-10-28T17:40:22.632-0800: [weak refs processing, 0.0000373 secs]2020-10-28T17:40:22.632-0800: [class unloading, 0.0004632 secs]2020-10-28T17:40:22.632-0800: [scrub symbol table, 0.0003753 secs]2020-10-28T17:40:22.632-0800: [scrub string table, 0.0001420 secs][1 CMS-remark: 336749K(349568K)] 357108K(506816K), 0.0039130 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
````

从上文第四个阶段(CMS Final Remark)我们可以看出，YG occupancy: 20359 K (157248 K) – 年轻代当前占用12%，[1 CMS-remark: 336749K(349568K)] 357108K(506816K), 0.0039130 secs]-年老代当前占用96%，清理完之后的堆大小为357108K，总大小为506816K，可以看出来年老代可用空间已经非常少了，后续肯定还会不停的GC，所以从日志可以看出，在执行完第六个阶段并发重置以后，CMS Initial Mark又开始了，直到最后一次的CMS，[1 CMS-remark: 335860K(349568K)] 351771K(506816K), 0.0020600 secs]年老代当前还占用96%，所以，程序运行下去，还是会不停的进行GC工作，直到内存溢出。

### 四、G1 GC

##### 启动参数

java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

##### YGC

````java
2020-10-28T21:44:04.040-0800: [GC pause (G1 Evacuation Pause) (young), 0.0213468 secs]
   [Parallel Time: 20.5 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 589.7, Avg: 589.8, Max: 589.9, Diff: 0.2]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.2, Diff: 0.2, Sum: 0.7]
      [Update RS (ms): Min: 0.2, Avg: 0.2, Max: 0.4, Diff: 0.2, Sum: 1.8]
         [Processed Buffers: Min: 0, Avg: 2.9, Max: 5, Diff: 5, Sum: 23]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.2]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 19.3, Avg: 19.6, Max: 20.0, Diff: 0.6, Sum: 156.5]
      [Termination (ms): Min: 0.0, Avg: 0.4, Max: 0.6, Diff: 0.6, Sum: 3.3]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 20.2, Avg: 20.3, Max: 20.4, Diff: 0.2, Sum: 162.5]
      [GC Worker End (ms): Min: 610.1, Avg: 610.1, Max: 610.2, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 0.7 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.1 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.2 ms]
      [Free CSet: 0.1 ms]
   [Eden: 234.0M(234.0M)->0.0B(378.0M) Survivors: 33.0M->34.0M Heap: 629.7M(1024.0M)->399.4M(1024.0M)]
 [Times: user=0.04 sys=0.09, real=0.02 secs]
````

- **Parallel Time**：并行收集任务在运行过程中引发的STW（Stop The World）时间，从新生代垃圾收集开始到最后一个任务结束，共花费20.5ms
- **GC Workers**：有8个线程负责垃圾收集，通过参数`-XX:ParallelGCThreads`设置，这个参数的值的设置，跟CPU有关，如果物理CPU支持的线程个数小于8，则最多设置为8；如果物理CPU支持的线程个数大于8，则默认值为number * 5/8

- **GC Worker Start**：第一个垃圾收集线程开始工作时JVM启动后经过的时间（min）；最后一个垃圾收集线程开始工作时JVM启动后经过的时间（max）；diff表示min和max之间的差值。理想情况下，你希望他们几乎是同时开始，即diff趋近于0。
- **Ext Root Scanning**：扫描root集合（线程栈、JNI、全局变量、系统表等等）花费的时间，扫描root集合是垃圾收集的起点，尝试找到是否有root集合中的节点指向当前的收集集合（CSet）
- **Update RS(Remembered Set or RSet)**：每个分区都有自己的RSet，用来记录其他分区指向当前分区的指针，如果RSet有更新，G1中会有一个post-write barrier管理跨分区的引用——新的被引用的card会被标记为dirty，并放入一个日志缓冲区，如果这个日志缓冲区满了会被加入到一个全局的缓冲区，在JVM运行的过程中还有线程在并发处理这个全局日志缓冲区的dirty card。**Update RS**表示允许垃圾收集线程处理本次垃圾收集开始前没有处理好的日志缓冲区，这可以确保当前分区的RSet是最新的。
  - **Processed Buffers**，这表示在Update RS这个过程中处理多少个日志缓冲区。

- **Scan RS**：扫描每个新生代分区的RSet，找出有多少指向当前分区的引用来自CSet。
- **Code Root Scanning**：扫描代码中的root节点（局部变量）花费的时间
- **Object Copy**：在疏散暂停期间，所有在CSet中的分区必须被转移疏散，Object Copy就负责将当前分区中存活的对象拷贝到新的分区。
- **Termination** ：当一个垃圾收集线程完成任务时，它就会进入一个临界区，并尝试帮助其他垃圾线程完成任务（steal outstanding tasks），min表示该垃圾收集线程什么时候尝试terminatie，max表示该垃圾收集回收线程什么时候真正terminated。
  - **Termination Attempts**：如果一个垃圾收集线程成功盗取了其他线程的任务，那么它会再次盗取更多的任务或再次尝试terminate，每次重新terminate的时候，这个数值就会增加。
- **GC Worker Other**：垃圾收集线程在完成其他任务的时间
- **GC Worker Total**：展示每个垃圾收集线程的最小、最大、平均、差值和总共时间。
- **GC Worker End**：min表示最早结束的垃圾收集线程结束时该JVM启动后的时间；max表示最晚结束的垃圾收集线程结束时该JVM启动后的时间。理想情况下，你希望它们快速结束，并且最好是同一时间结束。
- **Code Root Fixup** ：释放用于管理并行垃圾收集活动的数据结构，应该接近于0，该步骤是线性执行的；
- **Code Root Purge**：清理更多的数据结构，应该很快，耗时接近于0，也是线性执行。
- **Clear CT**：清理card table
- **Choose CSet**：选择要进行回收的分区放入CSet（G1选择的标准是垃圾最多的分区优先，也就是存活对象率最低的分区优先）
- **Ref Proc**：处理Java中的各种引用——soft、weak、final、phantom、JNI等等。
- **Ref Enq**：遍历所有的引用，将不能回收的放入pending列表
- **Redirty Card**：在回收过程中被修改的card将会被重置为dirty
- **Humongous Register**：JDK8u60提供了一个特性，巨型对象可以在新生代收集的时候被回收——通过`G1ReclaimDeadHumongousObjectsAtYoungGC`设置，默认为true。
- **Humongous Reclaim**：做下列任务的时间：确保巨型对象可以被回收、释放该巨型对象所占的分区，重置分区类型，并将分区还到free列表，并且更新空闲空间大小。
- **Free CSet**：将要释放的分区还回到free列表。

- **Eden: 234.0M(234.0M)->0.0B(378.0M)**：（1）当前新生代收集触发的原因是Eden空间满了，分配了234M，使用了234M；（2）所有的Eden分区都被疏散处理了，在新生代结束后Eden分区的使用大小成为了0.0B；（3）Eden分区的大小扩大为378.0M
- **Survivors: 33.0M->34.0M**：由于年轻代分区的回收处理，survivor的空间从33.0M涨到34.0M；
- **Heap: 629.7M(1024.0M)->399.4M(1024.0M)**：（1）在本次垃圾收集活动开始的时候，堆空间整体使用量是629.7M，堆空间的最大值是1024.0M；（2）在本次垃圾收集结束后，堆空间的使用量是399.4M，最大值是1024.0M。

##### 并发回收

````java
2020-10-28T21:44:04.093-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0085599 secs]
   [Parallel Time: 7.8 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 642.2, Avg: 642.2, Max: 642.3, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.9]
      [Update RS (ms): Min: 0.2, Avg: 0.2, Max: 0.4, Diff: 0.2, Sum: 1.7]
         [Processed Buffers: Min: 0, Avg: 3.0, Max: 4, Diff: 4, Sum: 24]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 6.7, Avg: 7.0, Max: 7.3, Diff: 0.6, Sum: 56.0]
      [Termination (ms): Min: 0.0, Avg: 0.3, Max: 0.6, Diff: 0.6, Sum: 2.5]
         [Termination Attempts: Min: 1, Avg: 1.4, Max: 4, Diff: 3, Sum: 11]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 7.6, Avg: 7.7, Max: 7.8, Diff: 0.2, Sum: 61.3]
      [GC Worker End (ms): Min: 649.9, Avg: 649.9, Max: 650.0, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 0.6 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.1 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.0 ms]
   [Eden: 155.0M(378.0M)->0.0B(323.0M) Survivors: 34.0M->42.0M Heap: 588.6M(1024.0M)->440.1M(1024.0M)]
 [Times: user=0.04 sys=0.01, real=0.01 secs]
2020-10-28T21:44:04.102-0800: [GC concurrent-root-region-scan-start]
2020-10-28T21:44:04.102-0800: [GC concurrent-root-region-scan-end, 0.0001741 secs]
2020-10-28T21:44:04.102-0800: [GC concurrent-mark-start]
2020-10-28T21:44:04.105-0800: [GC concurrent-mark-end, 0.0031039 secs]
2020-10-28T21:44:04.105-0800: [GC remark 2020-10-28T21:44:04.105-0800: [Finalize Marking, 0.0001171 secs] 2020-10-28T21:44:04.105-0800: [GC ref-proc, 0.0000463 secs] 2020-10-28T21:44:04.105-0800: [Unloading, 0.0006099 secs], 0.0013302 secs]
 [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T21:44:04.106-0800: [GC cleanup 457M->445M(1024M), 0.0009083 secs]
 [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T21:44:04.107-0800: [GC concurrent-cleanup-start]
2020-10-28T21:44:04.107-0800: [GC concurrent-cleanup-end, 0.0000239 secs]
````

- Humongous Allocation原因是大于G1中region大小50％的对象。
- **阶段 1: Initial Mark（初始标记）**：为了充分利用STW的机会来trace所有可达（存活）的对象，initial-mark阶段是作为新生代垃圾收集中的一部分存在的（搭便车）
- **阶段 2: Root Region Scan（分区扫描）**：根分区扫描开始，根分区扫描主要扫描的是新的survivor分区，找到这些分区内的对象指向当前分区的引用，如果发现有引用，则做个记录。
- **阶段 3: Concurrent Mark（并发标记）**：并发标记阶段开始。（1）并发标记阶段的线程是跟应用线程一起运行的，不会STW，所以称为并发；并发标记阶段的垃圾收集线程，默认值是Parallel Thread个数的25%，这个值也可以用参数`-XX:ConcGCThreads`设置；（2）trace整个堆，并使用位图标记所有存活的对象，因为在top TAMS之前的对象是隐式存活的，所以这里只需要标记出那些在top TAMS之后、阈值之前的；（3）记录在并发标记阶段的变更，G1这里使用了SATB算法，该算法要求在垃圾收集开始的时候给堆做一个快照，在垃圾收集过程中这个快照是不变的，但实际上肯定有些对象的引用会发生变化，这时候G1使用了pre-write barrier记录这种变更，并将这个记录存放在一个SATB缓冲区中，如果该缓冲区满了就会将它加入到一个全局的缓冲区，同时G1有一个线程在并行得处理这个全局缓冲区；（4）在并发标记过程中，会记录每个分区的存活对象占整个分区的大小的比率；
- **阶段 4: Remark（重新标记）**：会STW，会处理Finalizer列表里的对象、引用（soft、weak、final、phantom、JNI等等）处理、类卸载，这个阶段最重要的事情就是所有存活的对象都会被标记。
- **阶段 5: Cleanup（清理）**：并发清理阶段开始，完成第4阶段剩余的清理工作，将完全清理好的分区加入到二级free列表，等待最终还会到总体的free列表。

##### 混合回收

````java
2020-10-28T21:44:04.339-0800: [GC pause (G1 Evacuation Pause) (mixed), 0.0109243 secs]
   [Parallel Time: 9.7 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 888.0, Avg: 888.1, Max: 888.1, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.2, Diff: 0.1, Sum: 1.1]
      [Update RS (ms): Min: 0.2, Avg: 0.2, Max: 0.5, Diff: 0.3, Sum: 1.9]
         [Processed Buffers: Min: 0, Avg: 3.0, Max: 4, Diff: 4, Sum: 24]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.2]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 8.8, Avg: 8.8, Max: 9.0, Diff: 0.2, Sum: 70.8]
      [Termination (ms): Min: 0.0, Avg: 0.3, Max: 0.4, Diff: 0.4, Sum: 2.0]
         [Termination Attempts: Min: 1, Avg: 1.8, Max: 4, Diff: 3, Sum: 14]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 9.5, Avg: 9.5, Max: 9.6, Diff: 0.1, Sum: 76.2]
      [GC Worker End (ms): Min: 897.6, Avg: 897.6, Max: 897.7, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 1.2 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.8 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.1 ms]
   [Eden: 15.0M(15.0M)->0.0B(47.0M) Survivors: 36.0M->4096.0K Heap: 679.6M(1024.0M)->568.7M(1024.0M)]
 [Times: user=0.05 sys=0.02, real=0.02 secs]
````

该日志的大部分跟之前讨论的新生代收集相同，只有第1部分不一样：**GC pause(G1 Evacuation Pause)(mixed),0.0109243s**，这一行表示这是一个混合垃圾收集周期。在混合垃圾收集处理的CSet不仅包括新生代的分区，还包括老年代分区——也就是并发标记阶段标记出来的那些老年代分区。

##### FGC

````java
2020-10-28T22:13:55.719-0800: [Full GC (Allocation Failure)  100M->269K(128M), 0.0019496 secs]
   [Eden: 0.0B(6144.0K)->0.0B(76.0M) Survivors: 0.0B->0.0B Heap: 100.3M(128.0M)->269.7K(128.0M)], [Metaspace: 2701K->2701K(1056768K)]
 [Times: user=0.01 sys=0.00, real=0.01 secs]
````

如果堆内存空间不足以分配新的对象，或者是Metasapce空间使用率达到了设定的阈值，那么就会触发Full GC——你在使用G1的时候应该尽量避免这种情况发生，因为G1的Full Gc是单线程、会Stop The World，代价非常高。而我们需要注意的是

- **Full GC的原因** ：由上可见是Allocation Failure，还有一个常见的原因是Metadata GC Threshold。
- **Full GC发生的频率：**
- **Full GC的耗时** :由上可见Full GC耗时10ms。



