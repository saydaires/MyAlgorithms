import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Exercise01 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write an sentence: ");
        String sentence = scanner.nextLine();

        ArrayList<String> sentenceWords = new ArrayList<>();
        sentenceWords = splitWords(sentence);

        ArrayList<Integer> frequencyWords = new ArrayList<>();
        frequencyWords = frequencyList(sentenceWords);

        eliminateDuplicateWords(sentenceWords);

        HashMap<String, Integer> map = new HashMap<>();
        createHashMap(sentenceWords, frequencyWords, map);

        System.out.println("\nSentence: " + sentence);
        System.out.println(map);
    }
    
    public static ArrayList<String> splitWords(String sentence)
    {
        ArrayList<String> wordsList = new ArrayList<>();
        
        String word = ""; // String 'word' is empty, not null
        for(int i = 0; i < sentence.length(); i++)
        {
            String currentChar = Character.toString(sentence.charAt(i));
            
            if(!currentChar.equals(" "))
            {
                word += currentChar;
                if(i == sentence.length() - 1) // checks if the sentence was finished
                    wordsList.add(word);
            }
            else
            {
                wordsList.add(word); // adding the word into wordsList
                word = ""; // resseting the word   
            } 
        }
        return wordsList;
    }
    
    public static ArrayList<Integer> frequencyList(ArrayList<String> wordsList)
    {
        ArrayList<String> checkedWords = new ArrayList<>();
        ArrayList<Integer> frequencyList = new ArrayList<>();
        int frequencyWord = 1;
        
        for(int i = 0; i < wordsList.size(); i++)
        {
            int currentWordChecked = 0;
            
            if(!checkedWords.isEmpty())
                if(checkedWords.contains(wordsList.get(i)))
                    currentWordChecked = 1;
            
            if(currentWordChecked == 1) // prevents unecessary frequency verifications
                continue;
            
            for(int k = i + 1; k < wordsList.size(); k++)
                if(wordsList.get(i).equals(wordsList.get(k)))
                    frequencyWord++;
            
            frequencyList.add(frequencyWord);
            checkedWords.add(wordsList.get(i));
            frequencyWord = 1; // resseting frequencyWord to next word
        }
        return frequencyList;
    }
    
    public static void eliminateDuplicateWords(ArrayList<String> sentenceWords)
    {
        for(int i = sentenceWords.size() - 1; i >= 0; i--)
            for(int k = 0; k <= i - 1; k++)
                if(sentenceWords.get(i).equals(sentenceWords.get(k)))
                {
                    sentenceWords.remove(i);
                    break; // prevents IndexOutOfBoundsException
                }
    }
    
    public static void createHashMap(ArrayList<String> sentenceWords, ArrayList <Integer> frequencyWords, HashMap<String, Integer> map)
    {
        final int NUMBER_OF_DIFFERENT_WORDS = sentenceWords.size();
        
        for(int i = 0; i < NUMBER_OF_DIFFERENT_WORDS; i++)
            map.put(sentenceWords.get(i), frequencyWords.get(i));       
    }
}
