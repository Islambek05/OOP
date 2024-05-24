import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        StringBuilder monthsBuilder = new StringBuilder();
        String[] monthsArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October"," November","December"};
        for (String month : monthsArray) {
            monthsBuilder.append(month).append(",");
        }

        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randomNumbers.add(random.nextInt(monthsArray.length));
        }

        String monthsSeparated = monthsBuilder.toString().replaceAll(",$", "");
        String[] monthsSeparatedArray = monthsSeparated.split(",");

        Map<Integer, String> monthsMap = new HashMap<>();
        for (int i = 0; i < monthsSeparatedArray.length; i++) {
            monthsMap.put(i, monthsSeparatedArray[i]);
        }

        CorrespondingValues correspondingValues = (map, list) -> {
            return IntStream.range(0, list.size())
                    .filter(i -> map.containsKey(i) && map.get(i).equals(monthsArray[list.get(i)]))
                    .mapToObj(i -> monthsArray[list.get(i)])
                    .collect(Collectors.toCollection(ArrayList::new));
        };

        ArrayList<String> result = correspondingValues.getValues(monthsMap, randomNumbers);

        System.out.println("Corresponding values:");
        result.forEach(System.out::println);
    }

    interface CorrespondingValues {
        ArrayList<String> getValues(Map<Integer, String> monthsMap, ArrayList<Integer> randomNumbers);
    }
}
