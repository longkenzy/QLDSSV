
import java.io.Serializable;
import java.util.Scanner;

public class SinhVien implements Serializable {
	public String Name;
	public String MSSV;
	public double dTB;

	public SinhVien() {
	}

	public SinhVien(String name, String mssv, double dTB) {
		this.Name = name;
		this.MSSV = mssv;
		this.dTB = dTB;
	}

	public void NhapSV(Scanner sc) {
		sc.nextLine();
		System.out.println("Name: ");
		Name = sc.nextLine();
		System.out.println("MSSV: ");
		MSSV = sc.nextLine();
		System.out.println("Diem trung binh: ");
		dTB = sc.nextDouble();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	public double getdTB() {
		return dTB;
	}

	public void setdTB(double dTB) {
		this.dTB = dTB;
	}

	public String hocluc() {
		if (this.dTB < 5)
			return "Yeu";
		else if (this.dTB < 6)
			return "Trung Binh";
		else if (this.dTB < 7)
			return "Trung Binh Kha";
		else if (this.dTB < 8)
			return "Kha";
		else if (this.dTB < 9)
			return "Gioi";
		else
			return "Xuat Sac";
	}

	public String toString() {
		return String.format("%-32s %-10s %-10.1f %-10s\n", Name, MSSV, dTB, hocluc());
	}
}
