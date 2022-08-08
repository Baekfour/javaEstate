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
			System.out.println("메뉴를 선택하세요\n");
			System.out.println(" 1.매매 관련");
			System.out.println(" 2.전세 관련");
			int select1 = scanner.nextInt();
			if (select1 == 1) {
				System.out.println("메뉴를 선택하세요\n");
				System.out.println(" 1.아파트(매매) 데이터병합");
				System.out.println(" 2.아파트(매매) 월별 거래량");
				System.out.println(" 3.아파트(매매) 분기별 거래량");
				System.out.println(" 4.아파트(매매) 연도별 거래량");
				System.out.println(" 5.연립다세대(매매) 데이터병합");
				System.out.println(" 6.연립다세대(매매) 월별  거래량");
				System.out.println(" 7.연립다세대(매매) 분기별 거래량");
				System.out.println(" 8.연립다세대(매매) 연도별 거래량");
				System.out.println(" 9.오피스텔(매매) 데이터병합");
				System.out.println(" 10.오피스텔(매매) 월별 거래량");
				System.out.println(" 11.오피스텔(매매) 분기별 거래량");
				System.out.println(" 12.오피스텔(매매) 연도별 거래량");
				System.out.println(" 13. 종료");

				UtilAptOffice utilAptOffice = new UtilAptOffice();
				UtilDasedae utilDasedae = new UtilDasedae();
				// 폴더 내 파일 확인
				int select2 = scanner.nextInt();
				if (select2 == 1) {
					List fileList = utilAptOffice.getFileList("C:\\Users\\Baek\\Desktop\\APT");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilAptOffice.mergeFiles(fileList, rawDataAPT);
					System.out.println("파일 합병이 완료되었습니다");
					System.out.println();
				}
				// 월별
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
					System.out.println("파일 합병이 완료되었습니다");
					System.out.println();
				}
				// 월별
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
					System.out.println("파일 합병이 완료되었습니다");
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
				System.out.println("메뉴를 선택하세요\n");
				System.out.println(" 1.아파트(전월세) 데이터병합");
				System.out.println(" 2.아파트(전월세) 월별 거래량");
				System.out.println(" 3.아파트(전월세) 분기별 거래량");
				System.out.println(" 4.아파트(전월세) 연도별 거래량");
				System.out.println(" 5.연립다세대(전월세) 데이터병합");
				System.out.println(" 6.연립다세대(전월세) 월별 거래량");
				System.out.println(" 7.연립다세대(전월세) 분기별 거래량");
				System.out.println(" 8.연립다세대(전월세) 연도별 거래량");
				System.out.println(" 9.오피스텔(전월세) 데이터병합");
				System.out.println(" 10.오피스텔(전월세) 월별 거래량");
				System.out.println(" 11.오피스텔(전월세) 분기별 거래량");
				System.out.println(" 12.오피스텔(전월세) 연도별 거래량");
				System.out.println(" 13. 종료");

				UtilRent utilRent = new UtilRent();
				// 폴더 내 파일 확인
				int select2 = scanner.nextInt();
				if (select2 == 1) {
					List fileList = utilRent.getFileList("C:\\Users\\Baek\\Desktop\\AptRent");
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
					// MergeFiles
					utilRent.mergeFiles(fileList, rawDataAPTRent);
					System.out.println("파일 합병이 완료되었습니다");
					System.out.println();
				}
				// 월별
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
					System.out.println("파일 합병이 완료되었습니다");
					System.out.println();
				}
				// 월별
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
					System.out.println("파일 합병이 완료되었습니다");
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
