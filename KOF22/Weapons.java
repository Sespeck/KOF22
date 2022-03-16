public class Weapons{
    private ArrayList<Weapon> weaponList;
    public Weapons(){
        weaponList = new ArrayList<Weapon>();

        weaponList.add(new Melee());   	
        weaponList.add(new Ranged());  
        weaponList.add(new Magic());  
    }

    public String print(){
        
		System.out.println("1. " weaponList.get(0).toString());
        System.out.println("2. " weaponList.get(1).toString());
        System.out.println("3. " weaponList.get(2).toString());

    }
}