package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;

//state machines are life.
public class ExampleMechanismStateMachine {
    private DcMotorEx example;

    public enum ExampleState {
        IDLE,
        INTAKE,
        OUTTAKE
    }

    private ExampleState currentState = ExampleState.IDLE;

    public ExampleMechanismStateMachine(DcMotorEx example) {
        this.example = example;
        this.example.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void setState (ExampleState state) {
        currentState = state;

    }

    public ExampleState getState() {
        return currentState;

    }

    public void update() {
        switch (currentState) {
            case IDLE:
                example.setPower(0);
                break;

            case INTAKE:
                example.setPower(1);
                break;

            case OUTTAKE:
                example.setPower(-1);
                break;

        }
    }
}
