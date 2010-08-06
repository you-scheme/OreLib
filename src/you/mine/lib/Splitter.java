package you.mine.lib;

import java.util.ArrayList;
import java.util.List;

// �܂��͑啶�������������̏ꍇ���l���܂��傤
public class Splitter {
	public List<List<String>> splitIdentiry(String name){
		List<String> tokens = new ArrayList<String>();
		List<List<String>> ret = new ArrayList<List<String>>();
		//tokens = splitOnLowercaseToUppercase(name);
		List<String> ls = splitOnSpecialletterOrDigit(name);
		for (String s : ls) {
			tokens.addAll(splitOnLowercaseToUppercase(s));
		}
		ret.add(new ArrayList<String>());
		//TreeNode root = new TreeNode("");

		for (String token: tokens) {
			if (isAllLowercaseORSingleUppercase(token)) {
				//root.addData(root, token);
				for (List <String> l : ret) {
					l.add(token);
				}
			}
			else if (isAllUppercase(token)) {
				//root.addData(root, token);
				for (List<String> l : ret) {
					l.add(token);
				}
			} else {
				StringBuffer buf1 = new StringBuffer();
				StringBuffer buf11 = new StringBuffer();
				StringBuffer buf2 = new StringBuffer();
				StringBuffer buf21 = new StringBuffer();
				int i = 0;
				for (; i < token.length(); i++) {
					if (Character.isLowerCase(token.charAt(i))) {
						break;
					}
				}
				for (int j = 0; j < i; j++) {
					buf1.append(token.charAt(j));
				}
				for (int j = i; j < token.length(); j++) {
					buf11.append(token.charAt(j));
				}
				for (int j = 0; j < i - 1; j++) {
					buf2.append(token.charAt(j));
				}
				for (int j = i - 1; j < token.length(); j++) {
					buf21.append(token.charAt(j));
				}
				//root.addDivideData(root, buf1.toString(), buf11.toString(), buf2.toString(), buf21.toString());
				List<List<String>> cop = new ArrayList<List<String>>();
				for (List<String> l : ret) {
					List<String> ne = new ArrayList<String>();
					for (String s : l) {
						ne.add(new String(s));
					}
					cop.add(ne);
				}
				for (List<String> l : ret) {
					l.add(buf1.toString());
					l.add(buf11.toString());
				}
				for (List<String> l : cop) {
					l.add(buf2.toString());
					l.add(buf21.toString());
				}
				for (List<String> l : cop) {
					ret.add(l);
				}
			}
		}
		return ret;
	}

	//
	public static List<String> splitOnStrictCamel(String name) {
		List<String> tem = splitOnSpecialletterOrDigit(name);
		List<String> ret = new ArrayList<String>();
		
		StringBuilder buf = new StringBuilder();
		//System.out.println("strictCamel> " + tem);
		// �ꕶ���̖��O�ɑΉ����Ă��Ȃ�
		for (String s : tem) {
			int pos = 0;
			char[] st = s.toCharArray();
			//buf.delete(0, buf.length());
			buf = null;
			buf = new StringBuilder();
			while (pos < st.length) {
				buf.append(st[pos]);
				if (Character.isLowerCase(st[pos])) {
					//System.out.println(st[pos]);
					if (pos+1 < st.length) {
						if (Character.isUpperCase(st[pos+1])) {
							ret.add(buf.toString());
							//buf.delete(0, buf.length());
							buf = null;
							buf = new StringBuilder();
						}
					}
				} else if (Character.isUpperCase(st[pos])){
					if (pos+2 < st.length) {
						if (Character.isUpperCase(st[pos+1]) && Character.isLowerCase(st[pos+2])) {
							ret.add(buf.toString());
							//buf.delete(0, buf.length());
							buf = null;
							buf = new StringBuilder();
						}
					}
				}
				pos++;
			}
			ret.add(buf.toString());
		}
		// �ǂ����ŏ��̕������啶�����Ƌ󕶎����������Ⴄ���ۂ�
		if (ret.size() > 0 && ret.get(0).equals("")) {
			ret.remove(0);
		}
		buf = null;
		return ret;
	}
	//List<String> splitOnSpecialCharAndDigit(String name){ }
	public static List<String> splitOnLowercaseToUppercase(String name) {
		int pos = 0;
		List<String> ret = new ArrayList<String>();
		char[] st = name.toCharArray();
		StringBuffer buf = new StringBuffer();
		ret.clear();
		// �ꕶ���̖��O�ɑΉ����Ă��Ȃ�
		while (pos < name.length()) {
			buf.append(st[pos]);
			if (pos+1 < name.length()) {
				if ((Character.isLowerCase(st[pos]) && Character.isUpperCase(st[pos+1]))) {
					ret.add(buf.toString());
					buf = null;
					buf = new StringBuffer();
				}
			}
			pos++;
		}
		ret.add(buf.toString());
		return ret;
	}

	boolean isAllLowercaseORSingleUppercase(String name) {
		int i=0;
		if (Character.isUpperCase(name.charAt(i))) {
			i++;
		}
		for (; i < name.length(); i++) {
			if (!(Character.isLowerCase(name.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	boolean isAllUppercase(String name) {
		int i =0;
		for (; i < name.length(); i++) {
			if (!(Character.isUpperCase(name.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	static List<String> splitOnSpecialletterOrDigit(String name) {
		List<Character> specialletters = new ArrayList<Character>();
		List<String> ret = new ArrayList<String>();
		specialletters.add('_');
		
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			if (specialletters.contains(name.charAt(i))) {
				ret.add(buf.toString());
				//buf.delete(0, buf.length());
				buf = null;
				buf = new StringBuilder();
			} else if (Character.isDigit(name.charAt(i))) {
				ret.add(buf.toString());
				//buf.delete(0, buf.length());
				buf = null;
				buf = new StringBuilder();
				for ( ; i < name.length() && Character.isDigit(name.charAt(i)); i++) {
					buf.append(name.charAt(i));
				}
				ret.add(buf.toString());
				//buf.delete(0, buf.length());
				buf = null;
				buf = new StringBuilder();
				if (i < name.length()) 
					buf.append(name.charAt(i)); // �����̌�̕����͒ǉ�
			} else {
				buf.append(name.charAt(i));
			}
		}
		if (!buf.toString().equals("")) {
			ret.add(buf.toString());
		}
		buf = null;
		return ret;
	}

	public static String normalizeCamel(String s) {
		StringBuffer ret = new StringBuffer();
		char[] c = s.toCharArray();
		if (c.length < 1) return s;
		ret.append(Character.toUpperCase(c[0]));
		for (int i=1; i<c.length; i++) {
			ret.append(Character.toLowerCase(c[i]));
		}
		return ret.toString();
	}

	public static List<String> normalizeCamelNames(List<String> words) {
		List<String> ret = new ArrayList<String>();
		for (String s : words) {
			ret.add(normalizeCamel(s));
		}
		return ret;
	}

}
