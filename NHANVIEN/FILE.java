package NHANVIEN;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FILE {

    public String filePath()
    {
        return "E:\\java\\baitap\\doan\\NHANVIEN\\NhanVien.txt"; // tu them path file
    }

//ham de xoa data trong 1 file
    public void xoaDataFile() {
        try {
            FileWriter writer = new FileWriter(filePath(), false);
            writer.write("");

            writer.close();
        } catch (IOException e) {
            System.out.println("loi");
        }
    }
//ham ghi file
    public void ghiLine(String s)
    {
    
        // xoa data trong file tr
        File outFile = new File(filePath()) ;
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
    void ghiFile(int soLuongNV)
    {
        xoaDataFile();
        ghiLine(String.valueOf(soLuongNV));
        for (int i=0;i<soLuongNV;i++)
        {
            ghiLine(""); // điền dsnv[i].getMaNV()+","+dsnv[i].getHo()+","+dsnv[i].getTen()+","+dsnv[i].getGioiTinh()+","+dsnv[i].getNgaySinh()+","+dsnv[i].getChucVu()+","+dsnv[i].getSDT()+","+dsnv[i].getHoatDong() 
        }
    }
}
