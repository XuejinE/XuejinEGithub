import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;








/*对N个长度最长可达到1000的数进行排序。
输入描述:
输入第一行为一个整数N，(1<=N<=100)。
接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
每个数都是一个正数，并且保证不包含前缀零。
输出描述:
可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，
输出排序后的结果，每个数占一行。
示例：
示例1：
输入
3
11111111111111111111111111111
2222222222222222222222222222222222
33333333
输出
33333333
11111111111111111111111111111
2222222222222222222222222222222222
*//*
public class lianxi{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){//题目出现多组数据
            int n=in.nextInt();//输入得数字赋给n
            BigInteger[] nums=new BigInteger[n];//.java中可以使用BigInteger操作大整数，
                                                // 也可以转换进制。如果在操作的时候一个整型数据已经
                                                // 超过了整数的最大类型长度long的话，则此数据就无法装入，所以，此时要使用BigInteger类进行操作。这些大数都会以字符串的形式传入
            for(int i=0;i<n;i++){
                nums[i]=in.nextBigInteger();
            }
            Arrays.sort(nums);
            for(int i=0;i<n;i++){
                System.out.println(nums[i]);
            }
        }
    }
}*/







/*输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数
(如’3’，输出：10110011)。
输入描述:
输入包括一个字符串，字符串长度不超过100。
输出描述:
可能有多组测试数据，对于每组数据，对于字符串中的每一个字符，输出按题目
进行奇偶校验后的数，每个字符校验的结果占一行。
输入
3
3a
输出
10110011
10110011
01100001
解析：
这里将数字和字母统一看成是char类型（字符）的，所以数字3实际存储时为ASCII码中的‘3’，
其十进制表示是51，转化为二进制表示就是0110011，取最高位为奇校验位，校验位为1，
所以校验后的二进制数为10110011，字母同理。首先将每个字符都转换为7位二进制表示，
第八位为保留的奇校验位，若7位二进制中1的个数为奇数，则奇校验位为0，若个数为偶数，
则奇校验位为1.
*//*
public class lianxi{
    public static void jiJiaoYan(char[] s){
        int[] result=new int[8];
        for(int i =0;i<s.length;i++){
            int n=0x01;//0000 0001;
            int j=7;
            int sum=0;
            //需要进行7次与运算，得出1得个数及二进制形式
            while(j>0){
                result[j]=(s[i]&n)==0?0:1;//与运算
                if(result[j]==1){
                    sum++;//个数
                }
                n=n<<1;
                j--;
            }
            if((sum&1)==0){
                result[0]=1;
            }
            for(int k=0;k<result.length;k++){
                System.out.print(result[k]);
            }
            result[0]=0;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            jiJiaoYan(str.toCharArray());//将输入得字符统一转换为字符串数组
        }
    }
}*/




/*public class lianxi{
    *//*
    * 算法思想
    *     两个相同得数异或得0，一个数与0异或得它本身*//*
    public static void printOddTimesNum1(int[] arr){
        int result=0;
        for(int i=0;i<arr.length;i++){
                result^=arr[i];
        }
        System.out.println(result);
    }
    *//*
    * 找出两个奇数得算法思想：
    * 一趟异或下来，最终得结果即为那两个奇数异或得结果，
    * 如果其结果不为0，则说明至少存在这两个数中的某一个数的某一位不全为0
    * 那么可以根据这个不同的位，将数组分为两部分，在对这两个独立的部分，分别异或，就可以得到这两个奇数了*//*
    public static void printOddTimesNum2(int[] arr) {
        int orResult = 0;
        int oneResult = 0;
        for (int i = 0; i < arr.length; i++) {
            orResult ^= arr[i];//异或的结果
        }
        //得到两个数右起第一个不相同的位
        //一个数和自己的相反数进行位于，得到的是原数中右起第一个为1，其余都为0 的数
        //比如：3--》0011---》0001
        int oneRight = orResult & (~orResult);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & oneRight) != 0) {//根据这不同的位，将数组分为两个部分
                oneResult ^= arr[i];
            }
        }
        System.out.println(oneResult + "-" + (oneResult ^ orResult));
    }

    public static void main(String[] args) {
        int arr1={}
    }
}*/





/*给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
*//*
public class lianxi{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//数组长度为n，表示n个数字
        int sum=scanner.nextInt();//部分元素求和sum
        int[] value=new int[n];//初始化数组
        long[] dp=new long[sum+1];//动态数组规划
        dp[0]=1;//index=0的初始化值
        for(int i=0;i<n;i++){
            value[i]=scanner.nextInt();
            for(int j=sum;j>=0;j--){
                if(j>=value[i]){
                    dp[j]+=dp[j-value[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
}*/








/*今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
2. 待所有字条加入完毕，每人从箱中取一个字条；
3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
*//*
public class lianxi{
  *//*用排列组合求出z,也就是求出多少种抽奖的可能，
  * 如果5个人抽奖，那么第一个人就有五种中奖的可能，第二个人4种，
  * 第三个人3种，依次类推，n个人抽奖的可能性就是n！*//*
public static float denominator(int n){//分母，阶乘
    float result=1;
    if(n==0){
        return 1;
    }else if(n>0){
        result=n*denominator(n-1);
    }
    return result;
}
*//*使用错误排序求出m，就是求出所有抽取错的情况
* 如果5个人抽奖，第一个人抽错可能就有4种，第二个人3种
* 1.第一个人抽到的是第二个人的名字，那么第二个人抽错的概率就是100%，直接求
* 2.如果第一个人抽到的名字不是第二个人的名字，那么第二个人抽错的可能就有三种*//*
    public static float misSort(int n){
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            return (n-1)*(misSort(n-1)+misSort(n-2));
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner((System.in));
        while (sc.hasNext()){
            int n=sc.nextInt();
            float m=denominator(n);//所有可能抽到的情况
            float z=misSort(n);//抽错的情况
            float result=(z/m)*100;//无人中奖的情况
            System.out.println(String.format("%.2f",result)+"%");//打印出概率
        }
    }
}*/







/*
import java.util.Scanner;
public class lianxi{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String n=scan.next();
            if(isShouXingShu(n)){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
    public static boolean isShouXingShu(String num){
        if(num==null||num.isEmpty()){
            return false;
        }
        long n=(long)Math.pow(Double.parseDouble(num),2);
        String m=String.valueOf(n);
        if(m.length()>1 && m.length()<3){
            m=String.valueOf(n).substring(m.length()-1);
        }else if(m.length()>=3){
            m=String.valueOf(n).substring(m.length()-2);
        }
        if(num.equals(m)){
            return true;
        }
        return false;
    }
}*/




/*

整数与IP地址间的转换
原理： ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例： 一个ip地址为10.0.3.193

每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001

组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
输入
1 输入IP地址
2 输入10进制型的IP地址
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址
示例1
输入
10.0.3.193
167969729
输出
167773121
10.3.3.193
*//*
public class lianxi{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String ip=sc.nextLine();//输入IP地址字符串
            String ip10=sc.nextLine();//输入10进制表示的IP地址字符串
            System.out.println(convertIp10(ip));//IP地址转为10进制字符串
            System.out.println(convertIp(ip10));//10进制IP地址转IP地址
        }
    }
    private static long convertIp10(String ip){
        String[] ips=ip.split("\\.");//使用。分割
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<ips.length;i++){
            sb.append(binaryString(ips[i]));//10进制数转二进制字符串
        }
        return Long.parseLong(sb.toString(),2);
    }
    //10进制转换为8位二进制
    private static String binaryString(String s){
        StringBuffer sb=new StringBuffer();
        int num=Integer.parseInt(s);
        int k=1<<7;
        for(int i=0;i<8;i++){
            int flag=(num&k)==0?0:1;
            sb.append(flag);
            num=num<<1;
        }
        return  sb.toString();
    }
    private static String convertIp(String ip10){
        StringBuffer sb=new StringBuffer();
        String ip2=Long.toBinaryString(Long.parseLong(ip10));
        String as="";
        if(ip2.length()<32){//不足32位前面补0
            for(int i=0;i<32-ip2.length();i++){
                as+="0";
            }
        }
        ip2=as+ip2;
        //IP地址每一段进行拼接
        String[] ips=new String[4];
        ips[0]=ip2.substring(0,8);
        ips[1]=ip2.substring(8,16);
        ips[2]=ip2.substring(16,24);
        ips[3]=ip2.substring(24);
        for(int i=0;i<4;i++){
            sb.append(Integer.parseInt(ips[i],2));
            if(i!=3){
                sb.append(".");
            }
        }
           return sb.toString();
    }
}*/




/*
* 输入一个数n,然后输入n个数值各不相同,再输·入一个值x,
* 输出这个值在这个数组中的下标(从 0开始,若不在数组中则输出-1)。
*/
/*public class lianxi{
    public static int search(int[] arr,int x){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] arr=new int[n];
        int i=0;
        for(i=0;i<n;i++){
            int m=input.nextInt();
            arr[i]=m;
        }
        int x=input.nextInt();
        System.out.println(search(arr,x));
    }
}*/






/*public class lianxi{
    Scanner input=new Scanner(System.in);
    while(input.hasNextInt()){
        int n = input.nextInt();
        int m = n * n;
        int sum1 = 0;
        int sum2 = 0;
        while (n > 0) {
            sum1 += n % 10;
            n = n / 10;
        }
        while (m > 0) {
            sum2 += m % 10;
            m = m / 10;
        }
        System.out.println(sum1 + " " + sum2);

    }
}*/





/*考试题目和要点:
1、中大写金额数字前应标明“人民币”字样。大写金额数
字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、任、
万、亿、元、角、分、零、整等字样填写。(30分)
2、中大写金额数字到元”为止的，在“元"之后，应写“整字，
如￥532.00应写成“人民币伍佰叁拾贰元整”。在角“和”分"后面
不写"整字。(30分)
3、阿拉伯数字中间有“0”时，中大写要写零”字，阿拉伯数字
中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如
￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
，(
*/
/*public class lianxi { //阿拉伯数字0-9对应的中文
    static String[] map = {"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String number = scan.next();
            resolve(number);
        }
        scan.close();
    }


    public static void resolve(String str) {
        String[] strArr = str.split("\\.");
        //整数部分
        int number = Integer.valueOf(strArr[0]);
        StringBuffer res = new StringBuffer("人民币");
        int yi = (int) (number / 100000000);
        if (yi != 0) {
            res.append(resolveQian(yi)).append("亿");
            number = number - yi * 100000000;
        }
        int wan = (int) (number / 10000);
        if (wan != 0) {
            res.append(resolveQian(wan)).append("万");
            number = number - wan * 10000;
        }
        //处理最后一个千百十个位
        String beforePointString = resolveQian(number);
        if (beforePointString.length() > 1) {
            res.append(beforePointString).append("元");
        }
        //若有小数点，处理小数点后面位数
        //小数部分处理
        if (strArr.length > 1) {
            String afterPointStr = strArr[1];
        res.append(handleNumberAfterPoint(afterPointStr));
    }

    //在resolveQian() 方法里可能会返回零xxx
// 但在最高位不能有"零"
    String resString = res.toString();
    //参考字符串：人民币零伍佰叁拾贰元整 
    if(resString.length()>4&&resString.charAt(3)=='零'&&resString.charAt(4)!='元')

    {
        //最高位的零去掉 
        resString = resString.substring(0, 3) + resString.substring(4);
    } 
    System.out.println(resString);
    }

    //处理4位数千百十个位
    public static String resolveQian(double temp) {
        StringBuffer resBuffer = new StringBuffer();
        //千位
        int qian = (int) (temp / 1000);
        if (qian != 0) {
            resBuffer.append(map[qian - 1]).append("仟");
            temp = temp - qian * 1000;
        }
        //百位
        int bai = (int) (temp / 100);
        if (bai != 0) {
            resBuffer.append(map[bai - 1]).append("佰");
            temp = temp - bai * 100;
        }
        //注意:零只会添加在百位和十位 
        if (qian != 0 && bai == 0) {
            resBuffer.append("零");
        }
        //十位
        int shi = (int) (temp / 10);
        if (shi != 0) {
            if (shi != 1) {
                resBuffer.append(map[shi - 1]);
            }
        }
        resBuffer.append("拾");
        temp = temp - shi * 10;

//注意：0
        if (bai != 0 && shi == 0) {
            resBuffer.append("零");
        }
        //个位
        int ge = (int) (temp % 10);
        if (ge != 0) {
            //1 这种情况，千百十位均为0
            if (qian == 0 && bai == 0 && shi == 0) {
                resBuffer.append("零");
            }
            resBuffer.append(map[ge - 1]);
        }
        String res = resBuffer.toString();
        return res;
    }

    //处理小数点后面的数
    public static String handleNumberAfterPoint(String str) {
        String res = "";
        if (str.equals("00") || str.equals("0")) {
            res = "整";
        } else {
            if (str.charAt(0) != '0') {
                res += map[Integer.valueOf(str.charAt(0) + "") - 1] + "角";
            }
            if (str.length() > 1 && str.charAt(1) != '0') {
                res += map[Integer.valueOf(str.charAt(1) + "") - 1] + "分";
            }
        }
        return res;
    }*/
//}*/





/*public class lianxi{
    private final static char[] NUM={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖','拾','佰','仟','万','亿'};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double d=scanner.nextDouble();
        System.out.println(convert(d));
    }
    private static String convert(double d){
        long n=(long) d;
        StringBuilder builder=new StringBuilder("人民币");
        //处理整数部分，前提是整数部分大于0
        if(n>0){
            convert(n,builder);
            builder.append('元');
        }
        //加上0.0001是为了防止d*100发生失真
        int v=(int)(d*100-n*100+0.0001);
        int i=v/10;
        int j=v%10;
        if(i==0&&j==0){
            builder.append('整');
            return builder.toString();
        }
        if(j!=0){
            builder.append(NUM[i]).append('角');
        }
        if(j!=0){
            builder.append(NUM[j]).append('分');
        }
        return builder.toString();
    }
    private static void convert(long n,StringBuilder builder){
        //大于一亿
        if(n>=1_0000_0000){
            long q=n/1_0000_0000;
            long r=n%1_0000_0000;
            convert(q,builder);
            builder.append('亿');
            //是亿的整数倍
            if(r!=0){
                convert(r,builder);
            }
        }
        //大于一万
        else if(n>=1_0000){
            long q=n/1_0000;
            long r=n%1_0000;
            convert(q,builder);
            builder.append('万');
            //是亿的整数倍
            if(r!=0){
                if(r<100){
                    builder.append('零');
                }
                convert(r,builder);
            }
        }
        else if(n>=1000){
            long q=n/1000;
            long r=n%1000;
            convert(q,builder);
            builder.append('仟');
            //是亿的整数倍
            if(r!=0){
                if(r<100){
                    builder.append('零');
                }
                convert(r,builder);
            }
        }
        //大于100
        else if(n>=100){
            long q=n/100;
            long r=n%100;
            convert(q,builder);
            builder.append('佰');
            //是亿的整数倍
            if(r!=0){
                if(r<100){
                    builder.append('零');
                }
                convert(r,builder);
            }
        }
        //大于    10
        else if(n>=10){
            long q=n/10;
            long r=n%10;
            convert(q,builder);
            builder.append('拾');
            //是亿的整数倍
            if(r!=0){
                if(r<100){
                    builder.append('零');
                }
                convert(r,builder);
            }
        }else{
            builder.append(NUM[(int) n]);
        }
    }
}*/








/*北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
 公式如下：
 实际成绩 绩点
90——100 4.0
 85——89 3.7
 82——84 3.3
 78——81 3.0
 75——77 2.7
 72——74 2.3
 68——71 2.0
 64——67 1.5
 60——63 1.0
 60以下 0
 1．一门课程的学分绩点=该课绩点*该课学分
2．总评绩点=所有学科绩点之和/所有课程学分之和
 现要求你编写程序求出某人A的总评绩点（GPA）。
输入：
第一行 总的课程数n（n<10）；
 第二行 相应课程的学分（两个学分间用空格隔开）；
 第三行 对应课程的实际得分；
 此处输入的所有数字均为整数。
输出：
输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
样例输入： 5
4 3 4 2 3
91 88 72 69 56
样例输出： 2.52*//*
public class lianxi {
    public static double point(int grade) {//判断绩点
        double point = 0.0;
        if (grade >= 90 && grade <= 100) {
            point = 4.0;
        } else if (grade >= 85 && grade <= 89) {
            point = 3.7;
        } else if (grade >= 82 && grade <= 84) {
            point = 3.3;
        } else if (grade >= 78 && grade <= 81) {
            point = 3.0;
        } else if (grade >= 75 && grade <= 77) {
            point = 2.7;
        } else if (grade >= 72 && grade <= 74) {
            point = 2.3;
        } else if (grade >= 68 && grade <= 71) {
            point = 2.0;
        } else if (grade >= 64 && grade <= 67) {
            point = 1.5;
        } else if (grade >= 60 && grade <= 63) {
            point = 1.0;
        } else if (grade < 60) {
            point = 0;
        }
        return point;
    }
    public static double totalGPA(int[] grade, int[] course) {//学分，分数
        double total = 0;//总课程的学分绩点
        double eachtotal = 0;
        for (int i = 0; i < grade.length; i++) {
            total += point(course[i]) * grade[i];//该课绩点*该课学分
            eachtotal += grade[i];
        }
        return total / eachtotal;//总评绩点=所有学科绩点之和/所有课程学分之和
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int grade[] = new int[n];//学分
        int course[] = new int[n];//分数
        for (int i = 0; i < n; i++) {
            grade[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            course[i] = in.nextInt();
        }
        System.out.printf("%.2f", totalGPA(grade, course));//保留两位小数
    }
}*/




/*import java.util.*;
 *//*春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现
的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。*//*
public class lianxi{
    public int getValue(int[] gifts,int n){
        Arrays.sort(gifts);
        int mid=gifts[n/2];
        int num=0;
        for(int i=0;i<n;i++){
            if(gifts[i]==mid){
                num++;
            }
        }
        return num>n/2?mid:0;
    }
    public static void main(String[] args) {
        lianxi lx=new lianxi();
        int[] num={1,2,2,2,5};
        System.out.println(lx.getValue(num,5));
    }
}*/







/*
 *//*输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。*//*
    class student {
    String name;
    int score;

    public student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
        public class lianxi{
            public static void main(String[] args) {
                Scanner input=new Scanner(System.in);
                while(input.hasNext()){
                  int n=input.nextInt();//要排序的人的个数
                  int order=input.nextInt();//排序方式
                    List<student> list=new ArrayList<>();
                    for(int i=0;i<n;i++){
                        String name=input.next();
                        int score=input.nextInt();
                        list.add(new student(name,score));
                    }
                    //降序
                    if(order==0){
                        Collections.sort(list, new Comparator<student>() {
                            @Override
                            public int compare(student o1, student o2) {
                                return o2.score-o1.score;
                            }
                        });
                    }
                    //升序
                    if(order==1){
                        Collections.sort(list, new Comparator<student>() {
                            @Override
                            public int compare(student o1, student o2) {
                                return o1.score-o2.score;
                            }
                        });
                    }
                    for(int i=0;i<list.size();i++){
                        System.out.println(list.get(i).name+" "+list.get(i).score);
                    }
                }
            }
    }*/








/*public class lianxi{
 *//*现有一个小写英文字母组成的字符串s和一个包含较短小写英文
字符串的数组p，请设计一个效算法，对于p中的每一个较短字
符串，判断其是否为s的子串。
给定一个string数组p和它的大小n,同时给定strings,为为串,
请返回一个bool数组，每个元素代表p中的对应字符串是否为s的
子串。保证p中的串长度小于等于8，且p中的串的个数小于等于
500，同时保证s的长度小于等于1000。
*//*
    public boolean[] chkSubStr(String[] p,int n,String s){
        boolean[] str=new boolean[n];
        for(int i=0;i<n;i++){
            if(s.contains(p[i])){
                str[i]=true;
            }
        }
        return str;
    }

    public static void main(String[] args) {

    }

}*/





/*class Person {
    public int a;
    private String name;
    String sex;//默认权限，默认不是public->>
}
class MyValue {
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

    public class lianxi {
    //交换
    public static void swap(MyValue myValue1, MyValue myValue2) {
        int tmp = myValue1.getVal();
        //int tmp=myValue1.val;
        //myValue1.val=myValue2.val;
        myValue1.setVal(myValue2.getVal());
        //myValue2.val=tmp;
        myValue2.setVal(tmp);

    }

    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.setVal(10);
        MyValue myValue2 = new MyValue();
        myValue2.setVal(20);
        System.out.println(myValue1.getVal() + " " + myValue2.getVal());
        swap(myValue1, myValue2);
        System.out.println(myValue1.getVal() + " " + myValue2.getVal());

    }
}*/





/*//冒泡排序
public class lianxi {
    public static void bubbleSort(int[] array){
        boolean flg=false;//标记
        for(int i=0;i<array.length-1;i++){
            flg=false;
            for(int j=0;j<array.length-i-1;j++){
                int tmp;
                if(array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flg=true;
                }
            }
            if(flg==false){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] array={4,2,6,7,9,8,1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}*/
