package com.qnet.githubapi.services;

public class UpgradeService {

    String upgradeVersion;

    DemoService demo;

    public UpgradeService(String upgradeVersion, DemoService demo) {
        this.upgradeVersion = upgradeVersion;
        this.demo = demo;
    }

    public String getUpgradeVersion() {
        return upgradeVersion;
    }

    public void setUpgradeVersion(String upgradeVersion) {
        this.upgradeVersion = upgradeVersion;
    }

    public DemoService getDemo() {
        return demo;
    }

    public void setDemo(DemoService demo) {
        this.demo = demo;
    }
}
