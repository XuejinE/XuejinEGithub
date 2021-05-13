class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data=data;

    }
}

public class MyLinkedList{
    public Node head;
  public void addFirst(int data){
      Node node=new Node(data);
      node.next=this.head;
      this.head=node;
  }

  public void addLast(int data){
      Node node=new Node(data);
      if(this.head==null){
          this.head=node;
      }else{
          Node cur=this.head;
      while(cur.next!=null){
         cur=cur.next;
     }
         cur.next=node;
     }
  }

  //任意位置查插入
 public boolean checkIndex(int index){
      if(index<0 || index>getLength()){
          return false;
      }
      return true;
 }

    public int getLength() {
      Node cur=this.head;
      int count=0;
      while(cur!=null){
          count++;
          cur=cur.next;
      }
      return count;
    }
    public Node searchPrev(int index){
      int count=0;
      Node cur=this.head;
      while(count<index-1){
          cur=cur.next;
          count++;
      }
      return cur;
    }
    public void addIndex(int index,int data){
      if(!checkIndex(index)){
          return;
      }
      if(index==0){
          addFirst(data);
          return;
      }
      if(index==this.getLength()){
          addLast(data);
          return;
      }
      Node cur=searchPrev(index);
      Node node =new Node(data);
      node.next=cur.next;
      cur.next=node;
    }

    //删除链表中出现的12
   public void deleteNode(int data,int key){

      Node cur=searchPrev(key);
     if(this.head==null) return;
     while(cur.data==key) {
         if (cur.next!= null) {


         }else{
           this.head=this.head.next;
     }
            cur=cur.next;

     }
   }

    public void diaPlay(){
      Node cur=this.head;
      while(cur!=null){

          System.out.print(cur.data+" ");
          cur=cur.next;
      }
  }
}