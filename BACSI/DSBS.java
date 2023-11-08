package BACSI;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.io.*;
public class DSBS {
//Thuoc tinh:
    private BacSi [] dsbs;
    private int n;
    Scanner input = new Scanner(System.in);
//Phuong thuc:
    DSBS(){
        dsbs = null;
        n = 0;
    }

    DSBS(BacSi dsbs[], int n){
        this.dsbs = dsbs;
        this.n = n;
    }

    DSBS(DSBS l){
        dsbs = l.dsbs;
        n = l.n;
    }
    // ham de lay dong thong tin cua bac si
    public String getLine(int i)
    {
        return dsbs[i].getMaBS()+","+dsbs[i].getHo()+","+dsbs[i].getTen()+","+dsbs[i].getGioiTinh()+","+dsbs[i].getNgaySinh()+","+dsbs[i].getSDT()+","+dsbs[i].getTrinhDo()+","+dsbs[i].getChuyenNganh()+","+dsbs[i].getHoatDong();
    }
    //ham thay the dong 
    public void thayThe(String searchCode, String newLine) {
        try {
            FileReader fileReader = new FileReader("E:\\java\\baitap\\doan\\BACSI\\BacSi.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchCode)) {
                    fileContent.append(newLine).append("\n");
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            bufferedReader.close();
            FileWriter fileWriter = new FileWriter("E:\\java\\baitap\\doan\\BACSI\\BacSi.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContent.toString());
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }
  
//Nhap:
    public void ghiFile(String s)
    {
                File outFile = new File("E:\\java\\baitap\\doan\\BACSI\\BacSi.txt");
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
    public void Nhap(){
        System.out.print("\nNhap so luong: ");
        n = input.nextInt();
        dsbs = new BacSi[n];

            
            

        for(int i = 0; i < n; i++){
            dsbs[i] = new BacSi();
            dsbs[i].Nhap();
            
            
            ghiFile(getLine(i));
        }
    }

//Xuat:
    public void Xuat(){
        for(int i = 0; i < n; i++){
            dsbs[i].Xuat();
        }
    }

//Them:
    public void Them(){
        n = dsbs.length;
        dsbs = Arrays.copyOf(dsbs, n + 1);
        dsbs[n] = new BacSi();
        dsbs[n].Nhap();
        ghiFile(getLine(n));
        
        n++;
    
    }

//Tim:
    public int Timkiem(String maBS){
        for(int i = 0; i < n; i++){
            if(dsbs[i].getMaBS().equals(maBS)){
                return i;
            }
        }
        return -1;
    }

//Xoa: 
    public void Xoa(String maBS){
        int d = Timkiem(maBS);
        if(d == -1){
            System.out.print("\nKHONG TON TAI NGUOI NAY!!!");
        }
        else{
            for(int i = d; i < n - 1; i++){
                dsbs[i] = new BacSi(dsbs[i + 1]);
            }
            dsbs = Arrays.copyOf(dsbs, n - 1);
            n--;
        }
    }

//Sua: 
    public void SuaTT(){
        System.out.print("\nNhap ma bac si: ");
        String ma = input.nextLine();
        for(int i = 0; i < n; i++){
            if(dsbs[i].getMaBS().equals(ma)){
                MenuSua(i);
            }
        }
    }
    public void MenuSua(int m){
        System.out.print("\n** MENU Thong Tin Sua **" + "\n1) MaBS. \n2) Ho. \n3) Ten. \n4) Gioi Tinh. \n5) Ngay Sinh. \n6) SDT. \n7) Trinh Do \n8) Chuyen Nganh. \n9) Hoat Dong.");
        System.out.print("\nChon thong tin can sua: ");
        int menu = input.nextInt();
        input.nextLine();
        switch(menu){
            case 1:
                System.out.print("\nNhap thong tin sua: ");
                String tt1 = input.nextLine();
                dsbs[m].setMaBS(tt1);
                break;
            case 2:
                System.out.print("\nNhap thong tin sua: ");
                String tt2 = input.nextLine();
                dsbs[m].setHo(tt2);
                break;
            case 3:
                System.out.print("\nNhap thong tin sua: ");
                String tt3 = input.nextLine();
                dsbs[m].setTen(tt3);
                break;
            case 4:
                System.out.print("\nNhap thong tin sua: ");
                String tt4 = input.nextLine();
                dsbs[m].setGioiTinh(tt4);
                break;
            case 5:
                System.out.print("\nNhap thong tin sua: ");
                String ngaySinhTemp = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
                LocalDate tt5 = LocalDate.parse(ngaySinhTemp, formatter);
                dsbs[m].setNgaySinh(tt5);
                break;
            case 6:
                System.out.print("\nNhap thong tin sua: ");
                String tt6 = input.nextLine();
                dsbs[m].setSDT(tt6);
                break;
            case 7:
                System.out.print("\nNhap thong tin sua: ");
                String tt7 = input.nextLine();
                dsbs[m].setTrinhDo(tt7);
            case 8:
                System.out.print("\nNhap thong tin sua: ");
                String tt8 = input.nextLine();
                dsbs[m].setChuyenNganh(tt8);
            case 9:
                System.out.print("\nNhap thong tin sua: ");
                boolean tt9 = input.nextBoolean();
                dsbs[m].setHoatDong(tt9);

        }

        thayThe(dsbs[m].getMaBS(),getLine(m));
    }
}
