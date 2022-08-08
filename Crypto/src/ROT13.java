import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private int shift;

    ROT13(Character cs, Character cf) {
        this.shift = cf - cs;
    }

    ROT13() {
        this.shift = 13;
    }

    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if((ch >= 'a' && ch <= 'm') || (ch >= 'A' && ch <= 'M')) {
                ch += 13;
            }
            else if((ch >= 'n' && ch <= 'z') || (ch >= 'N' && ch <= 'Z')) {
                ch -= 13;
            }
            sb.append(ch);
        }

        return sb.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return encrypt(text);
    }

    public static String rotate(String s, Character c) {
        String prefix, suffix, result;
        if(s.charAt(0) == c) {
            return s;
        }

        int index = s.indexOf(c);

        prefix = s.substring(index);
        suffix = s.substring(0, index);
        result = prefix + suffix;

        return result;
    }

}
