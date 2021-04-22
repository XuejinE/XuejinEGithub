 class ListNode{
        public int data;
        public ListNode next;
        public ListNode prev;

        public ListNode(int data) {
            this.data = data;
        }
    }
 public class RealLinkedList {
    public ListNode head;
    //头插法
     public void addFirst(int data){
       ListNode node=new ListNode(data);
       if(this.head==null){
           this.head=node;
       }else{
           node.next=this.head;
           this.head.prev=node;
           this.head=node;
       }
     }
}
