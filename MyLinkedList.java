public class MyLinkedList{
    public static void main(String[] args) {
        
    }
}


/*
class Node {
    public int data;
    public Node next;//默认为空

    public Node(int data) {
        this.data = data;
    }

    public class MyLinkedList {//单项不带头非循环列表
        public Node head;//标识头节点（单链表）

        //public int usedSize;成员变量可不写
        //头插法
        public void addFirst(int data) {
            Node node = new Node(data);
            node.next = this.head;
            this.head = node;

        }


    public void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.display();

    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
  }
}
*/



/*
class Node{
    public int data;
    public Node next;//默认为空

    public Node(int data) {
        this.data = data;
    }
public class MyLinkedList {
    //单向不带头非循环列表
    public Node head;//标识头节点（单链表）
    //public int usedSize;成员变量，可不写

    //直接插入，将head放前边，即头插法
    public  void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.println(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

        public static void main(String[] args) {
            MyLinkedList myLinkedList=new MyLinkedList();
            MyLinkedList.addFirst(1);
            MyLinkedList.addFirst(2);
            myLinkedList.display();
        }

    }
}
*/
