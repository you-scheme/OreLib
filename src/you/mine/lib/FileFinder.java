package you.mine.lib;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FileFinder {
	private FileFinder() {
		
	}
	public static void main(String[] args) {
		List<File> ans = listFiles(new File("C:\\Users\\y-kasima\\workspace\\OreLib"), Pattern.compile(".+\\.java"));
		for (File f : ans)
			System.out.println(f.getAbsolutePath());
	}
	public static List<File> listFiles(File rootDir, Pattern pattern) {
		if (!rootDir.isDirectory())
			return null;
		List<File> ans = new ArrayList();
		listFilesSub(rootDir, pattern, ans);
		return ans;
	}
	
	private static void listFilesSub(File rootDir, Pattern pattern, List<File> filelist) {
		final File[] rootFilelist = rootDir.listFiles();
		for (final File file : rootFilelist) {
			if (file.isDirectory()) {
				listFilesSub(file, pattern, filelist);
			} else {
				if (pattern.matcher(file.getName()).matches())
					filelist.add(file);
			}
		}
	}
	
	class FileFinderSub {
		final List<File> filelist;
		FileFinderSub() {
			filelist = new ArrayList<File>();
		}
	}
}
