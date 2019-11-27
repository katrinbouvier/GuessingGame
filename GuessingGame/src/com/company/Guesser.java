package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guesser {

    //static Question question;
    private String numOfQuestion;
    Map <Integer, String> qMap;
    Path qPath;

    Guesser() {
        qPath = Paths.get("./src/creatures/animal_questions.txt");
        qMap = getQuestionSet(qPath);
    }

    String askQuestion() {
        Question question = getRandomQuestion(qMap);
        qMap.remove(question.getNumber()); // удаляем из
        System.out.println();
        numOfQuestion = question.getNumber().toString();// запоминаем номер заданого вопроса
        return question.getValue().toString();
    }

    public static String generateQuestion() {
        Path qPath;
        Map<Integer, String> qSet;
        qPath = Paths.get("./src/creatures/animal_questions.txt");
        qSet = getQuestionSet(qPath);
        return "";
                //getRandomQuestion(qSet);
    }

    void getAnswer(boolean answer) {
        Path aPath;
        Map<String, String> aSet;
        aPath = Paths.get("./src/creatures/animal_answers.txt");
        aSet = getAnswerSet(aPath);

//        for(Map.Entry<String, String> elem : aSet.entrySet()) {
//            for (String s : aSet.values().) {
//                if (s.equals((question.number).toString())) {
//
//                   // String rnd  = getRandomNumber(elem.getValue().split(","));
//                   // int numNewQuestion = Integer.valueOf(rnd);
//                }
//            }
        //}
    }

    boolean isGameOver() {
        return false;
    }

    private static <T, M> Map<T, M> getQuestionSet(Path path) {
        Map<T, M> set = new HashMap<>();
        List<String> lines;
        String[] arr;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (int i = 1; i < lines.size(); i++) {
                arr = lines.get(i).split("=");
                set.put((T)arr[0], (M)arr[1]);
            }
        } catch (IOException e) { e.printStackTrace(); }
        return set;
    }

    private static <T, M> Map<T, M> getAnswerSet(Path path) {
        Map<T, M> set = new HashMap<>();
        List<String> lines;
        String[] arr;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (int i = 1; i < lines.size(); i++) {
                arr = lines.get(i).split("=");
                set.put((T)arr[0], (M)(arr[1]).split(","));
            }
        } catch (IOException e) { e.printStackTrace(); }
        return set;
    }

    private static <T, M> Question getRandomQuestion(Map<T, M> set) {
        int size = set.size();
        int rdm = 1 + (int) (Math.random() * size);
        int i = 1;

        for (Map.Entry<T, M> elem : set.entrySet()) {
            if (i == rdm) {
               // Question question = new Question(elem.getKey(), elem.getValue());
//                System.out.println(question.getNumber());
//                System.out.println(question.getValue());
                return new Question(elem.getKey(), elem.getValue());
            }
            i++;
        }
        return null;
    }

    private static String getRandomNumber(String...set){
        int size = set.length;
        int rnd = 1+(int) (Math.random() * size);
        int i = 1;
        for (String elem : set) {
            if (i == rnd) {
                return elem;
            }
            i++;
        }
        return "";
    }

}
