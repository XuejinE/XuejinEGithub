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
          System.out.println("下标不合法"); 
          return false;
      }
      return true;
    }

    public int getLength() {
     int count=0;
     Node cur=this.head;
     while(cur!=null){
         cur=cur.next;
        count++;
     }
     return count;
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
      Node node=new Node(data);
      node.next=cur.next;
      cur.next=node;
    }

    public Node searchPrev(int index) {
     Node cur=this.head;
     int count=0;
     while(count<index-1){
         cur=cur.next;
         count++;
     }
     return cur;
    }

    public void diaPlay(){
      Node cur=this.head;
      while(cur!=null){

          System.out.print(cur.data+" ");
          cur=cur.next;
      }
  }
}