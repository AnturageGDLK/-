package manicure;


import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        List<String> firstClients = List.of(
                "Anya",
                "Sveta",
                "Olya",
                "Alexandra",
                "Ruslana",
                "Olesya",
                "Vika"
        );

        Queue<String> queue = new ArrayDeque<>();
        queue.addAll(firstClients);


        while (!queue.isEmpty()) {

            String clientName = queue.poll();

            System.out.println(clientName + " сделал(а) новый маникюр.");

            double randomValue = Math.random();

            if (randomValue < 0.5) {

                String friendName = "a friend of " + clientName;
                queue.add(friendName);
            } else {

            }
        }
    }
}

