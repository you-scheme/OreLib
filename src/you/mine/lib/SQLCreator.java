package you.mine.lib;

public class SQLCreator {
	public static String createSelectAsta(String tablename) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from " + tablename + ";");
		return sb.toString();
	}
}
