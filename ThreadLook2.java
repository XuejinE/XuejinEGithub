package lesson1;

public class ThreadLook2 {

    public static void main(String[] args) {

        //第一种创建线程的方法，使用Thread类，重写run（）
        //main线程中，new了线程对象（匿名内部类Thread子类重写run（）方法
        Thread t = new Thread("main中的子线程") {
            @Override
            public void run() {//线程进入运行态之后执行
                while (true) {

                }
            }
        };
        //线程要启动，必须使用start()==>告诉系统调用本线程
        //申请系统调用，线程由创建态---》就绪态，什么时候变为运行态？由系统决定
        //t.setDaemon(true);
        t.start();
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isDaemon());
        System.out.println(t.isInterrupted());
    }
}

