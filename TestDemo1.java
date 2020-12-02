import java.util.Scanner;
class Teacher2 implements Comparable<Teacher2>{
    String name;
    int age;
    int height;
    int weight;

    public Teacher2(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    public int compareTo(Teacher2 o){
        if(this.age<o.age){
            return -1;
        }else if(this.age==o.age){
            return 0;
        }else{
            return 1;
        }
    }
}
public class TestDemo1{
    public static void main(String[] args) {
        Teacher2 t1=new Teacher2("高博",18,190,80);
        Teacher2 t2=new Teacher2("陈沛鑫",20,190,80);
        //对两个对象进行“比较”
        int r=t1.compareTo(t2);
        if(r<0){//代表t1指向的对象的现实事物小于t2指向的对象代表的现实事物
            System.out.println("高博小于陈沛鑫");
        }else if(r==0){
            System.out.println("高博等于陈沛鑫");
        }else{
            System.out.println("高博大于陈沛鑫");
        }
        r=t2.compareTo(t1);
        //r肯定大于0
        System.out.println(r);
    }
}



//将一个数组从左开始前k个字符进行旋转：左旋数组 。
//如：将"abcdef"当k等于2时，进行旋转，得到结果为："cdefab"
/*
public class TestDemo1{
    
}
*/








//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。【不限语
//例如:数组为{1，3，5，7，1，3，5，9,}，找出7和9。
/*public class TestDemo1 {
    public static int findNum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int count = 1;//计数器
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    continue;//下标相等则进入下一次循环
                if (array[i] == array[j])
                    count++;//如果不同下标的数组元素相等，则计算器加1
            }
            if (count == 1)
                return array[i];//返回只出现一次的元素
        }
         return 0;//找不到则返回null
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        str = str.substring(1, str.length() - 1);//去掉键盘输入的字符串中的“【”和“】”
        String[] s = str.split(",");//将字符串以“,"分割，转为一个字符串数组
        int[] array = new int[s.length];//定义一个整型数组，准备用来存数据
        //int[] array1={1,3,5,7,1,3,5,9};
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(s[i]);//将字符串转为int型数据存入整型数组中
        System.out.println(findNum(array));//调方法
    }
}*/



//import java.util.Arrays;
//输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的
//最大值。要求时间复杂度为O(n)。
//例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        int max = MaxSum(a);
        System.out.println(max);
    }
    public static int MaxSum(int[] a) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[a.length - i - 1];
            if (a[a.length - i - 1] >= 0) {
                if (max < sum) {
                    max = sum;
                }
            }
            if (sum < 0) {
                sum = 0;
            }
        }
            return max;
        }
    }
*/








//1.找出无序数组当中，出现次数超过数组长度一半的数字。
//如：{1,2,3,2,2,2,5,4,2} 数组长度为9，超过数组长度一半的数字为2。 因为长度的一半为4，超过4次的数字为2
/*
import java.util.Arrays;
public class TestDemo1{
    public static void main(String[] args) {
        int[] a={1,2,2,2,3,6,2};
        TestDemo1 cc=new TestDemo1();
        System.out.println(cc.find(a));
    }
    public int find(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        Arrays.sort(array);
        int index=array[array.length/2];
        int number=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==index){
                number++;
            }
        }
        return number > array.length/2 ? index : 0;
    }
}
*/







//求一个数组中前k个最小的数字。
//如：{1,2,3,2,2,2,5,4,2} 当k等于3为。前3个最小的数字为 1 2 2
//import com.sun.corba.se.spi.ior.iiop.RequestPartitioningComponent;
/*
package com.hunter.Offer Example;
import java.util.Scanner;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int k = scan.nextInt();
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            int index=Partition(arr, n, 0, n - 1);
            while (index != k - 1) {
                if (index > k - 1) {
                    index = Partition(arr, n, 0, index - 1);
                } else {
                    index = Partition(arr, n, index + 1, n - 1);
                }
                for (int i = 0; i < k; i++)
                    System.out.println(arr[i]);
            }
        }
        public static int Partition(int[] arr,int n,int start,int end){
            int temp = arr[start];
            while (start < end && arr[end] >= temp)
                end--;
            if (start < end)
                arr[start++] = arr[end];
            while (start < end && arr[start] < temp)
                start++;
            if (start < end) {
                arr[end--] = arr[start];
            }
            arr[start] = temp;
            return start;
        }
    }
}
*/







/*
import java.util.Arrays;
import java.util.Scanner;
//求一个十进制数字在内存中二进制1的个数。要求：正数和负数都可以求，并且时间最优【不限语言】
//示例：如7的二进制：0000 0000 0000 0000 0000 0000 0000 0111 共有二进制1的个数为3个
public class TestDemo1 {
     public static int countOne(int x){
         int count=0;
         while(x!=0){
             count++;
             x=x&x-1;
         }
         return count;
     }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();

        System.out.println(countOne(x));

    }
}
*/








//调整数组中元素的位置，使得奇数位于偶数之前.【不限语言】
//示例数组：int[] array = {1,2,3,4,5,6,7,8,}; 将奇数放在偶数前面，无序关心变化后的数据是否有序。
/*public class TestDemo1{
    public static void swapNum(int[] array){
        int i=0;
        int j=array.length-1;
        while(i<j&&array[j]%2==0){
            j--;
        }
        while(i<j&&array[i]%2!=0){
            i++;
        }
        int tmp=array[i];9
        array[i]=array[j];
        array[j]=tmp;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        swapNum(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]+" ");
        }
        System.out.println();
    }
}*/











//import java.util.Arrays;
//import java.util.Scanner;
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个
//函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。时间复杂度小于O(n) ,空间复杂度O(1).
/*
public class TestDemo1 {
    public static boolean Find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col])
                return true;
            else if (target > array[row][col])//target在元素a所在列的下边
                row++;
            else
                col--;//在元素a所在行的左边
        }
            return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入数组行数和列数\n");
        int x = s.nextInt();
        int y = s.nextInt();
        int[][] array = new int[x][y];
        System.out.println("请输入数组元素\n");
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                array[i][j] = s.nextInt();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数\n");
        int t = sc.nextInt();
        Find(t, array);
        if (Find(t, array) == false) {
            System.out.println("数组中不含该元素");
        } else
            System.out.println("数组中含有该元素");
    }
}
*/











/*import java.util.Arrays;
public class TestDemo1{
    public static void main(String[] args) {
        String str="abcd";
        str+="xur";
        System.out.println(str);
        StringBuffer sb=new StringBuffer("abcd");
        System.out.println(sb.append("xur1"));
        *//*StringBuilder sb=new StringBuilder();
        sb.append(str).append("hello");
        str=sb.toString();
        System.out.println(str);*//*
    }
}*/


/*
import java.util.Scanner;

public class TestDemo1 {
    public static String reverse(String str, char begin, char end) {
        char[] ch=str.toCharArray();
        while(begin<end){
            char tmp=ch[begin];
            ch[begin]=ch[end];
            ch[end]=tmp;
            begin++;
            end--;
        }
        return String.copyValueOf(ch);
    }

     public static String reverseK (String str, int k) {
         if (str == null || k <= 0 || k >= str.length()) {
             return null;
         }
         str = reverse(str,0, k-1);
         str = reverse(str,k,str.length() - 1);
         str = reverse(str,0, str.length() - 1);
         return str;

     }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        String ret=reverseK(str,k);
        System.out.println(ret);
    }


}
*/




/*//实现方法 compareTo, 能够实现按照字典序比较字符串大小
public class TestDemo1{
    public static void main(String[] args) {
        String str="abcdef";
        String str2="Abcdef";
        System.out.println(str.compareTo(str2));
    }
}*/



//实现方法 contains, 能够判定字符串中是否包含子串
/*public class TestDemo1{
    public static void main(String[] args) {
        String str="abcdcd";
        System.out.println(str.contains("cde"));
    }
}*/




//实现方法 indexOf, 能够找出字符串子串存在的位置
/*
public class TestDemo1{
    public static void main(String[] args) {
        String str="abcdcd";
        System.out.println(str.indexOf("cd",2));
    }
}
*/





//实现方法 replace, 能够替换字符串中的某个部分
/*
public class TestDemo1{
    public static void main(String[] args) {
        String str="abcdab";
        String ret=str.replaceFirst("ab","gg");
        System.out.println(ret);
    }
}
*/



//实现方法 split, 能够指定分割符将字符串拆分成字符串数组(不必支持正则表达式)

/*import java.util.Arrays;

public class TestDemo1 {
    public static void main(String[] args) {
        String str3="hello";
        char ch=str3.charAt(0);
        System.out.println(ch);
        char[] chars=str3.toCharArray();
        System.out.println(Arrays.toString(chars));
    }
}*/
