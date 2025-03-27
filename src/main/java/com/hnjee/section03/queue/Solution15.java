package com.hnjee.section03.queue;

import java.util.ArrayDeque;
import java.util.Queue;

// 문제 15. 요세푸스 문제
// Queue를 ArrayDeque()로 구현
// add() == addLast(), poll() == pollFirst()
public class Solution15 {
    public static int solution(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        //ArrayDeque<Integer> queue = new ArrayDeque<>(); //addLast(), pollFirst() 사용 가능
        for(int i=0; i<n; i++) queue.add(i+1);
        queue.add(1);
        while(queue.size()>1){
            for(int i=1; i<k; i++){
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 3));
    }
}
