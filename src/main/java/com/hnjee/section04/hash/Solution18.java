package com.hnjee.section04.hash;

import java.util.HashSet;

// 문제 18. 두 개의 수로 특정값 만들기
// HashSet 사용하기
public class Solution18 {
    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            if(target-i==i) continue;
            if(set.contains(target-i)) return true;
            set.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,8,4}, 12));
        System.out.println(solution(new int[] {1,2,3,8,7}, 6));
    }
}

