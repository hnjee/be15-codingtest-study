package com.hnjee.section02.stack;

import java.util.Stack;

//문제 13. 크레인 인형뽑기 게임
class Solution13 {
    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves){
            for(int i=0; i<board.length; i++){
                if(board[i][move-1]!=0) {
                    int doll = board[i][move-1];
                    if(!stack.isEmpty() && stack.peek()==doll){
                        stack.pop();
                        answer+=2;
                    } else{
                        stack.push(doll);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
    }
}