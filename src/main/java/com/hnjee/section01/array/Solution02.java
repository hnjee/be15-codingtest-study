package com.hnjee.section01.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

//문제 02. 배열 제어하기
public class Solution02 {
    //풀이1: Arrays.stream() 사용
    public static int[] solution(int[] arr){
        Integer[] result = Arrays.stream(arr)   //배열을 스트림으로 변환
                .boxed()        //int를 Integer로 변환
                .distinct()     //중복 제거
                .toArray(Integer[]::new);   //다시 배열로 변환

        Arrays.sort(result, Collections.reverseOrder()); //내림차순 정렬

        // 다시 int 배열로 변환해서 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
    
    //풀이2: TreeSet 사용
    public static int[] solution2(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));

        System.out.println(Arrays.toString(solution2(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution2(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution2(new int[]{6, 1, 7})));
    }
}
