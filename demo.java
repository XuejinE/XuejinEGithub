import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
public class demo{
    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.add(4,5);
        myArrayList.disPlay();

    }
}





/*交换两个数*//*
class MyValue{
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
public class demo{
    public static void swap(MyValue myValue1,MyValue myValue2){
        //上下两句等价。但是不能用原来的方法
      //int tmp=myValue1.val
        int tmp=myValue1.getVal();

        //myValue1.val=myValue2.val;
      myValue1.setVal(myValue2.getVal());

      //myValue2.val=tmp;
      myValue2.setVal(tmp);
    }

    public static void main(String[] args) {
        MyValue myValue1=new MyValue();
        myValue1.setVal(10);

        MyValue myValue2=new MyValue();
        myValue2.setVal(20);
        System.out.println(myValue1.getVal()+" "+myValue2.getVal());
        swap(myValue1,myValue2);
        System.out.println(myValue1.getVal()+" "+myValue2.getVal());

    }
}*/






/*
编写一个类Calculator,有两个属性num1,num2，这两个数据的值，不能在定义的
同时初始化，最后实现加减乘除四种运算
*/

/* class demo {
    private int num1;
    private int num2;
    public demo(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public int add() {
        return this.num1 + this.num2;
    }
    public int sub() {
        return this.num1 - this.num2;
    }
    public int mul() {
        return this.num1 * this.num2;
    }
    public double dev() {
        return this.num1 * 1.0 / this.num2;
    }
}*/







/*输入描述:
一行字符串
输出描述:
最终坐标，以,分隔
示例1
输入
A10;S20;W10;D30;X;A1A;B10A11;;A10;
输出
10,-10
*//*
public class demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String input = scan.nextLine();
            String[] str = input.split(";");//split() 方法用于把一个字符串分割成字符串数组。
            int x = 0, y = 0;
            for (int i = 0; i < str.length; i++) {
                if (correctCoordinate(str[i])) {
                    if (str[i].charAt(0) == 'A') {
                        x = x - Integer.parseInt(str[i].substring(1));
                        //Integer.parseInt(String)就是将String字符类型数据转换为Integer整型数据
                        //取字符串的前i个字符
                    }  else if (str[i].charAt(0) == 'D') {
                        x = x + Integer.parseInt(str[i].substring(1));
                    } else if (str[i].charAt(0) == 'W') {
                        y = y + Integer.parseInt(str[i].substring(1));
                    } else if (str[i].charAt(0) == 'S') {
                        y = y - Integer.parseInt(str[i].substring(1));
                    }
                }
            }
            System.out.println(x + "," + y);//把x,y连接起来
        }
        scan.close();
    }
    public static boolean correctCoordinate(String s){
        //判断是否合法有效，correctCoordinate：正确坐标
        int n=s.length();
        //s.length()的意思是计算字符串s的长度，其返回值是一个整数
        if(n<=3 && n>1){
            if(s.charAt(0)=='A'||s.charAt(0)=='D'||s.charAt(0)=='W'||s.charAt(0)=='S'){
                if(n==2 && Character.isDigit(s.charAt(1))){
                     //Character.isDigit() 方法用于判断指定字符是否为数字。
                    return true;
                }else if(n==3 && Character.isDigit(s.charAt(1)) && Character.isDigit(s.charAt(2))){
                    return true;

                }
            }
        }
        return false;

    }

}*/

