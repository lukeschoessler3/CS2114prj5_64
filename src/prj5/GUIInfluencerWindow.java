package prj5;

import cs2.*;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Luke Schoessler
 * @version Apr 22, 2024
 */
public class GUIInfluencerWindow
{
    // ~ Fields ................................................................
    private SinglyLinkedList<Influencer> infData;
    private Window window;
    private Button sortChannelName;
    private Button sortEngagementRate;
    private Button quit;
    private Button traditionalEngagementRate;
    private Button reachEngagementRate;
    private Button january;
    private Button february;
    private Button march;
    private Button firstQuarter;
    private int dataWindowSize;
    private String monthString;
    private String sortMethodString;
    private String engagementTypeString;
    public static final int BAR_SIZE_MULTIPLIER = 2;

    // ~ Constructors ..........................................................

    /**
     * Creates a new GUIInfluencerWindow view for a given list of influencers
     *
     * @param infList
     *            the game to create a view for
     */
    public GUIInfluencerWindow(SinglyLinkedList<Influencer> infList)
    {
        infData = infList;
        monthString = "";
        sortMethodString = "";
        engagementTypeString = "";
        window = new Window();

        sortChannelName = new Button("Sort by Channel Name");
        sortChannelName.onClick(this, "clickedSortChannel");
        window.addButton(sortChannelName, WindowSide.NORTH);

        sortEngagementRate = new Button("Sort by Engagement Rate");
        sortEngagementRate.onClick(this, "clickedSortEngagement");
        window.addButton(sortEngagementRate, WindowSide.NORTH);

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

        traditionalEngagementRate = new Button("Traditional Engagement Rate");
        traditionalEngagementRate.onClick(this, "clickedTraditional");
        window.addButton(traditionalEngagementRate, WindowSide.WEST);

        reachEngagementRate = new Button("Reach Engagement Rate");
        reachEngagementRate.onClick(this, "clickedReach");
        window.addButton(reachEngagementRate, WindowSide.WEST);

        january = new Button("January");
        january.onClick(this, "clickedJan");
        window.addButton(january, WindowSide.SOUTH);

        february = new Button("February");
        february.onClick(this, "clickedFen");
        window.addButton(february, WindowSide.SOUTH);

        march = new Button("March");
        march.onClick(this, "clickedMar");
        window.addButton(march, WindowSide.SOUTH);

        firstQuarter = new Button("First Quarter (Jan - March)");
        firstQuarter.onClick(this, "clickedQ1");
        window.addButton(firstQuarter, WindowSide.SOUTH);

    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Update window when january is clicked
     * 
     * @param janButton
     *            january button
     */
    public void clickedJan(Button janButton)
    {

    }


    // ----------------------------------------------------------
    /**
     * Update window when february is clicked
     * 
     * @param febButton
     *            february button
     */

    public void clickedFeb(Button febButton)
    {

    }


    // ----------------------------------------------------------
    /**
     * Update window when march is clicked
     * 
     * @param marchButton
     *            march button
     */
    public void clickedMar(Button marchButton)
    {

    }


    // ----------------------------------------------------------
    /**
     * Update window when first quarter is clicked
     * 
     * @param firstQuarterButton
     *            first quarter button
     */
    public void clickedQ1(Button firstQuarterButton)
    {

    }


    // ----------------------------------------------------------
    /**
     * Exits out of the system when the quit button is clicked
     * 
     * @param quitButton
     *            quit button
     */
    public void clickedQuit(Button quitButton)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Update window when sort by channel name is clicked
     * 
     * @param sortChannel
     *            sort channel button
     */
    public void clickedSortChannel(Button sortChannel)
    {

    }


    // ----------------------------------------------------------
    /**
     * Update window when sort by engagement rate is clicked
     * 
     * @param sortEngage
     *            sort engagement button
     */
    public void clickedSortEngagement(Button sortEngage)
    {

    }


    // ----------------------------------------------------------
    /**
     * Update window when traditional is clicked
     * 
     * @param traditional
     *            traditional button
     */
    public void clickedTraditional(Button traditional)
    {

    }


    // ----------------------------------------------------------
    /**
     * Update window when reach is clicked
     * 
     * @param reach
     *            reach button
     */
    public void clickedReach(Button reach)
    {

    }

}
