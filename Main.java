
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//Given a large number of binary files, write a program that finds the
//longest strand of bytes that is identical between two or more files
//
//Use the test set attached (files sample.*)
//
//The program should display:
//- the length of the strand
//- the file names where the largest strand appears
//- the offset where the strand appears in each file

public class Main {
	//Contains all the occurrences of the largest strand, as well as the offset
	public static ArrayList<String> dupes = new ArrayList<>();

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the absolute path of the first file that you want to read");	
//		C:\\Users\\Raghav\\eclipse-workspace\\CSE12\\src\\sample.1
		String inString1 = scanner.next();
		System.out.println("Input the absolute path of the second file that you want to read");
		String inString2 = scanner.next();
		System.out.println("Input the absolute path of the third file that you want to read");
		String inString3 = scanner.next();
		System.out.println("Input the absolute path of the fourth file that you want to read");
		String inString4 = scanner.next();
		System.out.println("Input the absolute path of the fifth file that you want to read");
		String inString5 = scanner.next();
		System.out.println("Input the absolute path of the sixth file that you want to read");
		String inString6 = scanner.next();
		System.out.println("Input the absolute path of the seventh file that you want to read");
		String inString7 = scanner.next();
		System.out.println("Input the absolute path of the eigth file that you want to read");
		String inString8 = scanner.next();
		System.out.println("Input the absolute path of the ninth file that you want to read");
		String inString9 = scanner.next();
		System.out.println("Input the absolute path of the tenth file that you want to read");
		String inString10 = scanner.next();
		scanner.close();
		
		FileInfo File1 = new FileInfo(inString1);
		FileInfo File2 = new FileInfo(inString2);
		FileInfo File3 = new FileInfo(inString3);
		FileInfo File4 = new FileInfo(inString4);
		FileInfo File5 = new FileInfo(inString5);
		FileInfo File6 = new FileInfo(inString6);
		FileInfo File7 = new FileInfo(inString7);
		FileInfo File8 = new FileInfo(inString8);
		FileInfo File9 = new FileInfo(inString9);
		FileInfo File10 = new FileInfo(inString10);
		
		int[] winners = new int[3];

		
		
		//comparing 1 against everyone
		winners = compare(length(File1.list, File2.list), winners,File1.getName(),File2.getName());
		winners = compare(length(File1.list, File3.list), winners,File1.getName(),File3.getName());
		winners = compare(length(File1.list, File4.list), winners, File1.getName(),File4.getName());
		winners = compare(length(File1.list, File5.list), winners, File1.getName(),File5.getName());
		winners = compare(length(File1.list, File6.list), winners,File1.getName(),File6.getName());
		winners = compare(length(File1.list, File7.list), winners,File1.getName(),File7.getName());
		winners = compare(length(File1.list, File8.list), winners,File1.getName(),File8.getName());
		winners = compare(length(File1.list, File9.list), winners,File1.getName(),File9.getName());
		winners = compare(length(File1.list, File10.list), winners,File1.getName(),File10.getName());
		
		//comparing 2 against everyone
		winners = compare(length(File2.list, File3.list), winners, File2.getName(),File3.getName());
		winners = compare(length(File2.list, File4.list), winners, File2.getName(),File4.getName());
		winners = compare(length(File2.list, File5.list), winners, File2.getName(),File5.getName());
		winners = compare(length(File2.list, File6.list), winners, File2.getName(),File6.getName());
		winners = compare(length(File2.list, File7.list), winners, File2.getName(),File7.getName());
		winners = compare(length(File2.list, File8.list), winners, File2.getName(),File8.getName());
		winners = compare(length(File2.list, File9.list), winners, File2.getName(),File9.getName());
		winners = compare(length(File2.list, File10.list), winners,File2.getName(),File10.getName());
		
		//comparing 3 against everyone
		winners = compare(length(File3.list, File4.list), winners, File3.getName(),File4.getName());
		winners = compare(length(File3.list, File5.list), winners, File3.getName(),File5.getName());
		winners = compare(length(File3.list, File6.list), winners,File3.getName(),File6.getName());
		winners = compare(length(File3.list, File7.list), winners,File3.getName(),File7.getName());
		winners = compare(length(File3.list, File8.list), winners,File3.getName(),File8.getName());
		winners = compare(length(File3.list, File9.list), winners,File3.getName(),File9.getName());
		winners = compare(length(File3.list, File10.list), winners,File3.getName(),File10.getName());
		
		//comparing 4 against everyone
		winners = compare(length(File4.list, File5.list), winners, File4.getName(),File5.getName());
		winners = compare(length(File4.list, File6.list), winners,File4.getName(),File6.getName());
		winners = compare(length(File4.list, File7.list), winners,File4.getName(),File7.getName());
		winners = compare(length(File4.list, File8.list), winners,File4.getName(),File8.getName());
		winners = compare(length(File4.list, File9.list), winners,File4.getName(),File9.getName());
		winners = compare(length(File4.list, File10.list), winners,File4.getName(),File10.getName());
		
		//comparing 5 against everyone
		winners = compare(length(File5.list, File6.list), winners,File5.getName(),File6.getName());
		winners = compare(length(File5.list, File7.list), winners,File5.getName(),File7.getName());
		winners = compare(length(File5.list, File8.list), winners,File5.getName(),File8.getName());
		winners = compare(length(File5.list, File9.list), winners,File5.getName(),File9.getName());
		winners = compare(length(File5.list, File10.list), winners,File5.getName(),File10.getName());
		
		//comparing 6 against everyone
		winners = compare(length(File6.list, File7.list), winners,File6.getName(),File7.getName());
		winners = compare(length(File6.list, File8.list), winners,File6.getName(),File8.getName());
		winners = compare(length(File6.list, File9.list), winners,File6.getName(),File9.getName());
		winners = compare(length(File6.list, File10.list), winners,File6.getName(),File10.getName());
		
		//comparing 7 against everyone
		winners = compare(length(File7.list, File8.list), winners,File7.getName(),File8.getName());
		winners = compare(length(File7.list, File9.list), winners,File7.getName(),File9.getName());
		winners = compare(length(File7.list, File10.list), winners,File7.getName(),File10.getName());
		
		//comparing 8 against everyone
		winners = compare(length(File8.list, File9.list), winners,File8.getName(),File9.getName());
		winners = compare(length(File8.list, File10.list), winners,File8.getName(),File10.getName());
		
		//comparing 9 against everyone
		winners = compare(length(File9.list, File10.list), winners,File9.getName(),File10.getName());
		
		
		System.out.println("length of the largest strand:"+winners[0]);
		for (int i = 0; i < dupes.size()-1; i+=2) {
			System.out.println("Offset of "+dupes.get(i)+":"+ dupes.get(i+1));
			
		}
		
	}
	
	
	public static int[] length(ArrayList<Byte> a,ArrayList<Byte> b) {
		int table[][] = new int[2][b.size()+1];
		int res =0;
		int offset1 = 0;
		int offset2 = 0;
        for(int i=1;i<=a.size();i++)
        {
            for(int j=1;j<=b.size();j++)
            {
                if(a.get(i-1)==b.get(j-1))
                {
                    table[i%2][j]=table[(i-1)%2][j-1]+1;
                    if(table[i%2][j]>res) {
                    	offset1 =i;
                    	offset2 = j;
                        res=table[i%2][j];
                        
                    }
                }
                else table[i%2][j]=0;
            }
        }
        return new int[]{res,offset1-res,offset2-res};
    }
	
	public static int[] compare(int[] a,int[] b, String x, String y) {
		if(a[0] == b[0]) {
//			System.out.println("if:"+a[0]);
//			System.out.println(b[0]);
			if(!dupes.contains(x)) {
				dupes.add(x);
				dupes.add(a[1]+"");
			}
			if(!dupes.contains(y)) {
				dupes.add(y);
				dupes.add(a[2] +"");
			}
			return a;
		}

		if(a[0]>b[0]) {
//			System.out.println("if else:"+a[0]);
//			System.out.println(b[0]);
			dupes = new ArrayList<>();
			if(!dupes.contains(x)) {
				dupes.add(x);
				dupes.add(a[1]+"");
			}
			if(!dupes.contains(y)) {
				dupes.add(y);
				dupes.add(a[2] +"");
			}
			return a;
		}
//		System.out.println("else:"+a[0]);
//		System.out.println(b[0]);

		return b;
	}
}

	
	


class FileInfo{
	ArrayList<Byte> list;
	FileInputStream fileInputStream;
	String fileName;
	
	public FileInfo(String fileName) {
		list = new ArrayList<>();
		
		try {
			this.fileName = fileName;
			fileInputStream = new FileInputStream(new File((fileName)));
			while ( fileInputStream.read() != -1) {
				list.add( (byte) fileInputStream.read());
			}
		}
		catch (Exception e) {
			System.out.println("The file you entered was invalid");
		}
		
		
	}
	public String getName() {
		return fileName;
	}
	
}
	

