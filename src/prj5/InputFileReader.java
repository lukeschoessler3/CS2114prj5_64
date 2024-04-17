package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

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
        infData = new SinglyLinkedList<>();
        // influencerWindow = new GUIInfluencerWindow();

        // scanner
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // skip header
        scanner.nextLine();
        int count = 0;

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] values = line.split(",");

            String monthName = values[0];
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            Month newMonth =
                new Month(monthName, likes, comments, views, posts, followers);

            if (!isValidMonth(newMonth))
            {
                continue;
            }

            Influencer influencer = getInfluencerByUsername(username);
            if (count == 0 || infData.get(count - 1).getUsername() != username)
            {
                Month[] monthArray = new Month[12];
                influencer = new Influencer(
                    username,
                    channel,
                    country,
                    mainTopic,
                    monthArray);
                infData.add(influencer);
            }
            else
            {
                monthArray[index] = newMonth;
            }
            count++;
            scanner.close();
        }
    }


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
     * @param month
     *            is the month we are checking
     * @return if its valid
     */
    public boolean isValidMonth(Month month)
    {
        return (month.getMonthIndex() != -1);
    }


    private Influencer getInfluencerByUsername(String username)
    {
        for (Influencer influencer : infData)
        {
            if (influencer.getUsername().equals(username))
            {
                return influencer;
            }
        }
        return null;
    }
}
