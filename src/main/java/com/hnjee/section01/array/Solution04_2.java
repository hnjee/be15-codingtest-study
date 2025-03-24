package com.hnjee.section01.array;

import java.util.Arrays;
import java.util.ArrayList;

//문제 04. 모의고사 - 객체지향적으로 풀어보기
//Student 클래스 정의 -> compareTo(), scoring() 메서드 작성
class Solution04_2 {
    static class Student implements Comparable<Student>{
        int num;
        int[] pattern;
        int score;
        Student(int n, int[] p){
            this.num = n;
            this.pattern = p;
            score = 0;
        }
        @Override
        public int compareTo(Student other){
            if(this.score == other.score) return this.num - other.num;
            return other.score - this.score;
        }

        private int scoring(int[] answers){
            int score = 0;
            int len = this.pattern.length;
            for(int i=0; i<answers.length; i++){
                if(this.pattern[i%len]==answers[i]) score++;
            }
            return score;
        }
    }

    public static int[] solution(int[] answers) {
        int[][] patterns = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int totalStdNum = patterns.length;

        //학생 배열에 학생 객체 담기
        Student[] students = new Student[totalStdNum];
        for(int i=0; i<totalStdNum; i++){
            Student student = new Student(i+1, patterns[i]);
            student.score = student.scoring(answers); //채점
            students[i]=student;
        }
        Arrays.sort(students); //정렬

        //답안 배열 만들기
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(students[0].num);
        //동점자 처리
        int max_score = students[0].score;
        for(int i=1; i<totalStdNum; i++){
            if(students[i].score==max_score){
                answer.add(students[i].num);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}