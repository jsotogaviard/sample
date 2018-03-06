package com.jsotogaviard;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class AppTest {
	
	@Test
	public void test1() throws Exception {
		InputStream in = new FileInputStream("src/test/resources/one/in.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		App.exec(in, new PrintStream(baos));

		// Actual String
		ByteArrayInputStream actual = new ByteArrayInputStream(baos.toByteArray());

		// Expected string
		FileInputStream expectedOut = new FileInputStream("src/test/resources/one/out.txt");
		Assert.assertEquals(toString(actual), toString(expectedOut));
	}

	@Test
	public void test2() throws Exception {
		InputStream in = new FileInputStream("src/test/resources/two/in.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		App.exec(in, new PrintStream(baos));

		// Actual String
		ByteArrayInputStream actual = new ByteArrayInputStream(baos.toByteArray());

		// Expected string
		FileInputStream expectedOut = new FileInputStream("src/test/resources/two/out.txt");
		Assert.assertEquals(toString(actual), toString(expectedOut));
	}

	static String toString(InputStream is) throws Exception{
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = is.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		return result.toString("UTF-8");
	}

}
