package docfile;


import java.io.File;// khai bao thu vien file


import java.io.PrintWriter; // khai bao thu vien de ghi vao file

import java.util.Scanner; // khai bao ham nhap



public class SinhVien {

    public static void main(String[] args) {


    	File outFile = new File("E:\\java\\baitap\\doan\\docfile\\SinhVien.txt");  // 

    	Scanner read=null;

    	PrintWriter write=null;

    	try {

            write= new PrintWriter(outFile);

   	         }

   	catch (Exception e){ System.out.println("Khong the tao tap tin ket qua");

   	                     return;

   	}

    int sinhVienCNTT = 0;
	File inFile = new File("E:\\java\\baitap\\doan\\docfile\\SinhVien.txt");
    int sinhVienQTKD = 0;
	try
            {
                read = new Scanner(inFile);
            }
            catch (Exception e)
            {
                System.out.print("khong the mo file NhanVien.txt");
                return;
            }

    String tieuDe = read.nextLine();

    while(read.hasNextLine())

    {

    	String s= read.nextLine();

    	String[] tokens=s.split(",");

    	if(tokens[4].trim().toUpperCase().compareTo("QUAN TRI KINH DOANH")==0) sinhVienQTKD++;

    	if(tokens[4].toUpperCase().compareTo("CONG NGHE THONG TIN")==0)

    		    {

    		     sinhVienCNTT++;

    		     write.println(s);

    		    }

    }//while

    read.close();

    write.close();

    System.out.println("So sinh vien nganh QTKD = "+ sinhVienQTKD);

    System.out.println("So sinh vien nganh CNTT = "+ sinhVienCNTT);

    System.out.println("Tap tin sinh vien CNTT:  D:\\SinhVienCNTT.txt");

   }

}