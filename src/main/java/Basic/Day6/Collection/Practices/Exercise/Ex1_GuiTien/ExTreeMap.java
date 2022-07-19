package Basic.Day6.Collection.Practices.Exercise.Ex1_GuiTien;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class ExTreeMap {
    public static <age> void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Map<NguoiGuiTien,Double> customers = new TreeMap<>();
        //NguoiGuiTien(String Ma,String Hoten, String Diachi,String Sodienthoai,  Date Ngaysinh),SoTienGui
        customers.put(new NguoiGuiTien("HN01","Đoàn Văn Thế", "Thanh Xuân Bắc, Thanh Xuân, Hà Nội" ,"0123456789" ,dateFormat.parse("1998-07-19")),100.5);
        customers.put(new NguoiGuiTien("HN02","Nguyễn Văn Hải", "Hồ Tây, Tây Hồ, Hà Nội" ,"0122336789" ,dateFormat.parse("1998-06-22")),150.5);
        customers.put(new NguoiGuiTien("HN03","Đỗ Ngọc Chung", "Hùng Vương, Ba Đình, Hà Nội" ,"0123444789" ,dateFormat.parse("1998-08-21")),105.5);
        customers.put(new NguoiGuiTien("HN04","Đào Đình Luyện", "Số 1 Đinh Tiên Hoàng, Hoàn Kiếm, Hà Nội" ,"01666666666" ,dateFormat.parse("1998-05-14")),990.5);

        NguoiGuiTien cus1 = new NguoiGuiTien("HN04","Hoàng Minh Tuấn", "Số 1 Phạm Ngọc Thạch, Đống Đa, Hà Nội" ,"01696966969" ,dateFormat.parse("1998-01-11"));
                boolean kt = customers.containsKey(cus1);//
                if (kt) {
                System.out.println("Đã có trong danh sách");
                    customers.put(cus1, customers.get(cus1)+100.0);
                } else {
                System.out.println("Chưa có trong danh sách");
                    customers.put(cus1, 100.0);
                }
                System.out.println(customers);
    }
}