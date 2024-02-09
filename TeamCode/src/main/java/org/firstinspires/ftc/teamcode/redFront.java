
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class redFront extends LinearOpMode {
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

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        clawGrabber.setPosition(1);
        Nothing(.3, 1000);
        StrafeRight(.3, 1200);
        Forward(.3, 1400);
        SpinRight(.3, 1200);
        Nothing(.3, 1000);
        wristDown(.3, 600);
        armUpStay(.9);
        Nothing(.3, 1000);
        wristUp(.3, 200);
        Forward(.2, 900);
        wristDown(.2, 750);
        Nothing(.3, 500);
        armUpStay(.7);
        clawGrabber.setPosition(0);
        Nothing(.3 ,200);
        Backward(.3, 800);
        StrafeRight(.3, 1500);
        wristUp(.3, 500);
        Forward(.3, 1000);


        //down to spinleft should be good, run through then test
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
    public void Forward(double power, int ticks) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (frontLeft.isBusy() && frontRight.isBusy()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
            telemetry.addData("frontLeft: ", frontLeft.getCurrentPosition() - frontLeft.getTargetPosition());
            telemetry.addData("frontRight: ", frontRight.getCurrentPosition() - frontRight.getTargetPosition());
            telemetry.addData("backLeft: ", backLeft.getCurrentPosition() - backLeft.getTargetPosition());
            telemetry.addData("backRight: ", backRight.getCurrentPosition() - backRight.getTargetPosition());
            telemetry.update();
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void Backward(double power, int ticks) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(-ticks);
        frontRight.setTargetPosition(-ticks);
        backLeft.setTargetPosition(-ticks);
        backRight.setTargetPosition(-ticks);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (frontLeft.isBusy() && frontRight.isBusy()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
            telemetry.addData("frontLeft: ", frontLeft.getCurrentPosition() - frontLeft.getTargetPosition());
            telemetry.addData("frontRight: ", frontRight.getCurrentPosition() - frontRight.getTargetPosition());
            telemetry.addData("backLeft: ", backLeft.getCurrentPosition() - backLeft.getTargetPosition());
            telemetry.addData("backRight: ", backRight.getCurrentPosition() - backRight.getTargetPosition());
            telemetry.update();
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }
    public void Nothing(double power, long time) { //editing codes
        frontLeft.setPower(power*0);
        backLeft.setPower(power*0);
        frontRight.setPower(power*0);
        backRight.setPower(power*0);
        sleep(time);

    }

    public void SpinLeft(double power, int ticks) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(-ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(-ticks);
        backRight.setTargetPosition(ticks);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (frontLeft.isBusy() && frontRight.isBusy()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
            telemetry.addData("frontLeft: ", frontLeft.getCurrentPosition() - frontLeft.getTargetPosition());
            telemetry.addData("frontRight: ", frontRight.getCurrentPosition() - frontRight.getTargetPosition());
            telemetry.addData("backLeft: ", backLeft.getCurrentPosition() - backLeft.getTargetPosition());
            telemetry.addData("backRight: ", backRight.getCurrentPosition() - backRight.getTargetPosition());
            telemetry.update();
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void SpinRight(double power, int ticks) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(-ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(-ticks);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (frontLeft.isBusy() && frontRight.isBusy()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
            telemetry.addData("frontLeft: ", frontLeft.getCurrentPosition() - frontLeft.getTargetPosition());
            telemetry.addData("frontRight: ", frontRight.getCurrentPosition() - frontRight.getTargetPosition());
            telemetry.addData("backLeft: ", backLeft.getCurrentPosition() - backLeft.getTargetPosition());
            telemetry.addData("backRight: ", backRight.getCurrentPosition() - backRight.getTargetPosition());
            telemetry.update();
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void StrafeLeft(double power, int ticks) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(-ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(-ticks);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (frontLeft.isBusy() && frontRight.isBusy()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void StrafeRight(double power, int ticks) {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(-ticks);
        backLeft.setTargetPosition(-ticks);
        backRight.setTargetPosition(ticks);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (frontLeft.isBusy() && frontRight.isBusy()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }
}

