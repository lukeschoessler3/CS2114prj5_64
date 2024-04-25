package prj5;

import cs2.*;

import java.awt.Color;
import java.text.DecimalFormat;

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
    /**
     * Colors Array; ensure that the same colors are called each time
     */
    public static final String[] COLORS = { "" };

    /**
     * Value to calculate bar size; This number will be multiplied by engagement
     * rates; Can be capped if the number goes off screen
     */
    public static final int BAR_SIZE_MULTIPLIER = 1;
    public static final int BASE_Y = 400;

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

        bar1 = new Shape(180, BASE_Y - 50, 50, 50, Color.BLUE);
        bar2 = new Shape(330, BASE_Y - 40, 50, 40, Color.RED);
        bar3 = new Shape(480, BASE_Y - 30, 50, 30, Color.GREEN);
        bar4 = new Shape(630, BASE_Y - 20, 50, 20, Color.ORANGE);

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


    private void checkAndUpdate()
    {
        if (!sortMethodString.isEmpty() && !monthString.isEmpty()
            && !engagementTypeString.isEmpty())
        {
            sortData();
            
            if (sortMethodString.equals("Sorting by Channel Name")) {
                update("channel");
            }
            else if (engagementTypeString.equals("Traditional Engagement Rate")) {
                update("traditional");
            }
            else {
                update("reach");
            }
        }
    }


    private void sortData()
    {
        if (sortMethodString.equals("Sorting by Engagement Rate")
            && engagementTypeString.equals("Traditional Engagement Rate"))
        {
            if (monthString.equals("January"))
            {
                infData.sort(new CompareJanTraditionalEngagementRate());
            }
            else if (monthString.equals("February"))
            {
                infData.sort(new CompareFebTraditionalEngagementRate());
            }
            else if (monthString.equals("March"))
            {
                infData.sort(new CompareMarTraditionalEngagementRate());
            }
        }
        else if (sortMethodString.equals("Sorting by Engagement Rate")
            && engagementTypeString.equals("Reach Engagement Rate"))
        {
            if (monthString.equals("January"))
            {
                infData.sort(new CompareJanReachEngagementRate());
            }
            else if (monthString.equals("February"))
            {
                infData.sort(new CompareFebReachEngagementRate());
            }
            else if (monthString.equals("March"))
            {
                infData.sort(new CompareMarReachEngagementRate());
            }
        }
        else {
            infData.sort(new CompareByChannelName());
        }
    }


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

        checkAndUpdate();
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

        checkAndUpdate();
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

        checkAndUpdate();
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

        checkAndUpdate();
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

        checkAndUpdate();

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

        checkAndUpdate();
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

        checkAndUpdate();
    }


    // ----------------------------------------------------------
    /**
     * Updates the graphs
     */
    public void update(String type)
    {
        int rate1 = 0;
        int rate2 = 0;
        int rate3 = 0;
        int rate4 = 0;
        Double bar4FQEngageRate = 0.0;
        Double bar3FQEngageRate = 0.0;
        Double bar2FQEngageRate = 0.0;
        Double bar1FQEngageRate = 0.0;
        
        if (type.equals("traditional")) {
            rate1 = (int)infData.get(0).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            rate2 = (int)infData.get(1).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            rate3 = (int)infData.get(2).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            rate4 = (int)infData.get(3).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            
            bar4FQEngageRate = infData.get(3).traditionalEngagementRate();
            bar3FQEngageRate = infData.get(2).traditionalEngagementRate();
            bar2FQEngageRate = infData.get(1).traditionalEngagementRate();
            bar1FQEngageRate = infData.get(0).traditionalEngagementRate();
        }
        
        else if (type.equals("reach") || type.equals("channel")) {
            rate1 = (int)infData.get(0).reachEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            rate2 = (int)infData.get(1).reachEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            rate3 = (int)infData.get(2).reachEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            rate4 = (int)infData.get(3).reachEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            
            bar4FQEngageRate = infData.get(3).reachEngagementRate();
            bar3FQEngageRate = infData.get(2).reachEngagementRate();
            bar2FQEngageRate = infData.get(1).reachEngagementRate();
            bar1FQEngageRate = infData.get(0).reachEngagementRate();
        }

        DecimalFormat df = new DecimalFormat("#.##");

        bar1.setY(BASE_Y - rate1);
        bar2.setY(BASE_Y - rate2);
        bar3.setY(BASE_Y - rate3);
        bar4.setY(BASE_Y - rate4);

        String bar4Channel = new String(infData.get(3).getChannelName());
        String bar3Channel = new String(infData.get(2).getChannelName());
        String bar2Channel = new String(infData.get(1).getChannelName());
        String bar1Channel = new String(infData.get(0).getChannelName());

        TextShape fourChannelText = new TextShape(
            bar4.getX() - bar4.getWidth(),
            bar4.getY() - bar4.getHeight(),
            bar4Channel);
        TextShape threeChannelText = new TextShape(
            bar3.getX() - bar3.getWidth(),
            bar3.getY() - bar3.getHeight(),
            bar3Channel);
        TextShape twoChannelText = new TextShape(
            bar2.getX() - bar2.getWidth(),
            bar2.getY() - bar2.getHeight(),
            bar2Channel);
        TextShape oneChannelText = new TextShape(
            bar1.getX() - bar1.getWidth(),
            bar1.getY() - bar1.getHeight(),
            bar1Channel);

        TextShape fourFQEngageRate = new TextShape(
            fourChannelText.getX(),
            fourChannelText.getY() - 50,
            bar4FQEngageRate.toString());
        TextShape threeFQEngageRate = new TextShape(
            threeChannelText.getX(),
            threeChannelText.getY() - 50,
            bar3FQEngageRate.toString());
        TextShape twoFQEngageRate = new TextShape(
            twoChannelText.getX(),
            twoChannelText.getY() - 50,
            bar2FQEngageRate.toString());
        TextShape oneFQEngageRate = new TextShape(
            oneChannelText.getX(),
            oneChannelText.getY() - 50,
            bar1FQEngageRate.toString());

        window.addShape(fourChannelText);
        window.addShape(threeChannelText);
        window.addShape(twoChannelText);
        window.addShape(oneChannelText);
        window.addShape(fourFQEngageRate);
        window.addShape(threeFQEngageRate);
        window.addShape(twoFQEngageRate);
        window.addShape(oneFQEngageRate);

    }
}
