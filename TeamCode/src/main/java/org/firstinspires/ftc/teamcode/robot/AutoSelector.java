package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//thanks to Helios for the idea and for making their repo public to learn from
public class AutoSelector {

    public enum Alliance {
        RED,
        BLUE
    }

    private final LinearOpMode opMode;

    public Alliance alliance = Alliance.RED;
    public long delay = 0;

    private int selection = 0;

    public AutoSelector(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public void update() {

        if (opMode.gamepad1.dpadUpWasPressed()) {
            changeValue(-1);
        } else if (opMode.gamepad1.dpadDownWasPressed()) {
            changeValue(1);
        }

        if (opMode.gamepad1.aWasPressed()) {
            selection = Math.min(selection + 1, 1);
        } else if (opMode.gamepad1.bWasPressed()) {
            selection = Math.max(selection - 1, 0);
        }
    }

    private void changeValue(int direction) {
        switch (selection) { //there is a simpler way to do this, but if/when more options are added life becomes easy
            case 0:
                alliance = Alliance.values()[
                        Math.floorMod(alliance.ordinal() + direction, Alliance.values().length)
                        ]; //this is apparently important for cycling through lists, i dont fully understand this at time of writing
                break;

            case 1:
                delay = Math.max(0, delay + (long) direction * 500);
                break;
        }
    }

    public int getSelection() {
        return selection;
    }
}