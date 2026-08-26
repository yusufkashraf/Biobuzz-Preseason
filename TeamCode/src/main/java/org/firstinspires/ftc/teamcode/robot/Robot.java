package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;

public class Robot {

    public final Hardware hardware;

    public final Drivetrain drivetrain;
    public final Intake intake;
    public final Limelight3A limelight;

    public Robot(HardwareMap hardwareMap) {

        hardware = new Hardware();
        hardware.init(hardwareMap);

        drivetrain = new Drivetrain(
                hardware.frontLeftMotor,
                hardware.frontRightMotor,
                hardware.backLeftMotor,
                hardware.backRightMotor,
                hardware.imu
        );
        intake = new Intake(hardware.intake);
        limelight = hardware.limelight;
    }
}