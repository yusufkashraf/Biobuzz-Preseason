package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;

//state machines are life.
public class Intake {
    private DcMotorEx intake;

    public enum IntakeState {
        IDLE,
        INTAKE,
        OUTTAKE
    }

    private IntakeState currentState = IntakeState.IDLE;

    public Intake(DcMotorEx intake) {
        this.intake = intake;
        this.intake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void setState (IntakeState state) {
        currentState = state;
    }

    public IntakeState getState() {
        return currentState;
    }

    public void update() {
        switch (currentState) {
            case IDLE:
                intake.setPower(0);
                break;

            case INTAKE:
                intake.setPower(1);
                break;

            case OUTTAKE:
                intake.setPower(-1);
                break;

        }
    }
}
