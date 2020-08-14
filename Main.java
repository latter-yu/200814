import java.util.*;

public class Main {

    public static boolean IsPopOrder(int[] pushA,int[] popA) {

        // 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
        // 假设压入栈的所有数字均不相等。例如序列 1, 2, 3, 4, 5 是某栈的压入顺序，
        // 序列 4, 5, 3, 2, 1 是该压栈序列对应的一个弹出序列，
        // 但 4, 3, 5, 1, 2 就不可能是该压栈序列的弹出序列。

        //【思路】借用一个辅助的栈，遍历压栈顺序，
        // 先讲第一个放入栈中，这里是 1，然后判断栈顶元素是不是出栈顺序的第一个元素，
        // 这里是 4，很显然 1 ≠ 4，所以我们继续压栈，直到相等以后开始出栈，
        // 出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，
        // 如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。

        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(push, pop));
    }

    public boolean Find(int target, int[][] array) {
        // 在一个二维数组中（每个一维数组的长度相同），
        // 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
        // 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数

        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length) {
            col = array[0].length - 1;
            while (col >= 0) {
                if (array[row][col] == target) {
                    return true;
                }
                col--;
            }
            row++;
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        // 请实现一个函数，将一个字符串中的每个空格替换成 “%20”。
        // 例如，当字符串为 We Are Happy.
        // 则经过替换之后的字符串为 We%20Are%20Happy。
        // WeAreHappy . => WeAreHappy%20

        StringBuffer sb = new StringBuffer();
        String strs = str.toString();
        char[] strChar = strs.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(strChar[i]);
            }
        }
        return sb.toString();
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        // 层序遍历
        // 从上往下打印出二叉树的每个节点，同层节点从左至右打印

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
        // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

        if (pre.length == 0) {
            return null;
        }
        int treeNode = pre[0];
        if(pre.length == 1){
            return new TreeNode(treeNode);
            // 需返回 TreeNode 类型
        }
        TreeNode root = new TreeNode(treeNode);
        // 找到左右子树的范围
        int cur = 0;
        for (int i = 0; i < pre.length; i++) {
            if (treeNode == in[i]) {
                cur = i;
                break;
            }
        }
        // Arrays.copyOfRange(int[],start,end)是[)的区间
        // 使用递归
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, cur + 1), Arrays.copyOfRange(in, 0, cur));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, cur + 1, pre.length), Arrays.copyOfRange(in, cur + 1, in.length));
        return root;
    }
}

class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
 }
class Test {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 输入一个链表，按链表从尾到头的顺序返回一个 ArrayList

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

