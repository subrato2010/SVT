package com.edifixio.soc.web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class TextAnalyzer {
    private static final int BUFFER_LINE_COUNT = 10;
    private static final String DELIM_STR = "., ;\t";
    private static TextAnalyzer instance = new TextAnalyzer();
    private HashMap stopWordMap = new HashMap();
    private HashMap positiveWordMap = new HashMap();
    private HashMap negativeWordMap = new HashMap();
    private Object valueObj = new Object();
    
    private String positiveWord;
    private String negativeWord;
    


    private TextAnalyzer() {
        InputStream stopWordStream = TextAnalyzer.class
                .getResourceAsStream("props/stopwords.txt");
        loadWords(stopWordStream, stopWordMap);
        InputStream positiveWordStream = TextAnalyzer.class
                .getResourceAsStream("props/positives.txt");
        loadWords(positiveWordStream, positiveWordMap);
        InputStream negativeWordStream = TextAnalyzer.class
                .getResourceAsStream("props/negatives.txt");
        loadWords(negativeWordStream, negativeWordMap);
    }


    public static TextAnalyzer getInstance() {
        return instance;
    }


    private void loadWords(InputStream instream, HashMap map) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(instream));
            String currentLine = null;
            while ((currentLine = br.readLine()) != null) {
                currentLine = currentLine.trim();
                if (currentLine.length() > 0) {
                    map.put(currentLine.toLowerCase(), valueObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception exp) {
                }
            }
        }
    }


    public int getScore(String txt) {
        StringTokenizer tokenizer = new StringTokenizer(txt, DELIM_STR, false);
        String currentToken = null;
        int score = 0;
        while (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken().toLowerCase().trim();
            //currentToken = currentToken.toLowerCase().trim();
            if (stopWordMap.get(currentToken) == null) {
                if (positiveWordMap.get(currentToken) != null) {
                    score++;
                    setPositiveWord(currentToken);
                } else if (negativeWordMap.get(currentToken) != null) {
                    score--;
                    setNegativeWord(currentToken);
                }
                //System.out.println(currentToken + " " + score);
            }
        }
        return score;
    }


    public String getPositiveWord() {
        return positiveWord;
    }


    public void setPositiveWord(String positiveWord) {
        this.positiveWord = positiveWord;
    }


    public String getNegativeWord() {
        return negativeWord;
    }


    public void setNegativeWord(String negativeWord) {
        this.negativeWord = negativeWord;
    }
}
