package encryptdecrypt;

abstract class Algorithm {
    int key;

    Algorithm(int key) {
        this.key = key;
    }

    abstract String encode(String data);

    abstract String decode(String data);
}