package org.firstinspires.ftc.teamcode.opmodes.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robot.Robot;

@Autonomous(name = "Drive Test")
public class DriveTest extends LinearOpMode {

    @Override
    public void runOpMode() {

        Robot robot = new Robot(hardwareMap);

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        // (we should definitely NOT use this for actual autons - we should use pedro - but this is just for testing)
        // this is an example of how we can incorporate hardware classes into opmodes
        robot.drivetrain.drive(0, 0.5, 0);
        sleep(2000);
        robot.drivetrain.drive(0, 0, 0);
        sleep(500);
        robot.drivetrain.drive(0.5, 0, 0);
        sleep(2000);
        robot.drivetrain.drive(0, 0, 0);
    }
}