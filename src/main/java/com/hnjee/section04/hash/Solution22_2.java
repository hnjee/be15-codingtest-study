package com.hnjee.section04.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// 문제 22. 베스트 앨범
// class를 Genre와 Song으로 나눔
// HashMap<장르, 노래리스트>: HashMap<String, ArrayList<Song>> map
class Solution22_2 {
    class Genre implements Comparable<Genre>{
        String name;
        int plays;
        Genre(String name,  int plays){
            this.name = name;
            this.plays = plays;
        }
        @Override
        public int compareTo(Genre other){
            return Integer.compare(other.plays, this.plays);
        }
    }
    class Song implements Comparable<Song>{
        int number;
        int plays;
        Song(int number,  int plays){
            this.number = number;
            this.plays = plays;
        }
        @Override
        public int compareTo (Song other){
            if(other.plays == this.plays){
                return Integer.compare(this.number, other.number);
            } else{
                return Integer.compare(other.plays, this.plays);
            }
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> album = new ArrayList<>();
        int n = plays.length;
        int songMaxCnt = 2;
        HashMap<String, ArrayList<Song>> map = new HashMap<>();
        ArrayList<Genre> genreList = new ArrayList<>();

        //1. map에 장르-노래리스트 연결
        for(int i=0; i<n; i++){
            Song song = new Song(i, plays[i]);
            if(!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<Song>());
            }
            map.get(genres[i]).add(song);
        }

        //2. 장르 total_plays 구하기, 장르 내 노래 정렬
        for(String genre_name : map.keySet()){
            ArrayList<Song> songs = map.get(genre_name);
            int total_plays = 0;
            for(int i=0; i<songs.size(); i++){
                total_plays+=songs.get(i).plays;
            }
            genreList.add(new Genre(genre_name, total_plays));
            Collections.sort(songs); //장르 내 노래 정렬
        }
        //3. 장르 정렬
        Collections.sort(genreList);

        //4. 앨범에 노래 추가
        for(Genre genre : genreList){
            ArrayList<Song> songs = map.get(genre.name);
            int cnt = Math.min(songs.size(), songMaxCnt);
            for(int i=0; i<cnt; i++){
                album.add(songs.get(i).number);
            }
        }

        return album.stream().mapToInt(i->i).toArray();
    }
}