 Springmvc��ִ������:
	1.�û����������������,ǰ�˽���Servlet������,����DispatchServlet
	  ���Ŀ�������������

	2.DispatchServlet��URL���н���,��ȡURI,Ȼ�����URI����HandlerMapping,
	  ��ȡHandler�����õ�������صĶ���,�����HandlerExecutionChain�������ʽ���з���.

	3.���ݻ�ȡ��Handler,ѡ��һ�����ʵ�HandlerAdapter,��ȡRequest�е�ģ��,���Handler�Ĳ���,
	  ��ʼִ��Controller,ִ�������DispatchServlet����һ��ModelAndView����.

	4.���ݷ��ص�ModelAndViewѡ��һ�����ʵ�ViewReslover.

	5.ͨ��ViewResolver���Model��View,����Ⱦ��ͼ,DispaServlet����Ⱦ��ͼ�Ľ�����ؿͻ���

spring�����񴫲�����:
	1.propaGation-Required:����������ִ�е�ǰ������,���û������Ϳ���һ���µ�����

	2.supports:�������һ������,ִ�е�ǰ������,���������������Ƿ������ִ��

	3.mandatory:������������ִ�е�ǰ������,������������ܳ��쳣

	4.Required-new:���ǿ���һ���µ�����,�����������,������������

	5.not-supports:���Ƿ������ִ��,���������,���������д��ڵ�����

	6.never:���Ƿ������ִ��,����д�������,���׳�һ���쳣

	7.NeSted:���������.��Ƕ�׵�ǰ������,���û�оͿ���һ���µ�����

redis�Ļ��������ʲô?
    1.�ڴ����������ݵ�ʱ����redis�е����ݲ��ֹ���,����Ҫ����ȥDB�з�������,��DB��ɲ�С��ѹ��,���ܵ�������̱��.

redis�Ļ��洩͸��ʲô?
    1.�ڷ������ݵ�ʱ��,����redis�е�KEY������,���ݿ��е�����Ҳ������,���߶�ΪnuLl

����ĸ��뼶��:
	1.Read-UnCommit:��һ���������޸���ĳ������,��δ�ύ,��ѯ������ǰ������

	2.Read Connmit:��һ���������޸���ĳ������,�����ύ�������

	3.Repeatable-read:һ����������������������һЩ��,����һ�������ֲ���һ�������ַ���������һ����������һ������
	  ,����һ��ִ��ԭ������Щ���ڲ�ѯʱ���ܻ���ɻö�[���εõ���ͬ����].

�̵߳�ʵ�ַ�ʽ:
	1.�̳�Thread��
		public class test{
			public static void main(String[] args ){
				Mythread thread = new MyThread();
				thread.start();//�����߳�
			}
		}

    class MyThread  extends Thread{
		@Override
			public void run(){
			for(i=0;i<10;i++){
			System.out.println(Thread.currentThread()����"-->" + i );
			}
		}
    }


	2.ʵ��Runnable�ӿ�
public class test{
			public static void main(String[] args ){
				Thread thread = new Thread(new Task());
				thread.start();//�����߳�
			}
		}

class Task implements Runnble{
	@Override
		public void run(){
	for(i=0;i<10;i++){
			System.out.println(Thread.currentThread()����"-->" + i );
	}
}


ʹ�ü̳�Thread���ʵ��Runnable�ӿڵĹ�ϵ������

Thread�౾��Ҳ��ʵ����Runnable�ӿ�
���Ҳ��ʵ����Runnable�ӿ��е�run������
��ʹ�ü̳�Thread��ȥʵ���߳�ʱ��
������Ҫ��дrun��������ΪThread���е�run��������ʲô���鶼����
��ʹ��ʵ��Runnable�ӿ�ȥʵ���߳�ʱ��������Ҫ��дrun������
Ȼ��ʹ��new Thread(Runnable)���ַ�ʽ�������̶߳���
���ʱ���̶߳����е�run�����Ż�ȥִ�������Լ�ʵ�ֵ�Runnable�ӿ��е�run������


����ͽӿڵ�����
	          �ӿ�                             ������
��̳�        ֧��                              ��֧��[ֻ֧�ֵ��̳�]
��������      û��                              ��
����ʵ��      �̳������б����������ʵ��        �̳����п��Բ�����
��չ��        �Ƚ��鷳                          �����˵�Ƚ����
���̳�      �Ƚ��鷳,��Ҫ�����麯��           �Ƚ����    

������:��������������,���ǲ��ܱ�ʵ����,��������԰������󷽷�,������ͨ�಻�ܵ�
	   ���󷽷�ֻ���������ڳ�������,�������κ�ʵ��.��������븲�����ǡ�
	   ���⣬���������������һ�������࣬���Ը��ǻ���ĳ��󷽷�Ҳ���Բ����ǣ����������
	   ��������������븲�����ǡ�

�ӿ�:  �ӿ����������͵�,��������,�ͳ����������֮��������
	   1.���ܱ�ʵ����
	   2.����δʵ�ֵķ���������
	   3.���������ʵ��δʵ�ֵķ������������ǳ��󷽷����ӿ��������г�Ա
	    �������Ƿ�������������Ա����


�ҹ�˾�ں��ݻ�ݿƼ����޹�˾
	�������һ����Ŀ�ǿͻ�����ϵͳ ,����saasϵͳ����.���ǻ��ƿƼ����޹�˾ί���ҹ�˾����,
	�ù�˾ϣ��ͨ����������ɿͻ�������Ϣ,��ϵ����Ϣ ������Ϣ �ͻ�������Ϣ�ĳ�ֹ����
	�淶������,�ͻ���������׷�ٺͼ�¼���һЩ�¿ͻ��Ŀ���.


	newCachedThreadpool ����һ��������̳߳�,����̳߳س��ȳ���������Ҫ,���
		                �Ŀ��Բ��������߳�,������ܻ������´���һ��
	newFiledthreadpool �̳߳� ����һ�������̳߳�,�ɿ����߳������̲߳�����
		                       �������̻߳���еȴ�
	newScheduleuledThreadPool ����һ�������̳߳�,֧�ֶ�ʱ������������ִ��
	
	newSingleThreadExcutorpool ����һ�����̻߳����̳߳�,����Ψһ�Ĺ����̳߳���ִ������
		                       ��֤���е�������ָ����˳��(fifo lifo ���ȼ�ִ��)

````�̳߳ص����� :��Լ��Դ ����Ҫÿ��ȥ������������
	              �����̸߳���,���ᵼ�����ڶ��̹߳��ർ��ϵͳ���л���������
				  ��Ӧʱ�����

��������

public class Singleton
{
    // ˽�еġ���̬�ĳ�Ա����Ψһ��ʵ��
    private static Singleton inst;
    // ˽�й����������ⱻ���˴���ʵ��
    private Singleton(){}
    // �ṩһ�������ġ���̬�ķ�������ȡΨһ��ʵ��
    public static Singleton getInstance()
    {
        // �ܶ�ʾ�����붼���ڷ����ϼ�ͬ�������ǻ��ڡ���С��Χԭ�򡱣�Ӧ��Ҫ��ͬ�������
        // �������Ծ�������������Ĳ�������
        synchronized( Singleton.class )
        {
            // �ж�inst�Ƿ�Ϊnull�������null���½�һ��
            if( inst == null )
            {
                inst = new Singleton();
            }
        }
        return inst;
    }
}


��������
public class Singleton
{
    // ˽�еġ���̬�ĳ�Ա����Ψһ��ʵ��
    // ���౻��һ��ʹ�õ�ʱ�򣬾��Ѿ�����˼��ء���ļ��ع��̣�ϵͳ��֤�̰߳�ȫ��
    private static Singleton inst = new Singleton();
    // ˽�й����������ⱻ���˴���ʵ��
    private Singleton(){}

    // �ṩһ�������ġ���̬�ķ�������ȡΨһ��ʵ��
    public static Singleton getInstance()
    {
		
        return inst;
    }
}

servlet��������:  Servlet�������ڿ�ʼ,����Servlet��class�ļ�,ȥ���г�ʼ��
	              ��Ӧ����(Service�еķ���),���ٵ�ʱ��ȥ����distory����,��������


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


���ݿ�Ĵ洢����,�����������,����һ�α�����ڴε��þͲ����ڴα���,
	�û�ͨ��ָ֮���Ĵ洢�����е����ֲ�����������ִ��,�洢����ʱ���ݿ��
	һ����Ҫ����,�洢�����п��԰����߼������������ݲ������,���Խ��ܲ���
	�������,���ص������߶��������Լ�����ֵ.


Springmvc��ִ������:
	1.�û���������,ǰ��Servlet��������,����DispatchServlet���в�������
	2.DispatchServlet���ж������URl����,��ȡURI��Դ��λ��
	  Ȼ�����URI��ȡHandler���������������Ϣ,���ĵ�HandlerExecutionChain
	3.���ݻ�ȡ��Handler,ѡ��һ�����ʵ�HandlerAapater��ȡRequest�е�ģ��
	  ��ʼִ��,��DispatchServlet����һ��ModelandView
	4.���ݻ�ȡ��modelandViewѡ��һ�����ʵ�ViewResolver
	5.ͨ��ViewResolver���model��view����Ⱦ��ͼ���ظ�ǰ��


java8��������

lambda��һ���� �ɴ��ݵ���������
	   ��������һ������,��������һ���ض�����
	   ���ʽ���������һ�����д��� �Ӷ��򻯴���ı�д
optiona������Ч���ж��Ƿ�Ϊ�� ����������쳣
	���鲢��parallel����


ThreadLocalһ���Ϊ�̱߳��ر���,��һ��������̰߳󶨻���,
	        ���������̰߳���һ��,Ϊ,ÿά��һ�������ı���
	����.ͨ��ThreadLoca���Խ�����ɼ���Χ������ͬһ���߳���
	

�߳����� 
Spring��ʲô
redis����
elasticearch


ð������
	public class Sort {
    public static void main(String[] args){
        int[] arr = {6,3,2,1,7};
        for(int i = 0;i<arr.length-1;i++){//���ѭ��n-1
            for(int j = 0;j<arr.length-i-1;j++){//�ڲ�ѭ��n-i-1
                if(arr[j]>arr[j+1]){//�ӵ�һ����ʼ�����������Ƚϴ�С�����ǰ��ıȺ���Ĵ󣬽���λ��
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
