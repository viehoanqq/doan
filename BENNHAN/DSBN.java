package BENNHAN;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DSBN {
    // Thuoc tinh:
    private BenhNhan[] dsbn;
    private int n;

    // Phuong thuc:
    DSBN() {
        dsbn = null;
        n = 0;
    }

    DSBN(BenhNhan[] dsbn, int n) {
        this.dsbn = dsbn;
        this.n = n;
    }

    DSBN(DSBN l) {
        dsbn = l.dsbn;
        n = l.n;
    }

    // Nhap:
    public void Nhap() {
        FILE file = new FILE();
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap so luong: ");
        n = input.nextInt();
        dsbn = new BenhNhan[n];
        for (int i = 0; i < n; i++) {
            dsbn[i] = new BenhNhan();
            dsbn[i].nhapThongTinBenhNhan();
            file.ghiFile(i, null);
        }
    }

    // Xuat:
    public void Xuat() {
        for (int i = 0; i < n; i++) {
            dsbn[i].xuatThongTinBenhNhan();
        }
    }

    // Them:
    public void Them() {
        n = dsbn.length;
        dsbn = Arrays.copyOf(dsbn, n + 1);
        dsbn[n] = new BenhNhan();
        dsbn[n].nhapThongTinBenhNhan();
        n++;
    }

    // Tim kiem:
    public int Timkiem(String maBenhNhan) {
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getMaBenhNhan().equals(maBenhNhan)) {
                return i;
            }
        }
        return -1;
    }

    // Xóa:
    public void Xoa(String maBenhNhan) {
        int d = Timkiem(maBenhNhan);
        if (d == -1) {
            System.out.print("\nKhong ton tai nguoi nay!!!");
        } else {
            System.arraycopy(dsbn, d + 1, dsbn, d, n - d - 1);
            dsbn = Arrays.copyOf(dsbn, n - 1);
            n--;
        }
    }

    // Sửa:
    public void SuaTT() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap ma benh nhan: ");
        String ma = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (dsbn[i].getMaBenhNhan().equals(ma)) {
                MenuSua(i);
            }
        }
    }

    public void MenuSua(int m) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("\n** MENU Thong Tin Sua **" + "\n1) Ma benh nhan. \n2) Ho. \n3) Ten. \n4) Gioi Tinh. \n5) Ngay Sinh. \n6) SDT. \n7) Can Nang \n8) Chieu Cao. \n9) Ngay Tai Kham.");
        System.out.print("\nChọn thông tin cần sửa: ");
        int menu = input.nextInt();
        input.nextLine();
        switch(menu) {
            case 1:
                System.out.print("\nNhap thong tin sua: ");
                String tt1 = input.nextLine();
                dsbn[m].setMaBenhNhan(tt1);
                break;
            case 2:
                System.out.print("\nNhap thong tin sua: ");
                String tt2 = input.nextLine();
                dsbn[m].setHo(tt2);
                break;
            case 3:
                System.out.print("\nNhap thong tin sua: ");
                String tt3 = input.nextLine();
                dsbn[m].setTen(tt3);
                break;
            case 4:
                System.out.print("\nNhap thong tin sua: ");
                String tt4 = input.nextLine();
                dsbn[m].setGioiTinh(tt4);
                break;
            case 5:
                System.out.print("\nNhap thong tin sua: ");
                String ngaySinhTemp = input.nextLine();
                LocalDate tt5 = LocalDate.parse(ngaySinhTemp, formatter);
                dsbn[m].setNgaySinh(tt5.format(formatter));
                break;
            case 6:
                System.out.print("\nNhap thong tin sua: ");
                String tt6 = input.nextLine();
                dsbn[m].setSDT(tt6);
                break;
            case 7:
                System.out.print("\nNhap thong tín sua: ");
                double tt7 = input.nextDouble();
                dsbn[m].setCanNang(tt7);
                break;
            case 8:
                System.out.print("\nNhap thong tin sua: ");
                double tt8 = input.nextDouble();
                dsbn[m].setChieuCao(tt8);
                break;
            case 9:
                System.out.print("\nNhap thong tin sua (dd/mm/yyyy): ");
                String ngayTaiKhamTemp = input.nextLine();
                LocalDate tt9 = LocalDate.parse(ngayTaiKhamTemp, formatter);
                dsbn[m].setNgayTaiKham(tt9.format(formatter));
                break;
        }
    }
}

