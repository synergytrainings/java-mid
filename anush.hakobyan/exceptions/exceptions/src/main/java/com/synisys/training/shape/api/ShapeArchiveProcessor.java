package com.synisys.training.shape.api;

import java.util.zip.ZipInputStream;

import com.synisys.training.exceptions.NecessaryFilesMissingException;
import com.synisys.training.exceptions.NecessaryFilesOverflow;

public interface ShapeArchiveProcessor {
	
	/**
	 * Creates temporary shape files in the systems ~temp directory.
	 * 
	 * @param zipStream stream of the archive file, that should contain shape files.
	 * 
	 * @throws NecessaryFilesMissing  if the archive does not contain appropriate files (.shp, .shx, .prj, .dbf).
	 * @throws NecessaryFilesOverflow  if the archive contains files with the required extensions more than one.
	 */
	void createTempShapes(ZipInputStream zipStream) throws NecessaryFilesMissingException, NecessaryFilesOverflow;
	
}
