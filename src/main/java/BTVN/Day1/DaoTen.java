package BTVN.Day1;

import java.util.StringTokenizer;

public class DaoTen {

    public static void main(String[] args) {
//        String ten = new String("Hoàng Nguyễn Tuấn Anh");
//        StringTokenizer tokenizer = new StringTokenizer(ten);
//        String daoTen= new String();
//        while (tokenizer.hasMoreTokens()) {
//            String token = tokenizer.nextToken();
//            daoTen= token + " "+ daoTen;
//        };
//
//        System.out.println(daoTen);

        String ten = new String("Hoàng Nguyễn Tuấn Anh");
        StringTokenizer tokenizer = new StringTokenizer(ten);
        String [] tokens = ten.split("\s");
        String daoTen= new String(tokens[tokens.length - 1]);
        for (int i=0;i<tokens.length-1;i++){
            daoTen += " "+tokens[i];
        }
        System.out.println(daoTen);

    }
}