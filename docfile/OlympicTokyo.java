package docfile;
import java.io.*;
import java.util.Scanner;
public class OlympicTokyo {
    public static void main(String[] args) {

        // khai bao 2 mang 
        QuocGia [] QGList  = new QuocGia[21];
        ThanhTich [] TTList = new ThanhTich[21];


        //doc file Top20TokyoInfo.txt va truyen vao mang QGList
        File file = new File("E:\\java\\bt\\Top20TokyoInfo.txt");
        Scanner read =null;
        try{
            read = new Scanner(file);
        } catch(Exception e){
            System.out.println(" Khong the mo file !");
        }

        String tieuDe = read.nextLine();
        int i=0;
        while (read.hasNextLine())
        {
            String line = read.nextLine();
            String arr[] = line.split(",");
            QGList[i] = new QuocGia();
            QGList[i].setTenNuoc(arr[0]);
            QGList[i].setThuDo(arr[1]);
            QGList[i].setDanSo(Integer.parseInt(arr[2]));
            QGList[i].setDienTich(Double.parseDouble(arr[3]));
            i++;

        }
        //doc file Top20Tokyo.txt va truyen vao mang TTList
        File file2 = new File("E:\\java\\bt\\Top20Tokyo.txt");
        Scanner read2 =null;
        try{
            read2 = new Scanner(file2);
        } catch(Exception e){
            System.out.println(" Khong the mo file !");
        }
        String tieuDe2 = read2.nextLine();
        String soNuoc = read2.nextLine();
        String lineNuoc = read2.nextLine();
        String arrTenNuoc[] = lineNuoc.split(",");
        // khai bao 20 pt cua mang TTList va set ten nuoc cho 20 pt do
        for (int k=0;k<Integer.parseInt(soNuoc);k++)
        {
            TTList[k] = new ThanhTich();
            TTList[k].setTenNuoc(arrTenNuoc[k]);
        }
        int m =0;

        //doc file va truyen tham so vao mang TTList
        while (read2.hasNextLine())
        {
            String line = read2.nextLine();
            if (line != "")
            {

            String arr2[] = line.split(",");
            TTList[m].setHCV(Integer.parseInt(arr2[0].trim()));
            TTList[m].setHCB(Integer.parseInt(arr2[1].trim()));
            TTList[m].setHCD(Integer.parseInt(arr2[2].trim()));
            m++;
            }
        }


        // MENU CHON
        System.out.println("======== MENU =========");
        System.out.println("1: in ra thong tin 20 qg ");
        System.out.println("2: in ra thanh tich 20 qg ");
        System.out.println("3: Nhap ten 1 qg va in ra thong tin va thanh tich ");
        System.out.println("4: Nhap so hcv va in ra cac nuoc co so hcv lon hon");
        System.out.println("5: khong hieu de");
        System.out.println("6: ket thuc ");
        int dem=0;
        Scanner input = new Scanner(System.in);
        do
        {
        System.out.print("Lua chon: ");
        dem= input.nextInt();
        input.nextLine();
        switch(dem)
        {
            case 1:
            { 
                //in thong tin 20 nuoc
                for (int l=0;l<20;l++)
                {
                    System.out.println(QGList[l].toString());
                }
            } break;
            case 2:
            {
                for (int l=0;l<20;l++)
                {   
                    // in thanh tich 20 nuoc
                    System.out.println(TTList[l].toString());
                }
            } break;
            case 3:
            {
                //nhap ten 1 quoc gia va in thong tin va thong tich neu co
                System.out.print("Nhap ten 1 quoc gia: ");
                String ten = input.nextLine();
                boolean flag =false;
                for (int l=0;l<20;l++)
                {
                    if (ten.toUpperCase().equals(QGList[l].getTenNuoc().toUpperCase().trim()))
                    {
                        flag =true;
                        System.out.println(QGList[l].toString());
                    }
                    if (ten.toUpperCase().equals(TTList[l].getTenNuoc().toUpperCase().trim()))
                    { 
                        flag =true;
                        System.out.println(TTList[l].toString());
                    }
                    
                }
                if (!flag)
                    System.out.println("Khon tim thay!");
            } break;

            case 4:
            {
                System.out.print("Nhap so hcv : ");
                int hcv = input.nextInt();
                input.nextLine();
                for (int l=0;l<20;l++)
                {
                    if (hcv <= TTList[l].getSoHCV())
                    {
                        for (int n = 0;n<20;n++)
                        {
                            if (TTList[l].getTenNuoc().toUpperCase().trim().equals(QGList[n].getTenNuoc().toUpperCase()))
                            {
                                System.out.println(QGList[n].toString());
                            }
                        }
                    }
                }
            }

        }

        } while (dem!=6);


    }
}
