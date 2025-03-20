package com.hnjee.section01.array;

import java.util.Arrays;
import java.util.TreeSet;

//문제 05. 행렬의 곱
//행렬의 곱의 연산 원리를 파악한 후 -> 이를 코드로 구현하는 것이 핵심
//answer[i][j] += arr1의 i행 요소 * arr2의 j행 요소
//                -> (arr1[i][k] * arr2[k][j])
public class Solution05 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y = arr2[0].length;
        int z = arr2.length;
        int[][] answer = new int[x][y];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                for(int k=0; k<z; k++){
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        return answer;
    }
}
