package sample;

public class Player
{
    // Fields
    private String name;
    private int score;

    // Constructors
    public Player(String name, int score)
    {
        this.name = name;
        this.score = score;

    }
    // Methods
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
