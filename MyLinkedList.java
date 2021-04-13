
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
    }
}
public class MyLinkedList {
    //头插法
    public Node head;//标识单链表得头节点

    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    public void disPlay() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入
    public boolean checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            System.out.println("下标错误！");
            return false;
        }
        return true;
    }

    public void addLast(int data, int index) {
        if (!checkIndex(index)) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == this.getLength()) {
            addLast(data);
        }
        Node node = new Node(data);
        Node cur = searchPrev(index);
        node.next = cur.next;
        cur.next = node;
    }

    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur=cur.next;
        }
        return count;
    }
    public Node searchPrev(int index) {
        Node cur=searchPrev(index);
        int count=0;
        while(count<index-1){
            cur=cur.next;
           count++;
    }
        return cur;

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
        if(this.head.data==key){
            this.head=this.head.next;
        }
        Node cur=searchPrev(key);
        if(cur==null){
            System.out.println("没有要删除的节点");
            return;
        }
        Node del=cur.next;
        cur.next=del.next;

}
//查找是否包含关键字KEY是否在单链表当中
public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
}

//删除所有值为key的节点
public void removeAllKey(int key){
        if(this.head==null) return;
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
}


  //逆置一个单链表
public Node reverseList(){
        Node newHead=null;
        Node cur=this.head;
        Node prev=null;
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
}
public void disPlay2(Node newHead){
        Node cur=newHead;
        while(cur!=null){
            System.out.println(cur.data+" ");
            cur=cur.next;
        }
    System.out.println();

}


//给定一个带有头节点head的非空单链表，返回链表的中间节点，如果有两个
    //中间节点，则返回第二个中间节点
    





}


/*
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
    }
}
public class MyLinkedList {
    //头插法
    public Node head;//标识单链表得头节点
     public void addFirst(int data){
         Node node=new Node(data);
         node.next=this.head;
         this.head=node;
     }
     public void disPlay(){
         Node cur=this.head;
         while(cur!=null){
             System.out.println(cur.data+" ");
             cur=cur.next;
         }
     }
}
*/
