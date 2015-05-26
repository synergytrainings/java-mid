package com.synisys.training.shape.utils;

/**
 * Required types of the shape files
 */
public enum ShapeFileExtensions {

	/**
	 * Extension of the shape file.
	 */
	shp(0),

	/**
	 * Extension of the shapes to attributes index files.
	 */
	shx(1),

	/**
	 * Extension of the projection file.
	 */
	prj(2),

	/**
	 * Extension of the attributes table file.
	 */
	dbf(3);

	private int value;

	ShapeFileExtensions(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
