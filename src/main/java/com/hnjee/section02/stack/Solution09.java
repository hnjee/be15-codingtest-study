package com.hnjee.section02.stack;

import java.util.Stack;

//문제 09. 10진수를 2진수로 변환하기
class Solution09 {
    //1. Stack 사용
    static String solution(int num) {
        Stack<Integer> stack = new Stack<>();
        while(num>0){
            stack.push(num%2);
            num/=2;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0) sb.append(stack.pop());
        return sb.toString();
    }
    //2. StringBuilder의 insert() 사용
    static String solution_2(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0, num%2);
            num/=2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution_2(10));
        System.out.println(solution(12345));
        System.out.println(solution_2(12345));
    }
}