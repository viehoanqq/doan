package BENNHAN;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.Period;

class BenhNhan {
    private String Ho;
    private String Ten;
    private String gioiTinh;
    private String SDT;
    private double canNang;
    private double chieuCao;
    private LocalDate ngaySinh;
    private String maBenhNhan;
    private String queQuan;
    private String benhNen;
    private LocalDate ngayTaiKham;
    
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    BenhNhan() {
        this.Ho = "NULL";
        this.Ten = "NULL";
        this.gioiTinh = "NULL";
        this.SDT = "NULL";
        this.canNang = 0;
        this.chieuCao = 0;
        this.ngaySinh = LocalDate.of(0, 1, 1); 
        this.maBenhNhan = "NULL";
        this.queQuan = "NULL";
        this.benhNen = "NULL";
        this.ngayTaiKham = LocalDate.of(0, 1, 1);
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setCanNang(double canNang) {
        this.canNang = canNang;
    }

    public void setChieuCao(double chieuCao) {
        this.chieuCao = chieuCao;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = LocalDate.parse(ngaySinh, dateFormatter);
    }


    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setBenhNen(String benhNen) {
        this.benhNen = benhNen;
    }

    public void setNgayTaiKham(String ngayTaiKham) {
        this.ngayTaiKham = LocalDate.parse(ngayTaiKham, dateFormatter);
    }
    
    public String getHo() {
        return this.Ho;
    }

    public String getTen() {
        return this.Ten;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public String getSDT() {
        return this.SDT;
    }

    public double getCanNang() {
        return this.canNang;
    }

    public double getChieuCao() {
        return this.chieuCao;
    }

    public String getNgaySinh() {
        return ngaySinh.format(dateFormatter);
    }

    public String getMaBenhNhan() {
        return this.maBenhNhan;
    }

    public String getQueQuan() {
        return this.queQuan;
    }

    public String getBenhNen() {
        return this.benhNen;
    }

    public String getNgayTaiKham() {
        return this.ngayTaiKham.format(dateFormatter);
    }

    public void xuatSoNgayDenNgayTaiKham() {
    LocalDate ngayHienTai = LocalDate.now();
    Period period = ngayHienTai.until(ngayTaiKham);
    int soNgay = period.getDays();
    int soThang = period.getMonths();
    int soNam = period.getYears();
    if (soNgay > 0 || soThang > 0 || soNam > 0) {
        System.out.print("Thoi gian con lai den ngay tai kham: ");
                    if (soNam > 0 ) System.out.print(soNam + " nam ");
                    if (soThang > 0 ) System.out.print(soThang + " thang ");
                    System.out.println( soNgay +" ngay.");
        } else if (soNgay == 0 && soThang == 0 && soNam ==0) {
        System.out.println("Hom nay la ngay tai kham.");
        } else {
        System.out.println("Da qua han tai kham!");
        }
    }
    
public void nhapThongTinBenhNhan() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ho cua benh nhan: ");
    Ho = sc.nextLine();
    System.out.print("Nhap ten cua benh nhan: ");
    Ten = sc.nextLine();
    System.out.print("Nhap gioi tinh cua benh nhan: ");
    gioiTinh = sc.nextLine();
    System.out.print("Nhap so dien thoai cua benh nhan: ");
    SDT = sc.nextLine();
    System.out.print("Nhap can nang cua benh nhan (kg): ");
    canNang = sc.nextDouble();
    System.out.print("Nhap chieu cao cua benh nhan (cm): ");
    chieuCao = sc.nextDouble();
    sc.nextLine(); 
        
    String ngaySinhStr;
    LocalDate ngaySinhDate;
    do {
        System.out.print("Nhap ngay sinh cua benh nhan (dd/mm/yyyy): ");
        ngaySinhStr = sc.nextLine();
        ngaySinhDate = LocalDate.parse(ngaySinhStr, dateFormatter);
    } while (ngaySinhStr.isEmpty());
    ngaySinh = ngaySinhDate;

    System.out.print("Nhap ma benh nhan: ");
    maBenhNhan = sc.next();
    sc.nextLine();  // Đọc dòng trống sau số thực
    System.out.print("Nhap que quan cua benh nhan: ");
    queQuan = sc.nextLine();
    System.out.print("Nhap benh nen cua benh nhan: ");
    benhNen = sc.nextLine();

    String ngayTaiKhamStr;
    LocalDate ngayTaiKhamDate;
    do {
        System.out.print("Nhap ngay tai kham (dd/mm/yyyy): ");
        ngayTaiKhamStr = sc.nextLine();
        ngayTaiKhamDate = LocalDate.parse(ngayTaiKhamStr, dateFormatter);
    } while (ngayTaiKhamStr.isEmpty()); 
    ngayTaiKham = ngayTaiKhamDate;
}
    
    public void xuatThongTinBenhNhan() {
        System.out.println("------------------");
        System.out.println("Ho ten cua benh nhan: " + Ho + " " + Ten);
        System.out.println("Gioi tinh cua benh nhan: " + gioiTinh);
        System.out.println("So dien thoai cua benh nhan: " + SDT);
        System.out.println("Can nang cua benh nhan (kg): " + canNang);
        System.out.println("Chieu cao cua benh nhan (cm): " + chieuCao);
        System.out.println("Ngay sinh cua benh nhan: " + ngaySinh.format(dateFormatter));
        System.out.println("Ma benh nhan: " + maBenhNhan);
        System.out.println("Que quan cua benh nhan: " + queQuan);
        System.out.println("Benh nen cua benh nhan: " + benhNen);
        System.out.println("Ngay tai kham: " + ngayTaiKham.format(dateFormatter));
        xuatSoNgayDenNgayTaiKham(); 
    }
}

