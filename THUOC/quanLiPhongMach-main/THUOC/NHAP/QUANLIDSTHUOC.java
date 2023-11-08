package THUOC.NHAP;
import java.util.Scanner;

public class QUANLIDSTHUOC {
    Scanner quanliScanner = new Scanner(System.in);
    DANHSACHTHUOC ds ;

    QUANLIDSTHUOC() {
        this.ds = new DANHSACHTHUOC();
    }

    public void setDSTHUOC(DANHSACHTHUOC new_ds) {
        this.ds = new_ds;
    }

    public void menu() {
        int option = 0;
        do {
            System.out.println("Nhap 0 de thoat");
            System.out.println("Nhap 1 de them thuoc");
            System.out.println("Nhap 2 de xoa thuoc");
            System.out.println("Nhap 3 de sua");
            System.out.println("Nhap 4 de thong ke thuoc theo ten");
            System.out.println("Nhap 5 de in toan bo thuoc");
            System.out.println("Nhap 6 de tao don thuoc: ");
            System.out.println("Nhap 7 de truy cap menu phieu nhap hang");
            System.out.print("Nhap lua chon: ");
            option = quanliScanner.nextInt();

            if(option == 0) {
                break;
            } 

            if(option == 1) {
                System.out.print("Nhap loai thuoc can them (0 la thuoc chich, 1 la thuoc vi): ");
                int loaiThuocCanThem = quanliScanner.nextInt();
                if(loaiThuocCanThem == 0) {
                    THUOCCHICH tempThuocchich = new THUOCCHICH();
                    tempThuocchich.nhapThongTinThuoc();
                    this.ds.themThuoc(tempThuocchich);
                }
                else if(loaiThuocCanThem == 1) {
                    THUOCVI tempThuocvi = new THUOCVI();
                    tempThuocvi.nhapThongTinThuoc();
                    this.ds.themThuoc(tempThuocvi);
                }
            }

            if(option == 2) {
                System.out.print("Nhap vi tri thuoc can xoa: ");
                int index = quanliScanner.nextInt();
                this.ds.xoaThuoc(index);
            }

            if(option == 3) {
                this.ds.suaThongTin();
            }

            if(option == 4) {
                quanliScanner.nextLine();
                System.out.println("Nhap ten thuoc can tim: ");
                String tenThuocCanTim = quanliScanner.nextLine();
                ds.timThuocTheoTen(tenThuocCanTim);
            }

            if(option == 5) {
                ds.inDanhSachThuoc();
            }

            if(option == 6) {
                QUANLIDONTHUOC quanlidonthuoc = new QUANLIDONTHUOC(ds);
                quanlidonthuoc.menuDonThuoc();
            }
            if (option == 7){
                QUANLYNHAPHANG qlnh = new QUANLYNHAPHANG();
                qlnh.menu();
            }

            
        } while(option != 0);
    }
}
