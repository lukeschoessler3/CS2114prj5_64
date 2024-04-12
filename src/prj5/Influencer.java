package prj5;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author lasch
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

}
