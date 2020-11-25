import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
/*

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
//在一行里输出str最长的字符串
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
    //判断是否为回文
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


