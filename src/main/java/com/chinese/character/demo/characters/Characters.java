package com.chinese.character.demo.characters;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Characters {
    private static String[] characters = new String[]{
            //"的","一","是","了","不",
           // "在","有","人",
            "上","两",};
//            "这","大","我","国","来","们","和","个","他","中",
//            "说","到","地","为","以","子","小","就","时","全",
//            "可","下","要","十","生","会","也","出","年","得",
//            "你","主","用","那","道","学","工","多","去","发",
//            "作","自","好","过","动","对","行","里","能","二",
//            "天","三","同","成","活","太","事","面","民","日",
//            "家","方","后","都","于","之","分","经","种","还",
//            "看","产","所","起","把","进","前","着","没","而",
//            "样","部","长","又","问","法","从","本","定","见"};

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
