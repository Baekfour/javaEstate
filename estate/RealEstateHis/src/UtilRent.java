import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class UtilRent {

	static List<String> aptName;
	static List<String> rentType;
	static List<String> size;
	static List<String> date;
	static List<String> price;
	static List<String> monthPrice;
	static List<String> floor;
	static List<String> builtYear;
	static List<String> contractDate;
	static List<String> contractType;
	static List<String> previousContractPrice;
	static List<String> previousContractmonthPrice;

	public List getFileList(String folderPath) {
//			int cnt=0;
		File myDir = new File(folderPath);
		File[] contents = myDir.listFiles();
		List<File> fileList = new ArrayList<>();
		for (File temp : contents) {
			fileList.add(temp);
//				cnt++;
		}
//			System.out.println(cnt);
		return fileList;
	}

	// 리스트들을 한 파일로, fileList가 이름
	public void mergeFiles(List fileList, String fileName) {
//			System.out.println("merge");
		try {
			CSVWriter cw = new CSVWriter(new FileWriter(fileName));
			for (int i = 0; i < fileList.size(); i++) {
//					System.out.println("for");
				String readFileName = fileList.get(i).toString();
				CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
//					System.out.println(readFileName);
//					System.out.println(fileList.size());
				String[] nextLine;

				if (i == 0) {
					// 첫번째 파일일때 첫 15줄 제외
					for (int j = 0; j < 15; j++) {
						csvReader.readNext();
					}
					while ((nextLine = csvReader.readNext()) != null) {
						cw.writeNext(nextLine);

						for (int index = 0; index < nextLine.length; index++) {
						}
					}
				} else {
					// 첫번째 파일일때 첫 16줄 제외
					for (int j = 0; j < 16; j++) {
						csvReader.readNext();
					}
					while ((nextLine = csvReader.readNext()) != null) {
						cw.writeNext(nextLine);
						for (int index = 0; index < nextLine.length; index++) {

						}
					}
				}
			}
			cw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rawList(String fileName) {
		List<String> rawData = new ArrayList<>();
		try {

			String[] nextLine;
			List<String> rawDatacolumn = null;
			// Hashset 시군구+단지명(aptName) , 전용면적(size), 계약년월+일(date), 거래금액(price),
			// 층(floor), 건축년도(builtYear), 해제사유일(cancelDate), 거래유형(salesType),
			// 중개사소재지(agencyRegion)
			aptName = new ArrayList<String>();
			rentType = new ArrayList<String>();
			size = new ArrayList<String>();
			date = new ArrayList<String>();
			price = new ArrayList<String>();
			monthPrice = new ArrayList<String>();
			floor = new ArrayList<String>();
			builtYear = new ArrayList<String>();
			contractDate = new ArrayList<String>();
			contractType = new ArrayList<String>();
			previousContractPrice = new ArrayList<String>();
			previousContractmonthPrice = new ArrayList<String>();

			CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "CP949"));
			while ((nextLine = csvReader.readNext()) != null) {
				aptName.add(nextLine[0] + nextLine[4]);
				rentType.add(nextLine[5]);
				size.add(nextLine[6]);
				date.add(nextLine[7]);
				price.add(nextLine[9]);
				monthPrice.add(nextLine[10]);
				floor.add(nextLine[11]);
				builtYear.add(nextLine[12]);
				contractDate.add(nextLine[14]);
				contractType.add(nextLine[15]);
				previousContractPrice.add(nextLine[17]);
				previousContractmonthPrice.add(nextLine[18]);
			}
			rawData.addAll(aptName);
			rawData.addAll(rentType);
			rawData.addAll(size);
			rawData.addAll(date);
			rawData.addAll(price);
			rawData.addAll(monthPrice);
			rawData.addAll(floor);
			rawData.addAll(builtYear);
			rawData.addAll(contractDate);
			rawData.addAll(contractType);
			rawData.addAll(previousContractPrice);
			rawData.addAll(previousContractmonthPrice);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Hashset 시군구+단지명(aptName) , 전용면적(size), 계약년월+일(date), 거래금액(price),
	// 층(floor), 건축년도(builtYear), 해제사유일(cancelDate), 거래유형(salesType),
	// 중개사소재지(agencyRegion)
	// Check columns
//		String[] columns = util.getColumnNames(rawData);
//		for (int index = 0; index < columns.length; index++)
//			System.out.print(columns[index]+ ", ");
	// }
	// 칼럼명 print
	public String[] getColumnNames(String readFileName) {
		String[] columns = null;
		try {
			CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
			columns = csvReader.readNext();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return columns;
	}

	public void getMonthNum(String rawData) throws IOException {
		rawList(rawData);
//			util.aptName.get(0);
		// 사이즈
		int size = date.size();
		// Hashset 사이즈
		HashSet<String> dates = new HashSet<String>(size);
		for (int i = 0; i < date.size(); i++) {
			dates.add(date.get(i));
		}
		ArrayList<String> al = new ArrayList<>(dates);
		Collections.sort(al);
		Collections.reverse(al);
		String name = "Monthly Trade ";
//		System.out.println(name);
//		System.out.println(al.get(0));
		Collections.reverse(al);
		String newFile = changeFileName(rawData, name);
		CSVWriter cw = new CSVWriter(new FileWriter(newFile));
		String[] nextLine = new String[2];
		for (int i = 0; i < al.size() - 1; i++) {
			System.out.print(al.get(i));
			String names = al.get(i);
			int count = 0;
			for (int index = 0; index < date.size(); index++) {
				if (al.get(i).equals(date.get(index))) {
					count++;
				}
			}
			System.out.println("," + count);
			String counts = Integer.toString(count);
			nextLine[0] = names;
			nextLine[1] = counts;
			cw.writeNext(nextLine);
		}
		cw.close();
	}

	public void getQuarterNum(String rawData) throws IOException {
		rawList(rawData);
//			util.aptName.get(0);
		// 사이즈
		int size = date.size();
		// Hashset 사이즈
		HashSet<String> dates = new HashSet<String>(size);
		for (int i = 0; i < date.size(); i++) {
			dates.add(date.get(i).substring(0, 4));
		}
		ArrayList<String> al = new ArrayList<>(dates);
		Collections.sort(al);
		Collections.reverse(al);
		String name = "Quarterly Trade ";
		System.out.println(name);
		System.out.println(al.get(0));
		Collections.reverse(al);
		// 1-4분기
		String newFile = changeFileName(rawData, name);
		CSVWriter cw = new CSVWriter(new FileWriter(newFile));
		String[] nextLine = new String[2];
		for (int i = 0; i < al.size() - 1; i++) {
			for (int j = 1; j < 5; j++) {
				String names = al.get(i) + "년" + j + "분기";
				System.out.print(names);
				int first = j * 3 - 2;
				int second = first + 1;
				int third = first + 2;
				String firstString = null;
				String secontString = null;
				String thirdString = null;
				if (first < 10) {
					firstString = al.get(i) + "0" + Integer.toString(first);
					secontString = al.get(i) + "0" + Integer.toString(second);
					thirdString = al.get(i) + "0" + Integer.toString(third);
				} else {
					firstString = al.get(i) + Integer.toString(first);
					secontString = al.get(i) + Integer.toString(second);
					thirdString = al.get(i) + Integer.toString(third);
				}
				int count = 0;
				for (int index = 0; index < date.size(); index++) {
					if (firstString.equals(date.get(index)) || secontString.equals(date.get(index))
							|| thirdString.equals(date.get(index))) {
						count++;
					}
				}
				System.out.println("," + count);
				String counts = Integer.toString(count);
				nextLine[0] = names;
				nextLine[1] = counts;
				cw.writeNext(nextLine);
			}

		}
		cw.close();
	}

	public void getYearNum(String rawData) throws IOException {

		rawList(rawData);
//			util.aptName.get(0);
		// 사이즈
		int size = date.size();
		// Hashset 사이즈
		HashSet<String> dates = new HashSet<String>(size);
		for (int i = 0; i < date.size(); i++) {
			dates.add(date.get(i).substring(0, 4));
		}
		ArrayList<String> al = new ArrayList<>(dates);
		Collections.sort(al);
		Collections.reverse(al);
		String name = "Yearly Trade ";
		System.out.println(name);
		System.out.println(al.get(0));
		Collections.reverse(al);
//			Collections.reverse(al);
//			String[] a = rawData.split("\\\\");
//			String b = a[a.length - 1];
//			String fileName = name + b;
//			String rawDatas = rawData.replaceAll(b, fileName);
//			System.out.println(rawDatas);
		String newFile = changeFileName(rawData, name);
		CSVWriter cw = new CSVWriter(new FileWriter(newFile));
		String[] nextLine = new String[2];
		for (int i = 0; i < al.size() - 1; i++) {
			System.out.print(al.get(i));
			int count = 0;
			for (int index = 0; index < date.size(); index++) {
				if (al.get(i).equals(date.get(index).substring(0, 4))) {
					count++;
				}
			}
			System.out.println("," + count);
			String counts = Integer.toString(count);
			nextLine[0] = al.get(i);
			nextLine[1] = counts;
			cw.writeNext(nextLine);
		}
		cw.close();
	}

	public String changeFileName(String rawData, String name) {
		String[] a = rawData.split("\\\\");
		String b = a[a.length - 1];
		String fileName = name + b;
		String rawDatas = rawData.replaceAll(b, fileName);
		return rawDatas;
	}
}
