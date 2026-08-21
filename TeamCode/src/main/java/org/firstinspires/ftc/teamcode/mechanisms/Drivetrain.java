package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.robot.Hardware;

public class Drivetrain {

    private final Hardware hardware;


    public Drivetrain(DcMotorEx frontLeft,
                      DcMotorEx frontRight,
                      DcMotorEx backLeft,
                      DcMotorEx backRight) {
        this.hardware = new Hardware();
        this.hardware.frontLeftMotor = frontLeft;
        this.hardware.frontRightMotor = frontRight;
        this.hardware.backLeftMotor = backLeft;
        this.hardware.backRightMotor = backRight;
    }

    public void drive(double x, double y, double rotation) {
        double frontLeft = y + x + rotation;
        double frontRight = y - x - rotation;
        double backLeft = y - x + rotation;
        double backRight = y + x - rotation;

        hardware.frontLeftMotor.setPower(frontLeft);
        hardware.frontRightMotor.setPower(frontRight);
        hardware.backLeftMotor.setPower(backLeft);
        hardware.backRightMotor.setPower(backRight);
    }
}