package BENNHAN;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FILE {

    public String filePath()
    {
        return "E:\\java\\baitap\\doan\\BENNHAN"; // tu them path file
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

    void ghiFile(int soLuongNV,String s)
    {
        xoaDataFile();
        File outFile = new File(filePath()) ;
        PrintWriter write=null;
            try {

                write= new PrintWriter(new FileWriter(outFile,true));
        
                }
        
               catch (Exception e){ System.out.println("Khong the tao tap tin ket qua");
        
                                    return;
               }
               write.print(String.valueOf(soLuongNV));
               write.print("\n");
        for (int i=0;i<soLuongNV;i++)
        {
            write.print(s);
            write.print("\n"); // điền dsnv[i].getMaNV()+","+dsnv[i].getHo()+","+dsnv[i].getTen()+","+dsnv[i].getGioiTinh()+","+dsnv[i].getNgaySinh()+","+dsnv[i].getChucVu()+","+dsnv[i].getSDT()+","+dsnv[i].getHoatDong() 
        }
        write.close();
    }
}
