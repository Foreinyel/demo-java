public class StringTest {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        String s5 = "ab" + "c";
        String s6 = "ab" + new String("c");

        String s7 = s1 + s2;

        final String s8 = "abc";
        final String s9 = "abc";
        String s10 = s8 + s9;


        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s7 == "abcabc");
        System.out.println(s10 == "abcabc");

        System.out.println(s3.equals(s1));

    }

}
