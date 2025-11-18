/**
 * Zombie class that inherits from the HorrorCharacter class.
 * A zombie is vulnerable to sunlight and fire.
 */

public class Zombie extends HorrorCharacter
{
    /**
     * Constructor for Zombie class
     * @param name
     * @param health

     */
    public Zombie(String name, int health)
    {
        super(name, health, new Vulnerability[]{Vulnerability.SUNLIGHT, Vulnerability.FIRE});
    }
    /**
     * The zombie bites you.
     */
    @Override
    void attack()
    {
        System.out.println("The zombie bites you");
    }
    /**
     * The zombie runs away.
     */
    @Override
    void flee()
    {
        System.out.println("The zombie runs away.");
    }
    /**
     * Returns a string representation of the zombie.
     * @return String
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
