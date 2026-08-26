package org.firstinspires.ftc.teamcode.vision;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.robot.Robot;

/**
 * Direct from Limelight docs, the same website whose code screwed me over previously
 */
@TeleOp
public class LimelightFromLLDocs extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException
    {
        Robot robot = new Robot(hardwareMap);
        //robot.limelight = hardwareMap.get(Limelight3A.class, "limelight");
        //robot.imu = hardwareMap.get(IMU.class, "imu");

        telemetry.setMsTransmissionInterval(11);

        robot.limelight.pipelineSwitch(0);

        /*
         * Starts polling for data.
         */
        robot.limelight.start();

        while (opModeIsActive()) {

            YawPitchRollAngles orientation = robot.hardware.imu.getRobotYawPitchRollAngles();
            robot.limelight.updateRobotOrientation(orientation.getYaw(AngleUnit.DEGREES));
            LLResult result = robot.limelight.getLatestResult();

            if (result != null) {
                if (result.isValid()) {
                    Pose3D botpose = result.getBotpose();
                    Pose3D botpose_MT2 = result.getBotpose_MT2();
                    telemetry.addData("tx", result.getTx());
                    telemetry.addData("ty", result.getTy());
                    telemetry.addData("Botpose", botpose.toString());
                    telemetry.addData("Botpose", botpose_MT2.toString());
                }
            }
        }
    }
}