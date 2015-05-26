package com.synisys.training.exceptions;

public class NecessaryFilesMissingException extends Exception {
	//Parameterless Constructor
    public NecessaryFilesMissingException() {}

    //Constructor that accepts a message
    public NecessaryFilesMissingException(String message)
    {
       super(message);
    }
}
