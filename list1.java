class Node1{
    public int data;
    public Node1 next;

    public Node1(int data) {
        this.data = data;
    }
}

public class list1 {
    public Node head;
    public void addFirst(int index){
        Node node=new Node(index);
       node.next=this.head;
       this.head=node;
    }

    public void addLast(int index) {
        Node cur = this.head;
        Node node = new Node(index);
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public boolean checkIndex(int index){
    if(index<0 || index>this.getLength()){
        System.out.println("下标不合法");
        return false;
    }
    return true;
    }
    //任意位置插入，第一个数据节点为0 号下标
    public void addIndex(int index,int data){
        if(!checkIndex(index)){
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==getLength()){
            addLast(data);
            return;
        }
        Node cur=searchPrev(index);
        Node node=new Node(data);
        node.next=cur.next;
        cur.next=node;
    }
    public Node searchPrev(int index){
        Node cur=this.head;
        int count=0;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    public int getLength(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
    return count;
    }

   public void remove(int key){
   if(this.head==null) return;
   if(this.head.data==key){
       this.head=this.head.next;
       return;
   }
   Node cur=searchPrev(key);
   if(cur==null){
       System.out.println("没有你要删除的数字！");
       return;
   }
   Node del=cur.next;
   cur.next=del.next;
    }


    public void disPlay(){
        Node cur=this.head;
        while(cur!=null){
        System.out.println(cur.data+" ");
        cur=cur.next;
        }
}
