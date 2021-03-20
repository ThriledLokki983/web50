package com.company;

public class Pegeout extends Car {
    private int roadService;

    public Pegeout(int roadService) {
        super("Pegeout", "4WD", 4, 5, 6, false);
        this.roadService = roadService;
    }

    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() + rate;
        // ternary operator
        // newVelocity = 0 ? stop() : newVelocity > 0 && newVelocity <= 10 ? changeGear(1) : changeGear(2);
        // newVelocity > 10 && newVelocity <= 20 ? changeGear(2) : newVelocity > 20 && newVelocity <= 30 ? changeGear(3) : changeGear(4);

        if (newVelocity == 0){
            stop();
            changeGear(1);
        }else if (newVelocity > 0 && newVelocity <= 10){
            changeGear(1);
        }else if (newVelocity > 10 && newVelocity <= 20){
            changeGear(2);
        }else if (newVelocity > 20 && newVelocity <= 30){
            changeGear(3);
        }else if (newVelocity > 30 && newVelocity <= 40){
            changeGear(4);
        }else {
            changeGear(4);
        }

        if (newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
