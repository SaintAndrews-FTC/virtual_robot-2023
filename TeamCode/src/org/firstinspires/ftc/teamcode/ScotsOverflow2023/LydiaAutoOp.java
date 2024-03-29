package org.firstinspires.ftc.teamcode.ScotsOverflow2023;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.List;

@Autonomous(name = "LydiaOP")
public class LydiaAutoOp extends LinearOpMode {

    DcMotor back_left;
    DcMotor back_right;
    DcMotor front_left;
    DcMotor front_right;
    DcMotor lift;
    Servo hand;
    ColorSensor colorSensor;
    boolean zone1 = false;
    boolean zone2 = false;
    boolean zone3 = false;
    boolean drop = false;
    int side;
    int distance;
    int spin;
    int little;
    boolean timetogo = false;


    @Override
    public void runOpMode(){

        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        //   lift = hardwareMap.get(DcMotor.class, "lift");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();


        goForward(190);
        back_left.setPower(0);
        back_right.setPower(0);
        front_left.setPower(0);
        front_right.setPower(0);
        sleep(5000);

        if(colorSensor.green() > colorSensor.blue() && colorSensor.green()> colorSensor.red()){
            zone2 = true;
            telemetry.addData("zone 2",zone2);
            telemetry.update();
        }
        if(colorSensor.blue() > colorSensor.green() && colorSensor.blue()> colorSensor.red()){
            zone3 = true;
            telemetry.addData("zone 3",zone3);
            telemetry.update();
        }
        if(colorSensor.red() > colorSensor.green() && colorSensor.red()> colorSensor.blue()){
            zone1 = true;
            telemetry.addData("zone 1",zone1);
            telemetry.update();
        }

        goForward(-200);
        sleep(400);
        strafe2(310);
        sleep(400);
        goForward(550);
        sleep(400);
        if(zone2==true){
            strafe2(-330);
        }
        if(zone1==true){
            strafe2(-670);
            goForward(-10);
        }
        telemetry.addData("zone 1",zone1);
        telemetry.addData("zone 2",zone2);
        telemetry.addData("zone 3",zone3);
        telemetry.update();
        sleep(4000);




  /*
    goForward(190);
        back_left.setPower(0);
        back_right.setPower(0);
        front_left.setPower(0);
        front_right.setPower(0);
    sleep(5000);

     if(colorSensor.green() > colorSensor.blue() && colorSensor.green()> colorSensor.red()){
            zone2 = true;
              telemetry.addData("zone 2",zone2);
            telemetry.update();
        }
        if(colorSensor.blue() > colorSensor.green() && colorSensor.blue()> colorSensor.red()){
            zone3 = true;
              telemetry.addData("zone 3",zone3);
            telemetry.update();
        }
        if(colorSensor.red() > colorSensor.green() && colorSensor.red()> colorSensor.blue()){
            zone1 = true;
            telemetry.addData("zone 1",zone1);
            telemetry.update();
        }

    goForward(-200);
    sleep(400);
    strafe2(-298);
    sleep(400);
    goForward(550);
    sleep(400);
    if(zone3==true){
        strafe2(-10);
    }
    if(zone2==true){
        strafe2(330);
    }
    if(zone1==true){
        strafe2(660);
    }
    telemetry.addData("zone 1",zone1);
            telemetry.update();
            sleep(4000);












  /*


 goForward(175);
  back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
 if(colorSensor.green() > colorSensor.blue() && colorSensor.green()> colorSensor.red()){
            zone1 = true;
              telemetry.addData("COlor",zone1);
            telemetry.update();
        }
        if(colorSensor.blue() > colorSensor.green() && colorSensor.blue()> colorSensor.red()){
            zone2 = true;
              telemetry.addData("COlor",zone2);
            telemetry.update();
        }
        if(colorSensor.red() > colorSensor.green() && colorSensor.red()> colorSensor.blue()){
            zone3 = true;
            telemetry.addData("COlor",zone3);
            telemetry.update();
        }

       goForward(-150);
        back_left.setPower(0);
        back_right.setPower(0);
        front_left.setPower(0);
        front_right.setPower(0);
        strafe2(120);
        goForward(200);
         strafe2(-200);

        /*\ telemetry.addData("color",colorSensor.argb());
    telemetry.update();
    sleep(3000);
           back_left.setPower(0);
        back_right.setPower(0);
        front_left.setPower(0);
        front_right.setPower(0);
        goForward(200);
        strafe2(-150);
          back_left.setPower(0);
        back_right.setPower(0);
        front_left.setPower(0);
        front_right.setPower(0);
        goForward(320);
        */

 /*
  goForward(100);
 goForward(-100);
 strafe2(135);
 goForward(100);
  strafe2(-135);
  goForward(200);
  strafe2(-135);
  */








 /*if(colorSensor.green() > colorSensor.blue() && colorSensor.green()> colorSensor.red()){
            zone1 = true;
        }
        if(colorSensor.blue() > colorSensor.green() && colorSensor.blue()> colorSensor.red()){
            zone2 = true;
        }
        if(colorSensor.red() > colorSensor.green() && colorSensor.red()> colorSensor.blue()){
            zone3 = true;
        }
        */
        //   arm(30);
     /*
        goForward(50);
        if(colorSensor.green() > colorSensor.blue() && colorSensor.green()> colorSensor.red()){
            zone1 = true;
        }
        if(colorSensor.blue() > colorSensor.green() && colorSensor.blue()> colorSensor.red()){
            zone2 = true;
        }
        if(colorSensor.red() > colorSensor.green() && colorSensor.red()> colorSensor.blue()){
            zone3 = true;
        }
        strafe(10);
        goForward(5000);
        strafe(-10);
        arm(10);
        goForward(50);
        drop = true;
        if(zone1==true){
            strafe(10);
        }
        if(zone3==true){
            strafe(-10);
        }
*/

    }


    public void strafe2(int distanceToTravel){

        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int position = distanceToTravel;
        back_right.setTargetPosition(-position);
        back_left.setTargetPosition(position);
        front_left.setTargetPosition(-position);
        front_right.setTargetPosition(position);


        telemetry.addData("back right target", back_right.getTargetPosition());
        telemetry.update();


        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.update();

        back_right.setPower(-0.1);
        back_left.setPower(0.1);
        front_right.setPower(0.1);
        front_left.setPower(-0.1);

        while(back_right.isBusy()){
            back_left.setPower(0.1);
            front_right.setPower(0.1);
            front_left.setPower(-0.1);
        }


        telemetry.addData("back left current:", back_left.getCurrentPosition());
        telemetry.addData("back right current:", back_right.getCurrentPosition());
        telemetry.addData("front right current:", front_right.getCurrentPosition());
        telemetry.addData("front left current:", front_left.getCurrentPosition());
        telemetry.update();

    }
    public void pause(int value) {
        try {
            wait(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public void strafe(int distanceToTravel) {

        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int position = distanceToTravel;
        back_right.setTargetPosition(position);
        back_left.setTargetPosition(-position);
        front_left.setTargetPosition(position);
        front_right.setTargetPosition(-position);


        telemetry.addData("back right target", back_right.getTargetPosition());
        telemetry.update();


        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.update();

        back_right.setPower(0.25);
        back_left.setPower(-0.25);
        front_right.setPower(-0.25);
        front_left.setPower(0.25);

        while (back_right.isBusy()){
            front_right.setPower(0.25);
            back_left.setPower(0.25);
            front_left.setPower(0.25);
        }



        telemetry.addData("back left current:", back_left.getCurrentPosition());
        telemetry.addData("back right current:", back_right.getCurrentPosition());
        telemetry.addData("front right current:", front_right.getCurrentPosition());
        telemetry.addData("front left current:", front_left.getCurrentPosition());
        telemetry.update();

    }

    public void arm(int distanceToTravel){

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int position = distanceToTravel;
        lift.setTargetPosition(position);

        telemetry.addData("lift", lift.getTargetPosition());
        telemetry.update();

        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.update();

        lift.setPower(0.25);

        telemetry.addData("lift:", lift.getCurrentPosition());
        telemetry.update();

    }

    public void goForward(int distanceToTravel) {
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int position = distanceToTravel;
        back_right.setTargetPosition(position);
        back_left.setTargetPosition(position);
        front_left.setTargetPosition(position);
        front_right.setTargetPosition(position);


        telemetry.addData("back right target", back_right.getTargetPosition());
        telemetry.update();


        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.update();

        back_right.setPower(0.1);
        back_left.setPower(0.1);
        front_right.setPower(0.1);
        front_left.setPower(0.1);


        while (back_right.isBusy()){
            front_right.setPower(0.1);
            back_left.setPower(0.1);
            front_left.setPower(0.1);
        }

        telemetry.addData("back left current:", back_left.getCurrentPosition());
        telemetry.addData("back right current:", back_right.getCurrentPosition());
        telemetry.addData("front right current:", front_right.getCurrentPosition());
        telemetry.addData("front left current:", front_left.getCurrentPosition());
        telemetry.update();

    }


    public void rotate(int distanceToTravel) {
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        int position2 = distanceToTravel;
        back_left.setTargetPosition(position2);
        back_right.setTargetPosition(-position2);
        front_left.setTargetPosition(position2);
        front_right.setTargetPosition(-position2);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (Math.abs(back_left.getCurrentPosition()) < Math.abs(back_left.getTargetPosition())) {
            telemetry.addData("back left current:", back_left.getCurrentPosition());
            telemetry.addData("back right current:", back_right.getCurrentPosition());
            telemetry.addData("front right current:", front_right.getCurrentPosition());
            telemetry.addData("front left current:", front_left.getCurrentPosition());

            telemetry.update();
            back_left.setPower(0.5);
            back_right.setPower(-0.5);
            front_left.setPower(0.5);
            front_right.setPower(-0.5);
        }
    }

}

