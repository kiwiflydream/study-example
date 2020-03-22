/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2020 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.leetcode;

import cn.coder4j.study.example.leetcode.model.LinkedListNode;

/**
 * @author buhao
 * @version LinkListMiddle.java, v 0.1 2020-03-19 21:11 buhao
 */
public class LinkedListMiddle {

    public static void main(String[] args) {
        LinkedListNode headNode = generatorLinkeListAndReturnHead(5);
        LinkedListNode slow = headNode;
        LinkedListNode fast = headNode;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        if (fast == null) {
            int secondMiddleNodeVal = slow.getVal();
            LinkedListNode firstMiddleNode = getPreNodeByNextVal(headNode, secondMiddleNodeVal);
            System.out.println("中间节点为：[" + firstMiddleNode.getVal() + "," + secondMiddleNodeVal + "]");
            return;
        }

        System.out.println("中间节点为：" + slow.getVal());
    }

    public static LinkedListNode getPreNodeByNextVal(LinkedListNode head, int nextVal) {
        LinkedListNode preNode = head;
        if (preNode == null) {
            return null;
        }
        while (true) {
            LinkedListNode next = preNode.getNext();
            if (next != null) {
                if (next.getVal() == nextVal) {
                    return preNode;
                }
                preNode = next;
            } else {
                return null;
            }
        }
    }

    public static LinkedListNode generatorLinkeListAndReturnHead(int length) {
        LinkedListNode head = new LinkedListNode();
        head.setVal(1);
        LinkedListNode preNode = head;
        for (int i = 2; i <= length; i++) {
            LinkedListNode curNode = new LinkedListNode();
            curNode.setVal(i);
            preNode.setNext(curNode);
            preNode = curNode;
        }
        return head;
    }


}