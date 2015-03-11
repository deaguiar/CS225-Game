/**
 * The car is an object which moves in a direction with a speed. It has a name, a start position,
 * current position and final position.
 *
 * @Sean Johnston
 * @1.0
 */
public class Car
{
    private String name;

    //speed in kilometers/hour
    private int speed;

    /**
     * Constructor for objects of class Car
     *
     * @param n: name
     * @param s: speed
     */
    public Car(String n, int s)
    {
        name = n;
        speed = s;
    }

    /**
     * return the speed of this car
     * @return int: speed of car
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * return the name of the car
     * @return String: name of car
     */
    public String getName()
    {
        return name;
    }

    /**
     * set the name of the car
     * @param n : String
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     * set the speed of this car
     * @param s: int
     */
    public void setSpeed(int s)
    {
        speed = s;
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean equals(Car c)
    {
        if( name.equals(c.getName()) ){

            return true;
        }
        return false;
    }
}//End of Car.java


