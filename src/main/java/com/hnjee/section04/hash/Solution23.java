package com.hnjee.section04.hash;

import java.util.ArrayList;
import java.util.HashMap;

// 문제 23. 신고 결과 받기
class Solution23 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> reported_reporter_map = new HashMap<>();
        HashMap<String, Integer> reporter_email_cnt_map = new HashMap<>();

        //신고당한사람-신고자들 세팅
        for(String str : report){
            String[] arr = str.split(" ");
            String reporter = arr[0];
            String reported = arr[1];

            if(!reported_reporter_map.containsKey(reported)){ //신고 받은 적 없는 경우 신고자 리스트 생성
                reported_reporter_map.put(reported, new ArrayList<String>());
            }
            if(!reported_reporter_map.get(reported).contains(reporter)) { //신고자 넣기
                reported_reporter_map.get(reported).add(reporter);
            }
        }

        //k번 이상 신고당해 정지된 사람의 경우, 신고자들에게 이메일 보냄
        for(String reported : reported_reporter_map.keySet()){
            ArrayList<String> repoters = reported_reporter_map.get(reported);
            if(repoters.size()>=k){
                //이메일 보내기
                for(String repoter : repoters){
                    reporter_email_cnt_map.put(repoter, reporter_email_cnt_map.getOrDefault(repoter, 0)+1);
                }
            }
        }

        //신고자 이메일 받은 횟수 answer 배열에 넣기
        for(int i=0; i<id_list.length; i++){
            answer[i] = reporter_email_cnt_map.getOrDefault(id_list[i],0);
        }
        return answer;
    }
}