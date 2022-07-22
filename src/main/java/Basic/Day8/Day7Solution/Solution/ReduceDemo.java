/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Hung
 */
public class ReduceDemo {

    public static void main(String[] args) {
        int[] numbers = {123, 456, 789, 246, 135, 802, 791};
        int sum = Arrays.stream(numbers).reduce(0, (x, y) -> (x + y));
        
        System.out.println("sum = " + sum);

        Integer prod = Stream.of(3, 2, 5).parallel()
                .reduce(1, (x, y) -> x + y, (p, q) -> p * q);
        
        System.out.println(prod);//24

    }
}
