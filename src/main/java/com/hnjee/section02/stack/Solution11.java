package com.hnjee.section02.stack;

import java.util.Stack;

//문제 11. 짝지어 제거하기
class Solution11 {
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if(stack.peek()==ch) stack.pop();
            else stack.push(ch);
        }
        return (stack.isEmpty()) ? 1 : 0;
    }
}