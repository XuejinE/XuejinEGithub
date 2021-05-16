public class demo{
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
       myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
       // myLinkedList.diaPlay();
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        //myLinkedList.diaPlay();
        myLinkedList.addIndex(2,3);
        myLinkedList.diaPlay();
    }
}