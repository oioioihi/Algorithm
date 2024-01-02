import org.junit.jupiter.api.Test;

import java.util.Scanner;

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
}
