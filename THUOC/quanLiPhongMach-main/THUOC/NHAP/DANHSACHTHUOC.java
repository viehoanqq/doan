package THUOC.NHAP;
import java.util.Arrays;
import java.util.Scanner;

public class DANHSACHTHUOC {
    Scanner mayScanner = new Scanner(System.in);
    private THUOC[] dsThuoc;
    private int soLuongThuoc;

    DANHSACHTHUOC() {
        this.dsThuoc = new THUOC[0];
        this.soLuongThuoc = 0;
    }

    DANHSACHTHUOC(THUOC[] dsThuoc, int soLuongThuoc) {
        this.dsThuoc = dsThuoc;
        this.soLuongThuoc = soLuongThuoc;
    }

    DANHSACHTHUOC(DANHSACHTHUOC newDsThuoc) {
        this.dsThuoc = newDsThuoc.dsThuoc;
        this.soLuongThuoc = newDsThuoc.soLuongThuoc;
    }

    public THUOC[] getDsThuoc() {
        return this.dsThuoc;
    }

    public int getSoLuongThuoc() {
        return this.soLuongThuoc;
    }

    public void setSoLuongThuoc(int soLuongThuoc) {
        this.soLuongThuoc = soLuongThuoc;
    }

    public int[] getSoThuocTungLoai() {
        int[] thuocTungLoai = new int[2];
        Arrays.fill(thuocTungLoai, 0);
        // thuoc chich la 0
        // thuoc vi la 1
        for (THUOC i : this.dsThuoc) {
            if (i instanceof THUOCCHICH)
                thuocTungLoai[0] += 1;
            else if (i instanceof THUOCVI)
                thuocTungLoai[1] += 1;
        }
        return thuocTungLoai;
    }

    public void nhapThuoc(int soThuocCanNhap) {
        for (int i = 0; i < soThuocCanNhap; i++) {
            int typeThuoc;
            do {
                System.out.print("Nhap loai thuoc(0 la thuoc chich, 1 la thuoc vi): ");
                typeThuoc = mayScanner.nextInt();
                if (typeThuoc == 0) {
                    this.dsThuoc[i] = new THUOCCHICH();
                    this.dsThuoc[i].nhapThongTinThuoc();
                } else if (typeThuoc == 1) {
                    this.dsThuoc[i] = new THUOCVI();
                    this.dsThuoc[i].nhapThongTinThuoc();
                }
            }

            while (typeThuoc < 0 && typeThuoc > 1);

        }
    }

    public void themThuoc(THUOC newThuoc) {
        this.soLuongThuoc += 1;
        this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc);
        this.dsThuoc[soLuongThuoc - 1] = newThuoc;
        
    }
    public void addThuoc()
    {
        this.soLuongThuoc +=1;
        this.dsThuoc = Arrays.copyOf(this.dsThuoc,this.soLuongThuoc);
        System.out.print("Nhap loai thuoc(0 la thuoc chich, 1 la thuoc vi): ");
                int typeThuoc = mayScanner.nextInt();
                if (typeThuoc == 0) {
                    this.dsThuoc[soLuongThuoc-1] = new THUOCCHICH();
                    this.dsThuoc[soLuongThuoc-1].nhapThongTinThuoc();
                } else if (typeThuoc == 1) {
                    this.dsThuoc[soLuongThuoc] = new THUOCVI();
                    this.dsThuoc[soLuongThuoc].nhapThongTinThuoc();
                }

    }

    public void xoaThuoc(int index) {
        if (index == this.soLuongThuoc - 1) {
            this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc - 1);
            this.soLuongThuoc -= 1;
        } else {
            for (int i = index; i < this.soLuongThuoc - 1; i++)
                this.dsThuoc[i] = this.dsThuoc[i + 1];
            this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc - 1);
            this.soLuongThuoc -= 1;
        }
    }

    public void suaThongTin() {
        System.out.println("Nhap ma thuoc can sua: ");
        String maThuocCanSua = mayScanner.nextLine();
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (maThuocCanSua.equals(this.dsThuoc[i].getMaThuoc()))
                this.dsThuoc[i].suaThongTinThuoc();
        }
    }

    public void inDanhSachThuoc() {
        int[] thuocTungLoai = this.getSoThuocTungLoai();
        System.out.println("So thuoc chich: " + thuocTungLoai[0]);
        System.out.println("So thuoc vi: " + thuocTungLoai[1]);

        for (int i = 0; i < this.soLuongThuoc; i++) {
            this.dsThuoc[i].inThongTinThuoc();
        }
    }

    public void timThuocTheoTen(String tenThuocCanTim) {
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getTenThuoc().equals(tenThuocCanTim))
                dsThuoc[i].inThongTinThuoc();
        }
    }

    public THUOC timThuocTheoMa(String maThuocCanTim) {
        
        int index = 0;
        for(int i = 0; i < this.soLuongThuoc; i ++) {
            // System.out.println(this.dsThuoc[i].getMaThuoc() + " - " + maThuocCanTim);
            if(this.dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuocCanTim))
                index = i;
        }
        if(this.dsThuoc[index] instanceof THUOCCHICH) {
            THUOCCHICH thuocchich = new THUOCCHICH();
            thuocchich = (THUOCCHICH)this.dsThuoc[index];
            return thuocchich;
        }
        if(this.dsThuoc[index] instanceof THUOCVI) {
            THUOCVI thuocvi = new THUOCVI();
            thuocvi = (THUOCVI)this.dsThuoc[index];
            return thuocvi;
        }
        return null;
        
    }
    public int timThuocTheoMaTraVeViTrI(String maThuocCanTim) {
        
        int index = 0;
        for(int i = 0; i < this.soLuongThuoc; i ++) {
            // System.out.println(this.dsThuoc[i].getMaThuoc() + " - " + maThuocCanTim);
            if(this.dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuocCanTim))
                return i;
        }
        return -1;
        
    }


    public void addSoLuongThuoc(int i,int soLuong)
    {
        dsThuoc[i].setSoLuong(dsThuoc[i].getSoLuong()+soLuong);
    }
    // 2 loai 
}
