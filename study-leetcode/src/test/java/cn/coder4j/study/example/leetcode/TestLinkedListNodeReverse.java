/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.leetcode;

import cn.coder4j.study.example.leetcode.model.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * @author buhao
 * @version TestLinkedListNodeReverse.java, v 0.1 2020-12-10 17:41 buhao
 */
public class TestLinkedListNodeReverse {

    private LinkedListNode head;

    @Before
    public void init() {
        final LinkedListNode n6 = new LinkedListNode(6, null);
        final LinkedListNode n5 = new LinkedListNode(5, n6);
        final LinkedListNode n4 = new LinkedListNode(4, n5);
        final LinkedListNode n3 = new LinkedListNode(3, n4);
        final LinkedListNode n2 = new LinkedListNode(2, n3);
        final LinkedListNode n1 = new LinkedListNode(1, n2);
        head = new LinkedListNode(-1, n1);
    }

    @Test
    public void testReverse() {
        LinkedListNode curr = head.getNext();
        LinkedListNode prev = null;
        LinkedListNode next = null;
        while (curr != null) {
            head.setNext(curr);
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        printLinkedList(head);
    }

    /**
     * 头插法
     */
    @Test
    public void testReverseWithHeadInsert() {
        // 创建一个新的链表头
        final LinkedListNode newHead = new LinkedListNode(-1, null);
        LinkedListNode curr = head.getNext();
        // 遍历老链表
        while (curr != null) {
            // 1. 先保存下一个结点，防止下步修改后，链表断了
            final LinkedListNode next = curr.getNext();
            // 2. 把新链表现在的结点，接到新结点后面
            curr.setNext(newHead.getNext());
            // 3. 把新节点插入头结点后
            newHead.setNext(curr);
            // 4. 老链表下移一位，接着遍历
            curr = next;
        }
        printLinkedList(newHead);
    }

    /**
     * 通过栈
     */
    @Test
    public void testReverseWithStack() {
        final Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode curr = head.getNext();
        while (curr != null) {
            stack.push(curr);
            curr = curr.getNext();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getVal());
        }
    }

    private void printLinkedList(LinkedListNode head) {
        if (head == null) {
            return;
        }
        LinkedListNode curr = head.getNext();
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }
    }
}