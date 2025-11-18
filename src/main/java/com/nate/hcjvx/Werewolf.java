/**
 * Represents a Werewolf character in a horror-themed game.
 * Inherits from HorrorCharacter and implements Transformable interface.
 * A werewolf can transform between human and wolf forms, affecting its attack and flee behaviors.
 */

public class Werewolf extends HorrorCharacter implements Transformable
{
    /**
    * Indicates whether the werewolf is in wolf form (true) or human form (false)
     */
    private Boolean transformed;
    /**
     * Constructor for Werewolf class
     * @param name
     * @param health
     * @param transformed
     */
    public Werewolf(String name, int health, Boolean transformed)
    {
        super(name, health, new Vulnerability[]{Vulnerability.SUNLIGHT, Vulnerability.HOLY_WATER});
        this.transformed = transformed;
    }
    /**
     * If the werewolf is not transformed, it slaps you.
     * If the werewolf is transformed, it slashes you.
     */
    @Override
    void attack()
    {
        if(!transformed)
        {
            System.out.println("The Werewolf " + super.getName() + " (in human form) slaps you");
        }
        else
        {
            System.out.println("The Werewolf " + super.getName()+" (in wolf form) slashes you");
        }
    }
    /**
     * If the werewolf is not transformed, it turns around and runs away.
     * If the werewolf is transformed, it runs away on all fours.
     */
    @Override
    void flee()
    {
        if(!transformed)
        {
            System.out.println("The Werewolf " + super.getName()+ " (in human form) turns around and runs away");
        }
        else
        {
            System.out.println("The Werewolf " + super.getName()+ " (in wolf form) runs away on all fours");
        }
    }

    /**
     * Transforms the werewolf from human to wolf form or vice versa.
     */
    @Override
    public void transform()
    {
        transformed = !transformed;
        if(transformed)
        {
            System.out.println("The Werewolf " + super.getName() + " has transformed into wolf form.");
        }
        else
        {
            System.out.println("The Werewolf " + super.getName() + " has transformed into human form.");
        }
    }
    /**
     * Returns a string representation of the werewolf, including its transformation state.
     * @return String
     */
    @Override
    public String toString()
    {
        return super.toString() + ", transformed=" + transformed;
    }
}
