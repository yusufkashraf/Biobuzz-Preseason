package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;

//state machines are life.
public class ExampleMechanismStateMachine {
    private DcMotorEx exampleMotor;

    public enum ExampleState {
        IDLE,
        SOMETHING1,
        SOMETHING2
    }

    private ExampleState currentState = ExampleState.IDLE;

    public ExampleMechanismStateMachine(DcMotorEx exampleMotor) {
        this.exampleMotor = exampleMotor;
        this.exampleMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
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
                exampleMotor.setPower(0);
                break;

            case SOMETHING1:
                exampleMotor.setPower(1);
                break;

            case SOMETHING2:
                exampleMotor.setPower(-1);
                break;

        }
    }
}
