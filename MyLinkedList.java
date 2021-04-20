
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
            cur = cur.next;
        }
        return count;
    }

    public Node searchPrev(int index) {
        Node cur = searchPrev(index);
        int count = 0;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;

    }

    //删除某个关键字为key的节点
    public Node searchPrevNode(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(int key) {
        if (this.head == null) return;
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        Node cur = searchPrev(key);
        if (cur == null) {
            System.out.println("没有要删除的节点");
            return;
        }
        Node del = cur.next;
        cur.next = del.next;

    }

    //查找是否包含关键字KEY是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) return;
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }
    //清空链表，回收内存
    public void clear(){
        this.head=null;
    }


    //逆置一个单链表
    public Node reverseList() {
        Node newHead = null;
        Node cur = this.head;
        Node prev = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void disPlay2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();

    }


    //给定一个带有头节点head的非空单链表，返回链表的中间节点，如果有两个
    //中间节点，则返回第二个中间节点
    public Node middleNode() {
        Node fast = this.head.next;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个节点
    public Node FindKthToTail(int k) {
        if (this.head == null || k <= 0) {
            return null;
        }
        Node fast = null;
        Node slow = null;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("您输入的k值过大");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的节点排在大于或等于x的节点之前
    public Node partition(int x) {
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = bs;
                } else {
                    be.next = cur;
                    be = cur;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = as;
                } else {
                    ae.next = cur;
                    ae = cur;
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

    //在一个排序的链表中，存在重复的节点，请删除该链表中重复的节点，重复的节点
// 不保留，返回链表头指针
public Node deleteDuplication(int x){
        Node newHead=new Node(-1);
        Node cur=this.head;
        Node tmp=newHead;
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


//链表的回文结构{
public boolean chkPalindrome(){
if(this.head==null){
    return false;
}
if(this.head.next==null){
    return true;
}
//找到中间节点
    Node fast=this.head;
    Node slow=this.head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
    }

    //  翻转
    Node cur=slow.next;
    while(cur!=null){
        Node curNext=cur.next;
        cur.next=slow;
        slow=cur;
        cur=curNext;
    }
    //3.判断data是否相同，一个从前往后走，一个从后往前走，直到相遇的时候
    while(this.head!=slow){

        //为了偶数节点来实现的
        if(this.head.data==slow.data){
            return false;
        }
        this.head=this.head.next;
        slow=slow.next;    }
    return true;
}

//判断链表是否有环
/*public boolean hasCycle(){
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }

        }
    return false;
}*/

//判断是否有环，第二种方法
public boolean hasCycle2(){
    Node fast=this.head;
    Node slow=this.head;
    while(fast!=null && fast.next!=null){
        fast=fast.next;
        slow=slow.next;
        if(fast==slow){
           break;
        }

    }
    //有两种情况
    if(fast==null || fast.next==null){
        return false;
    }
    return true;
}



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
