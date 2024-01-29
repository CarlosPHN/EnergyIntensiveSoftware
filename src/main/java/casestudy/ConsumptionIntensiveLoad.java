package casestudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class ConsumptionIntensiveLoad {

	private static ConsumptionIntensiveLoad mInstance;

	private ConsumptionIntensiveLoad() {
	}

	public static ConsumptionIntensiveLoad getInstance() {
		if (mInstance == null)
			mInstance = new ConsumptionIntensiveLoad();
		return mInstance;
	}

	public void prepare(int milis, int id) throws Exception {
		System.out.println("==========Preparing intensive load: " + id + " =============");
		Thread.sleep(milis);
	}

	public void sleep() throws Exception {
		System.out.println("Sleeping for 2 secs");
		Thread.sleep(2000);
	}

	public void launch(File file, int id) throws Exception {
		File fileCreated = null;
		FileInputStream fInput = null;
		FileOutputStream fOutput = null;
		int c;
		System.out.println("\t==========Throwing intensive load: " + id + " =============");
		fInput = new FileInputStream(file);
		fileCreated = new File("stuff/file" + "_" + id + ".txt");
		fOutput = new FileOutputStream(fileCreated);
		while ((c = fInput.read()) != -1)
			fOutput.write(c);
		fInput.close();
		fOutput.close();
		fileCreated.delete();
	}

	public void main(int launches, int millis) {
		File file = new File(Paths.get("stuff/file.txt").toAbsolutePath().toString());
		try {
			for (int i = 0; i < launches; i++) {
				prepare(millis, i);
				launch(file, i);
				sleep();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}