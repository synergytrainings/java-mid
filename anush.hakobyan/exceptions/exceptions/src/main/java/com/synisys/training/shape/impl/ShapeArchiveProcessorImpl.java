package com.synisys.training.shape.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synisys.training.exceptions.NecessaryFilesMissingException;
import com.synisys.training.exceptions.NecessaryFilesOverflow;
import com.synisys.training.shape.api.ShapeArchiveProcessor;
import com.synisys.training.shape.utils.ShapeFileExtensions;

public class ShapeArchiveProcessorImpl implements ShapeArchiveProcessor{
	
	private ZipInputStream zipStream = null;
	private Logger log = LoggerFactory.getLogger(ShapeArchiveProcessor.class);
	
	public ShapeArchiveProcessorImpl(ZipInputStream zipInputStream) {
		this.zipStream = zipInputStream;
	}

	/**
	 * 
	 * @throws NecessaryFilesMissingException  if the archive files does not contain appropriate files.s
	 * @throws NecessaryFilesOverflow if the archive contains more than one of the required files.
	 */
	public void createTempShapes(ZipInputStream zipStream) throws NecessaryFilesMissingException, NecessaryFilesOverflow {
		ArrayList<ZipEntry> zipEntries = this.getRequiredShapeEntries(zipStream);
		if(this.checkNecessaryFiles(zipEntries) != 0 ) {
			throw new NecessaryFilesMissingException("Archive does not contain .shp, .shx, .dbf, .prj shape files.");
		} else if(this.checkFilesUniqueness(zipEntries) != 0) {
			throw new NecessaryFilesOverflow("Archive contains files with the required extensions more than once.");
		} else {
			//TODO:create temp shape files
		}
	}
	
	/**
	 * 
	 * @param zipEntries
	 * @return 1, if zip file does not contain all required files, 0 otherwise.
	 */
	private int checkNecessaryFiles(ArrayList<ZipEntry> zipEntries) {
		byte expectedResult = 15;
		byte result = 0;
		for (ZipEntry entry : zipEntries) {
			final String name = entry.getName().toLowerCase();
			String extension = name.substring(name.lastIndexOf(".") + 1);
			if (extension.equals("shp")) {
				result = (byte) (result | 0x00000001);
			} else if (extension.equals("shx")) {
				result = (byte) (result | 0x0000002);
			} else if (extension.equals("prj")) {
				result = (byte) (result | 0x00004);
			} else if (extension.equals("dbf")) { 
				result = (byte) (result | 0x0008); 
			}
		}
		
		return (expectedResult ^ result) != 0 ? 1 : 0; 
	}
	
	private int checkFilesUniqueness(ArrayList<ZipEntry> zipEntries){
		int requiredCilesCount = 4;
		return zipEntries.size() > requiredCilesCount ? 2 : 0;
	}
	
	
	/**
	 * Returns all the entries of the archive file
	 * @param stream of the archive file
	 * 
	 * @return ArrayList of the ZipEntries
	 */
	private ArrayList<ZipEntry> getRequiredShapeEntries(ZipInputStream stream) {
		ZipInputStream zipStream = stream;
		ZipEntry entry = null;
		ArrayList<ZipEntry> zipEntries = new ArrayList<ZipEntry>();
		try {
			while ((entry = zipStream.getNextEntry()) != null) {
				final String name = entry.getName().toLowerCase();
				String extension = name.substring(name.lastIndexOf(".") + 1);
				if (this.isRequiredExtension(extension)) {
					zipEntries.add(entry);
				}
			}
		} catch (IOException ex){
			log.error("Error while reading entries", ex);
			ex.printStackTrace();
		}
		return zipEntries;
	}
	
	
	public boolean isRequiredExtension(String extension) {
		for (ShapeFileExtensions shapeExtension : ShapeFileExtensions.values()) {
			if(shapeExtension.name().equals(extension)) { 
				return true; 
			}
		}
		return false;
	}

}
