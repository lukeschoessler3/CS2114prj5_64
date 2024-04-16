package prj5;

// -------------------------------------------------------------------------
/**
 * Creates the Month class with data per each month allowing the data to be
 * gathered
 * 
 * @author Luke Schoessler
 * @version Apr 11, 2024
 */
public class Month
{
    // ~ Fields ................................................................
    private String monthName;
    private int likes;
    private int comments;
    private int views;
    private int posts;
    private int followers;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Month object.
     * 
     * @param nameOfMonth
     *            name of month
     * @param likeNum
     *            number of likes
     * @param comNum
     *            number of comments
     * @param viewNum
     *            number of views
     * @param postNum
     *            number of posts
     * @param followNum
     *            number of followers
     */
    public Month(
        String nameOfMonth,
        int likeNum,
        int comNum,
        int viewNum,
        int postNum,
        int followNum)
    {
        monthName = nameOfMonth;
        likes = likeNum;
        comments = comNum;
        views = viewNum;
        posts = postNum;
        followers = followNum;
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Gets the month name
     * 
     * @return returns the month name
     */
    public String getMonthName()
    {
        return monthName;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of likes
     * 
     * @return returns the number of likes
     */
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of comments
     * 
     * @return returns the number of comments
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of views
     * 
     * @return returns the number of views
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of posts
     * 
     * @return returns the number of posts
     */
    public int getPosts()
    {
        return posts;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of followers
     * 
     * @return returns the number of followers
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Compares months
     * 
     * @param otherMonth
     * @return returns -1 if less than otherMonth, 1 if greater, and 0 if they
     *             are the same
     */
    public int compareTo(Month otherMonth)
    {

        if (this.getMonthIndex() == -1 || otherMonth.getMonthIndex() == -1)
        {
            return 100;
        }

        if (this.getMonthIndex() < (otherMonth.getMonthIndex()))
        {
            return -1;
        }

        if (this.getMonthIndex() > (otherMonth.getMonthIndex()))
        {
            return 1;
        }

        return 0;

    }


    // ----------------------------------------------------------
    /**
     * Gets the index of the month
     * 
     * @return returns the index of the month and -1 if the month is invalid
     */
    public int getMonthIndex()
    {
        if (this.getMonthName().equals("January"))
        {
            return 0;
        }
        if (this.getMonthName().equals("February"))
        {
            return 1;
        }
        if (this.getMonthName().equals("March"))
        {
            return 2;
        }
        if (this.getMonthName().equals("April"))
        {
            return 3;
        }
        if (this.getMonthName().equals("May"))
        {
            return 4;
        }
        if (this.getMonthName().equals("June"))
        {
            return 5;
        }
        if (this.getMonthName().equals("July"))
        {
            return 6;
        }
        if (this.getMonthName().equals("August"))
        {
            return 7;
        }
        if (this.getMonthName().equals("September"))
        {
            return 8;
        }
        if (this.getMonthName().equals("October"))
        {
            return 9;
        }
        if (this.getMonthName().equals("November"))
        {
            return 10;
        }
        if (this.getMonthName().equals("December"))
        {
            return 11;
        }

        return -1;

    }
}
