package prj5;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author lasch
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
     * @param nameOfMonth
     *          name of month
     * @param likeNum
     *          number of likes
     * @param comNum
     *          number of comments
     * @param viewNum
     *          number of views
     * @param postNum   
     *          number of posts
     * @param followNum
     *          number of followers
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

}
