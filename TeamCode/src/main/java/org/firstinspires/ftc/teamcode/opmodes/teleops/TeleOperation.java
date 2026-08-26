package org.firstinspires.ftc.teamcode.opmodes.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;

@TeleOp
public class TeleOperation extends LinearOpMode {

    @Override
    public void runOpMode() {

        Robot robot = new Robot(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            /**
             * free will! we can choose robot or field centric!
             */
            //robot.drivetrain.robotCentricDrive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
            robot.drivetrain.fieldCentricDrive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);


            if (gamepad1.a) {
                robot.intake.setState(Intake.IntakeState.INTAKE);
            } else if (gamepad1.b) {
                robot.intake.setState(Intake.IntakeState.OUTTAKE);
            } else {
                robot.intake.setState(Intake.IntakeState.IDLE);
            }

            robot.intake.update();


            telemetry.addData("Intake", robot.intake.getState());
            telemetry.addData("Heading",
                    robot.hardware.imu.getRobotYawPitchRollAngles().getYaw(
                            org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES
                    )
            );
            telemetry.update();
        }
    }
}