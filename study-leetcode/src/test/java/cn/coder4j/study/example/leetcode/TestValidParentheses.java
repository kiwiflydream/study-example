/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author buhao
 * @version TestValidParentheses.java, v 0.1 2020-09-24 19:48 buhao
 */
public class TestValidParentheses {

    /**
     * 断言测试
     *
     * @param code      代码
     * @param isSuccess 是否成功
     */
    private static void assertTest(String code, boolean isSuccess) {
        Assert.assertEquals(isValidParentheses(code), isSuccess);
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

            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (aChar == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (aChar == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                } else if (aChar == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        // 最后一个匹配不了直接报错
                    } else {
                        return false;
                    }
                }
            }

        }
        return stack.size() == 0;
    }

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

    @Test
    public void testValid() {
        assertTest("()", true);
        assertTest("()[]{}", true);
        assertTest("(]", false);
        assertTest("([)]", false);
        assertTest("{[]}", true);
        assertTest("({}[]]])", false);
    }
}