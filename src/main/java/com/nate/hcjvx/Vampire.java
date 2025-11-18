/**
 * Vampire class that extends HorrorCharacter and implements Transformable interface
 * A vampire can transform between human and bat form
 * A vampire has vulnerabilities to sunlight and silver
 */

public class Vampire extends HorrorCharacter implements Transformable
{
    /** Indicates whether the vampire is in bat form (true) or human form (false)
     */
    private Boolean transformed;

    /**
     * Constructor for Vampire class
     * @param name
     * @param health
     * @param transformed
     */
    public Vampire(String name, int health, Boolean transformed)
    {
        super(name, health, new Vulnerability[]{Vulnerability.SUNLIGHT, Vulnerability.SILVER});
        this.transformed = transformed;
    }
    /**
     * If the vampire is not transformed, it bites you.
     * If the vampire is transformed, it swoops down and scratches you.
     */
    @Override
    void attack()
    {
        if(!transformed)
        {
            System.out.println("The vampire " + super.getName() + "(in human form) bites you.");
        }
        else
        {
            System.out.println("The vampire " + super.getName() + " (in bat form) swoops down and scratches you.");
        }
    }
    /**
     * If the vampire is not transformed, it flies away.
     * If the vampire is transformed, it disappears.
     */
    @Override
    void flee()
    {
        if (transformed)
        {
            System.out.println("The vampire " + super.getName()+" (in bat form) flies away.");
        } else
        {
            System.out.println("The vampire " + super.getName()+ "(in human form) dissapeared.");
        }
    }

    /**
     * Transforms the vampire from human to bat form or vice versa.
     */
    @Override
    public void transform()
    {
        transformed = !transformed;
        if (transformed) {System.out.println("The vampire " + super.getName() +" has transformed into bat form.");}
        else {System.out.println("The vampire " + super.getName() + " has transformed into human form.");}
    }
    /**
     * Returns a string representation of the vampire, including the value of transformed.
     * @return String
     */
    @Override
    public String toString()
    {
        return super.toString() + ", transformed=" + transformed;
    }
}
