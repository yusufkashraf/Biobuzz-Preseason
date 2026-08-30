package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.teamcode.robot.Config.STRAFE_COMPENSATION;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Drivetrain {

    private final DcMotorEx frontLeftMotor;
    private final DcMotorEx frontRightMotor;
    private final DcMotorEx backLeftMotor;
    private final DcMotorEx backRightMotor;
    private final IMU imu;

    public Drivetrain(DcMotorEx frontLeftMotor, DcMotorEx frontRightMotor, DcMotorEx backLeftMotor, DcMotorEx backRightMotor, IMU imu) {
        this.frontLeftMotor = frontLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backLeftMotor = backLeftMotor;
        this.backRightMotor = backRightMotor;
        this.imu = imu;
    }

    public void robotCentricDrive(double strafe, double forward, double rotation) {

        strafe *= STRAFE_COMPENSATION;

        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotation), 1);
        double frontLeftPower = (forward + strafe + rotation) / denominator;
        double backLeftPower = (forward - strafe + rotation) / denominator;
        double frontRightPower = (forward - strafe - rotation) / denominator;
        double backRightPower = (forward + strafe - rotation) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }

    public void fieldCentricDrive(double strafe, double forward, double rotation) {

        double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double rotatedX = strafe * Math.cos(-heading) - forward * Math.sin(-heading);
        double rotatedY = strafe * Math.sin(-heading) + forward * Math.cos(-heading);

        robotCentricDrive(rotatedX, rotatedY, rotation);
    }
}