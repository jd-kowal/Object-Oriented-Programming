
public class Singleton {
	private Singleton() {}
	private static final Singleton x = new Singleton();
	public static final Singleton getInstance() {
		return x;
	}

}
