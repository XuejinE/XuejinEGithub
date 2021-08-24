package sort;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Arrays;

public class Sort {
public static void insertSort(long[] array){
    for(int i=0;i<array.length-1;i++){
        long key=array[i+1];
        int j;
        for(j=i;j>=0;j--){
            if(key<array[j]){
                array[j+1]=array[j];
            }else{
                break;
            }
        }
        array[j+1]=key;
    }
}
  public static void bubbleSort(long[] array){
  for(int i=0;i<array.length;i++){
       boolean isSorted=true;
       for(int j=0;j<array.length-i-1;j++){
           if(array[j]>array[j+1]){
               swap(array,j,j+1);
               isSorted=false;
           }
       }
       if(isSorted){
           break;
       }
  }
  }

    private static void swap(long[] array, int j, int i) {
      long t=array[i];
      array[i]=array[j];
      array[j]=t;
    }

public static void selectSort(long[] array){
    for(int i=0;i<array.length-1;i++){
        for(int j=0;j<array.length-i;j++){
            int maxIndex=0;
            if(array[maxIndex]<array[j]){
                maxIndex=j;
            }
            swap(array, maxIndex,array.length-i-1);

        }

    }
}
public static void heapSort(long[] array){
    //建大堆
    createHeap(array,array.length);
    //进行选择的过程，一共要array.length-1组
    for(int i=0;i<array.length-1;i++){
        swap(array,0,array.length-i-1);

    }

}

    private static void createHeap(long[] array, int length) {
    }

    public static void main(String[] args) {
        long[] array={4,2,5,2,7,8};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
