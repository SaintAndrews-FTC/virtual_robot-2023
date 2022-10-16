package org.firstinspires.ftc.teamcode.ScotsOverflow2023;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "NorthAutoNew", group = "Competition")
public class NorthAutoNew extends OpMode {

    //-------------------CONTROL HUB OBJECTS-------------------//
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DcMotor carouselMotor;
    DcMotor elevatorMotor;
    DcMotor intakeMotor;
    Servo handServo;


    //-------------------OTHER VARIABLES-------------------//
    long ms = 0L;


    @Override
    public void init() {
        motorFrontLeft = hardwareMap.dcMotor.get("front_left");
        motorBackLeft = hardwareMap.dcMotor.get("back_left");
        motorFrontRight = hardwareMap.dcMotor.get("front_right");
        motorBackRight = hardwareMap.dcMotor.get("back_right");
        carouselMotor = hardwareMap.dcMotor.get("carousel");
        elevatorMotor = hardwareMap.dcMotor.get("elevator");
        intakeMotor = hardwareMap.dcMotor.get("intake");
        handServo = hardwareMap.servo.get("hand_servo");
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        long startTime = System.currentTimeMillis();
        ms = startTime;
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(-0.6);
            motorFrontRight.setPower(0.6);
            motorBackLeft.setPower(0.6);
            motorBackRight.setPower(-0.6);
            ms = System.currentTimeMillis();
        }
        startTime = System.currentTimeMillis();
        ms = startTime;
        while ((startTime - ms) < 10000L) {
            carouselMotor.setPower(0.7);
            ms = System.currentTimeMillis();
        }




    }
}
