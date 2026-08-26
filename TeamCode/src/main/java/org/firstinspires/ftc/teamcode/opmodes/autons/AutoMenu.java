package org.firstinspires.ftc.teamcode.opmodes.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robot.AutoSelector;

@Autonomous
public class AutoMenu extends LinearOpMode {

    @Override
    public void runOpMode() {

        AutoSelector selector = new AutoSelector(this);

        while (opModeInInit()) {
            selector.update();

            int selection = selector.getSelection();
            telemetry.addLine("=== AUTO SELECTOR ===\n");

            telemetry.addData(selection == 0 ? "> Alliance" : "  Alliance", selector.alliance);
            telemetry.addData(selection == 1 ? "> Delay"    : "  Delay",    selector.delay + " ms");

            telemetry.addLine("\nD-Pad: Change");
            telemetry.addLine("A/B: Select");
            telemetry.update();
        }

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        sleep(selector.delay); //be careful when adding more options and stuff, know whether it goes before or after this

        if (selector.alliance == AutoSelector.Alliance.RED) {
            runRedAuto();
        } else {
            runBlueAuto();
        }
    }

    private void runRedAuto() {
        // Red auton
    }

    private void runBlueAuto() {
        // Blue auton
    }
}