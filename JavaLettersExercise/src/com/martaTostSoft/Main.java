package com.martaTostSoft;


import java.util.*;

public class Main {

    public static final char A = 'a';
    public static final char E = 'e';
    public static final char I = 'i';
    public static final char O = 'o';
    public static final char U = 'u';



    public static void main(String[] args) {
	    char[] name = {'M','a','r','t','a'};
	    char[] surname = {'T','o','s','t'};


        Phase1(name);
        List<Character> nameList = Phase2(name);
        Phase3(nameList);
        List<Character> fullName = Phase4(nameList,surname);
        System.out.println(fullName);
        nameList.clear();

    }


    protected static void Phase1 (char[] name){
        for (int i = 0; i < name.length ; i++) {
            System.out.println(name[i]);
        }
    }


    protected static List<Character> Phase2(char[] name){
        List<Character> nameList = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            if(LetterIsVowel(name[i])){
                System.out.println("VOCAL");
            }else {
                    if(Character.isLetter(name[i])){
                        System.out.println("CONSONANT");
                    }else{
                        System.out.println("Els noms de persones no contenen números!");
                        return nameList;
                    }
                }
            nameList.add(name[i]);
        }
        return nameList;
    }

    protected static boolean LetterIsVowel(char character){
        char characterInLowerCase = Character.toLowerCase(character);
        if((characterInLowerCase==A)||(characterInLowerCase==E)||(characterInLowerCase==I)||(characterInLowerCase==O)||(characterInLowerCase==U)) {
            return true;
        }else {
            return false;
        }
    }

    protected static void Phase3 (List<Character> nameList){
        Map<Character, Integer> nameMap = new HashMap<>();
        Set<Character> letters = nameMap.keySet();

        for(Character character: nameList){
            if (nameMap.putIfAbsent(character,1)!=null){
                Integer quantity = nameMap.get(character)+1;
                nameMap.put(character, quantity);
            }
        }
        System.out.println(nameMap);

    }

    protected static List<Character> Phase4(List<Character> nameList, char[] surname){

        List<Character> surnameList = Phase2(surname);
        List<Character> fullName = nameList;
        fullName.add(' ');
        fullName.addAll(surnameList);
        return fullName;
    }

}
