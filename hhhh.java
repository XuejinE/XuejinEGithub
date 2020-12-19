import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import sun.applet.Main;

import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import java.io.*;







/*一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：我每天给你10 万元，
你第一天给我1 分钱，第二天2 分钱，第三天4 分钱……这样交换 30 天后，百万富翁交出了多少钱？
陌生人交出了多少钱？（注意一个是万元，一个是分）
 */
/*public class hhhh{
    public static void main(String[] args) {
        int m=0;
        int n=0;
        for(int i=0;i<30;i++){
            n+=10;
            m+=(int)(Math.pow(2,i));//Math是double类型，需要强转为int类型
        }
        System.out.println(n+" "+m);
    }
}*/




/*一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列
中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例
非常重要。因为高的GC-Ratio可能是基因的起始点。
给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
输入描述：
输入一个string型基因序列，和int型子串的长度。
输出描述：
找出GC比例最高的子串，如果有多个输出第一个的子串。
示例：输入AACTGTGCGACCTGA 5，输出GCACG
思路：
由题可知，A+C+G+T=n。因此，求G:C最高，即求在长度为n的字符串里出现G和C次数最多的子串。从输入字符串
下标为0的位置开始，依次遍历n个字符，记录出现C或G的次数，如果高于之前记录的最大值，则更新最大出现次数
和最大子串开始的下标(i)。
*//*
public class hhhh{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
        int max=0;
        int maxIndex=0;
        for(int i=0;i<str.length()-n;i++){
            int count=0;
            for(int j=i;j<i+n;j++){
                if(str.charAt(j)=='C'||str.charAt(j)=='G'){
                    count++;
                }
                if(count>max){
                    max=count;
                    maxIndex=i;
                }
            }
        }
        System.out.println(str.substring(maxIndex,maxIndex+n));
    }
}*/





/*操作给定的二叉树，将其变换为源二叉树的镜像
问题描述
将给定的原二叉树变换为镜像二叉树
*//*
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;
    public TreeNode(int val){
        this.val=val;
    }
}
public class hhhh{
    public void Mirror(TreeNode root){
        if(root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {

    }
}*/



/*题目描述
给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字
1-9编号。要求以字典序排序输出火车出站的序列号。 
输入描述:
有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
输出描述:
输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
思路：
先排列出所有可能，再判断是否符合
*//*
public class hhhh{
    public static boolean isLegal(int[] in,int[] out,int n){
        int i=0;
        int j=0;
        Stack<Integer>stack=new Stack<>();//创建一个int类型的栈
        while(i<n)
        {
            if(in[i]==out[i])
            {
                i++;
                j++;
            }
            else
                {
                if(stack.isEmpty())
                {
                    stack.push(in[i]);
                    i++;
                }
                else
                    {
                    int top=stack.peek();
                    if(top==out[j])
                    {
                        j++;
                        stack.pop();
                    }
                    else if(i<n)
                    {
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while(!stack.isEmpty()&&j<n){
            int top=stack.pop();
            if(top==out[j])
                j++;
            else
                return false;
        }
        return true;
    }

    //求出所有的排列
    public static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){//排序
        if(start==n)
            return;
        if(start==n-1){
            int[] B=A.clone();
            result.add(B);
            return;
        }
        for(int i=start;i<n;i++){
            swap(A,i,start);
            Permutation(A,start+1,n,result);
            swap(A,i,start);
        }
    }
    public static void swap(int[] A,int i,int j){
        int tmp=A[i];
        A[i]=A[j];
        A[j]=tmp;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] A=new int[n];
            for(int i=0;i<n;i++)
                A[i]=scanner.nextInt();
            ArrayList<int[]> result=new ArrayList<>();
            int start=0;
            Permutation(A,start,n,result);
            Set<String> set=new TreeSet<>();
            for(int[] out:result){
                if(isLegal(A,out,n)){
                    StringBuffer sb=new StringBuffer();
                    for(int i=0;i<n-1;i++)
                        sb.append(out[i]+" ");
                    sb.append(out[n-1]);
                    set.add(sb.toString());
                }
            }
            for(String s:set)
                System.out.println(s);
        }
    }
}*/





/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class hhhh{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); String inputString = br.readLine();
        String[] eachScore = inputString.split("\\s+");
        String[] outScore = br.readLine().split("\\s+");
        int[] scoreCounts = new int[120];
        for (int i=0; i<eachScore.length; ++i) {
            int score = Integer.parseInt(eachScore[i]);
            scoreCounts[score]++;
        }
        boolean tag = true;
        for (int i=1; i<outScore.length; ++i) {
            int score = Integer.parseInt(outScore[i]);
            if (tag) {
                System.out.print(scoreCounts[score]);
                tag = false;
            } else {
                System.out.print(" "+scoreCounts[score]);
            }
        }
        System.out.println();
    }
}*/





/*public class hhhh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        int[] score = new int[101];
        int m = Integer.parseInt(br.readLine());// 学生人数
        String[] str = br.readLine().split(" "); // 每名学生的成绩
        String[] cx = br.readLine().split(" ");    // 要查询的人数 和成绩
        br.close();
        for (int i = 0; i < m; i++) {
            score[Integer.parseInt(str[i])]++;
        }
        int cxshu = Integer.parseInt(cx[0]); //要查询的人数
        for (int i = 0; i < cxshu; i++) {
            if (i != cxshu - 1) {
                sb.append(score[Integer.parseInt(cx[i + 1])] + " ");
            } else {
                sb.append(score[Integer.parseInt(cx[i + 1])]);
            }
        }
        out.print(sb);
        out.flush();
    }
}*/








/*洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，
左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放
下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌
过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就
变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
输入描述:
第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，
接下来一行有2n个数a1,a2,…,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
输出描述:
对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
输入例子:
3
3 1
1 2 3 4 5 6
3 2
1 2 3 4 5 6
2 2
1 1 1 1
输出例子:
1 4 2 5 3 6
1 5 4 3 2 6
1 1 1 1
解法一：模拟洗牌法 * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组
，左手拿着1,2,3；右手拿着4,5,6。 * 新建一个ArrayList,先加入1，然后4，接着
依次加入 2 ， 5 ， 3 ， 6 * 于是1,4,2,5,3,6，这就完成了一次洗牌的过程 * k
次洗牌，就把上述过程重复k次。 * 优点： 直观易懂，模拟题中的洗牌过程。 * 缺点：
 大量运用arrayList 和数组的数字转移，且for循环次数过多，繁琐

*//*
public class hhhh {
    public static void ShuffleOnce(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n/2;i++){
            list.add(arr[i]);
            list.add(arr[i+n/2]);
        }
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[2*n];
            for(int j=0;j<2*n;j++){
                arr[j]=sc.nextInt();
            }
            for(int times=0;times<k;times++){
                ShuffleOnce(arr,arr.length);
            }
            for(int a=0;a<n*2-1;a++){
                System.out.print(arr[a]+" ");
            }
            System.out.println(arr[n*2-1]);
        }
    }
}*/







/*小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。
对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使
用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007
整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需
要使用多少次神秘力量就能吃到贝壳。
      解题思路：4*x + 3 是2次2 * x + 1的结果，而8 * x + 7 是三次 2 * x + 1的结果，
每次都进行2 * x + 1，最后再统计出来每次执行3次和执行2次的次数的和就是至少的所求、

*//*
public class hhhh{
    public int MinChance(int x){
        if(x%1000000007==0){
            return 0;
        }
        int count=0;
        while(x!=0&&count<=300000){
            x=((x<<1)+1)%1000000007;
            count++;
        }
        int res=(count+2)/3;
        return res>100000?-1:res;
    }

    public static void main(String[] args) {
        hhhh hhhh=new hhhh();
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int pop=in.nextInt();
            int nums= hhhh.MinChance(pop);
            System.out.println(nums);
        }
    }
}*/





/*请编写一个函数，将两个数字相加，不得使用+或其他算术运算符
* 给定两个int A和B，请返回A+B的值*//*
*//*首先看十进制是如何做的： 5+7=12，三步走
第一步：相加各位的值，不算进位，得到2。
第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111 第一步：相加各位的值，不算进位，
得到010，二进制每位相加就相当于各位做异或操作，101^111。
第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果
*//*
public class hhhh{
    public static int addAB(int A, int B) {
        // write code here
        int sum,carry;
        do{
            sum=A^B;
            carry=(A&B)<<1;
            A=sum;
            B=carry;
        }while(carry!=0);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println("输入a: ");
        int b=sc.nextInt();
        System.out.println("输入b: ");
        System.out.println(addAB(a,b));

    }
}*/




/*验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
例如：
1^3=1
2^3=3+5
3^3=7+9+11
4^3=13+15+17+19
输入描述：
输入一个int整数
输出描述：
输出分解后的String
解题思路：
观察规律，m的3次方可以表示成m个连续奇数的和。m的2次方很明显是这m个连续奇数的平均数
，由此可以找到等式的开始数和结尾数，最后用StringBuffer类的变量和"+"将这m个数连接起来,就得到最终的结果。
*//*
public class hhhh{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int res = n * n * n;
            int mid = n * n;
            StringBuffer sb = new StringBuffer();
            int begin = mid + 1 - n;
            int end = mid - 1 + n;
            for (; begin <= end; begin += 2) {
                if (begin == end) {
                    sb.append(begin);
                    break;
                }
                sb.append(begin + "+");
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}*/



/*给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
现给定数字，请编写程序输出能够组成的最小的数。
输入描述:
每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，
顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
输出描述:
在一行中输出能够组成的最小的数。
示例1
输入
2 2 0 0 0 3 0 0 1 0
输出
10015558
解题思路：找到所给数字中非零并且最小的数，让它为数字最高位，，然后将剩余元素从小到大依次添加。
*//*
public class hhhh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] nums = new int[10];
            for(int i = 0;i<10;i++){
                nums[i] = in.nextInt();//该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
            }
            System.out.println(GetNum(nums));
        }
    }
    public static String GetNum( int[] nums){
        String s = "";
        for(int i = 1; i<10;i++){
            if(nums[i] != 0){
                s += i;
                nums[i] --;
                break;
            }
        }
        for(int i = 0;i<10;i++){
            while(nums[i] != 0){
                s += i;
                nums[i] --;
            }
        }
        return s;
    }
}*/






/*//设计一个算法完成两个超长正整数的加法
public class hhhh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();//next()从遇到第一个有效字符（非空格、换行符）开始扫描，
                                 // 遇到第一个分隔符或结束符（空格’ ‘或者换行符 ‘\n’）时结束
            String b = sc.next();
            BigInteger sum = new BigInteger(a);//BigInteger内部用一个int[]数组来模拟一个非常大的整数：
            BigInteger sum1 = new BigInteger(b);
            BigInteger res = sum.add(sum1);
            System.out.println(res);
        }
    }
}*/






        /*美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上
        首位编写计算机代码的总统。2014 年底，为庆祝“计算机科学教育周”正式启动，奥巴马
        编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！
        输入格式：
        输入在一行中给出正方形边长 N（3≤N≤20）和组成正方形边的某种字符 C，间隔一个空格。
        输出格式：
        输出由给定字符 C 画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像
        正方形，我们输出的行数实际上是列数的 50%（四舍五入取整）。
        *//*
public class hhhh{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();//nextLine()读取到回车结束也就是“\r”；
        String[] str2 = new String[str.length()];
        int pop = 0;
        int low = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            }else{
                str2[pop] = "";
                for (int j = low; j < i; j++) {
                    str2[pop] += str.charAt(j); //获取截取的第一个字符串
                }
                pop++;
                low = i + 1;
            }
        }
        str2[pop] = "";
        for (int j = low; j < str.length(); j++) {
            str2[pop] += str.charAt(j); //获取截取的第二个字符串
        }
        int nums = Integer.parseInt(str2[0]); //边长转换为能用的整数,是将整型数据Integer转换为基本数据类型int
        String key = str2[1];
        for (int i = 0; i < (nums + 1) / 2; i++) { //列数为四舍五入之后的数字，所以nums+1
            if(i == 0 || i == (nums + 1) / 2 - 1){ //第一行和最后一行需要输出一整行
                for (int j = 0; j < nums; j++) {
                    System.out.print(key);
                }
                if(i == 0){
                    System.out.println(); //第一行之后需要换行而最后一行不用
                }
            }else{
                for (int j = 0; j < nums; j++) {
                    if(j == 0 || j == nums - 1){ //只有第一个和最后一个字符需要输出，其他的则是空格即可
                        System.out.print(key);
                    }else{
                        System.out.print(' ');
                    }
                }
                System.out.println(); //每行输出完成之后需要换行
            }
        }
    }
}*/




/*public class hhhh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            //打印第一行
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
           System.out.println();
            //打印中间行，先输出一个字符，再输出空格，最后输出字符

            for (int i = 0; i <= Math.ceil((double) n / 2) - 2; i++) {//向上取整应该是“返回 大于等于 参数d的 最小整数,即对浮点数向上取整”。
                System.out.print(c);
                System.out.println();
                for (int j = 2; j <= n - 1; j++) {
                    //System.out.println("");
                }
                System.out.print(c);
           //     System.out.println();
            }
            //打印最后一行
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }*/
//}






/*题目：生成格雷码
在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码(Gray Code)，
请编写一个函数，使用递归的方法生成N位的格雷码。给定一个整数n，请返回n位的格雷码，顺序为从0开始。
测试样例：1
返回：[“0”,“1”]
分析： 递归的思路就是n位gray码是由n-1位gray码生成。
比如：
求n=3的gray码时，先了解n=2的gray码为（00，01，11，10），然后再给各首位添加0或1，
添加0后变成（000，001，011，010），添加1后需要顺序反向（为了使任意两个相邻的代码只
有一位二进制数不同）则变成（110，111，101，100），即n=3时其gray码为（000，001，011，010，110，111，101，100）。
*//*
public class hhhh {
    public static String[] getGray(int n) {
        // write code here
        if (n == 1) {
            return new String[]{"0", "1"};
        }
        String[] s1 = getGray(n - 1);
        String[] s2 = new String[2 * s1.length];
        for (int i = 0; i < s1.length; i++) {
            s2[i] = "0" + s1[i];//首位添加0
            s2[i + s1.length] = "1" + s1[s1.length - 1 - i];//首位添加1，注意顺序反向
        }
        return s2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(Arrays.toString(getGray(n)));

        }
    }*/









/*请编写一个函数,函数内不使用任何临时变量,直接交换两个数的值。给定一个int数组AB,其第零个元素和
第一个元素为待交换的值,请返回交换后的数组。
测试样例:
[1,2]
返回:
[2,1]
用加法来解决不用临时变量就能交换的问题
例如：
a = 1; b = 2;
a = a + b = 3;
b = a(3) - b (2)= a (1)+ b (2)- b(2) = 1;
a = a(3) - b(1) = a(1) + b(2) - ( a(1) + b(2) - b(2) ) = 2;
括号里的数字代表的数当前字母的值
*/
/*public class hhhh{
            public int[] exchangeAB(int[] AB) {
                // write code here
                AB[1]=AB[0]+AB[1];
                AB[0]=AB[1]-AB[0];
                AB[1]=AB[1]-AB[0];
                return AB;
            }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    }
}*/
/*
//方法二简单方法
public class hhhh{
        public int[] exchange(int[] AB){
          int temp=AB[0];
          AB[0]=AB[1];
          AB[1]=temp;
          return AB;
        }


    public static void main(String[] args) {

    }
}*/



/*给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法（元素可能为0，除以0操作未定义）
*//*
public class hhhh{
    public int[] multiply(int[] A){
        int length=A.length;
        int[] B=new int[length];
        if(length!=0){
            B[0]=1;
            //计算下三角连乘
            for(int i=1;i<B.length;i++){
                B[i]=B[i-1]*A[i-1];
            }
            //B[n]就会在第一个循环的时候，计算好，而把B【0】在下一个循环的时候计算好。
            int temp=1;
            //计算上三角
            for(int j=length-2;j>=0;j--){
                temp*=A[j+1];
                B[j]*=temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {

    }
}*/





/*
* 给定一个k位整数N=dk-1*10k-1 +...+ d*101 + do (0<=d<=9 1 -..k1, dk -0),请编写程序统计每种不同的个位数字出现的次数。
例如:给定N= 100311, 2个0，3个1, 和1个3.
* 数字(0~9)的ASCLL码是在48到57之间，所以用ASCLL码-48（或者直接减去'0'）来记录数字，把这些数字出现的次数记录在一个数组

*//*
public class hhhh{
    static int[] a=new int[10];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        for(int i=0;i<str.length();i++){
            a[str.charAt(i)-48]++;//str.charAt(index)index一个介于0 和字符串长度减1之间的整数。 (0~length-1)
                                  //如果没有提供索引，charAt() 将使用0。
        }
        for(int i=0;i<a.length;i++){
               if(a[i]!=0){
                   System.out.println(i+":"+a[i]);
               }
        }
    }
}*/



/*有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
*//*
import java.util.Scanner;

public class hhhh{
    public static int countWays(int x, int y) {
        // write code here
        int array[][]=new int [x][y];
        for(int i=0;i<y;i++){//最上边一行为1
            array[0][i]=1;
        }
        for(int i=0;i<x;i++){//最左边一行为1
            array[i][0]=1;
        }
        for(int row=1;row<x;row++){
            for(int col=1;col<y;col++){
                array[row][col]=array[row-1][col]+array[row][col-1];
            }
        }
        return array[x-1][y-1];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.println(countWays(a,b));
    }
}*/





/*ibonacci数列是这样定义的：
F[0] = 0
F[1] = 1
for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, …，在Fibonacci数列中的数我们称为Fibonacci数。
给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要
多少步可以变为Fibonacci数。
*//*
import java.util.Scanner;
import java.util.*;
import java.util.Stack;
public class hhhh{
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Scanner intput=new Scanner(System.in);
        int N=intput.nextInt();
        int i=0;
        for(;i<N;i++){
            if(fib(i)>=N){
                break;
            }
        }
        int p=Math.abs(fib(i)-N);//绝对值
        int q=Math.abs(fib(i-1)-N);
        if(p>q){
            System.out.println(q);
        }else{
            System.out.println(p);
        }
    }
}*/



//牛客不通过
/*public class hhhh{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int f1=0;
        int f2=1;
        int f3=f1+f2;
        while(true){
            if(f2==n){
                System.out.println(0);
            }else if(f2>n){
                if(Math.abs(f2-n)>Math.abs(f1-n)){
                    System.out.println(Math.abs(f1-n));
                }else{
                    System.out.println(Math.abs(f2-n));
                }
                break;
            }
            f1=f2;
            f2=f3;
            f3=f1+f2;
        }
    }
}*/




/*输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
*//*
public class hhhh{
    public static void toOut(int num){
        List<Integer> intNum=new ArrayList<>();
        while(num>0){
            intNum.add((num%10));
            num/=10;
        }
        for(int data:intNum){
            System.out.print(data);
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        toOut(num);
    }
}*/





/*输入一个正整数n,求n!(即阶乘)末尾有多少个0？
比如: n = 10; n! = 3628800,所以答案为2
分析：
计算n的阶乘，n的阶乘:n！=1×2×3×…×n那么我们在计算n的阶乘时，实际上就是把所有小于等于n的正整数分解成质因数，
然后再将其乘到一起，那么末尾0的个数实际上就是2 * 5的个数，而2的个数明显是很多很多的，所以问题就转化成了5的个数。
 而只有5的倍数才有5这个因数，所以，问题就进一步简化为小于等于n的数中有多少个数是5的倍数，当然25的倍数，125的倍数，
 625还要单独考虑，比如 拿25来说，25=5*5 ，里面有两个5，提供两个0.
*//*
public class hhhh{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int count=0;
        for(int i=n;i>=5;i--){
            int tmp=i;
            while(tmp%5==0){
                count++;
                tmp/=5;
            }
        }
        System.out.println(count);
    }
}*/



/*题目：找出n个数里最小的k个
        输入描述：每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n 不超过100。
        输出描述：输出n个整数里最小的k个数。升序输出
        输入  3 9 6 8 -10 7 -11 19 30 12 23 5
        输出  -11 -10 3 6 7
        思路：
        第一步：设一个List，将输入的数存入list中，这里面，输入的最后一个数为k值，所以要把他分割出来，然后删除；
        第二步：创建一个数组，将将更新后的list的数存入list中，然后对数组进行排序（从小到大）；
        第三步：打印出数组的前k个，此处注意打印出的数字打印在同一行并且之间相隔一个空格，但是最后一个数字后面不需要空格；*//*

public class hhhh{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>list=new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        int k=list.get(list.size()-1);
        list.remove(list.size()-1);
        int[] array=new int[list.size()];
        for(int i=0;i<list.size();i++){
            array[i]=list.get(i);
        }
        Arrays.sort(array);
        for(int i=0;i<k-1;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(array[k-1]);
    }
}
*/




/*问题：有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
        输入：数组的长度，如8；输出：6
        说明：countDel用来算删除的数的个数；count用来计算两数的间隔；i 是遍历数组的游标; l（length）是数组的长度
        采用下标标记，将删除的数的下标赋值为-1，遍历数组，当遇到值非-1的就用count计数，count累计为3时，
        说明当前的这个下标对应的数应当被删除（对应的值置为-1），这时也要累计删除的个数countSize并将count清0。
        遍历数组时，当游标 i 等于数组长度时，模掉数组长度，如此循环，直到countDel=数组长度时，跳出遍历循环，
        返回的 i-1  就是最后一个被删除的数的下标。*//*
public class hhhh{
    public static int countIndex(int l,int[] index){
        int i=0;
        int count=0;
        int countDel=0;
        while(true){
            if(countDel==l){
                return i-1;
            }
            if(i==l){
                i=i%l;
            }
            if(index[i]!=-1){
                count++;
            }
            if(count==3){
                count=0;
                countDel++;
                index[i%l]=-1;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int length;
        while(scanner.hasNext()){
            length=scanner.nextInt();
            int[] index=new int[length];
            System.out.println(countIndex(length,index));
        }
    }
}*/





/*//求最小公倍数
public class hhhh{
    private static int gcd(int a,int b){
        int t;
        while(b!=0){
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println((n*m)/gcd(n,m));

        }
    }
}*/



/*public class hhhh{
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int r=a%b;
        return gcd(b,r);
    }
    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(5,6));
    }
}*/




/*public class hhhh{
    public static int lcm(int a,int b){
        int temp=0;
        if(a<=0||b==0){
            return -1;
        }
        temp=Math.max(a,b);
        while(temp%a!=0||temp%b!=0){
            temp++;
        }
    return temp;
    }

    public static void main(String[] args) {
        System.out.println(lcm(3,6));
    }

}*/



/*public class hhhh{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int count=0;
        if(num1%4==0||num2%4==0){
            count=num1*num2/2;
        }else{
            count=num1*num2/2+1;
        }
        System.out.println(count);
    }
}*/




/*
public class hhhh{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){//判断集合中是否还有元素可以遍历
            int y1=scanner.nextInt();
            int y2=scanner.nextInt();
            int y3=scanner.nextInt();
            int y4=scanner.nextInt();
            int a=(y1+y3)/2;
            int b=(y2+y4)/2;
            int c=(y4-y2)/2;
            if(a-((y1+y3)/2)!=0){
                System.out.println("No");
                return;
            }
            if(b-((y2+y4)/2)!=0||b-(y3-y1)/2!=0){
                System.out.println("No");
                return;
            }
            if(c-((y4-y2)/2)!=0){
                System.out.println("No");
                return;
            }
            System.out.println(a+" "+b+" "+c);

        }
    }
}
*/



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


