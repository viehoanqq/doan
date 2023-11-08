package NHAP;
import java.time.LocalDate;
public class Main {   
    public static void main(String args[]) {
        QUANLIDSTHUOC trinhQuanLi = new QUANLIDSTHUOC();
        
        THUOCCHICH tc1 = new THUOCCHICH("TC01", "Jolly Mouse","Tri mat ngu", 7, 
        LocalDate.parse("2023-08-05"), LocalDate.parse("2024-07-19") ,100000 , 350);

        THUOCCHICH tc2 = new THUOCCHICH("TC02", "Cola Coka","Tri cam cum", 2, 
        LocalDate.parse("2023-11-05"), LocalDate.parse("2024-12-11") ,130000 , 200);

        THUOCVI tv1 = new THUOCVI("TV01", "Cola CoCo", "Hoat huyet duong nao", 24,
        LocalDate.parse("2022-02-28"), LocalDate.parse("2023-12-30"), 500000, 4, 13); 

        THUOCVI tv2 = new THUOCVI("TV02", "Jolly Snake", "Bar bo gan", 30, 
        LocalDate.parse("2022-01-28"), LocalDate.parse("2024-12-30"), 80000, 5, 11);

        DANHSACHTHUOC listThuoc = new DANHSACHTHUOC();
        listThuoc.themThuoc(tc1);
        listThuoc.themThuoc(tc2);
        listThuoc.themThuoc(tv1);
        listThuoc.themThuoc(tv2);

        trinhQuanLi.setDSTHUOC(listThuoc);
        
        trinhQuanLi.menu();


    }
}
