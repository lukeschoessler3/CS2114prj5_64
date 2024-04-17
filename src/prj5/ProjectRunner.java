package prj5;

import java.io.FileNotFoundException;
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
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException
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
    }

}
