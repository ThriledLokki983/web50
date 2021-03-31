package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/31/21
 * Time: 4:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyTypes() == BodyTypes.MOON){
            return super.addSatellite(moon);
        }else {
            return false;
        }
    }
}
