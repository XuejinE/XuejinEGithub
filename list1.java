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

    public 

    public void disPlay(){
        Node cur=this.head;
        while(cur!=null){
        System.out.println(cur.data+" ");
        cur=cur.next;
        }
}
