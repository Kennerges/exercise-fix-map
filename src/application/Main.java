package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] vector = line.split(",");
                String name = vector[0];
                int count = Integer.parseInt(vector[1]);

                if (map.containsKey(name)) {
                    int votesSoFar = map.get(name);
                    map.put(name, count + votesSoFar);
                } else {
                    map.put(name, count);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        sc.close();
    }
}
