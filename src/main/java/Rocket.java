public abstract class Rocket implements SpaceShip{
    public int cargo_Limit;
    public int actual_Capacity;

    @Override
    public boolean launch_Explosion(int actual_Capacity) {
        return true;
    }

    @Override
    public boolean land_Explosion(int actual_Capacity) {
        return true;
    }

    @Override
    public boolean canCarry(int weight) {

        if (actual_Capacity < cargo_Limit | actual_Capacity == cargo_Limit) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int carry(Item item) {
        actual_Capacity += item.weight;
        return actual_Capacity;
    }
}
