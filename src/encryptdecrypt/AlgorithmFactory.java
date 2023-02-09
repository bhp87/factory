package encryptdecrypt;

class AlgorithmFactory {
    static Algorithm getAlgorithm(String algorithm, int key) {
        switch (algorithm) {
            case "shift":
                return new ShiftAlgorithm(key);
            case "unicode":
                return new UnicodeAlgorithm(key);
            default:
                throw new IllegalArgumentException("Invalid algorithm name");
        }
    }
}