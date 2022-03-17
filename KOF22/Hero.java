class Hero extends Character {
    private int mana;
    private Weapon weapon;

    /**
     * A constructor for hero
     * @param name hero's name
     * @param hp hero's hitPoints
     * @param power hero's power
     * @param mana hero's mana
     */
    public Hero(String name, int hp, int power, int mana){
        super(name, hp, power);
        this.mana = mana;
        this.alive = true;
        this.weapon = null;
    }
    
    /**
     * A setter for adding a weapon
     * @param weapon
     */
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    /**
     * A setter for adding a weapon
     * @param weapon
     */
    public void setMana(int mana){
        this.mana = mana;
    }
    
    /**
     * Print out a character information
     * @return a formatted string
     */
    @Override
    public String toString(){  	
        return super.toString() + "Mana: "+ this.mana + "\n";
    }

    /**
     * A getter
     * @return the mana value of a hero
     */
    public int getMana(){
        return this.mana;
    }
    
    /**
     * A getter to get the hero's weapon
     * @return
     */
    public Weapon getWeapon(){
        return this.weapon;
    }

    /**
     * A attack method that belongs to a hero
     * @return the weapon attack value
     */
    public int attackWithWeapon(){
        return weapon.attack();
    }

    /**
     * A special attack method with weapon
     * @return the weapon special attack value
     */
    public int specAttackWithWeapon(){
        return weapon.specAttack();
    }

}
