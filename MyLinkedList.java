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
         System.out.print(cur.data+" ");
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

   /* public boolean contains(int key){

    }*/
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

    //清空链表
    public void clear(){
        this.head=null;
    }

    //翻转链表
    public Node reverseList(){
        Node newHead=null;//新链表的头节点
        Node cur=this.head;//当前需要翻转的节点
        Node prev=null;//当前需要翻转节点的前驱
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null) {
                newHead = cur;
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

    public Node middleNode(){
        Node fast=this.head.next;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
        }
        return slow;
    }
    public Node findKthToTail(int k){
        if(k<=0||this.head==null){
            return null;
        }
        Node fast=this.head;
        Node slow=this.head;

        while(k-1>0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else{
                System.out.println("K值过大");
                return null;
            }

        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public Node partition(int x) {
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {

            if (cur.data < x) {
                if (bs == null) {
                    //第一次插入(尾插）
                   bs=cur;
                   be=bs;
                } else {
                    be.next=cur;
                    be=cur;
                }

            } else {
                if (as == null) {
                    //第一次插入（尾插
                     as=cur;
                     ae=as;
                } else {
                    ae.next=cur;
                    ae=cur;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }
    public Node deleteDuplication(){
        Node newHead=new Node(-1);
        Node tmp=newHead;
        Node cur=this.head;
        while(cur!=null){
            if(cur.next!=null && cur.data==cur.next.data){
                while(cur.next!=null && cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp.next=cur;
                tmp=cur;
                cur=cur.next;
            }
        }
        tmp.next=null;
        return newHead.next;
    }


    //判断是否是回文结构
    public boolean chkPalindrome() {
        if (this.head == null) {
            return false;
        }
        if (this.head.next == null) {
            return true;
        }
        //找到中间节点
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }


        //2，翻转

        Node cur=slow.next;
        while(cur!=null){
        Node curNext=cur.next;
        cur.next=slow;
        slow=cur;
        cur=curNext;
        }


        //3.判断data是否相同：一个从前往后走，一个从后往后走，直到相遇的时候，--

        while(this.head!=slow){
            if(this.head.data==slow.data){
                return false;
            }
            this.head=this.head.next;
            slow=slow.next;
        }
        return true;
       }


}
