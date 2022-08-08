import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Process {
	private static String rawDataAPT = "C:\\Users\\Baek\\Desktop\\rawLists\\rawList\\rawDataAPT.csv";
	private static String rawDataDasedae = "C:\\Users\\Baek\\Desktop\\rawLists\\rawList\\rawDataDasedae.csv";
	private static String rawDataOffice = "C:\\Users\\Baek\\Desktop\\rawLists\\rawList\\rawDataOffice.csv";
	private static String rawDataAPTRent = "C:\\Users\\Baek\\Desktop\\rawLists\\rawListRent\\rawDataAPTRent.csv";
	private static String rawDataDasedaeRent = "C:\\Users\\Baek\\Desktop\\rawLists\\rawListRent\\rawDataDasedaeRent.csv";
	private static String rawDataOfficeRent = "C:\\Users\\Baek\\Desktop\\rawLists\\rawListRent\\rawDataOfficeRent.csv";

	public void process() throws IOException {

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("�޴��� �����ϼ���\n");
			System.out.println(" 1.�Ÿ� ����");
			System.out.println(" 2.���� ����");
			int select1 = scanner.nextInt();
			if (select1 == 1) {
				System.out.println("�޴��� �����ϼ���\n");
				System.out.println(" 1.����Ʈ(�Ÿ�) �����ͺ���");
				System.out.println(" 2.����Ʈ(�Ÿ�) ���� �ŷ���");
				System.out.println(" 3.����Ʈ(�Ÿ�) �б⺰ �ŷ���");
				System.out.println(" 4.����Ʈ(�Ÿ�) ������ �ŷ���");
				System.out.println(" 5.�����ټ���(�Ÿ�) �����ͺ���");
				System.out.println(" 6.�����ټ���(�Ÿ�) ����  �ŷ���");
				System.out.println(" 7.�����ټ���(�Ÿ�) �б⺰ �ŷ���");
				System.out.println(" 8.�����ټ���(�Ÿ�) ������ �ŷ���");
				System.out.println(" 9.���ǽ���(�Ÿ�) �����ͺ���");
				System.out.println(" 10.���ǽ���(�Ÿ�) ���� �ŷ���");
				System.out.println(" 11.���ǽ���(�Ÿ�) �б⺰ �ŷ���");
				System.out.println(" 12.���ǽ���(�Ÿ�) ������ �ŷ���");
				System.out.println(" 13. ����");

				UtilAptOffice utilAptOffice = new UtilAptOffice();
				UtilDasedae utilDasedae = new UtilDasedae();
				// ���� �� ���� Ȯ��
				int select2 = scanner.nextInt();
				if (select2 == 1) {
					List fileList = utilAptOffice.getFileList("C:\\Users\\Baek\\Desktop\\APT");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilAptOffice.mergeFiles(fileList, rawDataAPT);
					System.out.println("���� �պ��� �Ϸ�Ǿ����ϴ�");
					System.out.println();
				}
				// ����
				else if (select2 == 2) {
					utilAptOffice.getMonthNum(rawDataAPT);
					System.out.println();
				} // 1-3 4-6 7-9 10-12
				else if (select2 == 3) {
					utilAptOffice.getQuarterNum(rawDataAPT);
					System.out.println();
				} else if (select2 == 4) {
					utilAptOffice.getYearNum(rawDataAPT);
					System.out.println();
				} else if (select2 == 5) {
					List fileList = utilDasedae.getFileList("C:\\Users\\Baek\\Desktop\\Dasedae");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilAptOffice.mergeFiles(fileList, rawDataDasedae);
					System.out.println("���� �պ��� �Ϸ�Ǿ����ϴ�");
					System.out.println();
				}
				// ����
				else if (select2 == 6) {
					utilDasedae.getMonthNum(rawDataDasedae);
					System.out.println();
				} // 1-3 4-6 7-9 10-12
				else if (select2 == 7) {
					utilDasedae.getQuarterNum(rawDataDasedae);
					System.out.println();
				} else if (select2 == 8) {
					utilDasedae.getYearNum(rawDataDasedae);
					System.out.println();
				} else if (select2 == 9) {
					List fileList = utilAptOffice.getFileList("C:\\Users\\Baek\\Desktop\\Office");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilAptOffice.mergeFiles(fileList, rawDataOffice);
					System.out.println("���� �պ��� �Ϸ�Ǿ����ϴ�");
					System.out.println();
				} else if (select2 == 10) {
					utilAptOffice.getMonthNum(rawDataOffice);
					System.out.println();
				} // 1-3 4-6 7-9 10-12
				else if (select2 == 11) {
					utilAptOffice.getQuarterNum(rawDataOffice);
					System.out.println();
				} else if (select2 == 12) {
					utilAptOffice.getYearNum(rawDataOffice);
					System.out.println();
				} else if (select2 == 13) {
					break;
				}
			} else if (select1 == 2) {
				System.out.println("�޴��� �����ϼ���\n");
				System.out.println(" 1.����Ʈ(������) �����ͺ���");
				System.out.println(" 2.����Ʈ(������) ���� �ŷ���");
				System.out.println(" 3.����Ʈ(������) �б⺰ �ŷ���");
				System.out.println(" 4.����Ʈ(������) ������ �ŷ���");
				System.out.println(" 5.�����ټ���(������) �����ͺ���");
				System.out.println(" 6.�����ټ���(������) ���� �ŷ���");
				System.out.println(" 7.�����ټ���(������) �б⺰ �ŷ���");
				System.out.println(" 8.�����ټ���(������) ������ �ŷ���");
				System.out.println(" 9.���ǽ���(������) �����ͺ���");
				System.out.println(" 10.���ǽ���(������) ���� �ŷ���");
				System.out.println(" 11.���ǽ���(������) �б⺰ �ŷ���");
				System.out.println(" 12.���ǽ���(������) ������ �ŷ���");
				System.out.println(" 13. ����");

				UtilRent utilRent = new UtilRent();
				// ���� �� ���� Ȯ��
				int select2 = scanner.nextInt();
				if (select2 == 1) {
					List fileList = utilRent.getFileList("C:\\Users\\Baek\\Desktop\\AptRent");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilRent.mergeFiles(fileList, rawDataAPTRent);
					System.out.println("���� �պ��� �Ϸ�Ǿ����ϴ�");
					System.out.println();
				}
				// ����
				else if (select2 == 2) {
					utilRent.getMonthNum(rawDataAPTRent);
					System.out.println();
				} // 1-3 4-6 7-9 10-12
				else if (select2 == 3) {
					utilRent.getQuarterNum(rawDataAPTRent);
					System.out.println();
				} else if (select2 == 4) {
					utilRent.getYearNum(rawDataAPTRent);
					System.out.println();
				} else if (select2 == 5) {
					List fileList = utilRent.getFileList("C:\\Users\\Baek\\Desktop\\DasedaeRent");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilRent.mergeFiles(fileList, rawDataDasedaeRent);
					System.out.println("���� �պ��� �Ϸ�Ǿ����ϴ�");
					System.out.println();
				}
				// ����
				else if (select2 == 6) {
					utilRent.getMonthNum(rawDataDasedaeRent);
					System.out.println();
				} // 1-3 4-6 7-9 10-12
				else if (select2 == 7) {
					utilRent.getQuarterNum(rawDataDasedaeRent);
					System.out.println();
				} else if (select2 == 8) {
					utilRent.getYearNum(rawDataDasedaeRent);
					System.out.println();
				} else if (select2 == 9) {
					List fileList = utilRent.getFileList("C:\\Users\\Baek\\Desktop\\OfficeRent");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilRent.mergeFiles(fileList, rawDataOfficeRent);
					System.out.println("���� �պ��� �Ϸ�Ǿ����ϴ�");
					System.out.println();
				} else if (select2 == 10) {
					utilRent.getMonthNum(rawDataOfficeRent);
					System.out.println();
				} // 1-3 4-6 7-9 10-12
				else if (select2 == 11) {
					utilRent.getQuarterNum(rawDataOfficeRent);
					System.out.println();
				} else if (select2 == 12) {
					utilRent.getYearNum(rawDataOfficeRent);
					System.out.println();
				} else if (select2 == 13) {
					break;
				}
			}
		}

	}
}
