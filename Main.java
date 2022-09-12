
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static LinkedList<SinhVien> list = new LinkedList<SinhVien>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luaChon = 0;
		do {
			DSSV.ShowMenu();
			System.out.print("Moi nhap lua chon: ");
			luaChon = sc.nextInt();
			switch (luaChon) {
				case 1:
					DSSV.NhapDSSV(list);
					break;
				case 2: {
					DSSV.XuatSV(list);
					break;
				}
				case 3:
					DSSV.TimSV(list);
					break;
				case 4:
					DSSV.ThemSV(list);
					break;
				case 5:
					DSSV.DSSVloaiGioi_Yeu(list);
					break;
				case 6:
					DSSV.XoaSV(list);
					break;
				case 7:
					DSSV.SapXepTheoName(list);
					break;
				case 8:
					DSSV.SapXepTheoDTB(list);
					break;
				case 9:
					DSSV.CapNhatSV(list);
					break;
				case 10:
					list = DSSV.read("./test.txt");
				case 0:
					System.out.println("Thoat chuong trinh");
					break;
				default:
					System.out.println("Khong tim thay!!!");
					break;
			}

		} while (luaChon != 0);
		sc.close();
		DSSV.save(list, "./test.txt");
	}

}
