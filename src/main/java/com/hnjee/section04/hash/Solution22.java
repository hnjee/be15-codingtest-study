package com.hnjee.section04.hash;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

// 문제 22. 베스트 앨범
class Solution22 {
    class Song implements Comparable<Song>{
        String genre;
        int genrePlay;
        int songPlay;
        int number;
        Song(int number,  int songPlay, String genre, int genrePlay){
            this.number = number;
            this.genre = genre;
            this.genrePlay = genrePlay;
            this.songPlay = songPlay;
        }
        @Override
        public int compareTo (Song other){
            if(other.genre.equals(this.genre)){ //2 장르가 같으면
                if(other.songPlay == this.songPlay){ //3 장르도 노래 플레이수도 같으면
                    return Integer.compare(this.number, other.number); //3 노래 번호로 비교
                } else{
                    return Integer.compare(other.songPlay, this.songPlay); //2 노래 플레이수로 비교
                }
            } else { //1 장르가 다르면
                return Integer.compare(other.genrePlay, this.genrePlay); //1 장르 플레이수로 비교
            }
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> album = new ArrayList<>();
        int n = plays.length;
        Song[] songs = new Song[n];
        HashMap<String, Integer> genrePlaysMap = new HashMap<>();
        HashMap<String, Integer> genreCntMap = new HashMap<>();
        int songMaxCnt = 2;

        //1. genrePlaysMap: 장르별 play 총합 계산
        for(int i=0; i<n; i++){
            genrePlaysMap.put(genres[i], genrePlaysMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        //2. songs 배열에 song 넣기 -> 정렬 기준에 맞춰 정렬
        for(int i=0; i<n; i++){
            songs[i] = new Song(i, plays[i], genres[i], genrePlaysMap.get(genres[i]));
        }
        Arrays.sort(songs);

        //3. genreCntMap: 장르별 최대 노래 개수(2) 설정
        for(String key : genrePlaysMap.keySet()){
            genreCntMap.put(key, songMaxCnt);
        }
        //4. 앨범에 정렬 순서대로, 장르별 최대 개수에 맞게, 노래 넣기
        int index = 0;
        while(index<n){
            Song song = songs[index];
            if(genreCntMap.get(song.genre)>0) {
                album.add(song.number);
                genreCntMap.put(song.genre, genreCntMap.get(song.genre)-1);
            }
            index++;
        }
        return album.stream().mapToInt(i->i).toArray();
    }
}