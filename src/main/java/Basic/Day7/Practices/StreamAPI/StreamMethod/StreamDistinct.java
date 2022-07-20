package Basic.Day7.Practices.StreamAPI.StreamMethod;

import java.util.*;

public class StreamDistinct {
    public static void main(String[] args) {
        int [] numbers = {23,58,12,23,17,29,99,98,29,12};
        Arrays.stream(numbers).distinct().forEach(i->System.out.print(i+ " "));
    }
}
