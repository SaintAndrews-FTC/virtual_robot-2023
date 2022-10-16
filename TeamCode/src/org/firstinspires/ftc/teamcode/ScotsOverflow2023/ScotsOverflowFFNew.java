//ALL OF THIS IS OUTDATED, MUCH BETTER ONE ONLINE.

package org.firstinspires.ftc.teamcode.ScotsOverflow2023;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ScotsOverflowFF", group = "Competition")
public class ScotsOverflowFFNew extends OpMode {

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
    int levelAt = 0;
    int spinDirection=0;


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
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double y = gamepad1.left_stick_y; // For some reason, it's like... anti-reversed. This is the only one the isn't reversed.
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;
        double la = -gamepad1.left_trigger;
        double ra = gamepad1.right_trigger;
        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio, but only when
        // at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        //Elevator up/down stuff
        double elevatorPower = la + ra;

        //Strafing
        if (java.lang.Math.abs(x)>0.06 && java.lang.Math.abs(y)<0.15 && java.lang.Math.abs(x)>java.lang.Math.abs(x)) { //revisit drift, if not set to 0.2
            motorFrontLeft.setPower(x);
            motorFrontRight.setPower(-x);
            motorBackLeft.setPower(-x);
            motorBackRight.setPower(x);
            elevatorMotor.setPower(elevatorPower);
        }
        else {
            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);
            elevatorMotor.setPower(elevatorPower);
        }


        //Grab
        //Close
        if (gamepad1.left_bumper) {
            handServo.setPosition(0);
        }
        //Open
        if (gamepad1.right_bumper) {
            handServo.setPosition(1);
        }

        /*
            //Grab
            //Close
            if (gamepad1.a && handServo.getPosition()==0 && ((System.currentTimeMillis() - ms) > 300L)) {
                handServo.setPosition(1);
                ms = System.currentTimeMillis();
                //System.out.println("00000");
            }
            //Open
            if (gamepad1.a && handServo.getPosition()==1 && ((System.currentTimeMillis() - ms) > 300L) ) {
                handServo.setPosition(0);
                ms = System.currentTimeMillis();
                //System.out.println(System.currentTimeMillis() - ms);
            }
         */



        //Taunt button
        if (gamepad1.a) {
            for(int i=0; i<5; i++) {
                if(levelAt<3) {
                    setLevel(3, elevatorMotor);
                    motorFrontLeft.setPower(-0.2);
                    motorFrontRight.setPower(0.2);
                    motorBackLeft.setPower(-0.2);
                    motorBackRight.setPower(0.2);
                }
                else if(levelAt==3) {
                    setLevel(0,elevatorMotor);
                    motorFrontLeft.setPower(0.2);
                    motorFrontRight.setPower(-0.2);
                    motorBackLeft.setPower(0.2);
                    motorBackRight.setPower(-0.2);
                }
            }
        }



        //Elevator set 0
        if (gamepad1.dpad_down) {
            setLevel(0, elevatorMotor);
        }
        //Elevator set 1
        if (gamepad1.dpad_down) {
            setLevel(1, elevatorMotor);
        }
        //Elevator set 2
        if (gamepad1.dpad_down) {
            setLevel(2, elevatorMotor);
        }
        //Elevator set 3
        if (gamepad1.dpad_down) {
            setLevel(3, elevatorMotor);
        }




        //Suck
        //Greater than or equal to 0 bc what if you want to change it immediately from
        //expelling to intaking or something like that.
        if (gamepad1.x && intakeMotor.getPower()>=0 && ((System.currentTimeMillis() - ms) > 300L)) {
            intakeMotor.setPower(-0.7);
            //Prob change to like setPower or smth later instead later. Remember handServo.getPos==0 say
            //getpower==0. Then set the handServo.setPower(-0.7). BACKWARDS BC SUCK
            ms = System.currentTimeMillis();
            //System.out.println("00000");
        }
        //Stop suck
        //Less than 0 bc it's gonna be negative
        if (gamepad1.x && intakeMotor.getPower()<0 && ((System.currentTimeMillis() - ms) > 300L) ) {
            intakeMotor.setPower(0);
            ms = System.currentTimeMillis();
            //System.out.println(System.currentTimeMillis() - ms);
        }
        //Expel
        //Basically the same. Less than or equal to 0 bc what if intake to expel instantly.
        //If it starts freaking out later just set it back to 0
        if (gamepad1.b && intakeMotor.getPower()<=0 && ((System.currentTimeMillis() - ms) > 300L)) {
            intakeMotor.setPower(0.7);
            ms = System.currentTimeMillis();
            //Prob change to like setPower or smth later instead later. Remember handServo.getPos==0 say
            //getpower==0. Then set the handServo.setPower(0.7).
            //set diff var for ms or maybe not just test it
            //System.out.println("00000");
        }
        //Stop expel
        //Greater than 0 because the power will be positive when you want it to stop being positive
        if (gamepad1.b && intakeMotor.getPower()>0 && ((System.currentTimeMillis() - ms) > 300L) ) {
            intakeMotor.setPower(0);
            ms = System.currentTimeMillis();
            //System.out.println(System.currentTimeMillis() - ms);
        }

        //carousel motor
        //why is carousel spelt like that. weird
        //Go
        if (gamepad1.y && carouselMotor.getPower()<=0 && ((System.currentTimeMillis() - ms) > 300L)) {
            carouselMotor.setPower(0.7);
            ms = System.currentTimeMillis();
            //System.out.println("00000");
        }
        if (gamepad1.y && carouselMotor.getPower()>0 && ((System.currentTimeMillis() - ms) > 300L)) {
            carouselMotor.setPower(0);
            ms = System.currentTimeMillis();
            //System.out.println(System.currentTimeMillis() - ms);
        }
        //Backwards
        if (gamepad1.a && carouselMotor.getPower()>=0 && ((System.currentTimeMillis() - ms) > 300L)) {
            carouselMotor.setPower(-0.7);
            ms = System.currentTimeMillis();
            //System.out.println(System.currentTimeMillis() - ms);
        }
        //Stop
        if (gamepad1.a && carouselMotor.getPower()<0 && ((System.currentTimeMillis() - ms) > 300L)) {
            carouselMotor.setPower(0);
            ms = System.currentTimeMillis();
            //System.out.println(System.currentTimeMillis() - ms);
        }



            /*
            telemetry.addData("Color","Red: %d ", colorSensor.red());
            telemetry.addData("Color","Green: %d ", colorSensor.green());
            telemetry.addData("Color","Blue: %d", colorSensor.blue());


            Orientation orientation = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS);
            */


        //Basically the degrees
        /* So it's like this. If it starts facing forward then that's where 0 will be.
         * Kinda like an evil, confusing unit circle from geometry
         *              0
         *          90     -90
         *             ±180
         * So once it becomes 180 and goes past 180 it becomes -180 then goes back to 90
         * Also I have nowhere else to say this but they got rid of the turret bot in the virtual robot
         * I never got to test it and I am so sad
         * To do: Add a speaker so we can swear at other teams if they mess up or like get in our way.
         * To do: Add self-destruct mode so if we don't win we explode everyone else's robots.
         * If we lose, everyone loses.
         * At future people who somehow find my code: If I never got to add my self-destruct mode,
         * avenge me by adding it now!
         * */



            /*
            telemetry.addData("Heading", " %.1f", orientation.firstAngle * 180.0 / Math.PI);

            //The encoders are basically the amount of distance the motors have turned. Very helpful for distance and stuff.
            //After 1200 ticks it has made one full rotation

            telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
            telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
            telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
            telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
            */

        telemetry.addData("Encoder","Back Left Motor: %d", motorBackLeft.getCurrentPosition());
        telemetry.addData("Encoder","Front Left Motor: %d", motorFrontLeft.getCurrentPosition());
        telemetry.addData("Encoder","Front Right Motor: %d", motorFrontRight.getCurrentPosition());
        telemetry.addData("Encoder","Back Right Motor: %d", motorBackRight.getCurrentPosition());
        telemetry.update();
    }

    public void setLevel(int level, DcMotor spinner) {
//        Height lvl 0: 0 inches= 0 cm = 0 revolutions
//        Height lvl 1: 2.5 inches= 6.35 cm = 6.35 cm*1 revolution/19.25 cm= 0.3298701299 revolutions
//        Height lvl 2: 11 inches= 27.94 cm= 27.94 cm*1 revolutions/19.25 cm= 1.4514285714 revolutions
//        Height lvl 3: 20 inches= 50.8 cm= 50.8 cm*1 revolutions/19.25 cm= 2.638961039 revolutions
        double[] lvl = {0,0.3298701299,1.4514285714,2.638961039};
        double numToGo = lvl[level] - lvl[levelAt];
        numToGo *= spinner.getMotorType().getTicksPerRev();
        int start = spinner.getCurrentPosition();
        if (numToGo < 0) {
            while (spinner.getCurrentPosition()-start > numToGo) {
                spinner.setPower(-0.5);
            }
            return;
        }
        while (spinner.getCurrentPosition()-start < numToGo) {
            spinner.setPower(0.5);
        }
    }
}
