#include <RF24Network.h>
#include <RF24.h>
#include <SPI.h>
#include <SoftwareSerial.h>
#include <TinyGPS.h>

RF24 radio(4, 5);                   // nRF24L01(+) radio attached using Getting Started board

RF24Network network(radio);          // Network uses that radio

SoftwareSerial gpsSerial(2, 3); //rx,tx
TinyGPS gps; // create gps object

const uint16_t this_node = 01;        // Address of our node in Octal format
const uint16_t other_node = 00;       // Address of the other node in Octal format

const unsigned long interval = 1000; //ms  // How often to send 'hello world to the other unit

unsigned long last_sent;             // When did we last send?
unsigned long packets_sent;          // How many have we sent already

float l,t;

struct payload_t {                  // Structure of our payload
  byte State;
  int pulse;
  float lat;
  float lon;
};

void setup(void)
{
  Serial.begin(9600);
  SPI.begin();
  radio.begin();
  network.begin(/*channel*/ 90, /*node address*/ this_node);
  network.update();                          // Check the network regularly
  gpsSerial.begin(9600); // connect gps sensor
int st=0;
  do{
  while (gpsSerial.available()) { // check for gps data
    if (gps.encode(gpsSerial.read())) // encode gps data
    {
      gps.f_get_position(&l, &t); // get latitude and longitude
      Serial.print(l);
      Serial.print(",");
      Serial.println(5);
      st=1;
    }
  }
  Serial.print("Sending...");
  bool ok;
  do {
    payload_t payload = { 1, 123, l, t};
    RF24NetworkHeader header(/*to node*/ other_node);
    ok = network.write(header, &payload, sizeof(payload));
    if (ok)
      Serial.println("ok.");
    else
      Serial.println("failed.");
  } while (ok == 0);
  }while(st==1);

  
}

void loop() {
  network.update();                          // Check the network regularly
  unsigned long now = millis();              // If it's time to send a message, send it!
  if ( now - last_sent >= interval  )
  {
    last_sent = now;
    Serial.print("Sending...");
    bool ok;
    do {
      payload_t payload = { 0, 50,l,t};
      RF24NetworkHeader header(/*to node*/ other_node);
      ok = network.write(header, &payload, sizeof(payload));
      if (ok)
        Serial.println("ok.");
      else
        Serial.println("failed.");
    } while (ok == 0);
  }




  while (gpsSerial.available()) { // check for gps data
    if (gps.encode(gpsSerial.read())) // encode gps data
    {
      gps.f_get_position(&l, &t); // get latitude and longitude
      Serial.print(l);
      Serial.print(",");
      Serial.println(5);
    }
  }
}



