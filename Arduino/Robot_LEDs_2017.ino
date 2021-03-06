#include <Adafruit_NeoPixel.h>

#define PIN_Shooter 6   //DIO 1
#define PIN_ShooterMount 7   //DIO 1
#define PIN_Intake 8 //DIO 2
#define PIN_Intake2 9   //DIO 2
//#define PIN_Hopper 10
#define LEDs_Shooter 23
#define LEDs_ShooterMount 19
#define LEDs_IntakeR 8
#define LEDs_IntakeL 6
//#define LEDs_Hopper 12


//pins used
//2 flash (DIO 3)
//3 breathe (DIO 4)
//4 shooter (DIO 1)
//5 intake (DIO 2)
//6 shooter LED output
//7 shootermount LED output
//8 intake LED output
//9 intake2 LED output
//10 hopper LED output?
//11 limit switch input?

// stripIntake2 will be Left

Adafruit_NeoPixel stripShooter = Adafruit_NeoPixel(LEDs_Shooter, PIN_Shooter, NEO_GRB + NEO_KHZ800);
Adafruit_NeoPixel stripShooterMount = Adafruit_NeoPixel(LEDs_ShooterMount, PIN_ShooterMount, NEO_GRB + NEO_KHZ800);
Adafruit_NeoPixel stripIntake = Adafruit_NeoPixel(LEDs_IntakeR, PIN_Intake, NEO_GRB + NEO_KHZ800);
Adafruit_NeoPixel stripIntake2 = Adafruit_NeoPixel(LEDs_IntakeL, PIN_Intake2, NEO_GRB + NEO_KHZ800);
//Adafruit_NeoPixel stripHopper = Adafruit_NeoPixel(LEDs_Hopper, PIN_Hopper, NEO_GRB + NEO_KHZ800);

void setup() {
  // put your setup code here, to run once:
  stripShooter.begin();
  for (int i = 0; i < LEDs_Shooter; i = i + 3) {
    stripShooter.setPixelColor(i, 0, 255, 0);
  }
  stripIntake.begin();
  stripIntake2.begin();
  for (int i = 0; i < LEDs_IntakeR; i = i + 3) {
    stripIntake.setPixelColor(i, 0, 255, 0);
  }
  for (int i = 0; i < LEDs_IntakeL; i = i + 3) {
    stripIntake2.setPixelColor(i, 0, 255, 0);
  }
  stripShooterMount.begin();
  for (int i = 0; i < LEDs_ShooterMount; i = i + 3) {
    stripShooterMount.setPixelColor(i, 0, 255, 0);
  }
  //stripHopper.begin();
  //for (int i = 0; i < LEDs_Hopper; i++) {
  //stripHopper.setPixelColor(i, 0, 150, 0);
  //}
  stripShooter.show();
  stripShooterMount.show();
  stripIntake.show();
  stripIntake2.show();
  //stripHopper.show();

}

void loop() {
  // put your main code here, to run repeatedly:
  boolean resetNeeded;
  boolean resetHopper;
  resetNeeded = false;
  resetHopper = false;
  while (digitalRead(4) == HIGH) {   //when shooter is active (from DIO 1)
    for (int q = 0; q < 3; q++) {
      for (int i = 0; i < LEDs_Shooter; i = i + 3) {
        stripShooter.setPixelColor(i + (-(q - 2)), 0, 255, 0); //turn every third pixel on
      }
      for (int i = 0; i < LEDs_ShooterMount; i = i + 3) {
        stripShooterMount.setPixelColor(i + q, 0, 255, 0);
      }
      stripShooter.show();
      stripShooterMount.show();

      delay(250);

      for (int i = 0; i < LEDs_Shooter; i = i + 3) {
        stripShooter.setPixelColor(i + (-(q - 2)), 0);    //turn every third pixel off
      }
      for (int i = 0; i < LEDs_ShooterMount; i = i + 3) {
        stripShooterMount.setPixelColor(i + q, 0);
      }
    }
  }

  while (digitalRead(5) == HIGH) {   //while intake is active (DIO 2)
    for (int q = 3; q > 0; q--) {
      for (int i = 0; i < LEDs_IntakeR; i = i + 3) {
        stripIntake.setPixelColor(i + (-(q - 2)), 0, 255, 0);  //turn every third pixel on
      }
      for (int i = 0; i < LEDs_IntakeL; i = i + 3) {
        stripIntake2.setPixelColor(i + (-(q - 2)), 0, 255, 0);  //turn every third pixel on
      }
      stripIntake.show();
      stripIntake2.show();

      delay(250);

      for (int i = 0; i < LEDs_IntakeR; i = i + 3) {
        stripIntake.setPixelColor(i + (-(q - 2)), 0);      //turn every third pixel off
      }
      for (int i = 0; i < LEDs_IntakeL; i = i + 3) {
        stripIntake2.setPixelColor(i + (-(q - 2)), 0);      //turn every third pixel off
      }
    }
  }
  while (digitalRead(2) == HIGH) {   //random flashing lights (DIO 3)
    resetNeeded = true;
    long aa;
    int aaa;
    long bb;
    int bbb;
    long cc;
    int ccc;
    long dd;
    int ddd;
    for (int a = 0; a < LEDs_IntakeR; a++) {   //set to black
      stripIntake.setPixelColor(a, 0);
    }
    for (int a = 0; a < LEDs_IntakeL; a++) {   //set to black
      stripIntake2.setPixelColor(a, 0);
    }
    for (int b = 0; b < LEDs_Shooter; b++) {   //set to black
      stripShooter.setPixelColor(b, 0);
    }
    for (int c = 0; c < LEDs_ShooterMount; c++) {   //set to black
      stripShooterMount.setPixelColor(c, 0);
    }
    //for (int d = 0; d < LEDs_Hopper; d++) {   //set to black
    //stripHopper.setPixelColor(d, 0);
    //}

    for (int a = 0; a < 4; a++) {   //set random pixels to color
      aa = random(0, 7);
      aaa = (int) aa;
      stripIntake.setPixelColor(aaa, 0, 255, 0);
    }
    for (int a = 0; a < 3; a++) {   //set random pixels to color
      aa = random(0, 5);
      aaa = (int) aa;
      stripIntake2.setPixelColor(aaa, 0, 255, 0);
    }
    for (int b = 0; b < 13; b++) {   //set random pixels to color
      bb = random(0, 22);
      bbb = (int) bb;
      stripShooterMount.setPixelColor(bbb, 0, 255, 0);
    }
    for (int c = 0; c < 10; c++) {   //set random pixels to color
      cc = random(0, 18);
      ccc = (int) cc;
      stripShooter.setPixelColor(ccc, 0, 255, 0);
    }
    //*for (int d = 0; d < ; d++) {   //set random pixels to color
    //*dd = random(0, );
    //ddd = (int) dd;
    //stripHopper.setPixelColor(ddd, 0, 255, 0);
    //}
    stripIntake.show();
    stripIntake2.show();
    stripShooterMount.show();
    stripShooter.show();
    //stripHopper.show();
    delay(125);
  }
  while (digitalRead(3) == HIGH) {  //breath-like (DIO 4)
    resetNeeded = true;
    for (int e = 255; e > 150; e--) {   //lower intensity
      for (int a = 0; a < LEDs_Shooter; a++) {
        stripShooter.setPixelColor(a, 0, e, 0);
      }
      for (int b = 0; b < LEDs_IntakeR; b++) {
        stripIntake.setPixelColor(b, 0, e, 0);
      }
      for (int b = 0; b < LEDs_IntakeL; b++) {
        stripIntake2.setPixelColor(b, 0, e, 0);
      }
      for (int c = 0; c < LEDs_ShooterMount; c++) {
        stripShooterMount.setPixelColor(c, 0, e, 0);
      }
      //for (int d = 0; d < LEDs_Hopper; d++) {
      //stripHopper.setPixelColor(d, 0, e, 0);
      //}
      stripShooter.show();
      stripIntake.show();
      stripIntake2.show();
      stripShooterMount.show();
      //stripHopper.show();
    }
    for (int e = 150; e < 256; e++) {   //increase intensity
      for (int a = 0; a < LEDs_Shooter; a++) {
        stripShooter.setPixelColor(a, 0, e, 0);
      }
      for (int b = 0; b < LEDs_IntakeR; b++) {
        stripIntake.setPixelColor(b, 0, e, 0);
      }
      for (int b = 0; b < LEDs_IntakeL; b++) {
        stripIntake2.setPixelColor(b, 0, e, 0);
      }
      for (int c = 0; c < LEDs_ShooterMount; c++) {
        stripShooterMount.setPixelColor(c, 0, e, 0);
      }
      //for (int d = 0; d < LEDs_Hopper; d++) {
      //stripHopper.setPixelColor(d, 0, e, 0);
      //}
      stripShooter.show();
      stripIntake.show();
      stripIntake2.show();
      stripShooterMount.show();
      //stripHopper.show();
    }
  }
  //while (digitalRead(11) == HIGH) {  //Hopper LED flash
  //for (int i; i < LEDs_Hopper; i++) {
  //stripHopper.setPixelColor(i, 0, 255, 0);
  //}
  //stripHopper.show();
  //resetHopper = true;
  //}
  //if (resetHopper) {
  //for (int i; i < LEDs_Hopper; i++) {
  //stripHopper.setPixelColor(i, 0, 150, 0);
  //}
  //stripHopper.show();
  //resetHopper = false;
  //}
  if (resetNeeded) {
    for (int a = 0; a < LEDs_Shooter; a++) {
      stripShooter.setPixelColor(a, 0);
    }
    for (int a = 0; a < LEDs_Shooter; a = a + 3) {
      stripShooter.setPixelColor(a, 0, 255, 0);
    }
    for (int b = 0; b < LEDs_IntakeR; b++) {
      stripIntake.setPixelColor(b, 0);
    }
    for (int b = 0; b < LEDs_IntakeL; b++) {
      stripIntake2.setPixelColor(b, 0);
    }
    for (int b = 0; b < LEDs_IntakeR; b = b + 3) {
      stripIntake.setPixelColor(b, 0, 255, 0);
    }
    for (int b = 0; b < LEDs_IntakeL; b = b + 3) {
      stripIntake2.setPixelColor(b, 0, 255, 0);
    }
    for (int c = 0; c < LEDs_ShooterMount; c++) {
      stripShooterMount.setPixelColor(c, 0);
    }
    for (int c = 0; c < LEDs_ShooterMount; c = c + 3) {
      stripShooterMount.setPixelColor(c, 0, 255, 0);
    }
    //for (int d = 0; d < LEDs_Hopper; d++) {
    //stripHopper.setPixelColor(d, 0);
    //}
    //for (int d = 0; d < LEDs_Hopper; d = d + 3) {
    //stripHopper.setPixelColor(d, 0, 255, 0);
    //}
    stripShooter.show();
    stripIntake.show();
    stripIntake2.show();
    stripShooterMount.show();
    //stripHopper.show();
    resetNeeded = false;
  }
}
