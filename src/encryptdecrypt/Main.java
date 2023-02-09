package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> arguments = new HashMap<>(Map.ofEntries(
                Map.entry("-key", "0"),
                Map.entry("-mode", ""),
                Map.entry("-data", ""),
                Map.entry("-alg", "shift"),
                Map.entry("-in", ""),
                Map.entry("-out", "")
        ));
        for (int i = 0; i < args.length; i += 2) {
            if (arguments.containsKey(args[i])) {
                arguments.put(args[i], args[i + 1]);
            }
        }
        int key = Integer.parseInt(arguments.get("-key"));
        String mode = arguments.get("-mode");
        String data = arguments.get("-data");
        String algorithm = arguments.get("-alg");
        String inputFile = arguments.get("-in");
        String outputFile = arguments.get("-out");

        if (!inputFile.isEmpty()) {
            data = new String(Files.readAllBytes(Path.of(inputFile)));
        }

        Algorithm algorithmObj = AlgorithmFactory.getAlgorithm(algorithm, key);
        if (algorithmObj == null) {
            System.out.println("Error: Algorithm not found");
            return;
        }

        String result = mode.equals("enc") ? algorithmObj.encode(data) :
                mode.equals("dec") ? algorithmObj.decode(data) : null;

        if (result == null) {
            return;
        }
        if (!outputFile.isEmpty()) {
            Files.writeString(Path.of(outputFile), result);
        } else {
            System.out.println(result);
        }
    }
}