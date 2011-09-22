package com.edifixio.soc.web.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwtStopWords {
    
    static List<String> TREND_STOP_WORDS = new ArrayList<String>();
    static List<String> POSITIVE_WORDS = new ArrayList<String>();
    static List<String> NEGATIVE_WORDS = new ArrayList<String>();
    
    static List<String> SE_STOP_WORDS = new ArrayList<String>();
    public static TwtStopWords instance = new TwtStopWords();
    
    static final List<String> stopWords = Arrays.asList(
            
            "a", "about", "above", "across", "adj", "after", "afterwards",
            "again", "against", "albeit", "all", "almost", "alone", "along",
            "already", "also", "although", "always", "am", "among", "amongst", "an",
            "and", "another", "any", "anyhow", "anyone", "anything",
            "anywhere", "are", "around", "as", "at", "be", "became", "because",
            "become", "becomes", "becoming", "been", "before", "beforehand",
            "behind", "being", "below", "beside", "besides", "between",
            "beyond", "both", "but", "by", "can", "cannot", "co", "could",
            "down", "during", "each", "eg", "either", "else", "elsewhere",
            "enough", "etc", "even", "ever", "every", "everyone", "everything",
            "everywhere", "except", "few", "first", "for", "former",
            "formerly", "from", "further", "had", "has", "have", "he", "hence",
            "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers",
            "herself", "him", "himself", "his", "how", "however", "hv", "i", "ie", "if",
            "in", "inc", "indeed", "into", "is", "it", "its", "itself", "last",
            "latter", "latterly", "least", "less", "ltd", "many", "may", "me",
            "meanwhile", "might", "more", "moreover", "most", "mostly", "much",
            "must", "my", "myself", "namely", "neither", "never",
            "nevertheless", "next", "no", "nobody", "none", "noone", "nor",
            "not", "nothing", "now", "nowhere", "of", "off", "often", "on",
            "once one", "only", "onto", "or", "other", "others", "otherwise",
            "our", "ours", "ourselves", "out", "over", "own", "per", "perhaps",
            "rather", "s", "same", "seem", "seemed", "seeming", "seems",
            "several", "she", "should", "since", "so", "some", "somehow",
            "someone", "something", "sometime", "sometimes", "somewhere",
            "still", "such", "t", "than", "that", "the", "their", "them",
            "themselves", "then", "thence", "there", "thereafter", "thereby",
            "therefor", "therein", "thereupon", "these", "they", "this",
            "those", "though", "through", "throughout", "thru", "thus", "to",
            "together", "too", "toward", "towards", "under", "until", "up",
            "upon", "us", "very", "via", "was", "we", "well", "were", "what",
            "whatever", "whatsoever", "when", "whence", "whenever",
            "whensoever", "where", "whereafter", "whereas", "whereat",
            "whereby", "wherefrom", "wherein", "whereinto", "whereof",
            "whereon", "whereto", "whereunto", "whereupon", "wherever",
            "wherewith", "whether", "which", "whichever", "whichsoever",
            "while", "whilst", "whither", "who", "whoever", "whole", "whom",
            "whomever", "whomsoever", "whose", "whosoever", "why", "will",
            "with", "within", "without", "would", "xsubj", "xcal", "xauthor",
            "xother ", "xnote", "yet", "you", "your", "yours", "yourself",
            "yourselves","1", "2","3", "4","5", "6","7", "8","9", "0",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
            "q","r","s","t","u","v","w","x","y","z",
            "?", "-", "_","rt","r2"
            
  );
    
    static
    {
        try
        {
            InputStream stopWordStream = TwtStopWords.class.getResourceAsStream("/com/edifixio/soc/web/util/props/stopwords.txt");
            loadWords(stopWordStream, TREND_STOP_WORDS);
        
            InputStream positiveWordStream = TwtStopWords.class.getResourceAsStream("/com/edifixio/soc/web/util/props/positives.txt");
            loadWords(positiveWordStream, TREND_STOP_WORDS);
        
            InputStream negativeWordStream = TwtStopWords.class.getResourceAsStream("/com/edifixio/soc/web/util/props/negatives.txt");
            loadWords(negativeWordStream, TREND_STOP_WORDS);
            
            InputStream positiveWordStream1 = TwtStopWords.class.getResourceAsStream("/com/edifixio/soc/web/util/props/positives.txt");
            loadPositiveWords(positiveWordStream1, POSITIVE_WORDS);
            
            InputStream negativeWordStream1 = TwtStopWords.class.getResourceAsStream("/com/edifixio/soc/web/util/props/negatives.txt");
            loadNegativeWords(negativeWordStream1, NEGATIVE_WORDS);
            
            TREND_STOP_WORDS.addAll(stopWords);
            
        }catch(Exception e)
        {
            System.out.println("TwtStoWordserror :"+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void loadWords(InputStream stopWordStream, List<String> stopWordList) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(stopWordStream));
        String currentLine = null;
        
        while ((currentLine = br.readLine()) != null) {
            currentLine = currentLine.trim();
            if (currentLine.length() > 0) {
                stopWordList.add(currentLine.toLowerCase());
            }
        }
    }
    
    public static void loadPositiveWords(InputStream positiveWordStream, List<String> positiveWordList) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(positiveWordStream));
        String currentLine = null;
        
        while ((currentLine = br.readLine()) != null) {
            currentLine = currentLine.trim();
            if (currentLine.length() > 0) {
                positiveWordList.add(currentLine.toLowerCase());
            }
        }
    }
    
    public static void loadNegativeWords(InputStream negativeWordStream, List<String> negativeList) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(negativeWordStream));
        String currentLine = null;
        
        while ((currentLine = br.readLine()) != null) {
            currentLine = currentLine.trim();
            if (currentLine.length() > 0) {
                negativeList.add(currentLine.toLowerCase());
            }
        }
    }
    public List<String> getOnlyPositiveWordList()    {
        return POSITIVE_WORDS;
    }
    
    public List<String> getOnlyNegativeWordList() {
        return NEGATIVE_WORDS;
    }
    
    public List<String> getAllStopWords()  {
        return TREND_STOP_WORDS;
    }
    public static TwtStopWords getInstance() {
        return instance;
    }
    public static void main(String ar[])
    {
        new TwtStopWords();
    }
 
 
    
    static List<String> WITHOUT_POSITIVE_WORDS = new ArrayList<String>();
    public List<String> getNegativeAndStopWords() {
        WITHOUT_POSITIVE_WORDS.addAll(stopWords);
        WITHOUT_POSITIVE_WORDS.addAll(NEGATIVE_WORDS);
        
        return WITHOUT_POSITIVE_WORDS;
    }
  }

