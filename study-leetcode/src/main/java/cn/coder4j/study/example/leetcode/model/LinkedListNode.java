/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.leetcode.model;

/**
 * @author buhao
 * @version LinkedListNode.java, v 0.1 2020-03-19 21:23 buhao
 */

/**
 * 链表节点
 */
public class LinkedListNode {

    public LinkedListNode() {
    }

    public LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 保存数值
     */
    private int val;
    /**
     * 下一个节点
     */
    private LinkedListNode next;

    /**
     * Getter method for property <tt>val</tt>.
     *
     * @return property value of val
     */
    public int getVal() {
        return val;
    }

    /**
     * Setter method for property <tt>val</tt>.
     *
     * @param val value to be assigned to property val
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * Getter method for property <tt>next</tt>.
     *
     * @return property value of next
     */
    public LinkedListNode getNext() {
        return next;
    }

    /**
     * Setter method for property <tt>next</tt>.
     *
     * @param next value to be assigned to property next
     */
    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}