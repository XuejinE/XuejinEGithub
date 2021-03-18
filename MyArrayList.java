import java.util.Arrays;


//实现顺序表的代码
/*public class MyArrayList {
    public int[] elem;//null
    public int usedSize;//0

    public MyArrayList() {
        this.elem = new int[5];
        this.usedSize = 0;
    }


    //在POS位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("该位置不合法");
            return;
        }

        //扩容
        if (this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {//this.usedSize指有效数据个数
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判断是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind){
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            return -1;
        }
        return this.elem[pos];
    }
    //给pos位置的元素设为value
    public void setPos(int pos,int value){
        if (pos < 0 || pos >= this.usedSize) {
            return;
        }
        this.elem[pos]=value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove){
    //找到是否有要删除位置的元素（toRemove）
        int index=search(toRemove);
      if(index==-1){
          System.out.println("没有该数字");
          return;
      }
      for(int i=index;i<this.usedSize-1;i++){
          this.elem[i]=this.elem[i+1];
      }
      this.usedSize--;


    }

    //获取顺序表的长度
    public int size(){
        return 0;
    }

    //清空顺序表
    *//*
    * 如果顺序表存放的是引用类型，*//*
    public void clear(){
        this.usedSize=0;
    }

    //打印顺序表
    public void disPlay(){
    for(int i=0;i<this.usedSize;i++){
        System.out.println(this.elem[i]+" ");
    }
        System.out.println();

    }
}*/
