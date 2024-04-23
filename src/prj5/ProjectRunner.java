package prj5;

import java.io.IOException;

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
        GUIInfluencerWindow window;
        String fileName;
        SinglyLinkedList<Influencer> infData;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
            fileName = args[0];

        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
            fileName = "SampleInput1_2023.csv";
        }

        boolean showConsole = false;
        boolean showGUI = true;

        if (showConsole)
        {
            filer.printDataToConsole("traditional");
            filer.printDataToConsole("reach");

        }
        if (showGUI)
        {
            infData = filer.readFile(fileName);
            window = new GUIInfluencerWindow(infData);
        }
    }

}
