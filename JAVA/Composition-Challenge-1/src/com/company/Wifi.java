package com.company;

public class Wifi {
    private String serviceProvider;
    private int uploadSpeed;
    private int downloadSpeed;
    private int costPerMonth;

    public Wifi(String serviceProvider, int uploadSpeed, int downloadSpeed, int costPerMonth) {
        this.serviceProvider = serviceProvider;
        this.uploadSpeed = uploadSpeed;
        this.downloadSpeed = downloadSpeed;
        this.costPerMonth = costPerMonth;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public int getUploadSpeed() {
        return uploadSpeed;
    }

    public int getDownloadSpeed() {
        return downloadSpeed;
    }

    public int getCostPerMonth() {
        return costPerMonth;
    }
}
