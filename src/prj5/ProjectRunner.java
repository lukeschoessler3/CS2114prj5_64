package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Luke Schoessler (lukeschoessler3)

// -------------------------------------------------------------------------
/**
 * This class runs the file reader.
 * 
 * @author Luke Schoessler
 * @version Apr 17, 2024
 */
public class ProjectRunner
{

    // ~ Fields ................................................................

    // ~Public Methods ........................................................\
    // // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {

        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        boolean showConsole = true;
        boolean showGUI = false;

        if (showConsole)
        {
            filer.printDataToConsole("traditional");
            filer.printDataToConsole("reach");

        }
        if (showGUI)
        {
            // Should not be implemented till final submission
        }
    }

}
