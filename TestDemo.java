import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-07-24
 * Time: 8:23
 */
public class TestDemo {


    public static boolean isSorted(int[] array) {
        if(array == null || array.length == 0) {
            return false;
        }
        //                        5
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] array) {
        long start = System.currentTimeMillis();
        boolean flg = false;//标记
        for (int i = 0; i < array.length-1; i++) {
            flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            /*if(flg==false){ break;}与下句等效*/
            if(!flg) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    //递归顺序/逆序打印数组
    //递归实现数组的逆置
    public static void reverse(int[] array) {
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void show(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] array4 = new int[2][];//不规则二维数组
        array4[0] = new int[]{1,2,3};
        array4[1] = new int[]{4,5};
        show(array4);
        System.out.println("==============");
        System.out.println(Arrays.deepToString(array4));


        /*int[][] array1 = {{1,2,3},{4,5,6}};
        System.out.println(array1[1][2]);
        show(array1);*/
        /*int[] array2 = {1,2,3,4,5};
        System.out.println(array2.length);*/
    }

    public static void main3(String[] args) {
        int[][] array1 = {{1,2,3},{4,5,6}};
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        int[][] array3 = new int[2][3];//默认都是0

        int[][] array4 = new int[2][];//不规则二维数组


    }

    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));

    }
    public static void main1(String[] args) {
        //int[] array = {11,2,31,14,5,61,17};
        int[] array = new int[10_0000];
        Random random = new Random();//随机数
        for (int i = 0; i < array.length; i++) {
            //array[i] = i;;
            array[i] = random.nextInt(10_0000);//[0,99999]
        }

        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }
}
