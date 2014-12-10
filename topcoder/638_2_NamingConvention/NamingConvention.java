public class NamingConvention {
    public String toCamelCase(String variableName) {
        String[] str = variableName.split("\\_");
        int len = str.length;
        StringBuilder result = new StringBuilder(str[0]);
        for (int i = 1; i < len; i++) {
            StringBuilder sb = new StringBuilder(str[i]);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            result.append(sb.toString());
        }

        return result.toString();
    }
}
