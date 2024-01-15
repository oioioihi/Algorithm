import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        //Arrays.sort(nums);
        int pointer = nums.length-1;
        int sum = nums[pointer];
        int result;
        while(sum<target){
            pointer--;
            if(pointer < 0){
                break;
            }
            sum +=nums[pointer];
        }

        return pointer<0?0:nums.length-pointer;
    }

    @Test
    void testing (){
        int target = 213;
        int [] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int result = minSubArrayLen_209(target, nums);
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
