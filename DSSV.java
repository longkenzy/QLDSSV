
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class DSSV {
	static Scanner sc = new Scanner(System.in);
	static SinhVien sinhVien = new SinhVien();

	public static void NhapDSSV(LinkedList<SinhVien> list) {
		System.out.println("Nhap vao so luong SV: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			SinhVien sinhVien = new SinhVien();
			sinhVien.NhapSV(sc);
			list.add(sinhVien);
		}

	}

	public static void XuatSV(LinkedList<SinhVien> list) {
		System.out.printf("%-32s %-10s %-10s %-10s\n", "Name", "MSSV", "Diem TB", "Hoc Luc");
		for (SinhVien sinhVien : list) {
			System.out.println(sinhVien);
		}
	}

	public static void TimSV(LinkedList<SinhVien> list) {
		boolean flag = false;
		sc.nextLine();
		System.out.println("Nhap ten Sinh Vien can tim: ");
		String name = sc.nextLine();
		System.out.printf("%-10s %-10s %-10s %-10s\n", "Name", "MSSV", "Diem TB", "Hoc Luc");
		for (SinhVien sinhVien : list) {
			if (sinhVien.getName().equals(name)) {
				flag = true;
				System.out.println(sinhVien);
			}
		}
		if (flag == false) {
			System.out.println("Khong tim thay");
		}
	}

	public static void ThemSV(LinkedList<SinhVien> list) {
		sinhVien.NhapSV(sc);
		list.add(sinhVien);
		XuatSV(list);
	}

	public static void DSSVloaiGioi_Yeu(LinkedList<SinhVien> list) {
		boolean flag = false;
		System.out.println("\t\tDanh Sach Sinh Vien Hoc Luc Xuat Sac\n");
		System.out.printf("%-10s %-10s %-10s %-10s\n", "Name", "MSSV", "Diem TB", "Hoc Luc");
		for (SinhVien sinhVien : list) {
			if (sinhVien.getdTB() > 9) {
				flag = true;
				System.out.println(sinhVien);
			}
		}
		if (flag == false) {
			System.out.println("Khong co Sinh Vien nao co hoc luc XUAT SAC");
		}

		System.out.println("\t\tDanh Sach Sinh Vien Hoc Luc Yeu\n");
		System.out.printf("%-10s %-10s %-10s %-10s\n", "Name", "MSSV", "Diem TB", "Hoc Luc");
		for (SinhVien sinhVien : list) {
			if (sinhVien.getdTB() < 5) {
				flag = true;
				System.out.println(sinhVien);
			}
		}
		if (flag == false) {
			System.out.println("Khong co Sinh Vien nao co hoc luc YEU");
		}
	}

	public static void XoaSV(LinkedList<SinhVien> list) {
		sc.nextLine();
		System.out.println("Nhap mssv can xoa: ");
		String mssv = sc.nextLine();
		for (SinhVien sinhVien : list) {
			if (sinhVien.getMSSV().equals(mssv)) {
				list.remove(sinhVien);
			}
		}
		XuatSV(list);
	}

	public static void CapNhatSV(LinkedList<SinhVien> list) {
		int x;
		do {
			System.out.println("Nhap vi tri can cap nhat: ");
			x = sc.nextInt();
		} while (list.size() - 1 < x);
		sc.nextLine();
		System.out.println("Nhap mssv: ");
		String mssv = sc.nextLine();
		System.out.println("Nhap dTB: ");
		double dTB = sc.nextDouble();
		list.get(x).setMSSV(mssv);
		list.get(x).setdTB(dTB);
		XuatSV(list);
	}

	public static void SapXepTheoName(LinkedList<SinhVien> list) {
		Collections.sort(list, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		XuatSV(list);
	}

	public static void SapXepTheoDTB(LinkedList<SinhVien> list) {
		Collections.sort(list, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getdTB() < o2.getdTB()) {
					return 1;
				} else if (o1.getdTB() > o2.getdTB()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		XuatSV(list);
	}

	public static boolean save(LinkedList<SinhVien> s, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static LinkedList<SinhVien> read(String path) {
		LinkedList<SinhVien> s = new LinkedList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			s = (LinkedList<SinhVien>) o;
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void ShowMenu() {
		System.out.println("1.Nhap Danh Sach SV");
		System.out.println("2.Xuat Danh Sach SV");
		System.out.println("3.Tim SV");
		System.out.println("4.Them SV");
		System.out.println("5.Danh Sach SV XUAT SAC va YEU");
		System.out.println("6.Xoa SV theo MSSV");
		System.out.println("7.Sap Xep Sinh Vien Theo Ten");
		System.out.println("8.Sap Xep Sinh Vien Theo DTB");
		System.out.println("9.Cap nhat SV");
		System.out.println("10.Readfile");
	}

}
