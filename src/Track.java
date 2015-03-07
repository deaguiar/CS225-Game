/**
 * A track is where car's race. Each track has a length and a name
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Track
{
    private String name;

    //length in kilometers
    private int length;

    /**
     * Constructor for objects of class Track
     *
     * @param n: name
     * @param l: length of track
     */
    public Track(String n, int l)
    {
        name = n;
        length= l;
    }

    public int getLength()
    {
        return length;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setLength(int l)
    {
        length = l;
    }

    public boolean equals(Track t)
    {
        if( name.equals(t.getName()) ){

            return true;
        }
        return false;
    }
}

