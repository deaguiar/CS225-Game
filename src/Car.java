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
     * /
    public int getSpeed()
    {
        return speed;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setSpeed(int s)
    {
        speed = s;
    }

    public boolean equals(Car c)
    {
        if( name.equals(c.getName()) ){

            return true;
        }
        return false;
    }
}//End of Car.java


