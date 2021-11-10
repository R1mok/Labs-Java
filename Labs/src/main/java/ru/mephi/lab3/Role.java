package ru.mephi.lab3;

public enum Role {
    STAFF(0.1d),
    MANAGER(0.2d),
    EXECUTIVE(0.3d);
    public final double percent;
    Role (double percent) {this.percent = percent;}
    public double getPercent() {return percent;}
}