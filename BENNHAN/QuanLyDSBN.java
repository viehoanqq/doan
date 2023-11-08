package BENNHAN;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import java.util.Scanner;

public class QuanLyDSBN {
    // Thuộc tính:
    private DSBN dsbn;

    // Phương thức:
    public void Menu() {
        System.out.print("----------------");
        dsbn = new DSBN();
        int menu = 0;
        Scanner input = new Scanner(System.in);
        while (menu != 8) {
            System.out.print("\n1) Nhap DSBN." + "\n2) Xem DSBN." + "\n3) Them BN." + "\n4) Xoa BN." + "\n5) Sua thong tin BN." + "\n6) Tim kiem." + "\n8) Ket thuc.");
            System.out.print("\nHay chon chuc nang: ");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1:
                    dsbn.Nhap();
                    break;
                case 2:
                    dsbn.Xuat();
                    break;
                case 3:
                    dsbn.Them();
                    break;
                case 4:
                    System.out.print("\nNhap ma benh nhan muon xoa: ");
                    String ma1 = input.nextLine();
                    dsbn.Xoa(ma1);
                    break;
                case 5:
                    dsbn.SuaTT();
                    break;
                case 6:
                    System.out.print("\nNhap ma benh nhan can tim: ");
                    String ma2 = input.nextLine();
                    int foundIndex = dsbn.Timkiem(ma2);
                    if (foundIndex != -1) {
                        System.out.println("Benh nhan da duoc tim thay o vi tri " + foundIndex);
                    } else {
                        System.out.println("Khong tim thay thong tin benh nhan.");
                    }
                    break;
                //case 7:
                //dsbn.ThongKe();
                //break;
            }
        }
    }
}
