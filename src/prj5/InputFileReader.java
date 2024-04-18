package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

/**
 * // -------------------------------------------------------------------------
 * /** Parses through the input data from the text file.
 * 
 * @author jacks
 * @version Apr 15, 2024
 */
public class InputFileReader
{
    /**
     * constant designating the number of influencer tokens accepted
     */
    public static final int INF_TOKENS = 4;
    /**
     * constant designating the number of month tokens accepted
     */
    public static final int MONTH_TOKENS = 4;
    private SinglyLinkedList<Influencer> infData;
    private static final String TRADITIONAL = "traditional";
    private static final String REACH = "reach";

    /**
     * creates a new InputFileReader object
     * 
     * @param fileName
     *            is the name of the file containing the influencer data
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public InputFileReader(String fileName)
        throws ParseException,
        FileNotFoundException
    {
        infData = readFile(fileName);
    }


    /**
     * Reads through the file
     * 
     * @param fileName
     *            file to read through
     * @return returns a linked list of Influencers
     */
    public SinglyLinkedList<Influencer> readFile(String fileName)
        throws ParseException,
        FileNotFoundException
    {
        SinglyLinkedList<Influencer> data = new SinglyLinkedList<>();

        // scanner
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        boolean valid = true;

        // skip header
        scanner.nextLine();

        int maxInf = 4;
        int infCount = 0;

        while (scanner.hasNextLine())
        {

            Influencer influencer;
            for (int i = 0; i < maxInf; i++)
            {
                if (!scanner.hasNextLine())
                {
                    scanner.close();
                    return data;
                }

                String line = scanner.nextLine();
                String[] values = line.split(",");
                valid = true;

                String monthName = values[0];

                if (!isValidMonth(monthName))
                {
                    scanner.nextLine();
                }

                monthName = values[0];
                String username = values[1];
                String channel = values[2];
                String country = values[3];
                String mainTopic = values[4];
                int likes = toInt(values[5]);
                int posts = toInt(values[6]);
                int followers = toInt(values[7]);
                int comments = toInt(values[8]);
                int views = toInt(values[9]);

                Month newMonth = new Month(
                    monthName,
                    likes,
                    comments,
                    views,
                    posts,
                    followers);

                if (infCount == 0)
                {
                    Month[] monthArray = new Month[12];
                    monthArray[0] = newMonth;
                    influencer = new Influencer(
                        username,
                        channel,
                        country,
                        mainTopic,
                        monthArray);
                    data.add(influencer);
                    infCount++;

                }

                else
                {
                    for (int j = 0; j < infCount; j++)
                    {
                        if (username.equals(data.get(j).getUsername()))
                        {
                            valid = false;
                            data.get(j).getMonthArray()[getItemsInArray(
                                data.get(j).getMonthArray())] = newMonth;

                        }

                    }
                    if (valid)
                    {
                        Month[] monthArray = new Month[12];
                        monthArray[0] = newMonth;
                        influencer = new Influencer(
                            username,
                            channel,
                            country,
                            mainTopic,
                            monthArray);
                        data.add(influencer);
                        infCount++;
                    }

                }
            }

        }
        scanner.close();
        return data;
    }


    /**
     * Converts a string to an integer
     * 
     * @param str
     *            string to convert
     * @return returns the integer value or 0
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * checks if a month is valid
     * 
     * @param monthName
     *            is the month we are checking
     * @return if its valid
     */
    public boolean isValidMonth(String monthName)
    {
        String[] validMonthNames =
            { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };

        for (int i = 0; i < validMonthNames.length; i++)
        {
            if (monthName.equals(validMonthNames[i]))
            {
                return true;
            }
        }

        return false;
    }


    /**
     * Gets the items in an array
     * 
     * @param array
     *            array of months
     * @return returns the items in an array
     */
    private int getItemsInArray(Month[] array)
    {

        int count = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                count++;
            }
        }
        return count;
    }


    /**
     * prints the output data to the console. Called by project runner
     * @param type represents the type traditional and reach engagement metrics
     */
    public void printDataToConsole(String type)
    {
        DataProcessor dataProcessor = new DataProcessor(infData);
        if (type.equals(TRADITIONAL))
        {
            dataProcessor.printTraditionalEngagementData();
        }
        else if (type.equals(REACH))
        {
            dataProcessor.printReachEngagementData();
        }
    }

    private static class DataProcessor
    {
        private SinglyLinkedList<Influencer> infData;
        private DecimalFormat df;

        public DataProcessor(SinglyLinkedList<Influencer> infData)
        {
            this.infData = infData;
            this.df = new DecimalFormat("#.#");
        }


        private void printTraditionalEngagementData()
        {
            for (int i = 0; i < infData.size(); i++)
            {
                Influencer influencer = infData.get(i);
                System.out.println(influencer.getChannelName());
                double rate = influencer.traditionalEngagementRate();
                System.out.println("traditional: " + df.format(rate));
                System.out.println("==========");
            }
            System.out.println("**********");
            System.out.println("**********");
        }


        private void printReachEngagementData()
        {
            for (int i = 0; i < infData.size(); i++)
            {
                Influencer influencer = infData.get(i);
                System.out.println(influencer.getChannelName());
                double rate = influencer.reachEngagementRate();
                System.out.println("reach: " + df.format(rate));
                System.out.println("==========");
            }

        }
    }

}
