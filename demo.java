public class demo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);

        myLinkedList.disPlay();
        System.out.println();
      /*  myLinkedList.removeAllKey(2);
        myLinkedList.disPlay();
Node newHead=myLinkedList.reverseList();
myLinkedList.disPlay2(newHead);
Node ret=myLinkedList.FindKthToTail(1);
        System.out.println(ret.data);*/
Node newHead=myLinkedList.deleteDuplication(3);
        myLinkedList.disPlay2(newHead);
    }
}
