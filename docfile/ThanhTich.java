package docfile;

public class ThanhTich {
    private String tenNuoc;
    int HCV,HCB,HCD;

    public ThanhTich()
    {
        tenNuoc = "";
        HCV = 0;
        HCB = 0;
        HCD =0;
    }
    public ThanhTich(String t,int v,int b,int d)
    {
        tenNuoc = t;
        HCV =v;
        HCB = b;
        HCD = d;
    }

    public ThanhTich(ThanhTich tt)
    {
        tenNuoc = tt.tenNuoc;
        HCV =tt.HCV;
        HCB = tt.HCB;
        HCD = tt.HCD;
    }

    public String toString()
    {
        return tenNuoc+","+String.valueOf(HCV)+","+String.valueOf(HCB)+","+String.valueOf(HCD);
    }
    public void setTenNuoc(String t)
    {
        tenNuoc = t;
    }
    public void setHCV(int t)
    {
        HCV = t;
    }
    public void setHCB(int t)
    {
        HCB = t;
    }
    public void setHCD(int t)
    {
        HCD = t;
    }
    public String getTenNuoc()
    {
        return tenNuoc;
    }
    public int getSoHCV()
    {
        return HCV;
    }
}
