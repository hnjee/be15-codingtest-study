package com.hnjee.section01.array;

import java.util.Arrays;
import java.util.TreeSet;

//문제 04. 모의고사
public class Solution04 {
    public static int[] solution(int[] answers) {
        int[][] patterns = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] scores = new int[3];
        int max_score = 0;
        for(int i=0; i<3; i++){
            int[] pt = patterns[i];
            int len = pt.length;
            for(int j=0; j<answers.length; j++){
                if(pt[j%len]==answers[j]) scores[i]++;
            }
            if(scores[i]>max_score) max_score = scores[i];
        }
        TreeSet<Integer> set = new TreeSet();
        for(int i=0; i<3; i++){
            if(scores[i]==max_score) set.add(i+1);
        }
        return set.stream().mapToInt(x->x).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
    }
}
