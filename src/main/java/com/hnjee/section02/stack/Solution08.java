package com.hnjee.section02.stack;

import java.util.Stack;

//문제 08. 올바른 괄호
class Solution08 {
    //1. Stack 사용
    // stack은 First In First Out
    // '(' 일 때 push하고 ')'일 때 pop 해서 짝 맞추기
    boolean solution(String s) {
        Stack<Character>stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()) return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
    //2. int 변수 사용
    // '(' 일 때 +1하고 ')'일 때 -1 해서 짝 맞추기
    boolean solution_2(String s) {
        int stack = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack++;
                continue;
            }
            if(stack==0) return false;
            stack--;
        }
        return stack==0;
    }
}