package com.company;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Name: Gideon Nimoh
 * Date: 3/31/21
 * Time: 3:48 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    /**
     *     public static final int STAR = 1;
     *     public static final int PLANET = 2;
     *     public static final int DWARF_PLANET = 3;
     *     public static final int MOON = 4;
     *     public static final int COMET = 5;
     *     public static final int ASTEROID = 6;
     */

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID,
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    //the code that is calling this object does not have access to our original HashSets
    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

/**
 *     public final boolean equals(Object obj){
 *         if (this == obj){
 *             return true;
 *         }
 *         if (obj instanceof HeavenlyBody){
 *             HeavenlyBody theObject = (HeavenlyBody) obj;
 *             if (this.name.equals(theObject.getName())){
 *                 return this.bodyType == theObject.getBodyType();
 *             }
 *         }
 *         return false;
 *     }

**/

    public final boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if (this.key.name.equals(theObject.key.getName())){
                return this.key.equals(theObject.getKey());
            }
        }
        return false;
    }

    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name, bodyTypes);
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyTypes + ", " + this.orbitalPeriod;
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyTypes;

        public Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + bodyTypes.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
           Key key = (Key) obj;
           if (this.name.equals(key.getName())){
               return (this.bodyTypes == key.getBodyTypes());
           }
           return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyTypes;
        }
    }
}