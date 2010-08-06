package you.mine.lib;

public enum Ans {
	NONE(-1);
	int body;
	Ans(int body) {
		this.body = body;
	}
	public int getBody() {
		return body;
	}
}
