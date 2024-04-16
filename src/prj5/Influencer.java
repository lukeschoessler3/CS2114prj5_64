package prj5;

// -------------------------------------------------------------------------
/**
 * Creates the Influencer class with influencer data and an array of months to
 * hold separate data which is used to calculate engagement rates
 * 
 * @author Luke Schoessler
 * @version Apr 11, 2024
 */
public class Influencer
{
    // ~ Fields ................................................................
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private static final int ARRAY_LENGTH = 12;
    private Month[] monthArray;

    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param user
     *            username
     * @param channel
     *            channel name
     * @param countryName
     *            country name
     * @param topic
     *            main topic
     * @param arrayOfMonths
     *            array of each month
     */
    // ~ Constructors ..........................................................
    public Influencer(
        String user,
        String channel,
        String countryName,
        String topic,
        Month[] arrayOfMonths)
    {
        username = user;
        channelName = channel;
        country = countryName;
        mainTopic = topic;
        monthArray = arrayOfMonths;
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Gets the username
     * 
     * @return returns the username
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Gets the channel name
     * 
     * @return returns the channel name
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Gets the country
     * 
     * @return returns the country
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Gets the main topic
     * 
     * @return returns the main topic
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Gets the month array
     * 
     * @return returns the month array
     */
    public Month[] getMonthArray()
    {
        return monthArray;
    }


    // ----------------------------------------------------------
    /**
     * Gets the month at a specific index in the array
     * 
     * @param index
     *            index of the month
     * @return returns the month at a specific index
     */
    public Month getMonth(int index)
    {
        return monthArray[index];
    }


    // ----------------------------------------------------------
    /**
     * Gets the first month with same name as the parameter
     * 
     * @param nameOfMonth
     *            name of the requested month
     * @return returns the first month with same name as the parameter
     */
    public Month getMonth(String nameOfMonth)
    {
        for (int i = 0; i < ARRAY_LENGTH; i++)
        {
            if (monthArray[i].getMonthName().equals(nameOfMonth))
            {
                return monthArray[i];
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Returns the first quarter of month data
     * 
     * @return returns the first quarter of month data
     */
    public Month[] getFirstQuarter()
    {
        Month[] firstQuarter = new Month[3];

        firstQuarter[0] = getMonth("January");
        firstQuarter[1] = getMonth("February");
        firstQuarter[2] = getMonth("March");

        // Check that there is data for the 3 months
        for (int i = 0; i < firstQuarter.length; i++)
        {
            if (firstQuarter[i] == null)
            {
                return null;
            }
        }

        return firstQuarter;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the traditional engagement rate for the first quarter
     * 
     * @return returns the traditional engagement rate for the first quarter
     */
    public int traditionalEngagementRate()
    {
        int sumComments = 0;
        int sumLikes = 0;
        int sumFollowers = 0;
        int engagementRate = 0;
        Month[] firstQuarter = getFirstQuarter();

        // Check that the first quarter is not null and if so return 0
        if (firstQuarter == null)
        {
            return 0;
        }

        // Add up all values
        for (int i = 0; i < firstQuarter.length; i++)
        {
            sumComments += firstQuarter[i].getComments();
            sumLikes += firstQuarter[i].getLikes();
            sumFollowers += firstQuarter[i].getFollowers();
        }

        engagementRate = ((sumComments + sumLikes) / sumFollowers) * 100;
        return engagementRate;
    }


    // ----------------------------------------------------------
    /**
     * Calculate the reach engagement rate
     * 
     * @return returns the reach engagement rate
     */
    public int reachEngagementRate()
    {
        int sumComments = 0;
        int sumLikes = 0;
        int sumViews = 0;
        int engagementRate = 0;
        Month[] firstQuarter = getFirstQuarter();

        // Check that the first quarter is not null and if so return 0
        if (firstQuarter == null)
        {
            return 0;
        }

        // Add up all values
        for (int i = 0; i < firstQuarter.length; i++)
        {
            sumComments += firstQuarter[i].getComments();
            sumLikes += firstQuarter[i].getLikes();
            sumViews += firstQuarter[i].getViews();
        }

        engagementRate = ((sumComments + sumLikes) / sumViews) * 100;
        return engagementRate;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the array of months based on the month
     */
    public void sortMonths()
    {
        
    }

}
