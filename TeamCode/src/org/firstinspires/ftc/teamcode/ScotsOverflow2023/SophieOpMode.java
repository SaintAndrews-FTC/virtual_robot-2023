package org.firstinspires.ftc.teamcode.ScotsOverflow2023;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Sophie's arm/claw code", group = "TeleOp")
public class SophieOpMode extends OpMode {
    DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, lift;
    Servo claw;
    boolean isClawOpen = true;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get("front_left_motor");
        backLeftMotor = hardwareMap.dcMotor.get("back_left_motor");
        frontRightMotor = hardwareMap.dcMotor.get("front_right_motor");
        backRightMotor = hardwareMap.dcMotor.get("back_right_motor");
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        lift = hardwareMap.dcMotor.get("lift");
        claw = hardwareMap.servo.get("Servo");
    }

    @Override
    public void loop() {
        lift.setPower(0);
        double leftTrigger = gamepad1.left_trigger;
        double rightTrigger = gamepad1.right_trigger;
        double lefty = -gamepad1.left_stick_y;
        double leftx = -gamepad1.left_stick_x;
        double rightx = gamepad1.right_stick_x;
        telemetry.addData("Joystick left y data: ",lefty);
        telemetry.addData("Joystick left x data:", leftx);
        telemetry.addData("Joystick right x data", rightx);
        telemetry.update();
        frontLeftMotor.setPower((lefty + leftx));
        frontRightMotor.setPower((lefty - leftx));
        backLeftMotor.setPower((lefty + leftx));
        backRightMotor.setPower((lefty - leftx));
        if (gamepad1.a){
            if (isClawOpen){
                claw.setPosition(-1);
            }else{
                claw.setPosition(1);
            }
            isClawOpen = !isClawOpen;
        }
        telemetry.addData("left trigger:", leftTrigger);
        telemetry.addData("right trigger:", rightTrigger);
        telemetry.update();

        if (leftTrigger>=0.2){
            lift.setPower(leftTrigger-0.1);
        }
        if (rightTrigger<=-0.2){
            lift.setPower(rightTrigger+0.1);
        }

    }
}
