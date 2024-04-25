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
    public void update()
    {
        int height1;
        int height2;
        int height3;
        int height4;

        if (monthString.equals("First Quarter (Jan-Mar)"))
        {
            height1 = (int)infData.get(3).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            height2 = (int)infData.get(2).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            height3 = (int)infData.get(1).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            height4 = (int)infData.get(0).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;

            DecimalFormat df = new DecimalFormat("#.#");

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

            String bar4Channel = new String(infData.get(0).getChannelName());
            String bar3Channel = new String(infData.get(1).getChannelName());
            String bar2Channel = new String(infData.get(2).getChannelName());
            String bar1Channel = new String(infData.get(3).getChannelName());

            Double bar4EngageRate = infData.get(0).traditionalEngagementRate();
            Double bar3EngageRate = infData.get(1).traditionalEngagementRate();
            Double bar2EngageRate = infData.get(2).traditionalEngagementRate();
            Double bar1EngageRate = infData.get(3).traditionalEngagementRate();

            TextShape fourChannelText = new TextShape(
                bar4.getX(),
                bar4.getY() + bar4.getHeight() + 15,
                bar4Channel);
            TextShape threeChannelText = new TextShape(
                bar3.getX(),
                bar3.getY() + bar3.getHeight() + 15,
                bar3Channel);
            TextShape twoChannelText = new TextShape(
                bar2.getX(),
                bar2.getY() + bar2.getHeight() + 15,
                bar2Channel);
            TextShape oneChannelText = new TextShape(
                bar1.getX(),
                bar1.getY() + bar1.getHeight() + 15,
                bar1Channel);

            TextShape fourEngageRate = new TextShape(
                fourChannelText.getX(),
                fourChannelText.getY() + 30,
                df.format(bar4EngageRate));
            TextShape threeEngageRate = new TextShape(
                threeChannelText.getX(),
                threeChannelText.getY() + 30,
                df.format(bar3EngageRate));
            TextShape twoEngageRate = new TextShape(
                twoChannelText.getX(),
                twoChannelText.getY() + 30,
                df.format(bar2EngageRate));
            TextShape oneEngageRate = new TextShape(
                oneChannelText.getX(),
                oneChannelText.getY() + 30,
                df.format(bar1EngageRate));

            window.addShape(fourChannelText);
            window.addShape(threeChannelText);
            window.addShape(twoChannelText);
            window.addShape(oneChannelText);
            window.addShape(fourEngageRate);
            window.addShape(threeEngageRate);
            window.addShape(twoEngageRate);
            window.addShape(oneEngageRate);
        }

        else
        {
            height1 = (int)infData.get(3).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            height2 = (int)infData.get(2).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            height3 = (int)infData.get(1).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;
            height4 = (int)infData.get(0).traditionalEngagementRate()
                * BAR_SIZE_MULTIPLIER;

            DecimalFormat df = new DecimalFormat("#.#");

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

            String bar4Channel = new String(infData.get(0).getChannelName());
            String bar3Channel = new String(infData.get(1).getChannelName());
            String bar2Channel = new String(infData.get(2).getChannelName());
            String bar1Channel = new String(infData.get(3).getChannelName());

            Double bar4EngageRate =
                infData.get(0).monthTraditionalEngagementRate(monthString);
            Double bar3EngageRate =
                infData.get(1).monthTraditionalEngagementRate(monthString);
            Double bar2EngageRate =
                infData.get(2).monthTraditionalEngagementRate(monthString);
            Double bar1EngageRate =
                infData.get(3).monthTraditionalEngagementRate(monthString);

            TextShape fourChannelText = new TextShape(
                bar4.getX(),
                bar4.getY() + bar4.getHeight() + 15,
                bar4Channel);
            TextShape threeChannelText = new TextShape(
                bar3.getX(),
                bar3.getY() + bar3.getHeight() + 15,
                bar3Channel);
            TextShape twoChannelText = new TextShape(
                bar2.getX(),
                bar2.getY() + bar2.getHeight() + 15,
                bar2Channel);
            TextShape oneChannelText = new TextShape(
                bar1.getX(),
                bar1.getY() + bar1.getHeight() + 15,
                bar1Channel);

            TextShape fourEngageRate = new TextShape(
                fourChannelText.getX(),
                fourChannelText.getY() + 30,
                df.format(bar4EngageRate));
            TextShape threeEngageRate = new TextShape(
                threeChannelText.getX(),
                threeChannelText.getY() + 30,
                df.format(bar3EngageRate));
            TextShape twoEngageRate = new TextShape(
                twoChannelText.getX(),
                twoChannelText.getY() + 30,
                df.format(bar2EngageRate));
            TextShape oneEngageRate = new TextShape(
                oneChannelText.getX(),
                oneChannelText.getY() + 30,
                df.format(bar1EngageRate));

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
}
