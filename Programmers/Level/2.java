import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

     class Solution {
        public int solution(int[][] board, int[] moves) {
            AtomicInteger answer = new AtomicInteger();
            AtomicInteger count = new AtomicInteger(1);
            HashMap<Integer, Stack<Integer>> map = new HashMap<>();
            Stack<Integer> own = new Stack<>();

            for (int j = 0; j < board[0].length; j++) {
                Stack<Integer> stack = new Stack<>();
                map.put(count.getAndIncrement(), stack);
            }

            for (int i = board.length; i >0; i--) {
                for (int j = 1; j < board[0].length+1; j++) {
                    Stack<Integer> integers = map.get(j);
                    if(board[i-1][j-1]!=0) {
                        integers.push(board[i-1][j - 1]);
                    }
                }
            }

            List<Integer> moveList = Arrays.stream(moves).boxed().collect(Collectors.toList());

            moveList.forEach(num->{
                Stack<Integer> dollList = map.get(num);
                if(dollList.size()>0){
                    Integer pop = dollList.pop();
                    own.push(pop);
                }

                if(own.size()>1 && (own.get(own.size() - 1)).equals(own.get(own.size() - 2))){
                        answer.getAndIncrement();
                        own.pop();
                        own.pop();
                }
            });
            return answer.get()*2;
        }
    }
