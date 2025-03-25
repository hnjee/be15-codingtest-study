package com.hnjee.section02.stack;

import java.util.Stack;

//문제 12. 주식 가격
//스택에 객체 넣어서 사용하기
class Solution12 {
    private class Node { //주식 클래스
        int index;
        int price;
        Node(int i, int p){
            this.index = i;
            this.price = p;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<prices.length; i++){
            int nowPrice = prices[i];
            while(!stack.isEmpty() && nowPrice<stack.peek().price){ //주가 하락 상황
                Node node = stack.pop(); //가격이 떨어진 주식들은 스택에서 꺼내기
                answer[node.index] = i-node.index; //초 계산
            }
            stack.push(new Node(i, nowPrice)); //현재 주식을 스택에 넣기
        }
        while(!stack.isEmpty()){ //끝까지 가격이 떨어지지 않은 주식들 초 계산
            Node node = stack.pop();
            answer[node.index] = prices.length-node.index-1;
        }
        return answer;
    }
}