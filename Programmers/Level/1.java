import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate todayDate = LocalDate.parse(today, formatter);
            HashMap<String, String> termMap = new HashMap<>();
            HashMap<String[], Integer> privacyMap = new HashMap<>();
            Arrays.stream(terms)
                    .map(term -> term.split(" "))
                    .forEach(termArray->termMap.put(termArray[0],termArray[1]));

            List<String[]> info = Arrays.stream(privacies)
                    .map(privacie -> privacie.split(" "))
                    .collect(Collectors.toList());
            
            info.stream().forEach(a->privacyMap.put(a,atomicInteger.getAndIncrement()));

            List<String[]> result = info.stream().filter(a -> !extracted(formatter, todayDate, termMap, a)).collect(Collectors.toList());
            int[] ints = result.stream().mapToInt(privacyMap::get).sorted().toArray();

            return ints;
        }
        private boolean extracted(DateTimeFormatter formatter, LocalDate todayDate, HashMap<String, String> termMap, String[] info) {
            String s = termMap.get(info[1]);
            Integer num = Integer.valueOf(s);
            LocalDate date = LocalDate.parse(info[0], formatter);
            return date.plusMonths(num).isAfter(todayDate);
        }
       
    }
