import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class twoPointerTest {

    @Test
    void twoPointerTest(){
        //Scanner sc = new Scanner(System.in);
        int n = 5;
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while(endIndex != n){
            if(sum == n){
                count++;
                endIndex++;
                sum  = sum+endIndex;
            } else if (sum < n) {
                endIndex++;
                sum = sum+endIndex;
            } else if (sum>n) {
                sum = sum - startIndex;
                startIndex++;
            }
        }
        System.out.println(count);

    }

    @Test
    void twoPointer2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int count = 0;
        int startIndex = 0;
        int endIndex = n-1;
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        while(startIndex<endIndex){
            if(a[startIndex] + a[endIndex] < m) startIndex++;
            else if(a[startIndex] + a[endIndex] > m) endIndex--;
            else{
                count++;
                startIndex++;
                endIndex--;
            }
        }
        System.out.println(count);

    }

    @Test
    void Palindrome_125() {
        String s = "fghjk";
        String s1 = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        boolean result = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s1.charAt(s1.length()-1-i)){
                result = false;
        }
    }
        System.out.println("결과 = "+result);
    }

    @Test
    public int[] twoSum_167(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length-1;
        int[] result = new int[2];
        boolean loop=true;

        while(loop){
            if(numbers[startIndex]+numbers[endIndex]==target){
                result[0]=startIndex+1;
                result[1]=endIndex+1;
                loop=false;
            } else if (numbers[startIndex]+numbers[endIndex]<target) {
                startIndex++;
            }
            else {
                endIndex--;
            }
        }
        return result;

    }

    @Test
    public int container_With_Most_Water_11(int[] height) {

        int startIndex = 0;
        int endIndex = height.length-1;
        int max = 0;
        while(startIndex<endIndex){
            max = Math.max(max, (endIndex-startIndex)*Math.min(height[startIndex],height[endIndex]));
            if (height[startIndex] < height[endIndex]) {
                startIndex++;
            }else {
                endIndex--;
            }
        }
            return max;
    }
}
