package com.hnjee.section04.hash;

import java.util.ArrayList;
import java.util.HashMap;

// 문제 21. 오픈 채팅방
public class Solution21 {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> commands = new HashMap<>();
        HashMap<String, String> users = new HashMap<>();

        //1. command 세팅
        commands.put("Enter", "님이 들어왔습니다.");
        commands.put("Leave", "님이 나갔습니다.");
        //2. user 닉네임 세팅
        for(String str : record){
            String[] arr = str.split(" ");
            if(arr[0].equals("Leave")) continue;
            users.put(arr[1], arr[2]);
        }
        //3. answer 출력
        for(String str : record){
            String[] arr = str.split(" ");
            if(arr[0].equals("Change")) continue;
            answer.add(users.get(arr[1])+commands.get(arr[0]));
        }
        return answer.toArray(new String[0]);
    }
}

