class FreshJuice {
	enum FreshJuiceSize { SMALL, MEDIUM, LARGE }
	FreshJuiceSize size;
}

class FreshJuiceTest {
	public static void main(String[] args) {
		FreshJuice juice = new FreshJuice();
		juice.size = FreshJuice.FreshJuiceSize.MEDUIM;
	}
}

public class MyFirstJavaProgram {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
}