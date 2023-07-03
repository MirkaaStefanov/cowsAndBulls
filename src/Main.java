public class Main {
    public static boolean doesNumberSuits(String number) {
        int intNumber = Integer.parseInt(number);
        if (intNumber < 1000 || intNumber > 9999) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            for (int j = i+1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;

                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}