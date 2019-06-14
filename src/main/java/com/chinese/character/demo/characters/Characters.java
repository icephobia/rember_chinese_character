package com.chinese.character.demo.characters;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Characters {
    private static String[] characters = new String[]{
            "那","海","真","老","师","吗","同","什","才","亮","时","候",
            "觉","得","自","己","很","穿","衣","服","快","蓝","又","笑",
            "着","向","和","贝","娃","挂","活","金","哥","姐","弟","叔"};

    private static Random random = new Random();

    public static String getCharacter(int i){
       return characters[i];
    }

    public static int getLength(){
        return characters.length;
    }


    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();


        for(int i=0;i<100;i++){
            lists.add(random.nextInt(characters.length));
        }

        lists.sort(Integer::compareTo);

        lists.stream().forEach(e-> System.out.print(e+" , "));
    }
}
