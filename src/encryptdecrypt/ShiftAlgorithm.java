package encryptdecrypt;

class ShiftAlgorithm extends Algorithm {
    ShiftAlgorithm(int key) {
        super(key);
    }

    @Override
    String encode(String data) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + key) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + key) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    String decode(String data) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' - key + 26) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' - key + 26) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}