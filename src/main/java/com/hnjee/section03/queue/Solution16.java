package com.hnjee.section03.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;

// 문제 16. 기능 개발
public class Solution16 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            queue.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            int cnt = 1;
            while(!queue.isEmpty() && queue.peek()<=x){
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
