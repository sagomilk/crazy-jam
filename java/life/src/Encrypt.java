import java.io.*;
/**
 * 这是一个简单的利用异或加密和解密的简单程序
 * @author sagomilk
 * @version 20140805
 */
public class Encrypt {
	private static final int PASSWORD = 0x12345678;
	private static final String SUFFIX = ".ecpt";

	/**
	 * 加密方法
	 * @param path [需要加密的文件路径]
	 * @return [没有返回值]
	 */
	public void encrypt(String path) {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			int tmp = 0;
			File inFile = new File(path);
			in = new FileInputStream(inFile);
			File outFile = new File(path + SUFFIX);
			out = new FileOutputStream(outFile);
			while ((tmp = in.read()) != -1) {
				out.write(tmp^PASSWORD);
			}


		} catch (FileNotFoundException e) {
			System.out.println("File not exist. ");
		} catch (IOException e) {
			System.out.println("Read file exception ");
		} finally {
			try {
				if (in != null) {
					in.close();
				}

				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("Close resouce fail");
			}
		}
	}

	/**
	 * 解密方法
	 * @param path [需要解密的文件路径]
	 * @return [没有返回值]
	 */
	public void decrypt(String path) {
		int index = path.lastIndexOf(SUFFIX);

		if (index != path.length() - SUFFIX.length()) {
			System.out.println("file type error");
			return;
		}

		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			int tmp = 0;
			File inFile = new File(path);
			in = new FileInputStream(inFile);

			String name = path.substring(0, index);
			File outFile = new File(name);

			out = new FileOutputStream(outFile);

			while ((tmp = in.read()) != -1) {
				out.write(tmp^PASSWORD);
			}


		} catch (FileNotFoundException e) {
			System.out.println("File not exist. ");
		} catch (IOException e) {
			System.out.println("Read file exception ");
		} finally {
			try {
				if (in != null) {
					in.close();
				}

				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("Close resouce fail");
			}
		}

	}

	/**
	 * 简单的加密与解密测试
	 * @param args [调用java命令的时候传入的参数列表]
	 */
	public static void main(String[] args) {
		Encrypt e = new Encrypt();

		// 简单逻辑判断，参数不符合要求直接退出
		if (args.length != 2) {
			System.out.println("args number unmatch 2");
			return;
		}

		String param = args[0];
		String path = args[1];

		// 目前支持2种参数
		// -e 加密
		// -d 解密
		if (param.equalsIgnoreCase("-e")) {
			e.encrypt(path);
		} else if (param.equalsIgnoreCase("-d")) {
			e.decrypt(path);
		}
	}
}