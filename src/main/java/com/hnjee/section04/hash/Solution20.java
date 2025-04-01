package com.hnjee.section04.hash;

import java.util.HashMap;

// 문제 20. 할인 행사
public class Solution20 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        //discount 배열 0부터 discount.length-9까지 확인
        for(int i=0; i<discount.length-9; i++){
            //map 초기화
            for(int x=0; x<want.length; x++){
                map.put(want[x], number[x]);
            }
            //i부터 i+9까지의 물품에 원하는게 모두 있는지 확인
            boolean check = true;
            for(int j=i; j<i+10; j++){
                String product = discount[j];
                if(map.getOrDefault(product, 0)==0) {
                    check=false;
                    break;
                }
                map.put(product, map.get(product)-1);
            }
            if(check) answer++;
        }
        return answer;
    }
}

