public class U2 extends Rocket {

    public final int ROCKET_COST_U2;
    public final int ROCKET_WEIGHT_U2;
    public final int MAX_WEIGHT_U2;
    public final double percentage_Of_Success_Launching_U2;
    public final double percentage_Of_Success_Landing_U2;

    public U2() {
        ROCKET_COST_U2 = 120;
        ROCKET_WEIGHT_U2 = 18000;
        MAX_WEIGHT_U2 = 29000;
        this.cargo_Limit = MAX_WEIGHT_U2 - ROCKET_WEIGHT_U2;
        percentage_Of_Success_Launching_U2 = 0.02;
        percentage_Of_Success_Landing_U2 = 0.04;

    }

    @Override
    public boolean launch_Explosion(int actual_Capacity) {
        if (((this.actual_Capacity/this.cargo_Limit)*0.04) > this.percentage_Of_Success_Launching_U2)  {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean land_Explosion(int actual_Capacity) {
        if (((this.actual_Capacity/this.cargo_Limit)*0.08) > this.percentage_Of_Success_Landing_U2) {
            return true;
        } else {
            return false;
        }

    }


}
