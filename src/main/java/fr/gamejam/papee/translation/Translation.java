package fr.gamejam.papee.translation;

import fr.gamejam.papee.util.GDefines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Translation {
    private static final Map<String, String> trad = new HashMap<>();

    public static void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("res" + GDefines.LANG + GDefines.LANGUAGE.getLocale() + ".lang")))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] cols = line.split("=");

                String key = cols[0];
                StringBuilder value = new StringBuilder();

                for (int i = 1; i < cols.length; i++) {
                    value.append(cols[i]);
                }

                System.out.println("key: " + key);
                System.out.println("val: " + value.toString());

                add(key, value.toString());
            }
        } catch (Exception ignored) {

        }
    }

    public static void add(String key, String value) {
        trad.put(key, value);
    }

    public static String get(String key) {
        return trad.get(key);
    }
}
