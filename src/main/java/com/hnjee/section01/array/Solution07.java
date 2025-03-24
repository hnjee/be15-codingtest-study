package com.hnjee.section01.array;
import java.util.ArrayList;

//문제 07. 방문 길이
// Dot, Route 클래스 정의 -> 적절한 메소드 정의
// 1) Dot 클래스: equals(), isOut(), calcNext()
// 2) Route 클래스: equals(), isFirst()
class Solution07 {
    static char[] dir_name = {'U', 'D', 'R', 'L'};
    static int[] dir_x = {0, 0, 1, -1};
    static int[] dir_y = {1, -1, 0, 0};
    static ArrayList<Route> routes = new ArrayList<>();
    class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x=x;
            this.y=y;
        }
        private boolean equals(Dot other){
            return (this.x==other.x) && (this.y==other.y);
        }
        private boolean isOut(){
            return this.x<-5 || this.x>5 || this.y<-5 || this.y>5;
        }
        private Dot calcNext(char dir){
            for(int j=0; j<4; j++){
                if(dir_name[j]==dir) {
                    return new Dot(this.x+dir_x[j], this.y+dir_y[j]);
                }
            }
            return this;
        }
    }
    class Route {
        Dot now;
        Dot next;
        Route(Dot now, Dot next){
            this.now = now;
            this.next = next;
        }
        private boolean equals(Route other){
            return (this.now.equals(other.now) && this.next.equals(other.next))
                    || (this.now.equals(other.next) && this.next.equals(other.now));
        }
        private boolean isFirst(){
            for(Route route : routes){
                if(route.equals(this)) return false;
            }
            return true;
        }
    }
    public int solution(String dirs) {
        Dot now = new Dot(0,0);
        for(char dir: dirs.toCharArray()){
            Dot next = now.calcNext(dir); //1. 다음 좌표 계산
            if(next==now || next.isOut()) continue; //2. 움직임이 없거나, 좌표평면 경계 넘어가면 무시
            Route nowRoute = new Route(now, next);
            if(nowRoute.isFirst()) routes.add(nowRoute); //3. 처음으로 지나는 경로인지 확인하고 routes에 추가
            now=next; //4. 이동
        }
        return routes.size();
    }
}
