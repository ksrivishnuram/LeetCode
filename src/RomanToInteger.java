import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    public int romanIntString(String s) {
        HashMap<Character, Integer> list = new HashMap<>();
        list.put('I', 1);
        list.put('V', 5);
        list.put('X', 10);
        list.put('L', 50);
        list.put('C', 100);
        list.put('D', 500);
        list.put('M', 1000);
        ArrayList<Integer> num = new ArrayList<>();
        int count = s.length();
        for (int i = 0; i < s.length(); i++)
        {
            if (i == s.length() - 1)
            {
                num.add(list.computeIfPresent(s.charAt(i), (key, val) -> val));
            }
            else
            {
                    if ((s.charAt(i) == 'I')&&((s.charAt(i + 1) == 'V') || (s.charAt(i + 1) == 'X')))
                    {
                        num.add(list.computeIfPresent(s.charAt(i + 1), (key, val) -> (int) (val - (Math.pow(10, 0)))));
                        i += 1;
                    }

                    else if ((s.charAt(i) == 'X') && ((s.charAt(i + 1) == 'L') || (s.charAt(i + 1) == 'C')))
                    {
                        num.add(list.computeIfPresent(s.charAt(i + 1), (key, val) -> (int) (val - (Math.pow(10, 1)))));
                        i += 1;
                    }
                    else if ((s.charAt(i) == 'C') && ((s.charAt(i + 1) == 'D') || (s.charAt(i + 1) == 'M')))
                    {
                    num.add(list.computeIfPresent(s.charAt(i + 1), (key, val) -> (int) (val - (Math.pow(10, 2)))));
                    i += 1;
                    }
                    else
                    {
                        num.add(list.computeIfPresent(s.charAt(i), (key, val) -> val));
                    }
            }
        }
            int add = 0;
            for (int x : num) {
                add += x;
            }
            return add;
        }
        public int romanToInt(String s)
        {
            int sum = 0;
            int i = 0;
            while (i < s.length()) {
                String currentSymbol = s.substring(i, i + 1);
                int currentValue = values.get(currentSymbol);
                int nextValue = 0;
                if (i + 1 < s.length()) {
                    String nextSymbol = s.substring(i + 1, i + 2);
                    nextValue = values.get(nextSymbol);
                }

                if (currentValue < nextValue) {
                    sum += (nextValue - currentValue);
                    i += 2;
                }
                else {
                    sum += currentValue;
                    i += 1;
                }

            }
            return sum;

        }

    public static void main(String[] args)
    {
        RomanToInteger result = new RomanToInteger();
        System.out.println(result.romanToInt("LVIII"));
    }

}
