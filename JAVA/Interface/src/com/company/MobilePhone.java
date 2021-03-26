package com.company;

public class MobilePhone implements ITelephone {
    private  int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("MobilePhone is On");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn){
            System.out.println("Now Ringing " + phoneNumber);
        }else{
            System.out.println("Phone is switched off");
        }

    }

    @Override
    public void answer() {
        if (isOn){
            System.out.println("Answering the mobile phone");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn){
            System.out.println("Ringing......");
        }else{
            isRinging = false;
            System.out.println("Mobile phone is not ON!");
        }
        return false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
