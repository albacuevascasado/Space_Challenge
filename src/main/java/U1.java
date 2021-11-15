public class U1 extends Rocket{

    public final int ROCKET_COST_U1;
    public final int ROCKET_WEIGHT_U1;
    public final int MAX_WEIGHT_U1;
    public final double percentage_Of_Success_Launching_U1;
    public final double percentage_Of_Success_Landing_U1 ;

    public U1(){
        this.ROCKET_COST_U1 = 100;
        this.ROCKET_WEIGHT_U1 = 10000;
        this.MAX_WEIGHT_U1 = 18000;
        this.cargo_Limit = MAX_WEIGHT_U1 - ROCKET_WEIGHT_U1;
        this.percentage_Of_Success_Landing_U1 = 0.03;
        this.percentage_Of_Success_Launching_U1 = 0.01;
    }

    @Override
    public boolean launch_Explosion(int actual_Capacity) {
        if (((this.actual_Capacity/this.cargo_Limit)*0.05) > this.percentage_Of_Success_Launching_U1)  {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean land_Explosion(int actual_Capacity) {
        if (((this.actual_Capacity/this.cargo_Limit)*0.01) > this.percentage_Of_Success_Landing_U1) {
            return true;
        } else {
            return false;
        }

    }


}
