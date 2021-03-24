package javase;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 1、常量在哪个地方，和是不是被final修饰没关系。
 *   一个变量到底存在哪里，和其是不是成员变量或者是局部变量有关系。
 *
 * User: GAOBO
 * Date: 2020-07-25
 * Time: 9:22
 */

class Person {
    public int age;
    public String name;

    public static int count;
    public final int SIZE2 = 100;//普通的成员变量-》对象
    public static final int SIZE3 =999;//方法区

    public void eat() {
        int a = 0;
        final int SIZE = 10;//栈
        System.out.println("吃饭！"+SIZE);
    }

    public void show() {
        //Person person3 = new Person();
        System.out.println("我叫："+name+"年龄："+age);
    }
    //方法的地址在方法区。
    public static void func() {
        System.out.println("静态方法！");
    }

}

class MyValue {
    public int val;
}

public class TestDemo2 {

    public static void swap(MyValue a , MyValue b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;

        MyValue myValue2 = new MyValue();
        myValue2.val = 20;

        System.out.print(myValue1.val + " " + myValue2.val);

        swap(myValue1,myValue2);

        System.out.println();

        System.out.print(myValue1.val + " " + myValue2.val);

    }

    public static void main1(String[] args) {
        Person person1 = new Person();//实例化一个对象    person1：对象的引用
        person1.name = "bit";
        person1.age = 10;

        Person.count = 10;
        Person.func();

        Person person2 = new Person();
        person2.name = "gaobo";
        person2.age = 18;

    }
}
