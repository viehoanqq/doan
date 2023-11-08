package THANNHAN;
import java.util.Scanner;
public class QLDSTN {
    DSTN qldsnv = new DSTN();
    Scanner input = new Scanner(System.in);
    public void menu()
    
    {
    System.out.println("[==============  QUAN LY THAN NHAN ============]");
    System.out.println("\n");
    System.out.println(" 0. nhap danh sach nhan than");    
    System.out.println(" 1. Xem danh sach than nhan");
    System.out.println(" 2. Them them nhan");
    System.out.println(" 3. Xoa than nhan");
    System.out.println(" 4. Sua thong tin than nhan");
    System.out.println(" 5. Tim kiem nhan than");
    System.out.println(" 6. Thong ke than nhan cua benh nhan");
    System.out.println(" 7. Thoat");
        System.out.println("\n");
    int k=0;
    while (k!=7)
    {
    System.out.print("Lua chon: ");
    k = input.nextInt();
    switch(k)
        {
            case 0:
                qldsnv.nhap();
                break;
            case 1: 
            {
                qldsnv.xuat();
            } break;
            case 2: 
            {
                qldsnv.them();
            } break;
            case 3: 
            {
                qldsnv.xoa();
            } break;
            case 4: 
            {
                qldsnv.sua();
            } break;
            case 5:
            {
                qldsnv.timkiem().xuat();
                System.out.println("\n");
            } break;
            case 6:
            {
                qldsnv.thongKeThanNhan();
            } break;
            case 7:
            {
                break;
            }
            }
        }
    }
}
  
