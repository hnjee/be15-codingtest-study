package com.hnjee.section01.array;

import java.util.Arrays;
import java.util.TreeSet;

//문제 03. 두 개 뽑아서 더하기
public class Solution03 {
    public static int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        return set.stream().mapToInt(x->x).toArray();
//        int[] answer = new int[set.size()];
//        for(int i=0; i<answer.length; i++){
//            answer[i]=set.pollFirst();
//        }
//        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
    }
}
