package lesson6;
/*
面包店
升级版需求：面包师傅每个最多生产30次，面包店每天最多生产10*30*3=900
消费者不再一直消费，把900个消费完结束*/

public class BreadShop {
    private static int COUNT;
    //消费者
    public static class Consumer implements Runnable{
       private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //一直消费
            try {
                while(true){
                    synchronized (BreadShop.class){
                       //库存到达下限，不能继续消费，需要阻塞等待
                        if(COUNT==0){
                           BreadShop.class.wait(); //释放对象锁
                        }else{
                            //库存>0.允许消费
                            System.out.printf("消费者%s 消费了一个面包\n",name);
                            COUNT--;
                            //t通知BreadShop.class.wait();代码进入阻塞的流程
                            BreadShop.class.notifyAll();
                            //模拟消费的耗时
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//生产者
public static class producer  implements Runnable{
        private String name;

    public producer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //一直消费
        try {
            while(true){
                synchronized (BreadShop.class){
                    //库存到达上限，不能继续生产，需要阻塞等待
                    if(COUNT+3>100){
                        BreadShop.class.wait(); //释放对象锁
                    }else{
                        //库存满足生产条件，允许生产
                        System.out.printf("生产者%s 生产了3个面包\n",name);
                        COUNT+=3;
                        //t通知BreadShop.class.wait();代码进入阻塞的流程
                        BreadShop.class.notifyAll();
                        //模拟消费的耗时
                        Thread.sleep(500);
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    public static void main(String[] args) {
        //同时启动20个消费者线程
        Thread[] consumers = new Thread[20];
        for (int i = 0; i < 20; i++) {
            consumers[i] = new Thread(new Consumer(String.valueOf(i)));
        }
        //同时启动10个生产者线程
        Thread[] producer = new Thread[10];
        for (int i = 0; i < 10; i++) {
            consumers[i].start();
        }
        for (int i = 0; i < 20; i++) {
            consumers[i].start();
        }
    }
}
