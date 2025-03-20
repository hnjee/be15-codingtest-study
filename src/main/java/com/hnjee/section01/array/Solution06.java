package com.hnjee.section01.array;

import java.util.*;

//문제 06. 실패율
//1. 구현 문제는 최대한 문제에서 요구하는 사항을 코드로 그대로 구현하는 것이 쉽고 빠름
//2. Class에 Comparable 구현해서 정렬
//3. 0으로 나눌 수 없는 예외처리 중요
public class Solution06 {
    class Stage implements Comparable<Stage>{
        private int stageNum;
        private double failRate;
        public Stage(int stageNum, double failRate){
            this.stageNum = stageNum;
            this.failRate = failRate;
        }
        @Override
        public int compareTo(Stage other){
            if(this.failRate==other.failRate) return Integer.compare(this.stageNum, other.stageNum);
            return Double.compare(other.failRate, this.failRate);
        }
    }
    public int[] solution(int N, int[] stages) {
        int totalUserCnt = stages.length;
        int[] usersInStage = new int[N+2];
        for(int i=0; i<totalUserCnt; i++) usersInStage[stages[i]]++;

        int nowUserCnt = totalUserCnt;
        Stage[] stageArr = new Stage[N];
        for(int i=0; i<N; i++){
            int stageNum = i+1;
            //0으로 나눌 수 없는 예외처리 중요! **
            double failRate = (nowUserCnt<1) ? 0 : usersInStage[stageNum]/(double)nowUserCnt;
            stageArr[i] = new Stage(stageNum, failRate);
            nowUserCnt-=usersInStage[stageNum];
        }

        Arrays.sort(stageArr);
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = stageArr[i].stageNum;
        }
        return answer;
    }
}
