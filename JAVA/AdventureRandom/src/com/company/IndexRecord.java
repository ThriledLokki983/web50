package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/5/21
 * Time: 11:19 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class IndexRecord {
    private int startByte;
    private  int length;

    public IndexRecord(int startByte, int length) {
        this.startByte = startByte;
        this.length = length;
    }

    public int getStartByte() {
        return startByte;
    }

    public void setStartByte(int startByte) {
        this.startByte = startByte;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
