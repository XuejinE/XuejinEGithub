package heap;

public class MyPriorityQueue {
    private Integer[] array;
    private int size;
    public MyPriorityQueue(){
        //简单起见，不考虑扩容
        array=new Integer[100];
        size=0;
    }
    public Integer element(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        return array[0];
    }
    public Integer remove(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        int e=array[0];
        array[0]=array[size-1];
        size--;
        adjustDown(0);
        return e;
    }

    private void adjustDown(int index) {
        while(true){
            int leftIndex=index*2+1;
            if(leftIndex>=size){
                return;
            }
            int rightIndex=leftIndex+1;
            int minIndex=leftIndex;
            if(rightIndex<size&&array[rightIndex]<array[leftIndex]){
                minIndex=rightIndex;
            }
            if(array[index]<=array[minIndex]){
                return;
            }
            int t=array[index];
            array[index]=array[minIndex];
            array[minIndex]=t;
            index=minIndex;
        }
    }
}
