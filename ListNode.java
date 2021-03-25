/*public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    *//*//*/6.编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
给定一个链表的头指针 ListNode* pHead， // 请返回重新排列后的链表的头指针。注意：分割以
后保持原来的数据顺序不变。*//*
        public class Partition {
            public ListNode partition(ListNode pHead, int x) {
                if (pHead == null || pHead.next == null) {
                    return pHead;
                }
                ListNode cur = pHead;
                ListNode aHead = new ListNode(-1);
                ListNode bHead = new ListNode(-1);
                ListNode a = aHead;
                ListNode b = bHead;
                while (cur != null) {
                    if (cur.val < x) {
                        a.next = new ListNode(cur.val);
                        a = a.next;
                    } else {
                        b.next = new ListNode(cur.val);
                        b = b.next;
                    }
                    cur = cur.next;
                }
                cur = aHead;
                while (cur.next != null && cur.next.val != -1) {
                    cur = cur.next;
                }
                cur.next = bHead.next;
                return aHead.next;
            }

        }


    public static void main(String[] args) {


    }
}*/



/*    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode partition(ListNode pHead,int x) {
        //没有元素
        if(pHead==null){
            return null;
        }
        //只有一个元素
        if(pHead.next==null){
           return pHead;
        }
        //创建傀儡节点
        ListNode smallHead=new ListNode(-1);
        ListNode smallTail=smallHead;
        ListNode bijHead=new ListNode(-1);
        ListNode bigTail=bijHead;
        for(ListNode cur=pHead;cur!=null;cur=cur.next){
            if(cur.val<x){
                //插入到smallTail之后
                smallTail.next=new ListNode(cur.val);
                smallTail=smallTail.next;
            }else{
                //插入到bigtail之后
                bigTail=bigTail.next;
            }
        }
        smallTail.next=bijHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {

    }
}*/
