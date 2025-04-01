package com.hnjee.section04.hash;

import java.util.HashMap;

// 문제 19. 완주하지 못한 선수
// 동명이인 처리가 핵심 -> HashMap에 <이름, 사람수> 저장
public class Solution19 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String c : completion){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(String p : participant){
            if(map.getOrDefault(p, 0)==0) return p;
            map.put(p, map.get(p)-1);
        }
        return "";
    }
}

