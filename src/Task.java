import java.util.ArrayList;
import java.util.List;

public class Task 
{
    public static void main(String[] args) throws Exception 
    {
        /////////////////////////////// TASK 1
        System.out.println("Task 1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        System.out.println();

        /////////////////////////////// TASK 2
        System.out.println("Task 2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        System.out.println();

        /////////////////////////////// TASK 3
        System.out.println("Task 3");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        System.out.println();

        /////////////////////////////// TASK 4
        System.out.println("Task 4");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        System.out.println();
        /////////////////////////////// TASK 5
        System.out.println("Task 5");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        System.out.println();

        /////////////////////////////// TASK 6
        System.out.println("Task 6");
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println(same(new int[]{2}, new int[]{3, 3, 3, 3, 3}));

        System.out.println();

        /////////////////////////////// TASK 7
        System.out.println("Task 7");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));

        System.out.println();
        /////////////////////////////// TASK 8
        System.out.println("Task 8");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));

        System.out.println();

        /////////////////////////////// TASK 9
        System.out.println("Task 9");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        System.out.println();

        /////////////////////////////// TASK 10
        System.out.println("Task 10");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));

        System.out.println();
    }


    /////////////////////////////// TASK 1
    public static int solutions(int a, int b, int c)
    {
        if (((b*b) - 4 * a * c) > 0) { return 2; }
        else if (((b*b) - 4 * a * c) < 0) { return 0; }
        else { return 1; }
    }

    /////////////////////////////// TASK 2
    public static int findZip(String str)
    {
        return str.indexOf("zip", str.indexOf("zip") + 3);
    }
    
    /////////////////////////////// TASK 3
    public static boolean checkPerfect(int number)
    {
        int sum = 0;
        for (int i = 1; i < (number - 1); i++) 
        {
            if (number % i == 0) { sum += i; } 
            else { continue; }
        }
        return sum == number;
    }
    
    /////////////////////////////// TASK 4
    public static String flipEndChars(String str)
    {
        if (str.length() < 2) { return "Incompatible."; }
        
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);

        if (first == last) { return "Two's a pair."; }
        
        char[] data = str.toCharArray();
        data[0] = last;
        data[str.length() - 1] = first;

        return (new String(data));
    }
    
    /////////////////////////////// TASK 5
    public static boolean isValidHexCode(String str)
    {
        if ((str.charAt(0) != '#') || (str.length() != 7)) { return false; }

        char[] characters = str.toCharArray();
        char[] symbols = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','a','b','c','d','e','f'};

        boolean flag = true;
        for (int i = 1; i < str.length(); i++) 
        {
            flag = false;
            for (int j = 0; j < symbols.length; j++) 
            { if (characters[i] == symbols[j]) { flag = true; } }

            if (!flag) { return false; }
        }
        return true;
    }
    
    /////////////////////////////// TASK 6
    public static boolean same(int[] arr1, int[] arr2)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i : arr1)
        {
            if (!list1.contains(i)) { list1.add(i); }
        }
        for (int i : arr2)
        {
            if (!list2.contains(i)) { list2.add(i); }
        }

        return (list1.size() == list2.size());
    }
    
    /////////////////////////////// TASK 7
    public static boolean isKaprekar(int n)
    {
        int square = n * n; // квадрат числа
        double amount = Math.ceil(Math.log10(square)); // количество цифр в числе

        if (amount == 1) { return n == square; }

        char[] numbers = String.valueOf(square).toCharArray();
        String left = "";
        String right = "";
        if (amount % 2 == 0)
        {
            for (int i = 0; i < amount; i++) 
            {
                if (i < (amount / 2)) { left += numbers[i]; }
                else { right += numbers[i]; }
            }
            return ((Integer.parseInt(left) + Integer.parseInt(right)) == n);
        }
        else
        {
            for (int i = 0; i < amount; i++) 
            {
                if (i < ((amount - 1) / 2)) { left += numbers[i]; }
                else { right += numbers[i]; }
            }
            return ((Integer.parseInt(left) + Integer.parseInt(right)) == n);
        }
    }
    
    /////////////////////////////// TASK 8
    public static String longestZero(String str)
    {
        int counter = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) 
        {
            if (str.charAt(i) == '0') { counter++; }
            else
            {
                if (counter > max) { max = counter; }
                counter = 0;
            }
        }
        String zero = "";

        if (max == 0) { zero += "\"\""; }
        else { for (int i = 0; i < max; i++) { zero += '0'; } }

        return zero;
    }
    
    /////////////////////////////// TASK 9
    public static int nextPrime(int number)
    {
        boolean flag;
        while (!false)
        {
            flag = true;
            for (int i = 2; i < number; i++) 
            {
                if (number % i == 0) 
                { 
                    flag = false;
                    break; 
                }
            }
            if (flag) { return number; }
            number++;
        }
    }
    
    /////////////////////////////// TASK 10
    public static boolean rightTriangle(int x, int y, int z)
    {
        int hypotenuse_max = Math.max(Math.max(x, y), z); // максимальное ребро
        int cathet2_med; // среднее ребро
        int cathet1_min = Math.min(Math.min(x, y), z); // минимальное ребро

        if ((hypotenuse_max > x) && (x > cathet1_min)) { cathet2_med = x; }
        else if ((hypotenuse_max > y) && (y > cathet1_min)) { cathet2_med = y; }
        else { cathet2_med = z; }

        return (hypotenuse_max * hypotenuse_max) == ((cathet1_min * cathet1_min) + (cathet2_med * cathet2_med));
    }
}
