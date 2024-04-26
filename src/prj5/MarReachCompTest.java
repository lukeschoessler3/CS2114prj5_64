// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jackson Bauer (jacksonbauer)

package prj5;

import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** tests class for the march reach engagement comparator
 * 
 * @author Jackson Bauer
 * @version Apr 25, 2024
 */
public class MarReachCompTest
    extends TestCase
{

    private Influencer person;
    private Influencer person2;

    // ~ Constructors ..........................................................
    /**
     * sets up test cases
     */
    public void setUp()
    {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("apple");
        list.add("banana");
        list.add("mango");
        list.add("kiwi");

        Month jan1 = new Month("January", 1000, 100, 512, 100, 10);
        Month feb1 = new Month("February", 2000, 200, 842, 200, 30);
        Month march1 = new Month("March", 2000, 200, 54, 200, 450);
        Month jan2 = new Month("January", 3000, 300, 7521, 300, 320);
        Month feb2 = new Month("February", 4000, 400, 9385, 400, 57);
        Month march2 = new Month("March", 4000, 400, 32, 400, 243);
        Month jan3 = new Month("January", 5000, 500, 186, 500, 642);
        Month feb3 = new Month("February", 6000, 600, 4982, 600, 934);
        Month march3 = new Month("March", 6000, 600, 4382, 600, 124);

        Month[] monthArray1 = new Month[12];
        monthArray1[0] = jan1;
        monthArray1[1] = feb1;
        monthArray1[2] = march1;

        Month[] monthArray2 = new Month[12];
        monthArray2[0] = jan2;
        monthArray2[1] = feb2;
        monthArray2[2] = march2;

        Month[] monthArray3 = new Month[12];
        monthArray3[0] = jan3;
        monthArray3[1] = feb3;
        monthArray3[2] = march3;

        person = new Influencer("a", "football", "US", "Sports", monthArray1);
        person2 = new Influencer("b", "soccer", "US", "Sports", monthArray2);

        SinglyLinkedList<Influencer> list2 = new SinglyLinkedList<Influencer>();
        list2.add(person);

        list2.add(person2);

    }


    /**
     * tests the comparator
     */
    public void testCompare()
    {
        CompareMarReachEngagementRate compMarReach =
            new CompareMarReachEngagementRate();
        Influencer inf1 = person;
        Influencer inf2 = person2;

        int result = compMarReach.compare(inf1, inf2);
        assertTrue(result < 0);
    }
}
