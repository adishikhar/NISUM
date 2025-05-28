interface StringUtils {
    static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    static String capitalize(String s) {
        if (isNullOrEmpty(s)) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

public class Q15 {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "aditya";
        System.out.println("From isNullorEmpty interface: "  + StringUtils.isNullOrEmpty(str1));
        System.out.println("From Capitalize interface: " + StringUtils.capitalize(str2));
    }
}
