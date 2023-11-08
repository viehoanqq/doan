package THANNHAN;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ThanNhan 
{
    Scanner input = new Scanner(System.in);
    private String maTN,maBN,ho,ten,gioiTinh,SDT,quanHe;
    private LocalDate ngaySinh;

    public ThanNhan()
    {
        maTN = null;
        maBN=  null;
        ho = null;
        ten = null;
        gioiTinh= null;
        ngaySinh = null;
        SDT= null;
        quanHe = null;
    }
    public ThanNhan(String maTN,String maNV,String ho,String ten,String gioiTinh,LocalDate ngaySinh,String SDT,String quanHe)
    {
        this.maTN = maTN;
        this.maBN = maNV;
        this.ho=ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.quanHe = quanHe;
        
    }
    public ThanNhan(ThanNhan tn)
    {
        maTN = tn.maTN;
        maBN=tn.maBN;
        ho=tn.ho;
        ten=tn.ten;
        gioiTinh=tn.gioiTinh;
        ngaySinh=tn.ngaySinh;
        SDT= tn.SDT;
        quanHe = tn.quanHe;
    }
    public void nhap()
    {
        System.out.print(" - Ma TN: ");
        maTN = input.nextLine();
        System.out.print(" - Ma BN: ");
        maBN = input.nextLine();
        System.out.print(" - Ho: ");
        ho = input.nextLine();
        System.out.print(" - Ten: ");
        ten = input.nextLine();
        System.out.print(" - Gioi tinh(Nam/Nu)?:  ");
        gioiTinh = input.nextLine();
        System.out.print(" - Ngay sinh(dd/mm/yyyy): ");
        String ngaySinhTemp = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ngaySinh = LocalDate.parse(ngaySinhTemp, formatter);
        System.out.print(" - SDT: ");
        SDT = input.nextLine();
        System.out.print(" -  Quan He: ");
        quanHe = input.nextLine();
    }
    public void xuat()
    {
        System.out.print(maTN+"     "+maBN+"         "+ho+" "+ten+"         "+gioiTinh+"         "+ngaySinh+"         "+SDT+"         "+quanHe);
    }

//GET
    public String getMaTN()
    {
        return maTN;
    }
    public String getMaBN()
    {
        return maBN;
    }
    public String getHo()
    {
        return ho;
    }
    public String getTen()
    {
        return ten;
    }
    public String getGioiTinh()
    {
        return gioiTinh;
    }
    public LocalDate getNgaySinh()
    {
        return ngaySinh;
    }
    public String getSDT()
    {
        return SDT;
    }
    public String getQuanHe()
    {
       return quanHe;
    }
    
//SET
    public void setMaTN(String data)
    {
        maTN = data;
    }
    public void setMaBN(String data)
    {
        maBN = data;
    }
    public void setHo(String data)
    {
        ho = data;
    }
    public void setTen(String data)
    {
        ten = data;
    }
        public void setGioiTinh(String data)
    {
        gioiTinh = data;
    }
    public void setNgaySinh(LocalDate data)
    {
        ngaySinh = data;
    }
    public void setSDT(String data)
    {
        SDT = data;
    }
    public void setQuanHe(String data)
    {
        quanHe = data;
    }
    public void sua()
    {
        System.out.println("---------------");
        System.out.println("1. Ma than nhan");
        System.out.println("2. Ma benh nhan");
        System.out.println("3. Ho");
        System.out.println("4. Ten");
        System.out.println("5. Gioi tinh");
        System.out.println("6. Ngay sinh");
        System.out.println("6. SDT");
        System.out.println("7. Quan he");
        System.out.print("CHon thong tin can sua: ");
        int n = input.nextInt();
        input.nextLine();
        System.out.print("CHon noi dung can sua: ");
        String nd = input.nextLine();
        
        switch(n)
        {
            case 0:
            {
                setMaTN(nd);
            } break;
            case 2:
            {
                setMaBN(nd);
            } break;

            case 3:
            {
                setHo(nd);
            } break;
            
            case 4:
            {
                setTen(nd);
            } break;
            
            case 5:
            {
                setGioiTinh(nd);
            } break;
            
            case 6:
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ns = LocalDate.parse(nd, formatter);
                setNgaySinh(ns);
            } break;
            
            case 7:
            {
                setSDT(nd);
            } break;

            case 8:
            {
                setQuanHe(nd);
            } break;

            default:
            {
                System.out.print("Sai!");
            }
        }

    }

}