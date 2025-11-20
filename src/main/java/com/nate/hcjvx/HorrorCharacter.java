package com.nate.hcjvx;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 * Abstract class representing a character in a horror game.
 * Each character has a name, health points, and an array of vulnerabilities.
 * The class provides methods for attacking and fleeing, as well as a method to retrieve vulnerabilities.
 */
public abstract class HorrorCharacter
{
    /** Name of the character
     */
    private String name;
    /** Health points of the character
     */
    private int health;
    /** Array of vulnerabilities for the character
     */
    Vulnerability[] vulnerabilities;

    LocalDate lastSpotted;
    /**
     * Constructor for HorrorCharacter class
     * @param name
     * @param health
     * @param vulnerabilities
     */
    public HorrorCharacter(String name, int health, Vulnerability[] vulnerabilities, LocalDate lastSpotted)
    {
        this.name = name;
        this.health = health;
        this.vulnerabilities = vulnerabilities;
        this.lastSpotted = lastSpotted;
    }
    /**
     * Abstract method for attacking. To be implemented by subclasses.
     */
    void attack(){}
    /**
     * Abstract method for fleeing. To be implemented by subclasses.
     */
    void flee(){}
    /**
     * Returns the name of the character.
     * @return String
     */
    public String getName()
    {
        return name;
    }
    /**
     * Sets the name of the character.
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Returns the health points of the character.
     * @return int
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * Sets the health points of the character.
     * @param health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    /**
     * Sets the array of vulnerabilities for the character.
     * @param vulnerabilities
     */
    public void setVulnerabilities(Vulnerability[] vulnerabilities)
    {
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * Returns the array of vulnerabilities for the character.
     * @return Vulnerability[]
     */

    Vulnerability[] getVulnerabilities() {return vulnerabilities;}
    /**
     * Returns a string representation of the character, including name, health, and vulnerabilities.
     * @return String
     */
    @Override
    public String toString()
    {
        return
                "Name: " + name+
                ", Health: " + health +
                ", Vulnerabilities: " + Arrays.toString(vulnerabilities) +
                ", Last spotted: " + lastSpotted;
    }
}
