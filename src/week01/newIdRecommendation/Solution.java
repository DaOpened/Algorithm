package week01.newIdRecommendation;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";


        //step 1
        new_id.toLowerCase();

        List<String> filtered1 = new ArrayList<>();
        for( int i = 0 ; i < new_id.length(); i++){
            filtered1.add(String.valueOf(new_id.toCharArray()[i]));
        }

        //step 2
        List<String> filtered2 = new ArrayList<>();

        for( String word : filtered1 ){
            int code = (int)word.charAt(0);

            if((97 <= code && code <= 122) ||
                    (48 <= code && code <= 57) ||
                    word.equals("-") || word.equals("_") || word.equals(".")){
                filtered2.add(word);
            }
        }

        //step 3
        List<String> filtered3 = new ArrayList<>();

        for(int i = 0; i < filtered2.size()-1; i++ ){
            System.out.println("i = "+i + "");
            if(filtered2.get(i).equals(".") && filtered2.get(i+1).equals(".")){
                filtered3.add(filtered2.get(i));
                while(!filtered2.get(i+1).equals(".")){
                    i++;
                }
                continue;
            }
            filtered3.add(filtered2.get(i));
        }

        for(String word : filtered3){
            System.out.print(word+ " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        String tmp = new Solution().solution("..1*...hello12-._+");
    }
}
