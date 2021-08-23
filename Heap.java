package heap;

public class Heap {
    //时间复杂度就是O(log(n))
    public static void adjustDown(int index,int[] array,int size) {
        while(true){
        //判断是不是叶子节点
        int leftIndex = 2 * index + 1;
        if (leftIndex >= size) {
            return;
        }
        //找出最小节点
        int minIndex = leftIndex;
        int rightIndex = leftIndex + 1;
        if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
            minIndex = rightIndex;
        }
        //比较最小节点和index的区别
        if (array[index]<=array[minIndex]) {
            return;
        }

        //交换
        int t = array[index];
        array[index]=array[minIndex];
        array[minIndex]=t;

        //把最小的孩子视为index，继续循环
            index=minIndex;


        }
    }
    //最坏的情况，不细算是O（n*log(n)
public static void createHeap(int[] array,int size,int index){
        //找到最后一个节点的下标
        int lastIndex=size-1;
        //找到最后一个父节点的下标
        int lastParentIndex=(lastIndex-1)/2;
        //在[0,lastParentIndex]向下调整
        for(int i=lastParentIndex;i>=0;i--){
            adjustDown(i,array,size);
        }
}
public static void adjustUp(int[] array,int size,int index){
        while(true){
            //判断index是不是树的根了，如果是根调整结束
            if(index==0){
                break;
            }
            //2.找到index的父节点
            int parentIndex=(index-1)/2;
            //比较父节点的值和index的值
            //只要父节点的值<=index的值，调整结束
            if(array[parentIndex]<=array[index]){
                break;
            }
            int t=array[index];
            array[index]=array[parentIndex];
            array[parentIndex]=t;
            index=parentIndex;
        }
}


}
