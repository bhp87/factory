package encryptdecrypt;

class UnicodeAlgorithm extends Algorithm {
    UnicodeAlgorithm(int key) {
        super(key);
    }

    @Override
    String encode(String data) {
        return UnicodeCipher(data, key);
    }

    @Override
    String decode(String data) {
        return UnicodeCipher(data, -key);
    }

    String UnicodeCipher(String data, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            sb.append((char) (c + key));
        }
        return sb.toString();
    }
}