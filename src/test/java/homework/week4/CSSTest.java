package homework.week4;

import org.junit.*;

public class CSSTest {
	@Test
	public void test_css() {
		final ComputingStrongComponents testObj = new ComputingStrongComponents("/Users/Lansing/Desktop/Course/Algorithm_part1 /week4/SCC.txt");
		testObj.SCC();
		testObj.getTop5CSSGroupNumber();
	}

	@Test
	public void test_1() {
		final ComputingStrongComponents testObj = new ComputingStrongComponents("/Users/Lansing/GitResource/alg/src/test/java/homework/week4/Test1.txt");
		testObj.SCC();
		// testObj.printF();
		// testObj.printLeader();
		testObj.getTop5CSSGroupNumber();
	}
}
