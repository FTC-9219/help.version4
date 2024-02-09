
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
    public class blueBack extends LinearOpMode {
        public DcMotor frontLeft;
        public DcMotor backLeft;
        public DcMotor frontRight;
        public DcMotor backRight;
        public Servo clawGrabber;
        public DcMotor clawWrist;
        public DcMotor clawArmRight;
        public DcMotor clawArmLeft;

        @Override
        public void runOpMode() {
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight ");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            clawGrabber = hardwareMap.get(Servo.class, "clawGrabber");
            clawWrist = hardwareMap.get(DcMotor.class, "clawWrist");
            clawArmRight = hardwareMap.get(DcMotor.class, "clawArmRight");
            clawArmLeft = hardwareMap.get(DcMotor.class, "clawArmLeft");


            waitForStart();
            clawGrabber.setPosition(1);
            Nothing(1,1000);
            Forward(.7, 1200);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            StrafeLeft(.8, 2500);
            Backward(.5, 500);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            SpinLeft(.25, 200);
            wristDown(.5, 1000);
            armUpStay(1);
            wristUp(1, 2000);
            Forward(.3, 500);
            clawGrabber.setPosition(0);
            Backward(.8, 1000);
            StrafeRight(.8, 1000);
            Forward(.5, 2000);
        }
        public void armUpStay(double power){
        clawArmRight.setPower(power * 1);
        clawArmRight.setPower(power * 1);
        }
        public void clawGrabberOpen(double position, long time){
            clawGrabber.setPosition(position * 1);
            sleep(time);
        }
        public void clawGrabberClose(double position, long time){
        clawGrabber.setPosition(position * 1);
        sleep(time);
        }
        public void armUp(double power, long time){
           clawArmRight.setPower(power * 1);
           clawArmRight.setPower(power * 1);
           sleep(time);
        }
        public void armDown(double power, long time){
        clawArmRight.setPower(power * -1);
        clawArmRight.setPower(power * -1);
        sleep(time);
        }
        public void wristUp(double power, long time){
        clawWrist.setPower(power * 1);
        sleep(time);
        }
        public void wristDown(double power, long time){
        clawWrist.setPower(power * -1);
        sleep(time);
        }
        public void Forward(double power, long time) {
            frontLeft.setPower(power * -1);
            backLeft.setPower(power * -1);
            frontRight.setPower(power);
            backRight.setPower(power * -1);
            sleep(time);
        }

        public void Backward(double power, long time) {
            frontLeft.setPower(power);
            backLeft.setPower(power);
            frontRight.setPower(power*-1);
            backRight.setPower(power);
            sleep(time);
        }
        public void Nothing(double power, long time) { //editing codes
            frontLeft.setPower(power*0);
            backLeft.setPower(power*0);
            frontRight.setPower(power*0);
            backRight.setPower(power*0);
            sleep(time);

        }

        public void StrafeLeft(double power, long time) {
            frontRight.setPower(power);
            backLeft.setPower(power*-1);
            frontLeft.setPower(power);
            backRight.setPower(power);
            sleep(time);
        }

        public void StrafeRight(double power, long time) {
            frontLeft.setPower(power*-1);
            backLeft.setPower(power);
            frontRight.setPower(power * -1);
            backRight.setPower(power*-1);
            sleep(time);
        }

        public void SpinLeft(double power, long time) {
            frontLeft.setPower(power);
            backLeft.setPower(power);
            frontRight.setPower(power);
            backRight.setPower(power*-1);
            sleep(time);
        }

        public void SpinRight(double power, long time) {
            frontLeft.setPower(power*-1);
            backLeft.setPower(power*-1);
            frontRight.setPower(power * -1);
            backRight.setPower(power);
            sleep(time);
        }
    }

