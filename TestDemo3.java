/**
 * Created with IntelliJ IDEA.
 * Description:
 * 为什么？
 * 意义是什么？
 * 怎么用？
 * User: GAOBO
 * Date: 2020-07-25
 * Time: 10:11
 */
class Student {
    private String name;
    private int age = 176;
    public static int count = 99;


    {
        this.age = 998;
        System.out.println("实例代码块-》构造代码块");//3
    }

    static {
        //this.age = 888;//不可以。为什么？
        count = 1888;
        System.out.println("静态代码块-》笔试/考试");//4
    }

    public Student() {
        //this.age = 10;
        //this("bit");//调用带有一个参数的构造方法，且这个参数是String
        System.out.println("student()");//1
    }

    public Student(String name) {
        System.out.println("student(String)");//2
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void func() {
        {
            System.out.println("本地代码块：没有什么卵用");
        }
        System.out.println("func()");
    }

    public void func2() {
        this.func();
        System.out.println("func2()");
    }
}

public class TestDemo3 {

    public static void func5(int[] array) {

    }
    public static int func6(int a,int b) {
        return a+b;
    }

    /**
     * 可变参数编程
     * @param b
     * @return
     */
    public static int func7(int... b) {
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        func5(array);
        func5(new int[]{1,2,3,4,5});
        System.out.println(func7(array));
        System.out.println(func7(1,2,3,4,5,6,7,8));
        System.out.println(func7(new int[]{1,2,3,4,5}));
    }

    public static void func4(Student student) {

    }

    public static void main4(String[] args) {
        new Student().func();
        func4(new Student());

        Student student = new Student();
        student.func();
        func4(student);

    }

    public static void main3(String[] args) {
        Student student = new Student();
        System.out.println(student.getAge());
        System.out.println(Student.count);
        function();
    }

    public static void function() {

    }


    public static void main2(String[] args) {
        Student student1 = new Student();

        System.out.println("=================");
        Student student2 = new Student();

    }


    int a = 10;
    public void func() {
        this.a = 99;
    }

    public static void main1(String[] args) {

        Student student = new Student();
        System.out.println(student);

        /*Student student2 = new Student("gaobo");
        System.out.println(student2.getName());
        System.out.println("====================");
        Student student3 = new Student("bit",10);
        System.out.println(student3);*/

        /*student.setName("bit");
        System.out.println(student.getName());

        System.out.println(student);*/

        /*student.name="bit";
        System.out.println(student.name);*/
    }
}
