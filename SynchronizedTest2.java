package lesson3;
class MyThread implements Runnable{
    private static int seat=50;

    @Override
    public void run() {
        for(int i=0;i<3;i++) {
            synchronized (this) {
                if (this.seat > 0) {
                    seat--;
                    System.out.println(Thread.currentThread().getName() + ",还有" + this.seat + "座位");

                }
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class SynchronizedTest2 {
    //有一个教室，座位50个，同时有三个老师安排同学的座位，/*
    // 每个老师安排100个同学到这个教室，模拟使用多线程实现
    // 座位编号0-49/1-50，三个线程同时启动，安排同学，
    // 同学可以循环操作来安排，直到座位安排满之后*/
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        Thread t1=new Thread(mt,"A");
        Thread t2=new Thread(mt,"B");
        Thread t3=new Thread(mt,"C");
        t1.start();
        t2.start();
        t3.start();

    }
}
