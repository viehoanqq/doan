package docfile;
public class QuocGia {
    private String tenNuoc,thuDo;
    private int danSo;
    private double dienTich;
    
    public QuocGia()
    {
        tenNuoc = "";
        thuDo = "";
        danSo = 0;
        dienTich =0;
    }
    public QuocGia(String tn,String td,int ds,double dt)
    {
        tenNuoc = tn;
        thuDo = td;
        danSo = ds;
        dienTich = dt;
    }

    public QuocGia(QuocGia qg)
    {
        tenNuoc = qg.tenNuoc;
        thuDo = qg.thuDo;
        danSo = qg.danSo;
        dienTich =qg.dienTich;
    }
    

    public String toString()
    {
        return tenNuoc+","+thuDo+","+String.valueOf(danSo)+","+String.valueOf(dienTich);
    }
    public void setTenNuoc(String tt)
    {
        tenNuoc= tt;
    }
    public void setThuDo(String tt)
    {
        thuDo= tt;
    }
    public void setDienTich(double tt)
    {
        dienTich= tt;
    }
    public void setDanSo(int tt)
    {
        danSo= tt;
    }

    public String getTenNuoc()
    {
        return tenNuoc;
    }
}
