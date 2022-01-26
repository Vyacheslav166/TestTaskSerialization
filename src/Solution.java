import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


class Solution {

    public static Set<Integer> intSet = new LinkedHashSet<>(Arrays.asList(1, 222, 111, 2, 3, 5, 8, 13, 21, 555, 444, 325 ,478 ,999, 122, 15, 4));

    public static void main(String[] args) {

        System.out.println(serialization(intSet));
        Set<Integer> integers = deserialization(serialization(intSet));
        System.out.println(integers.size());
    }

    /**
     * Сериализация множества чисел в строку
     * @param values - множество чисел
     * @return Строка
     */
    public static String serialization(Set<Integer> values) {
        StringBuilder str = new StringBuilder();
        for(int i : values) {
            if(i>99) {
                str.append(i);
            } else if(i>9) {
                str.append(",");
                str.append(i);
            } else {
                str.append(".");
                str.append(i);
            }
        }
        return str.toString();
    }

    /**
     * Десериализация строки во множество чисел
     * @param str - строка
     * @return Множество чисел
     */
    public static Set<Integer> deserialization(String str) {
        Set<Integer> intSetResult = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder(str);
        while (sb.length()>1) {
            if(sb.charAt(0) == '.') {
                intSetResult.add(Integer.parseInt(sb.substring(1, 2)));
                sb.delete(0, 2);
            } else if (sb.charAt(0) == ',') {
                intSetResult.add(Integer.parseInt(sb.substring(1, 3)));
                sb.delete(0, 3);
            } else {
                intSetResult.add(Integer.parseInt(sb.substring(0, 3)));
                sb.delete(0, 3);
            }
        }
        return intSetResult;
    }
}
