package org.firstinspires.ftc.teamcode.ScotsOverflow2023;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "NorthAuto2023", group = "Competition")
public class NorthAuto2023NewVers extends OpMode {

    //-------------------CONTROL HUB OBJECTS-------------------//
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DcMotor elevatorMotor;
    DcMotor intakeMotor;
    //Servo handServo;


    //-------------------OTHER VARIABLES-------------------//
    long ms = 0L;


    @Override
    public void init() {
        motorFrontLeft = hardwareMap.dcMotor.get("front_left");
        motorBackLeft = hardwareMap.dcMotor.get("back_left");
        motorFrontRight = hardwareMap.dcMotor.get("front_right");
        motorBackRight = hardwareMap.dcMotor.get("back_right");
        elevatorMotor = hardwareMap.dcMotor.get("elevator");
        intakeMotor = hardwareMap.dcMotor.get("intake");
        //handServo = hardwareMap.servo.get("hand_servo");
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        /*
        To Do:
        1. Have robot be built
        2. Find out which way the servoes are set
        3. input

        PLANS:
        1. Identify image and set the position it's going to true
        2. Strafe to the side where the area is clear
        3. Go forward to the tallest cone
        4. Make a 90 degree turn
        5. Place the cone on top
        6. Go the final position
         */

        //I'm not really sure how to do the image stuff, I think Lydia wants to work on that, so this is just
        //going from the position.
        long startTime = System.currentTimeMillis();
        ms = startTime;
        //To do: find out proper length of time
        //Also to do: find out the proper values
        //Bc w/o the actual robot yet and how the motors are set up, I'm not gonna really know lol
        //Forward for some amount of time
        //Wait, wouldn't it be ms-startTime? Since startTime is the smaller one?
        while ((ms - startTime) < 300L) {
            motorFrontLeft.setPower(0.6);
            motorFrontRight.setPower(0.6);
            motorBackLeft.setPower(0.6);
            motorBackRight.setPower(0.6);
            ms = System.currentTimeMillis();
        }
        ms = System.currentTimeMillis();
        //90 degree turn (find out correct timing)
        while ((ms - startTime) < 600L) {
            motorFrontLeft.setPower(0.6);
            motorFrontRight.setPower(-0.6);
            motorBackLeft.setPower(0.6);
            motorBackRight.setPower(-0.6);
            ms = System.currentTimeMillis();
        }
        /*
        //This all may be backwards depending on how the motors are set up.
        //I think last time they were set up backwards so all of this may be backwards
        //Like right is left and left is right, etc
        //I think forwards/backwards is fine? Or it may be backward is motors are backwards again :/
        //Right strafe (backwards?)
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(-0.6);
            motorFrontRight.setPower(0.6);
            motorBackLeft.setPower(0.6);
            motorBackRight.setPower(-0.6);
            ms = System.currentTimeMillis();
        }
        //Left strafe (backwards?)
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(0.6);
            motorFrontRight.setPower(-0.6);
            motorBackLeft.setPower(-0.6);
            motorBackRight.setPower(0.6);
            ms = System.currentTimeMillis();
        }
        //Forward (motors are not backwards)
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(0.6);
            motorFrontRight.setPower(0.6);
            motorBackLeft.setPower(0.6);
            motorBackRight.setPower(0.6);
            ms = System.currentTimeMillis();
        }
        //Backward (motors are not backwards)
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(-0.6);
            motorFrontRight.setPower(-0.6);
            motorBackLeft.setPower(-0.6);
            motorBackRight.setPower(-0.6);
            ms = System.currentTimeMillis();
        }
        //Turn left (Not backwards)
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(0.6);
            motorFrontRight.setPower(-0.6);
            motorBackLeft.setPower(0.6);
            motorBackRight.setPower(-0.6);
            ms = System.currentTimeMillis();
        }
        //Turn right (Not backwards)
        while ((startTime - ms) < 300L) {
            motorFrontLeft.setPower(-0.6);
            motorFrontRight.setPower(0.6);
            motorBackLeft.setPower(-0.6);
            motorBackRight.setPower(0.6);
            ms = System.currentTimeMillis();
        }
         */




    }
}
