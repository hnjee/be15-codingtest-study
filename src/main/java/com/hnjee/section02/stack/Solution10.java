package com.hnjee.section02.stack;

import java.util.HashMap;
import java.util.Stack;

//문제 10. 괄호 회전하기
// Stack으로 괄호 짝 확인하기
// 괄호 종류가 3가지 이므로 HashMap에 괄호 짝 넣어서 containsKey(), get() 사용
class Solution10 {
    static HashMap<Character, Character> map = new HashMap();
    private boolean checkStr(String str){
        Stack<Character> stack = new Stack();
        for(char ch : str.toCharArray()){
            if(map.containsKey(ch)){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()) return false;
            if(ch != map.get(stack.pop())) return false;
        }
        return stack.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i) + s.substring(0, i);
            if(checkStr(str)) answer++;
        }
        return answer;
    }
}