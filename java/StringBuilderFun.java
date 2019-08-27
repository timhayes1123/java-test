/* Playing around with the StringBuilder class. */

public class StringBuilderFun {
    public static void main(String[] args) {
        StringBuilder test = new StringBuilder("This is a test string abcdefghijklmnopqrstuvwxyz");

        StringBuilder test2 = new StringBuilder();
        test2.append(test);
        System.out.println(test2);
        test2.deleteCharAt(2);
        System.out.println(test2);
        test2.insert(2, 1);
        System.out.println(test2);
        test2.reverse();
        System.out.println(test2);
        test2.replace(test2.length() - 4, test2.length() - 1, "Angry Ostrich");
        System.out.println(test2);

    }
}
