package com.synisys.training.map;

import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synisys.training.exceptions.NecessaryFilesMissingException;
import com.synisys.training.exceptions.NecessaryFilesOverflow;
import com.synisys.training.shape.api.ShapeArchiveProcessor;
import com.synisys.training.shape.impl.ShapeArchiveProcessorImpl;

public class ShapeProcessingHelper {
		
	public void processShapeFiles(ZipInputStream zipInputStream) {
		ShapeArchiveProcessor shpArchvieProcessor = new ShapeArchiveProcessorImpl(zipInputStream);
		try {
			shpArchvieProcessor.createTempShapes(zipInputStream);
		} catch (NecessaryFilesMissingException ex) {
			System.out.println("Cannot process shape files, as the required files are missing");
		} catch (NecessaryFilesOverflow ex) {
			System.out.println("Cannot process shape files, as there are several "
					+ "files of the required type and system cannot specify approrpiate ones.");
		}
	}
}
