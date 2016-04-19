##0
Drools是一款基于Java的开源规则引擎.

6.4.0.Final

###Try the examples now

Download the [zip](http://download.jboss.org/drools/release/6.4.0.Final/drools-distribution-6.4.0.Final.zip) and unzip it

1.  On Linux/Mac, run examples/runExamples.sh 
2.  On Windows, run examples/runExamples.bat



###Get started

 1. Open the  [documentation](http://docs.jboss.org/drools/release/6.4.0.Final/drools-docs/html_single/index.html)
 2. Read the Quick Start chapter

##原理
首先要穿进去参数，其次要获取到接口的实现执行完毕后的结果，而drools也是一样的，我们需要传递进去数据，
在drools中，这个传递数据进去的对象，术语叫 Fact对象。Fact对象是一个普通的java bean，
规则中可以对当前的对象进行任何的读写操作，调用该对象提供的方法，当一个java bean插入到workingMemory中，
规则使用的是原有对象的引用，规则通过对fact对象的读写，实现对应用数据的读写，对于其中的属性，
需要提供getter setter访问器，规则中，可以动态的往当前workingMemory中插入删除新的fact对象。

Drools提供了一些监听器来获得规则引擎执行过程中发生的一些事件： 
WorkingMemoryEventListene，AgendEventListener和RuleFlowEventListener 

##summary
规则的编译与运行要通过Drools提供的各种API来实现，这些API总 体来讲可以分为三类：规则编译、规则收集和规则的执行.完成这些工作的API主要有KnowledgeBuilder、KnowledgeBase、StatefulKnowledgeSession、StatelessKnowledgeSession、、等，它们起到了对规则文件进行收集、编译、查错、插入fact、设置global、执行规则或规则流等作用

###KnowledgeBuilder

作用就是用来在业务代码当中收集已经编写好的规则，然后对这些规则文件进行编译，最终产生一批编译好的规则包（KnowledgePackage）给其它的应用程序使用。

###KnowledgeBase
Drools提供的用来收集应用当中知识（knowledge）定义的知识库对 象，在一个KnowledgeBase当中可以包含普通的规则（rule）、规则流(rule flow)、函数定义(function)、用户自定义对象（type model）等。KnowledgeBase本身不包含任何业务数据对象（fact对象，后面有相应章节着重介绍fact对象），业务对象都是插入到由KnowledgeBase产生的两种类型的session对象当中（StatefulKnowledgeSession和StatelessKnowledgeSession），通过session对象可以触发规则执行或开始一个规则流执行。 

###StatefulKnowledgeSession
规则编译完成之后，接下来就需要使用一个API使编译好的规则包文件在规则引擎当 中运行起来。在Drools5当中提供了两个对象与规则引擎进行交互：StatefulKnowledgeSession和StatelessKnowledgeSession

StatefulKnowledgeSession对象是一种最常用的与规则引擎进行交互的方式，它可以与规 则引擎建立一个持续的交互通道，在推理计算的过程当中可能会多次触发同一数据集。在用户的代码当中，最后使用完StatefulKnowledgeSession对象之后，一定要调用其dispose()

法以释放相关内存资源。   StatefulKnowledgeSession可以接受外部插入（insert）的业务数据——也叫fact，一个 fact对象通常是一个普通的Java的POJO，一般它们会有若干个属性，每一个属性都会对应getter和setter方法，用来对外提供数据的设置与访问。一般来说，在Drools规则引擎当中，fact所承担的作用就是将规则当中要用到的业务数据从应用当中传入进来，对于规则当中产生的数据及状态的变化通常不用fact传出。如果在规则当中需要有数据传出，那么可以通过在StatefulKnowledgeSession当中设置global对象来实现，一个global对象也是一个普通的Java对象，在向StatefulKnowledgeSession当中设置global对象时不用insert方法而用setGlobal方法实现。   创建一个StatefulKnowledgeSession要通过KnowledgeBase对象来实现，

###StatelessKnowledgeSession
作用与StatefulKnowledgeSession相仿，它们都是用来接收 业务数据、执行规则的。事实上，StatelessKnowledgeSession对StatefulKnowledgeSession做了包装，使得在使用StatelessKnowledgeSession对象时不需要再调用dispose()方法释放内存资源了。   因为StatelessKnowledgeSession本身所具有的一些特性，决定了它的使用有一定的局限 性。在使用StatelessKnowledgeSession时不能进行重复插入fact的操作、也不能重复的调用fireAllRules()方法来执行所有的规则，对应这些要完成的工作在StatelessKnowledgeSession当中只有execute(…)方法，通过这个方法可以实现插入所有的fact并且可以同时执行所有的规则或规则流，事实上也就是在执行execute(…)方法的时候就在StatelessKnowledgeSession内部执行了insert()方法、fireAllRules()方法和dispose()方法

##Fact对象
Fact是指在Drools规则应用当中，将一个普通的JavaBean插入到规则的WorkingMemory当中后的对象。规则可以对Fact对象进行任意的读写操作，当一个JavaBean插入到WorkingMemory当中变成Fact之后，Fact对象不是对原来的JavaBean对象进行Clon，而是原来JavaBean对象的引用。规则在进行计算的时候需要用到应用系统当中的数据，这些数据设置在Fact对象当中，然后将其插入到规则的WorkingMemory当中，这样在规则当中就可以通过对Fact对象数据的读写，从而实现对应用数据的读写操作。一个Fact对象通常是个具有getter和setter方法的POJO对象，通过这些getter和setter方法可以方便的实现对Fact对象的读写操作，所以我们可以简单的把Fact对象理解为规则与应用系统数据交互的桥梁或通道。

当Fact对象插入到WorkingMemory当中后，会与当前WorkingMemory当中所有的规则进行匹配，同时返回一个FactHandler对象。FactHandler对象是插入到WorkingMemory当中Fact对象的引用句柄，通过FactHandler对象可以实现对对应的Fact对象的删除及修改等操作


在前面介绍StatefulKnowledgeSession和StatelessKnowledgeSession两个对象的时候也提 到了插入Fact对象的方法，在StatefulKnowledgeSession当中直接使用insert方法就可以将一个Java对象插入到WokingMemory当中，如果有多个Fact需要插入，那么多个调用insert方法即可；对于StatelessKnowledgeSession对象可利用CommandFactory实现单个Fact对象或多个Fact对象的插入



-----------

##规则文件
规则文件可以使用 .drl文件，也可以是xml文件,在一个drl 文件中可以包含多个规则，函数等等。但是你也可以将规则分开到多个规则文件中（在这种情况下建议采用.rule 扩展名，但不是必需的），分散规则利于管理巨量规则的情况。

###package
对一个规则文件而言，package是必须定义的，必须放在规则文件第一行。
package的名字不必必须对应物理路径，跟java的package的概念不同，只是逻辑上的一种区分。
同样的package下定义的function和query等可以直接使用。

###import
导入规则文件需要使用到的外部变量，这里的使用方法跟java相同。

###rule
rule：定义一个规则。rule "ruleName"。一个规则可以包含三个部分：
  属性部分：定义当前规则执行的一些属性等，比如是否可被重复执行、过期时间、生效时间等。

  条件部分，即LHS，定义当前规则的条件，如  when Message(); 判断当前workingMemory中是否存在Message对象。

  结果部分，即RHS，这里可以写普通java代码，即当前规则条件满足后执行的操作，可以直接调用Fact对象的方法来操作应用。

####规则
一个标准规则的结构。
一个规则通常包括三个部分：属性部分（attribute）、条件 部分（LHS,Left Hand Side）和结果部分（RHS）。对于一个完整的规则来说，这三个部分都是可选的.

如果LHS部分没空的话，那么引擎会自动添加一个eval(true)的条件.
表面上看“,”与“&&”具有相同的含义，但是有一点需要注意，“，”与“&&”和“||” 不能混合使用，也就是说在有“&&”或“||”出现的LHS当中，是不可以有“，”.


<pre>
rule "name"
     attributes
     when
         LHS
     then
         RHS 
end 
</pre>


sample

<pre>
rule "name"
       no-loop true
       when
               $message:Message(status == 0)
       then
               System.out.println("fit");
               $message.setStatus(1);
               update($message);
end
</pre>

##rule属性说明
no-loop : 定义当前的规则是否不允许多次循环执行，默认是false
lock-on-active true：通过这个标签，可以控制当前的规则只会被执行一次
date-expires：设置规则的过期时间，默认的时间格式：“日-月-年”，中英文格式相同
date-effective：设置规则的生效时间，时间格式同上。
duration：规则定时，duration 3000   3秒后执行规则
salience：优先级，数值越大越先执行，这个可以控制规则的执行顺序。
其他的属性可以参照相关的api文档查看具体用法，此处略。

规则的条件部分，即LHS部分：
when：规则条件开始。条件可以单个，也可以多个，多个条件一次排列。
Drools提供了十二中类型比较操作符：
    \>  \>=  <  <=  ==  !=  contains / not contains / memberOf / not memberOf /matches/ not matches

规则的结果部分

当规则条件满足，则进入规则结果部分执行，结果部分可以是纯java代码，比如：

then
当然也可以调用Fact的方法，比如  $message.execute();操作数据库等等一切操作。

结果部分也有drools提供的方法：

insert：往当前workingMemory中插入一个新的Fact对象，会触发规则的再次执行，除非使用no-loop限定；

update：更新

modify：修改，与update语法不同，结果都是更新操作

retract：删除

RHS部分除了调用Drools提供的api和Fact对象的方法，也可以调用规则文件中定义的方法，方法的定义使用 


##function 关键字

Drools还有一个可以定义类的关键字：

declare 可以再规则文件中定义一个class，使用起来跟普通java对象相似，你可以在RHS部分中new一个并且使用getter和setter方法去操作其属性。

declare Address
 @author(quzishen) // 元数据，仅用于描述信息

 @createTime(2011-1-24)
 city : String @maxLengh(100)
 postno : int
end

上述的'@'是什么呢？是元数据定义，用于描述数据的数据~，没什么执行含义

你可以在RHS部分中使用Address address = new Address()的方法来定义一个对象。


##参考链接
[1](http://wenku.baidu.com/view/a6516373f242336c1eb95e7c.html)
[2](http://blog.csdn.net/quzishen/article/details/6163012)


