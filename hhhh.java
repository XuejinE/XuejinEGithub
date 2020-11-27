import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
import java.util.Stack;




/*
//用两个栈完成一个队列，完成队列的push和pop操作，队列中的元素为int类型
//思路：入栈给stack1,出栈时，若stack2不为空，则出栈，若为空，把stack1的内容全都放入stack2,然后再出栈
    public class hhhh {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }
        public int pop() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
        }
            return stack2.pop();
    }

}
*/




/*public class hhhh {
        public static int differentKinds(int[] arr,int n,int v,int index){
            if(v==0){
                return 1;
            }
            if(n==0){
                return 0;
            }else{
                //从后往前装，最后一个开始，装上n个后，体积减少，继续往前
                //装上n个后，如果无解，删除改包，然后从n-1开始继续往前装
                return differentKinds(arr,n-1,v-arr[index],index+1)
                        +differentKinds(arr,n-1,v,index+1);
            }
        }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int kinds=scanner.nextInt();
            int[] arr=new int[kinds];
            for(int i=0;i<kinds;i++){
                arr[i]=scanner.nextInt();
            }
            System.out.println(differentKinds(arr,kinds,40,0));
        }
    }
}*/




//输入两个字符串，从第一个字符串中删除第二个字符串中所有的字符，例如，输入
//“They are students."和”aeiou",则删除之后的第一个字符串变为“thy r stdnts."
//思路：建立数组，将字符串2的字符在数组中标记为1，定义两个指针指向字符串1，遍历字符串1，若当前字符所代表的ASIIC码在数组中对应的值不为1
//表示该字符不是字符串2中出现的字符
/*public class hhhh{
    public static String deletePattern(String a,String b){
        StringBuilder s=new StringBuilder();//存储结果字符串
        char[] b1=new char[256];
        for(int i=0;i<b.length();i++){
            b1[b.charAt(i)]=1;//用于提取字符串中的特定字符
        }
        for(int i=0;i<a.length();i++){
            if(b1[a.charAt(i)]!=1){
                s.append(a.charAt(i));//剩余的字符串存放于这个新的数组
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String a="They are studnts.";
        String b="aeiou";
        System.out.println(deletePattern(a,b));
    }

}*/
/*//法2
public class hhhh{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        String[] arr1=s1.split("");//先将每个字符截取出来
        StringBuffer sb=new StringBuffer();//存储新的字符串
        for(int i=0;i<arr1.length;i++){
            if(!s2.contains(arr1[i])){//判断若第二个字符串包含第一个字符串就舍掉
                sb.append(arr1[i]);//不包含就用append进行拼接
            }
        }
        System.out.println(sb.toString());
    }
}*/






/*//小易买苹果，但是都是6个或者8个一包装，小易要买n个苹果，怎么买刚好买到整的，不能拆分
public class hhhh{
    public static int count(int n){
        if(n%2!=0||n==10||n<6){
            return -1;//一定是偶数，（6，8）都是，最小是6，10以上的偶数都可以
        }
        if(n%8==0){
            return n/8;//若果拿八个刚好拿完
        }
        return 1+n/8;//10以上的偶数，只要对8取余数不为0，就从前面的1或者2个8中拿出两个，把余数补为6（本来余数就为6，就不用拿了
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){//判断输入的是不是数字
            int n=in.nextInt();
            System.out.println(count(n));
        }
    }
}*/





/*
//判断（）是否对应，里边不能有别的字符，若是对应，输出true
public class hhhh {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        //先通过toCharArray转换成一个字符数组
        char[] arr = A.toCharArray();
        int num = 0;
        int i = 0;
        //2.遍历这个数组，num在遍历完之后等于0
        while (i < arr.length && num >= 0) {
            if (arr[i] == '(') {
                num++;
            } else if (arr[i] == ')') {
                num--;
            }
            i++;
        }
        if (i < arr.length || num != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hhhh{}";
    }

    public static void main(String[] args) {
        hhhh hhhh=new hhhh();
        System.out.println(hhhh.chkParenthesis("(()))",5 ));
        System.out.println();
    }
}
*/
/*//第二种方法,使用栈方法
public class hhhh {
    @Override
    public String toString() {
        return "hhhh{}";
    }

    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<Character>();
        if (A == null || A.length() != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            } else if (A.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                return false;
            }
        }if (!stack.empty()) {
                return false;
            } else {
                return true;
            }
        }

    public static void main(String[] args) {
        hhhh hhhh = new hhhh();
        System.out.println(hhhh.chkParenthesis("((()))", 6));
        System.out.println();
    }
}*/






/*
//在一行里输出str最长的字符串，//判断一个字符串中找到连续的数字字符最多的串，并输出
public class hhhh{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();//读取空格
        String result = " ";
        int count = 0;
        char[] arr = string.toCharArray();//将字符串转化为字符数组
        for (int i = 0; i < arr.length; i++) {
            if ('0' <= arr[i] && '9' >= arr[i]) {//当前是数字
                count = 1;//初始化计算器
                int index = i;//在后边的循坏存储截至索引
                for (int j = i + 1; j < arr.length; j++) {
                    if ('0' <= arr[j] && '9' >= arr[j]) {
                        count++;
                        index = j;
                    } else {
                        break;
                    }
                }
                if (count > result.length()) {
                    result = string.substring(i, index + 1);//截取字符串
                }
            } else {
                continue;
            }
        }
        System.out.println(result);
    }
}
*/





//2. 完善核心代码 标题：寻找第K大 | 时间限制：3秒 | 内存限制：32768K | 语言限制：[Python, C++, C#,
//Java]
//有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
//给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
//测试样例：
//[1,3,5,2,2],5,3
//返回：2
/*public class hhhh {
    public static void quickSort(int[] a,int low,int high) {
        if(low>=high){
            return;
        }
        int tmp=a[low];

        while(low<high){
            while(low<high&&a[high]>=tmp){
                high-=1;
            }
            a[low]=a[high];
            while(low<high&&a[low]<tmp){
                low+=1;
            }
            a[high]=a[low];
        }
        a[low]=tmp;
        quickSort(a,low,low-1);
        quickSort(a,low+1,high);
        return;

    }
    private static int findKth(int[] a,int n,int K){
        quickSort(a,0,a.length-1);
        int last=n-1;
        int tmp=a[last];
        int i=0;
        if(K==1){
            return a[a.length-1];
        }
        while(i!=K){
            tmp=a[last];
            if(tmp!=a[last-1]){
                i++;
                last--;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
       int[] a={1,3,5,2,2};
       for(int i=0;i<a.length-1;i++){
           System.out.println(a[i]+" ");
       }
        System.out.println();
        System.out.println(findKth(a,a.length,3));
    }*/
//}





/*public class hhhh {
    //1. ACM编程题 标题：统计回文 | 时间限制：1秒 | 内存限制：32768K
    //“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。花花非常喜欢这种拥有
    //对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符
    //串B插入字符串A使产生的字符串是一个回文串。你接受花花的请求，帮助她寻找有多少种插入办法可以使新
    //串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
    //例如：
    //A = “aba”，B = “b”。这里有4种把B插入A的办法：
    //* 在A的第一个字母之前: "baba" 不是回文
    //* 在第一个字母‘a’之后: "abba" 是回文
    //* 在字母‘b’之后: "abba" 是回文
    //* 在第二个字母'a'之后 "abab" 不是回文
    //NOWCODER.COM
    //牛客网·互联网名企笔试/面试题库
    //牛客出品-http://www.nowcoder.com所以满足条件的答案为2
    //输入描述：
    //每组输入数据共两行。
    //第一行为字符串A
    //第二行为字符串B
    //字符串长度均小于100且只包含小写字母
    //输出描述：
    //输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
    public static boolean ishuiwen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i, str2);//从0号位置开始插入
            if (ishuiwen(sb.toString())) {
                //说明是回文，计数+1
                count++;
            }
        }
        System.out.println(count);
    }
}*/




/*public class hhhh {
    public static int count(int[] Array, int n) {
        // write code here
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Array[i]>Array[j]){
                    count++;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n=8;
        int Array[]={1,2,3,4,5,6,7,0};
        count(Array,8);
        System.out.println(Arrays.toString(Array));
        System.out.println(count(Array,8));

    }
}*/




/*
public class hhhh {
    //把瓶子三个一组分好
    public static int water_max(int n) {
        int k = 0;
        while (n >= 3) {
            if (n % 3 == 0) {
                k = k + n / 3;
                n = n / 3;
            }
            if (n % 3 != 0) {
                k = k + n / 3;
                int t = n % 3;
                n = n / 3 + t;
            }
            if (n == 2) {
                k = k + 1;
            }

        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 0) {
                System.out.println(water_max(num));
            }
        }

    }
}
*/


