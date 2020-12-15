package lesson2;

public class ThreadTest {
    public static void main(String[] args) {
    for(int i=0;i<20;i++) {
        final int n=i;
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {//内部类使用外部的变量，必须用final修饰
                try{
                    Thread.sleep(3000);
                    System.out.println(n);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
        System.out.println("OK");
    }
}
