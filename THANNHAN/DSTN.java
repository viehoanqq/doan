package THANNHAN;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DSTN {
    private ThanNhan[] dstn = new ThanNhan[1];
    private int soLuongTN;
    Scanner input = new Scanner(System.in);
    DSTN()
    {
        soLuongTN = 0;
        dstn[0] = new ThanNhan();
        dstn[0] = null;
    }
    DSTN(ThanNhan [] ds, int sl)
    {
        dstn = ds;
        soLuongTN = sl;
    }
    DSTN(DSTN ds)
    {
        dstn = ds.dstn;
        soLuongTN = ds.soLuongTN;
    }
    public String fileTN()
    {
        return "E:\\java\\baitap\\doan\\THANNHAN\\ThanNhan.txt";
    }
//ham lay dong de ghi vao file
    public String getLine(int i)
    {
        return (dstn[i].getMaTN()+","+dstn[i].getMaBN()+","+dstn[i].getHo()+","+dstn[i].getTen()+","+dstn[i].getGioiTinh()+","+dstn[i].getNgaySinh()+","+dstn[i].getSDT()+","+dstn[i].getQuanHe()+".");
    }
//ham de xoa data trong 1 file
    public void xoaDataFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write("");

            writer.close();
        } catch (IOException e) {
            System.out.println("loi");
        }
    }
//ham ghi file
    public void ghiLine(String fileName,String s)
    {
        // xoa data trong file tr
        File outFile = new File(fileName);
        PrintWriter write=null;
            try {

                write= new PrintWriter(new FileWriter(outFile,true));
        
                }
        
               catch (Exception e){ System.out.println("Khong the tao tap tin ket qua");
        
                                    return;
               }
               write.print(s);
               write.print("\n");
               write.close();
    }
    void ghiFile()
    {
        xoaDataFile(fileTN());
        ghiLine(fileTN(),String.valueOf(soLuongTN));
        for (int i=0;i<soLuongTN;i++)
        {
            ghiLine(fileTN(),getLine(i));
        }
    }



        void nhap()
        {
            //xoa data trong file truoc khi ghi lai file moi
            xoaDataFile(fileTN());
            Scanner input = new Scanner(System.in);
            System.out.print(" - So : "); 
            soLuongTN = input.nextInt();
            dstn = new ThanNhan[soLuongTN];
            for (int i=0;i<soLuongTN;i++)
            {
                dstn[i] = new ThanNhan();
                System.out.print("Than Nhan ["+(i+1)+"] :\n");
                dstn[i].nhap();
                System.out.print("\n");
            }
            ghiFile();
        }
        void docData()
        {
            File inFile = new File(fileTN());
            Scanner read = null;
            try
            {
                read = new Scanner(inFile);
            }
            catch (Exception e)
            {
                System.out.print("khong the mo file ThanNhan.txt");
                return ;
            }
            int i=0;
            int k=0;
            String s="";
            String sl = read.nextLine();
            dstn = new ThanNhan[Integer.parseInt(sl)];
            while (read.hasNextLine())
            {   
                dstn[i] = new ThanNhan();
                String line = read.nextLine();
                for(int j=0;j<line.length();j++)
                {
                    char c = line.charAt(j);
                    if (c!=','&& c!='.')
                    {
                        s=s+c;
                    }
                    else
                    {   if (k==0) dstn[i].setMaBN(s);
                        if (k==1) dstn[i].setMaTN(sl);
                        if (k==2) dstn[i].setHo(s);
                        if (k==3) dstn[i].setTen(s);
                        if (k==4) dstn[i].setGioiTinh(s);
                        if (k==5) 
                        {
                        String ngaySinhTemp =s;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            LocalDate ngaySinh = LocalDate.parse(ngaySinhTemp, formatter);
                            dstn[i].setNgaySinh(ngaySinh);
                        }
                        if (k==6) dstn[i].setSDT(s);
                        if (k==7) 
                        {   
                            dstn[i].setQuanHe(s);
                        }
                        k++;
                        s="";
                        if (k==8) k=0;
                    
                    }

                }
                i++;
            }
            soLuongTN = i;
            read.close();
        }
    void xuat()
        {
            docData();
            System.out.println("Danh sach than nhan: ");
            for (int i=0;i<soLuongTN;i++)
            {
                dstn[i].xuat();
                System.out.print("\n");
            }
        }


    void them()
    {
        dstn= Arrays.copyOf(dstn,soLuongTN+1);
        dstn[soLuongTN] = new ThanNhan();
        dstn[soLuongTN].nhap();
        soLuongTN++;
        ghiFile();
    }

    void sua()
    {
        Scanner input = new Scanner(System.in);
        System.out.print(" - Nhap ma than nhan can sua: ");
        String ma = input.nextLine();
        boolean flag = false;
        for (int i=0;i<soLuongTN;i++)
        {
            if (ma.equals(dstn[i].getMaTN()))
            
            {
                flag = true;
                dstn[i].sua();
            }
        }
        if (!flag )
        System.out.println("khong tim thay nhan vien");
        ghiFile();
        
    }

    
    void sua(String ma)
    {
        boolean flag = false;
        for (int i=0;i<soLuongTN;i++)
        {
            if (ma.equals(dstn[i].getMaTN()))
            
            {
                flag = true;
                dstn[i].sua();
            }
        }
        if (!flag )
        System.out.println("khong tim thay nhan vien");

//sua trong file
        ghiFile();


    }
    boolean locThongTin(String line,String s)
    {
        if (line.indexOf(s) == -1)
        return false;
        else
        return true;
    }




    void xoa()
    {
//xoa trong array hien tai
        System.out.println(" - Nhap ma nhan vien can xoa: ");
        Scanner input = new Scanner(System.in);
        String ma;
        ma = input.nextLine();
        boolean flag = false;
        for (int i=0;i<soLuongTN;i++)
        {
            if (ma.equals(dstn[i].getMaTN()))
            {
                flag = true;
                for (int j=i;j<soLuongTN-1;j++)
                {
                    dstn[j]=dstn[j+1];
                }
                soLuongTN--;
            }

        }
        if (!flag)
        {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }
        ghiFile();
    }



    void xoa(String ma)
    {
//xoa trong array hien tai

        boolean flag = false;
        for (int i=0;i<soLuongTN;i++)
        {
            if (ma.equals(dstn[i].getMaTN()))
            {
                flag = true;
                for (int j=i;j<soLuongTN-1;j++)
                {
                    dstn[j] = dstn [ j+1];
                }
                soLuongTN--;
            }

        }
        if (!flag)
        {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }
// xoa trong file
        ghiFile();
    }

    public ThanNhan timkiem()
    {
        Scanner input = new Scanner(System.in);
        System.out.println(" - Nhap ma nhan vien hoac ten nhan vien can tim kiem: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongTN;i++)
        {
            if ((ma.equals(dstn[i].getMaTN())) || (ma.equals(dstn[i].getTen())) )
            {
                return dstn[i];
            }
        }
        System.out.println("Khong tim thay nhien vien");
        ThanNhan nv = new ThanNhan();
        return nv;
    }

    public ThanNhan timkiem(String ma)
    {
       for (int i=0;i<soLuongTN;i++)
        {
            if ((ma.equals(dstn[i].getMaTN())) || (ma.equals(dstn[i].getTen())) )
            {
                return dstn[i];
            }
        }
        System.out.println("Khong tim thay nhien vien");
        ThanNhan nv = new ThanNhan();
        return nv;
    }

    public void thongKeThanNhan()
    {

    }

    
}
