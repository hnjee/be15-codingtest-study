package com.hnjee.section03.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

// 문제 17. 카드 뭉치
public class Solution17 {
    //1. Queue로 풀기
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> queue1 = new ArrayDeque<>();
        ArrayDeque<String> queue2 = new ArrayDeque<>();
        for(String str : cards1) queue1.add(str);
        for(String str : cards2) queue2.add(str);
        //아래와 같이 한번에 선언+생성+초기화도 가능
        //ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));

        for(String str : goal){
            if(!queue1.isEmpty() && str.equals(queue1.peek())){
                queue1.poll();
            } else if(!queue2.isEmpty() && str.equals(queue2.peek())){
                queue2.poll();
            } else return "No";
        }
        return "Yes";
    }
    //2. 배열 index 접근으로 풀기
    // 큐에서 빼고 넣는 요소의 내용이 중요하지 않기 때문에 index만 사용해서 풀 수 있음 
    public String solution2(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for(String str : goal){
            if(index1<cards1.length && str.equals(cards1[index1])){
                index1++;
            } else if(index2<cards2.length && str.equals(cards2[index2])){
                index2++;
            } else return "No";
        }
        return "Yes";
    }
}
