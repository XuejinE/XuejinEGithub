class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyLinkedList {
    public Node head;//标识单链表的头节点
   // public int usedSize;//成员变量
    //t头插法
    public void addFirst(int data){
        Node node=new Node(data);

       /* if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }*/
        node.next=this.head;
        this.head=node;
    }
     public void disPlay() {
     Node cur=this.head;
     while(cur!=null){
         System.out.println(cur.data+" ");
         cur=cur.next;
     }
    }
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            //第一次插入，使用尾插法
            this.head=node;
        }else{
            //不是第一次插入
            Node cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }


    public boolean checkIndex(int index){
        if(index<0 || index>getLength()){
            System.out.println("下标不合法!");
            return false;
        }
        return true;
    }
//任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(!checkIndex(index)){//if(checkIndex(index)==false)
            return;
        }
      if(index==0){
          addFirst(data);
          return;//一定要写
      }
      if(index==this.getLength()){
          addLast(data);
          return;
      }
      Node cur=searchPrev(index);
      //cur此时保存的就是index-1位置的节点的引用
      Node node=new Node(data);
      node.next=cur.next;
      cur.next=node;
    }
    /*查找index-1的位置，找到返回引用*/
    public Node searchPrev(int index){
     Node cur=this.head;
     int count=0;
     while(count<index-1){
         cur=cur.next;
         count++;

     }
     return cur;

    }

    public int getLength() {
       int count=0;
       Node cur=this.head;
       while(cur!=null){
           count++;
           cur=cur.next;
       }
       return count;
    }

    //删除某个关键字为key的节点
    public Node searchPrevNode(int key){
        Node cur=this.head;
        while(cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    public void remove(int key){
        if(this.head==null) return;
        //头节点是删除的节点
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
       Node cur=searchPrev(key);
        if(cur==null){
            System.out.println("没有你要删除的数字");
            return;
        }
        Node del=cur.next;//要删除的节点
        cur.next=del.next;
    }

    public boolean contains(int key){

    }
    public void removeAllKey(int key){

    }
}
