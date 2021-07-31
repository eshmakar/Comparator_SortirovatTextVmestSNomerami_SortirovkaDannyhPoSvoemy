package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    //СРАВНЕНИЕ С ПОМОЩЬЮ COMPARATOR
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        //если лист содержит цифры и слова
        list.add("24. one");list.add("3. two");list.add("256. three");list.add("0. six");list.add("5698. four");list.add("1. five");

        list.sort(new Compar());// передаем в качестве параметра sort объект класса Compar
        list.forEach(System.out::println);
    }
}

class Compar implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        int a = Integer.parseInt(o1.replaceFirst("(\\d+)(\\. .*)", "$1"));//получаем только цифры
        int b = Integer.parseInt(o2.replaceFirst("(\\d+)(\\. .*)", "$1"));
        return b-a;//обратная сортировка, если нужна обычная, то a-b
    }
}

//ДРУГОЙ ВАРИАНТ №2
//        List<String> list = Arrays.asList("24. one", "3. two", "256. three", "0. six", "5698. four", "1. five");
//
//        list.sort((o1, o2) ->
//                Integer.parseInt(o2.replaceFirst("(\\d+)(\\. .*)", "$1")) -
//                Integer.parseInt(o1.replaceFirst("(\\d+)(\\. .*)", "$1")));
//        list.forEach(System.out::println);



//ДРУГОЙ ВАРИАНТ №3
//        Stream.of("24. one", "3. two", "256. three", "0. six", "5698. four", "1. five")
//        .sorted(Comparator.comparingInt(Test::parse)).forEach(System.out::println);
//    }
//    public static int parse (String s){
//        return -Integer.parseInt(s.replaceFirst("(\\d+)(\\. .*)", "$1"));
//    }



/*OUTPUT:
5698. four
256. three
24. one
3. two
1. five
0. six
* */