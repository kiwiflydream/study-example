/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author buhao
 * @version ValidParentheses.java, v 0.1 2020-09-24 18:57 buhao
 * @date 2020/09/24
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        test("()");
        test("()[]{}");
        test("(]");
        test("([)]");
        test("{[]}");
    }

    private static void test(String code) {
        System.out.println(code + " -> " + isValidParentheses(code));
    }


    /**
     * 是否有效的括号
     *
     * @param code 代码
     * @return boolean
     */
    private static boolean isValidParentheses(String code) {
        Stack<Character> stack = new Stack<>();
        final char[] chars = code.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '[':
                case '{':
                    stack.push(aChar);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                default:
            }
        }
        return stack.size() == 0;
    }

}