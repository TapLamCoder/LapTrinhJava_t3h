package chuDeAbstractVaInterface;

public class HinhTron extends HinhHoc
{
	private int bk;

	public int getBk() 
	{
		return bk;
	}

	public void setBk(int bk) 
	{
		this.bk = bk;
	}
	//Override Constructor HinhTron
	public HinhTron ()
	{
		setBk(0);
	}
	//Overload Constructor HinhTron
	public HinhTron (int bknhap)
	{
		setBk(bknhap);
	}
	
	//Override chuVi method
	public double chuVi() 
	
	{
		return (double)getBk()* 2 * Math.PI;
	}
	
	//Override dienTich method
	public double dienTich()
	{
		return (double)getBk() * getBk() * Math.PI;
	}
	
	public String TenHinh()
	{
		return super.tenHinh() + "Hinh Tron";
	}
}

