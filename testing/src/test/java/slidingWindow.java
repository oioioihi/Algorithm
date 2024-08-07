import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class slidingWindow {

    static int[] currentArray;
    static int[] checkArray;
    static int checkSecret;
    @Test
    void DNA_secret() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int totalSize = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());
        int result = 0;
        currentArray = new int[4];
        checkArray = new int[4];
        checkSecret = 0;
        char[] inputArray;
        inputArray = reader.readLine().toCharArray();

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i <4 ; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());
            if(checkArray[i] == 0){
                checkSecret++;
            }
        }

        // 처음 부분문자열 받을때 세팅
        for (int i = 0; i < windowSize; i++) {
            add(inputArray[i]);
        }
        if(checkSecret == 4) {
            result++;
        }
        
        //슬라이딩 윈도우
        for (int i = windowSize; i < totalSize; i++) {
            int j = i-windowSize;
            add(inputArray[i]);
            remove(inputArray[j]);
            if(checkSecret == 4) {
                result++;
            }
        }
        System.out.println("결과 = " + result);
        reader.close();
    }



    private void remove(char c) {
        switch (c){
            case 'A':
                if(currentArray[0] == checkArray[0]) checkSecret--;
                currentArray[0]--;
                break;
            case 'C':
                if(currentArray[1] == checkArray[1]) checkSecret--;
                currentArray[1]--;
                break;
            case 'G':
                if(currentArray[2] == checkArray[2]) checkSecret--;
                currentArray[2]--;
                break;
            case 'T':
                if(currentArray[3] == checkArray[3]) checkSecret--;
                currentArray[3]--;
                break;
        }
    }

    public int minSubArrayLen_209(int target, int[] nums) {
        int windowSize = Integer.MAX_VALUE;
        int leftPointer = 0;
        int sum = 0;

        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            sum += nums[rightPointer];

            while(sum>=target){
                sum-=nums[leftPointer];
                windowSize = Math.min(windowSize,rightPointer-leftPointer+1);
                leftPointer++;
            }
        }
        return windowSize==Integer.MAX_VALUE? 0 : windowSize;


    }
    @Test
    void testing (){
        int target = 213;
        int [] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int result = minSubArrayLen_209(target, nums);
        System.out.println("결과 = "+result);
    }

    public int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();
        int leftPointer = 0;
        HashSet<Character> set = new HashSet<>();
        int windowSize = 0;
        for (int rightPointer = 0; rightPointer <array.length ; rightPointer++) {

            set.add(array[rightPointer]);
            windowSize = Math.max(windowSize, rightPointer - leftPointer+1);
            if (set.size()<=rightPointer){
                leftPointer++;
               windowSize=windowSize-1;
            }
        }

        return windowSize;
    }

    @Test
    void lengthOfLongestSubstring_testing (){
        String input = "bbbbb";

        int result = lengthOfLongestSubstring(input);
        System.out.println("결과 = "+result);
    }

    private void add(char c) {
        switch (c){
            case 'A':
                currentArray[0]++;
                if(currentArray[0] == checkArray[0]) checkSecret++;
                break;
            case 'C':
                currentArray[1]++;
                if(currentArray[1] == checkArray[1]) checkSecret++;
                break;
            case 'G':
                currentArray[2]++;
                if(currentArray[2] == checkArray[2]) checkSecret++;
                break;
            case 'T':
                currentArray[3]++;
                if(currentArray[3] == checkArray[3]) checkSecret++;
                break;
        }
    }
}
