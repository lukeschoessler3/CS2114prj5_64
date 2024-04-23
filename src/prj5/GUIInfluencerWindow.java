package prj5;

import cs2.*;

import java.awt.Color;

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
    // Text shape for the month/quarter
    private TextShape monthText;
    // Text shape for the sorting type
    private TextShape sortText;
    // Text shape for the engagement type if sorting by engagement
    private TextShape engagementText;

    // Create bar shapes
    private Shape bar1;
    private Shape bar2;
    private Shape bar3;
    private Shape bar4;

    // Size of window
    private int dataWindowHeight;
    private int dataWindowWidth;
    // What will be displayed for the month/quarter
    private String monthString;
    // What will be displayed for the sorting method
    private String sortMethodString;
    // What will be displayed for the engagement type if sorting by engagement
    private String engagementTypeString;
    // Value to calculate bar size; This number will be multiplied by engagement
    // rates; Can be capped if the number goes off screen
    public static final int BAR_SIZE_MULTIPLIER = 20;

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
        dataWindowHeight = 800;
        dataWindowWidth = 1200;

        window = new Window();
        window.setTitle("Social Media Vis");
        window.setSize(dataWindowWidth, dataWindowHeight);

        monthText = new TextShape(10, 10, "");
        window.addShape(monthText);

        engagementText = new TextShape(10, 30, "");
        window.addShape(engagementText);

        sortText = new TextShape(10, 50, "");
        window.addShape(sortText);

        bar1 = new Shape(180, 530, 40, 0, Color.BLUE);
        bar2 = new Shape(380, 530, 40, 0, Color.RED);
        bar2 = new Shape(580, 530, 40, 0, Color.GREEN);
        bar3 = new Shape(680, 530, 40, 0, Color.ORANGE);

        window.addShape(bar1);
        window.addShape(bar2);
        window.addShape(bar3);
        window.addShape(bar4);

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
        february.onClick(this, "clickedFeb");
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
        monthString = "January";

        monthText.setText(monthString);
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
        monthString = "February";

        monthText.setText(monthString);
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
        monthString = "March";

        monthText.setText(monthString);
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
        monthString = "First Quarter (Jan-March)";

        monthText.setText(monthString);
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
        sortMethodString = "Sorting by Channel Name";

        sortText.setText(sortMethodString);

        CompareByChannelName comparator = new CompareByChannelName();

        infData.sort(comparator);
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
        sortMethodString = "Sorting by Engagement Rate";

        sortText.setText(sortMethodString);

        if (engagementTypeString.equals("Traditional Engagement Rate"))
        {
            if (monthString.equals("First Quarter (Jan-March)"))
            {
                CompareQuarterTraditionalEngagementRate comparator =
                    new CompareQuarterTraditionalEngagementRate();

                infData.sort(comparator);
            }

            else if (monthString.equals("January"))
            {
                CompareJanTraditionalEngagementRate comparator =
                    new CompareJanTraditionalEngagementRate();

                infData.sort(comparator);
            }
            else if (monthString.equals("February"))
            {
                CompareFebTraditionalEngagementRate comparator =
                    new CompareFebTraditionalEngagementRate();

                infData.sort(comparator);
            }
            else if (monthString.equals("March"))
            {
                CompareMarTraditionalEngagementRate comparator =
                    new CompareMarTraditionalEngagementRate();

                infData.sort(comparator);
            }

        }
        else if (engagementTypeString.equals("Reach Engagement Rate"))
        {
            if (monthString.equals("First Quarter (Jan-March)"))
            {
                CompareQuarterReachEngagementRate comparator =
                    new CompareQuarterReachEngagementRate();

                infData.sort(comparator);
            }

            else if (monthString.equals("January"))
            {
                CompareJanReachEngagementRate comparator =
                    new CompareJanReachEngagementRate();

                infData.sort(comparator);
            }
            else if (monthString.equals("February"))
            {
                CompareFebReachEngagementRate comparator =
                    new CompareFebReachEngagementRate();

                infData.sort(comparator);
            }
            else if (monthString.equals("March"))
            {
                CompareMarReachEngagementRate comparator =
                    new CompareMarReachEngagementRate();

                infData.sort(comparator);
            }
        }
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
        engagementTypeString = "Traditional Engagement Rate";

        engagementText.setText(engagementTypeString);

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
        engagementTypeString = "Reach Engagement Rate";

        engagementText.setText(engagementTypeString);
    }


    // ----------------------------------------------------------
    /**
     * Updates the graphs
     */
    public void update()
    {
        if (sortMethodString.equals("Reach Engagement Rate"))
        {
            int rate1 =
                (int)infData.get(0).reachEngagementRate() * BAR_SIZE_MULTIPLIER;
            int rate2 =
                (int)infData.get(1).reachEngagementRate() * BAR_SIZE_MULTIPLIER;
            int rate3 =
                (int)infData.get(2).reachEngagementRate() * BAR_SIZE_MULTIPLIER;
            int rate4 =
                (int)infData.get(3).reachEngagementRate() * BAR_SIZE_MULTIPLIER;

            bar1 = new Shape(
                bar1.getX(),
                bar1.getY(),
                bar1.getWidth(),
                rate1,
                Color.BLUE);

            bar2 = new Shape(
                bar2.getX(),
                bar2.getY(),
                bar2.getWidth(),
                rate2,
                Color.RED);

            bar3 = new Shape(
                bar3.getX(),
                bar3.getY(),
                bar3.getWidth(),
                rate3,
                Color.GREEN);

            bar4 = new Shape(
                bar4.getX(),
                bar4.getY(),
                bar4.getWidth(),
                rate4,
                Color.ORANGE);
        }

    }

}
