 Springmvc的执行流程:
	1.用户向服务器发送请求,前端进行Servlet的拦截,进入DispatchServlet
	  核心控制器捕获请求

	2.DispatchServlet对URL进行解析,获取URI,然后根据URI调用HandlerMapping,
	  获取Handler的配置的所有相关的对象,最后以HandlerExecutionChain对象的形式进行返回.

	3.根据获取的Handler,选择一个合适的HandlerAdapter,提取Request中的模型,填充Handler的参数,
	  开始执行Controller,执行完后向DispatchServlet返回一个ModelAndView对象.

	4.根据返回的ModelAndView选择一个合适的ViewReslover.

	5.通过ViewResolver结合Model和View,来渲染视图,DispaServlet将渲染视图的结果返回客户端

spring的事务传播特性:
	1.propaGation-Required:如果有事务就执行当前的事务,如果没有事务就开启一个新的事务

	2.supports:如果存在一个事务,执行当前的事务,如果不存在事务就是非事务的执行

	3.mandatory:如果存在事务就执行当前的事务,如果不存在则跑出异常

	4.Required-new:总是开启一个新的事务,如果存在事务,则将这个事务挂起

	5.not-supports:总是非事务的执行,如果存在事,将挂起所有存在的事务

	6.never:总是非事务的执行,如果有存活的事务,则抛出一个异常

	7.NeSted:如果有事务.就嵌套当前的事务,如果没有就开启一个新的事务

redis的缓存击穿是什么?
    1.在大量访问数据的时候发现redis中的数据部分过期,则需要重新去DB中访问数据,给DB造成不小的压力,可能导致数据瘫痪.

redis的缓存穿透是什么?
    1.在访问数据的时候,发现redis中的KEY不存在,数据库中的数据也不存在,两边都为nuLl

事务的隔离级别:
	1.Read-UnCommit:在一个事务中修改了某条数据,而未提交,查询出是以前的数据

	2.Read Connmit:在一个事务中修改了某条数据,并且提交这个事务

	3.Repeatable-read:一个事务中满足搜索条件的一些行,而另一个事务又插入一条数据又符合了事务一搜索条件的一个新行
	  ,事务一在执行原来的那些行在查询时可能会造成幻读[两次得到不同的行].

线程的实现方式:
	1.继承Thread类
		public class test{
			public static void main(String[] args ){
				Mythread thread = new MyThread();
				thread.start();//开启线程
			}
		}

    class MyThread  extends Thread{
		@Override
			public void run(){
			for(i=0;i<10;i++){
			System.out.println(Thread.currentThread()＋　"-->" + i );
			}
		}
    }


	2.实现Runnable接口
public class test{
			public static void main(String[] args ){
				Thread thread = new Thread(new Task());
				thread.start();//开启线程
			}
		}

class Task implements Runnble{
	@Override
		public void run(){
	for(i=0;i<10;i++){
			System.out.println(Thread.currentThread()＋　"-->" + i );
	}
}


使用继承Thread类和实现Runnable接口的关系和区别：

Thread类本身也是实现了Runnable接口
因此也是实现了Runnable接口中的run方法。
当使用继承Thread类去实现线程时，
我们需要重写run方法，因为Thread类中的run方法本身什么事情都不干
当使用实现Runnable接口去实现线程时，我们需要重写run方法，
然后使用new Thread(Runnable)这种方式来生成线程对象，
这个时候线程对象中的run方法才会去执行我们自己实现的Runnable接口中的run方法。


抽象和接口的区别
	          接口                             抽象类
多继承        支持                              不支持[只支持单继承]
类型限制      没有                              有
方法实现      继承类型中必须给出方法实现        继承类中可以不给出
扩展性        比较麻烦                          相对来说比较灵活
多层继承      比较麻烦,需要借助虚函数           比较灵活    

抽象类:抽象类是特殊类,但是不能被实例化,抽象类可以包括抽象方法,这是普通类不能的
	   抽象方法只能在声明于抽象类中,不包含任何实现.派生类必须覆盖它们。
	   另外，抽象类可以派生自一个抽象类，可以覆盖基类的抽象方法也可以不覆盖，如果不覆盖
	   ，则其派生类必须覆盖它们。

接口:  接口是引用类型的,类似于类,和抽象类的相似之处有三点
	   1.不能被实例化
	   2.包含未实现的方法的声明
	   3.派生类必须实现未实现的方法，抽象类是抽象方法，接口则是所有成员
	    （不仅是方法包括其他成员）；


我公司在杭州汇捷科技有限公司
	最近做的一个项目是客户管理系统 ,基于saas系统开发.这是华科科技有限公司委托我公司开发,
	该公司希望通过这个软件完成客户基本信息,联系人信息 交往信息 客户服务信息的充分共享和
	规范化处理,客户开发过程追踪和记录提高一些新客户的开发.


	newCachedThreadpool 创建一个缓存的线程池,如果线程池长度超过处理需要,灵活
		                的可以操作回守线程,如果不能回首则新创建一个
	newFiledthreadpool 线程池 创建一个长线线程池,可控制线程最大的线程并发数
		                       超出的线程会进行等待
	newScheduleuledThreadPool 创建一个定长线程池,支持定时及周期性任务执行
	
	newSingleThreadExcutorpool 创建一个单线程化的线程池,它会唯一的工作线程池来执行任务
		                       保证所有的任务按照指定的顺序(fifo lifo 优先级执行)

````线程池的作用 :节约资源 不需要每次去创建或者销毁
	              定义线程个数,不会导致由于多线程过多导致系统运行缓慢来崩溃
				  响应时间更快

懒汉代码

public class Singleton
{
    // 私有的、静态的成员保存唯一的实例
    private static Singleton inst;
    // 私有构造器，避免被别人创建实例
    private Singleton(){}
    // 提供一个公共的、静态的方法，获取唯一的实例
    public static Singleton getInstance()
    {
        // 很多示例代码都是在方法上加同步，但是基于“最小范围原则”，应该要用同步代码块
        // 这样可以尽可能提升程序的并发性能
        synchronized( Singleton.class )
        {
            // 判断inst是否为null，如果是null则新建一个
            if( inst == null )
            {
                inst = new Singleton();
            }
        }
        return inst;
    }
}


饿汉代码
public class Singleton
{
    // 私有的、静态的成员保存唯一的实例
    // 在类被第一次使用的时候，就已经完成了加载。类的加载过程，系统保证线程安全。
    private static Singleton inst = new Singleton();
    // 私有构造器，避免被别人创建实例
    private Singleton(){}

    // 提供一个公共的、静态的方法，获取唯一的实例
    public static Singleton getInstance()
    {
		
        return inst;
    }
}

servlet声明周期:  Servlet生命周期开始,加载Servlet的class文件,去进行初始化
	              响应请求(Service中的方法),销毁的时候去调用distory方法,生命结束


page pageContext config request application excation out reponse session 


public static void main (String[] args){

	private static Singleton inst;

	private Singleton(){}

 public  static Singleton getInstance(){
   
  syncharnized (Singleton.class){
  
  if(!inst==null){
    inst = new Singleton();
  }
  
  }
  return inst;
 } 
}


数据库的存储过程,在数据类库中,经过一次编译后在次调用就不会在次编译,
	用户通过之指定的存储过程中的名字并给出参数来执行,存储过程时数据库的
	一个重要对象,存储过程中可以包含逻辑控制语句和数据操纵语句,可以接受参数
	输出参数,返回单个或者多个结果集以及返回值.


Springmvc的执行流程:
	1.用户发送请求,前端Servlet进行拦截,进入DispatchServlet进行捕获请求
	2.DispatchServlet进行对请求的URl解析,获取URI资源定位符
	  然后根据URI获取Handler的所有配置相关信息,最后的到HandlerExecutionChain
	3.根据获取的Handler,选择一个合适的HandlerAapater提取Request中的模型
	  开始执行,向DispatchServlet返回一个ModelandView
	4.根据获取的modelandView选择一个合适的ViewResolver
	5.通过ViewResolver结合model和view来渲染视图返回给前端


java8的新特性

lambda是一个简单 可传递的匿名函数
	   本质上是一个函数,但不属于一个特定的类
	   表达式可以象参数一样进行传递 从而简化代码的编写
optiona可以有效的判断是否为空 解决控制针异常
	数组并行parallel操作


ThreadLocal一般称为线程本地变量,是一种特殊的线程绑定机制,
	        将变量与线程绑定在一起,为,每维护一个独立的变量
	副本.通过ThreadLoca可以将对象可见范围限制在同一个线程内
	

线程问题 
Spring是什么
redis缓存
elasticearch


冒泡排序
	public class Sort {
    public static void main(String[] args){
        int[] arr = {6,3,2,1,7};
        for(int i = 0;i<arr.length-1;i++){//外层循环n-1
            for(int j = 0;j<arr.length-i-1;j++){//内层循环n-i-1
                if(arr[j]>arr[j+1]){//从第一个开始，往后两两比较大小，如果前面的比后面的大，交换位置
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
