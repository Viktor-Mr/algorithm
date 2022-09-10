package leetcode.editor.cn;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 264 👎 0


//decode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * <p>
 * ListNode next = null;
 * <p>
 * ListNode(int x) {
 * val = x;
 * }
 * }
 */
class Solution1 {
    public int[] reversePrint(ListNode head) {

        if(head == null ){
            return  new int[]{};
        }
        if(head.next == null){
            int c =  head.val ;
            return  new int[]{c};
        }

        int[]ans = new int[10000];

        int i = 0;
        while (head.next != null && head != null) {
            ans[i++] = head.val;
            head = head.next;
        }
        ans[i++] = head.val;
        int[] ans2 = new int[i];
        int j = 0;
        while ( i > 0) {
            ans2[j++] = ans[--i];
        }
        return ans2;
    }
}


class Solution2 {
    /**
     * 不使用栈，就不使用递归，反正怎么样也是扫描两趟，为什么要额外分配空间呢
     */
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while( head != null){
            count++;
            head = head.next;
        }

        int  []ans = new int[count];
        while (node != null) {
            ans[count--] = node.val;
            node = node.next;
        }
        return  ans;
    }
}

//decode submit region end(Prohibit modification and deletion)

 class ListNode {
    int val;

    ListNode next = null;

    ListNode(int x) {
        val = x;
    }
}
