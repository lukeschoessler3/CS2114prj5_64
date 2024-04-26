package prj5;

import cs2.*;

import java.awt.Color;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * This class allows for the implementation of the Window and interace
 * in which the user interacts. It uses TextShapes, Buttons, Windows,
 * and Shape objects to achieve such feat (CS2 package).
 * 
 * @author Luke Schoessler
 * @author Lucas Lombardi
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

    private TextShape fourChannelText;
    private TextShape threeChannelText;
    private TextShape twoChannelText;
    private TextShape oneChannelText;

    private TextShape fourEngageRate;
    private TextShape threeEngageRate;
    private TextShape twoEngageRate;
    private TextShape oneEngageRate;

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
    public static final int BAR_SIZE_MULTIPLIER = 10;
    public static final int BASE_Y = 600;

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

        bar1 = new Shape(180, BASE_Y, 50, 0, Color.BLUE);
        bar2 = new Shape(330, BASE_Y, 50, 0, Color.RED);
        bar3 = new Shape(480, BASE_Y, 50, 0, Color.GREEN);
        bar4 = new Shape(630, BASE_Y, 50, 0, Color.ORANGE);

        fourChannelText = new TextShape(630, 615, "");
        threeChannelText = new TextShape(480, 615, "");
        twoChannelText = new TextShape(330, 615, "");
        oneChannelText = new TextShape(180, 615, "");

        fourEngageRate = new TextShape(630, 630, "");
        threeEngageRate = new TextShape(480, 630, "");
        twoEngageRate = new TextShape(330, 630, "");
        oneEngageRate = new TextShape(180, 630, "");

        window.addShape(bar1);
        window.addShape(bar2);
        window.addShape(bar3);
        window.addShape(bar4);

        window.addShape(oneChannelText);
        window.addShape(twoChannelText);
        window.addShape(threeChannelText);
        window.addShape(fourChannelText);

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

        firstQuarter = new Button("First Quarter (Jan-March)");
        firstQuarter.onClick(this, "clickedQ1");
        window.addButton(firstQuarter, WindowSide.SOUTH);

    }

    // ~Public Methods ........................................................


    private void checkAndUpdate()
    {
        if (!sortMethodString.isEmpty() && !monthString.isEmpty()
            && !engagementTypeString.isEmpty())
        {

            bar1.remove();
            bar2.remove();
            bar3.remove();
            bar4.remove();

            sortData();
            update();
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
            else if (monthString.equals("First Quarter (Jan-Mar)"))
            {
                infData.sort(new CompareQuarterTraditionalEngagementRate());
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
            else if (monthString.equals("First Quarter (Jan-Mar)"))
            {
                infData.sort(new CompareQuarterReachEngagementRate());
            }
        }
        else if (sortMethodString.equals("Sorting by Channel Name"))
        {
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

        checkAndUpdate();
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
     * Updates the graphs based on the various monthStrings, sortMethodStrings,
     * and engagementTypeStrings
     */
    public void update()
    {
        int height1 = 0;
        int height2 = 0;
        int height3 = 0;
        int height4 = 0;
        
        String bar4Channel;
        String bar3Channel;
        String bar2Channel;
        String bar1Channel;

        if (sortMethodString.equals("Sorting by Channel Name"))
        {
            if (engagementTypeString.equals("Traditional Engagement Rate"))
            {
                if (monthString.equals("First Quarter (Jan-March)"))
                {
                    height1 = (int)infData.get(0).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(1).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(2).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(3).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;

                    Double bar4EngageRate =
                        infData.get(3).traditionalEngagementRate();
                    Double bar3EngageRate =
                        infData.get(2).traditionalEngagementRate();
                    Double bar2EngageRate =
                        infData.get(1).traditionalEngagementRate();
                    Double bar1EngageRate =
                        infData.get(0).traditionalEngagementRate();
                    
                    DecimalFormat df = new DecimalFormat("#.#");
                    
                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }

                else
                {
                    height1 = (int)infData.get(0)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(1)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(2)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(3)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;

                    Double bar4EngageRate = infData.get(3)
                        .monthTraditionalEngagementRate(monthString);
                    Double bar3EngageRate = infData.get(2)
                        .monthTraditionalEngagementRate(monthString);
                    Double bar2EngageRate = infData.get(1)
                        .monthTraditionalEngagementRate(monthString);
                    Double bar1EngageRate = infData.get(0)
                        .monthTraditionalEngagementRate(monthString);
                    
                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }
            }

            else if (engagementTypeString.equals("Reach Engagement Rate"))
            {
                if (monthString.equals("First Quarter (Jan-March)"))
                {
                    height1 = (int)infData.get(0).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(1).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(2).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(3).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    
                    Double bar4EngageRate =
                        infData.get(3).reachEngagementRate();
                    Double bar3EngageRate =
                        infData.get(2).reachEngagementRate();
                    Double bar2EngageRate =
                        infData.get(1).reachEngagementRate();
                    Double bar1EngageRate =
                        infData.get(0).reachEngagementRate();
                    
                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }

                else
                {
                    height1 = (int)infData.get(0)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(1)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(2)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(3)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;

                    Double bar4EngageRate =
                        infData.get(3).monthReachEngagementRate(monthString);
                    Double bar3EngageRate =
                        infData.get(2).monthReachEngagementRate(monthString);
                    Double bar2EngageRate =
                        infData.get(1).monthReachEngagementRate(monthString);
                    Double bar1EngageRate =
                        infData.get(0).monthReachEngagementRate(monthString);

                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }
            }

        }
        else if (sortMethodString.equals("Sorting by Engagement Rate"))
        {
            if (engagementTypeString.equals("Traditional Engagement Rate"))
            {
                if (monthString.equals("First Quarter (Jan-March)"))
                {
                    height1 = (int)infData.get(3).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(2).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(1).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(0).traditionalEngagementRate()
                        * BAR_SIZE_MULTIPLIER;

                    Double bar4EngageRate =
                        infData.get(0).traditionalEngagementRate();
                    Double bar3EngageRate =
                        infData.get(1).traditionalEngagementRate();
                    Double bar2EngageRate =
                        infData.get(2).traditionalEngagementRate();
                    Double bar1EngageRate =
                        infData.get(3).traditionalEngagementRate();
                    
                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }

                else
                {
                    height1 = (int)infData.get(3)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(2)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(1)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(0)
                        .monthTraditionalEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    
                    Double bar4EngageRate = infData.get(0)
                        .monthTraditionalEngagementRate(monthString);
                    Double bar3EngageRate = infData.get(1)
                        .monthTraditionalEngagementRate(monthString);
                    Double bar2EngageRate = infData.get(2)
                        .monthTraditionalEngagementRate(monthString);
                    Double bar1EngageRate = infData.get(3)
                        .monthTraditionalEngagementRate(monthString);

                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }
            }

            else if (engagementTypeString.equals("Reach Engagement Rate"))
            {
                if (monthString.equals("First Quarter (Jan-March)"))
                {
                    height1 = (int)infData.get(3).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(2).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(1).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(0).reachEngagementRate()
                        * BAR_SIZE_MULTIPLIER;
                    
                    Double bar4EngageRate =
                        infData.get(0).reachEngagementRate();
                    Double bar3EngageRate =
                        infData.get(1).reachEngagementRate();
                    Double bar2EngageRate =
                        infData.get(2).reachEngagementRate();
                    Double bar1EngageRate =
                        infData.get(3).reachEngagementRate();
                    
                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }

                else
                {
                    height1 = (int)infData.get(3)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height2 = (int)infData.get(2)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height3 = (int)infData.get(1)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;
                    height4 = (int)infData.get(0)
                        .monthReachEngagementRate(monthString)
                        * BAR_SIZE_MULTIPLIER;

                    
                    Double bar4EngageRate =
                        infData.get(0).monthReachEngagementRate(monthString);
                    Double bar3EngageRate =
                        infData.get(1).monthReachEngagementRate(monthString);
                    Double bar2EngageRate =
                        infData.get(2).monthReachEngagementRate(monthString);
                    Double bar1EngageRate =
                        infData.get(3).monthReachEngagementRate(monthString);

                    DecimalFormat df = new DecimalFormat("#.#");

                    fourEngageRate.setText(df.format(bar4EngageRate));
                    threeEngageRate.setText(df.format(bar3EngageRate));
                    twoEngageRate.setText(df.format(bar2EngageRate));
                    oneEngageRate.setText(df.format(bar1EngageRate));
                }
            }
        }

        if (height1 > 400)
        {
            height1 = 400;
        }
        if (height2 > 350)
        {
            height2 = 350;
        }
        if (height3 > 300)
        {
            height3 = 300;
        }
        if (height4 > 250)
        {
            height4 = 250;
        }

        bar1.setY(BASE_Y - height1);
        bar2.setY(BASE_Y - height2);
        bar3.setY(BASE_Y - height3);
        bar4.setY(BASE_Y - height4);

        bar1 = new Shape(
            bar1.getX(),
            bar1.getY(),
            bar1.getWidth(),
            height1,
            Color.BLUE);
        bar2 = new Shape(
            bar2.getX(),
            bar2.getY(),
            bar2.getWidth(),
            height2,
            Color.RED);
        bar3 = new Shape(
            bar3.getX(),
            bar3.getY(),
            bar3.getWidth(),
            height3,
            Color.GREEN);
        bar4 = new Shape(
            bar4.getX(),
            bar4.getY(),
            bar4.getWidth(),
            height4,
            Color.ORANGE);
        window.addShape(bar1);
        window.addShape(bar2);
        window.addShape(bar3);
        window.addShape(bar4);
        
        bar4Channel = (infData.get(3).getChannelName());
        bar3Channel = (infData.get(2).getChannelName());
        bar2Channel = (infData.get(1).getChannelName());
        bar1Channel = (infData.get(0).getChannelName());
        

        fourChannelText.setText(bar4Channel);
        threeChannelText.setText(bar3Channel);
        twoChannelText.setText(bar2Channel);
        oneChannelText.setText(bar1Channel);

        window.addShape(fourChannelText);
        window.addShape(threeChannelText);
        window.addShape(twoChannelText);
        window.addShape(oneChannelText);
        window.addShape(fourEngageRate);
        window.addShape(threeEngageRate);
        window.addShape(twoEngageRate);
        window.addShape(oneEngageRate);  
    }
}
