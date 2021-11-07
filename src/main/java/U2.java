public class U2 extends Rocket {

    public final int ROCKET_COST_U2;
    public final int ROCKET_WEIGHT_U2;
    public final int MAX_WEIGHT_U2;
    public final int percentage_Of_Success_Launching_U2;
    public final int percentage_Of_Success_Landing_U2;

    public U2() {
        ROCKET_COST_U2 = 120;
        ROCKET_WEIGHT_U2 = 18000;
        MAX_WEIGHT_U2 = 29000;
        percentage_Of_Success_Launching_U2 = 4;
        percentage_Of_Success_Landing_U2 = 8;

    }

    @Override
    public boolean launch_Explosion(int actual_Capacity) {
        if (((this.actual_Capacity/this.cargo_Limit)*100) > this.percentage_Of_Success_Launching_U2)  {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean land_Explosion(int actual_Capacity) {
        if (((this.actual_Capacity/this.cargo_Limit)*100) > this.percentage_Of_Success_Landing_U2) {
            return true;
        } else {
            return false;
        }

    }


}
