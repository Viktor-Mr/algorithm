package leetcode.editor.cn;////定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
////
//// 
////
//// 示例: 
////
//// 输入: 1->2->3->4->5->NULL
////输出: 5->4->3->2->1->NULL 
////
//// 
////
//// 限制： 
////
//// 0 <= 节点个数 <= 5000 
////
//// 
////
//// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
//// Related Topics 递归 链表 👍 408 👎 0
//


//decode submit region begin(Prohibit modification and deletion)


import leetcode.editor.cn.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * @date  迭代法
 */
class Offer24_01 {
    public ListNode reverseList(ListNode head) {
        // if 头结点为空||头结点的下一个节点为空  ？ 直接返回:
        if(head == null ){
            return  head;
        }
        if(head.next == null){
            return  head;
        }
        //头结点不存放数据
        ListNode headAns = new ListNode(0);


        ListNode listNode;

        while (head != null) {
            //不断插入在头结点后面

             listNode = new ListNode(head.val);
             listNode.next = headAns.next;
             headAns.next = listNode;

             head = head.next;
        }
        return headAns.next;
    }
}

/**
 * @date  递归法
 */
class Offer24_02 {
    public ListNode reverseList(ListNode head) {
        // if 头结点为空||头结点的下一个节点为空  ？ 直接返回:
        if(head == null ||head.next == null ){
            return  head;
        }
        ListNode node =  reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
//decode submit region end(Prohibit modification and deletion)
