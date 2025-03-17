package com.hnjee.section01.array;

import java.util.Arrays;

//문제 01. 배열 정렬하기
public class Solution01 {
    public static int[] solution(int[] arr){
        Arrays.sort(arr); //원본 배열 자체를 정렬함
        //int[] clonedArr = arr.clone(); //배열 복사 메서드
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
    }
}
