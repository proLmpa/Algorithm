package Deepen2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class bj_20920 {
    // 2) Stream.Collectors 사용
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> vocab = new HashMap<String, Integer>();

        while(N-- > 0){
            String word = br.readLine();

            if(word.length() < M) continue;

            if(vocab.containsKey(word)){
                int freq = vocab.get(word);
                vocab.put(word, freq+1);
            } else {
                vocab.put(word, 1);
            }
        }

        List<String> words = vocab.keySet().stream().collect(Collectors.toList());

        words.sort((o1, o2) -> {
           int c1 = vocab.get(o1);
           int c2 = vocab.get(o2);

           if(c1==c2){
               if(o1.length() == o2.length())
                   return o1.compareTo(o2); // 알파벳 순
               else
                   return o2.length()-o1.length();  // 길이 순
           }
           return c2-c1;    // 빈도 순
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
} // 836 ms

/* 
// 1) ArrayList 활용
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> vocab = new HashMap<>();

        while(N-- > 0) {
            String word = br.readLine();

            if(word.length() < M) continue;

            if(vocab.containsKey(word)){
                int freq = vocab.get(word);
                vocab.put(word, freq+1);
            } else {
                vocab.put(word, 1);
            }
        }

        List<String> words = new ArrayList<>(vocab.keySet());

        words.sort((k1, k2) -> {
            int v1 = vocab.get(k1);
            int v2 = vocab.get(k2);

            if(v1 == v2) {
                if(k1.length() == k2.length()){
                    return k1.compareTo(k2);
                }
                return k2.length() - k1.length();
            }
            return v2 - v1;
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}
 */ // 760 ms

/*
import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    int frequency;
    int wordLength;
    String word;

    Word(String word){
        this.word = word;
       wordLength = word.length();
       frequency = 1;
    }

    public void setFrequency() { this.frequency++; }

    @Override
    public int compareTo(Word w) {
        if(frequency < w.frequency)
            return 1;
        else if(frequency == w.frequency){
            if(wordLength == w.wordLength)
                return word.compareTo(w.word);
            else
                return w.wordLength - wordLength;
        }
        return -1;
    }
}

public class Main{
    static final char LF = '\n';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Word> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String name;
        Word w;

        while(N-- > 0){
            name = br.readLine();
            w = map.get(name);

            if(name.length() < M) continue;

            if(w == null)
                map.put(name, new Word(name));
            else
                w.setFrequency();
        }
        br.close();

        TreeSet<Word> set = new TreeSet<>(map.values());

        for (Word word : set) sb.append(word.word).append(LF);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
 */ // 652 ms