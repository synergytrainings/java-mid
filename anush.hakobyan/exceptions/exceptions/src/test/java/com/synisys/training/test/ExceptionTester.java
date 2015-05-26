package com.synisys.training.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

import org.junit.Test;
import com.synisys.training.exceptions.NecessaryFilesMissingException;
import com.synisys.training.exceptions.NecessaryFilesOverflow;
import com.synisys.training.shape.api.ShapeArchiveProcessor;
import com.synisys.training.shape.impl.ShapeArchiveProcessorImpl;

public class ExceptionTester {

	@Test(expected = NecessaryFilesMissingException.class)
	public void TestNecessaryFiles() throws FileNotFoundException, NecessaryFilesMissingException, NecessaryFilesOverflow {
		InputStream stream = new FileInputStream("src/test/resources/ExceptionsTest/Exception1Test.zip");
		ZipInputStream zipInputStream = new ZipInputStream(stream);
		ShapeArchiveProcessor shpArchvieProcessor = new ShapeArchiveProcessorImpl(zipInputStream);
		shpArchvieProcessor.createTempShapes(zipInputStream);
	}
	
	@Test(expected = NecessaryFilesOverflow.class)
	public void TestUniqunessOfFiles() throws FileNotFoundException, NecessaryFilesMissingException, NecessaryFilesOverflow {
		InputStream stream = new FileInputStream("src/test/resources/ExceptionsTest/Exception2Test.zip");
		ZipInputStream zipInputStream = new ZipInputStream(stream);
		ShapeArchiveProcessor shpArchvieProcessor = new ShapeArchiveProcessorImpl(zipInputStream);
		shpArchvieProcessor.createTempShapes(zipInputStream);
	}
	
}
