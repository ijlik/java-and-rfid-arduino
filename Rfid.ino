 
#include <EEPROM.h> // Memanggil Library EEPROM
#include <SPI.h> // Memanggil Library SPI 
#include <MFRC522.h> // Memanggil Library MFRC522

boolean match = false;
boolean programMode = false;
byte storedCard[4];
byte readCard[4];
byte masterCard[4] = {0x5c,0xbd,0xdf,0xd5}; // UID kartu yang diijinkan masuk : 5CBDDFD5

int buzz = 5; // Pin data untuk buzzer satunya nanti Ground
int l = 2; // Pin led biasa satunya nanti Ground

#define SS_PIN 10
#define RST_PIN 9
MFRC522 mfrc522(SS_PIN, RST_PIN);

void setup() {
  Serial.begin(9600); 
  SPI.begin();
  mfrc522.PCD_Init();
  Serial.println("===== KUNCI OTOMATIS BERBASIS RFID =====");
  Serial.println("");
  Serial.println("Silahkan SCAN KARTU ANDA !");
  Serial.println("");
  pinMode(buzz, OUTPUT);
  pinMode(l, OUTPUT);
  }

void loop () 
{
  int successRead;  
  do 
  {
    successRead = getID(); 
  }
  
  while (!successRead); 
  
  if (isMaster(readCard)) // Jika kartu yang di didekatkan ke pembaca adalah MasterCard (EC9FE97) Maka akan muncul :
  { 
    Serial.println("Anda diizinkan untuk masuk!");
    Serial.println("");
    Serial.println("===================================================");
    Serial.println("");
    digitalWrite(l, HIGH); // Led Nyala
    beep3(buzz); // Buzzer akan mengeluarkan bunyi beep
    delay(2500); // Setelah delay selama 2500ms (2,5 detik),
    digitalWrite(l, LOW); // Lampu LED akan berubah kembali menjadi berwarna biru, dan
  }
  
  else // Jika kartu yang didekatkan ke pembaca BUKAN MasterCard (EC9FE97) Maka akan muncul :
  {
    Serial.println("Anda DILARANG MASUK !!");
    Serial.println("");
    Serial.println("===================================================");
    Serial.println("");
    digitalWrite(l, LOW); // LED akan berubah menjadi berwarna merah,
    beep2(buzz); // Buzzer akan mengeluarkan bunyi beep panjang, setelah beep selesai,
    digitalWrite(l, LOW); // lampu LED akan kembali menjadi berwarna biru.
  }
}

int getID() 
{
  if ( ! mfrc522.PICC_IsNewCardPresent()) 
  { 
    return 0;
  }
  if ( ! mfrc522.PICC_ReadCardSerial()) 
  {
    return 0;
  }
  
  Serial.print("NOMOR ID ANDA ADALAH : ");
  for (byte i = 0; i < mfrc522.uid.size; i++) {  
    readCard[i] = mfrc522.uid.uidByte[i];
    Serial.print(readCard[i], HEX);
  }
  Serial.println("");
  Serial.println("");
  mfrc522.PICC_HaltA();
  return 1;
}

boolean checkTwo ( byte a[], byte b[] ) {
  if ( a[0] != 0 ){ 
    match = true; 
  }
  for ( int k = 0; k < 4; k++ ) { 
    if ( a[k] != b[k] )
      match = false;
  }
  if ( match ) { 
    return true; 
  }
  else  {
    return false; 
  }
}

boolean isMaster( byte test[] ) {
  if ( checkTwo( test, masterCard ) )
    return true;
  else
    return false;
}

void beep2(int x) // Program untuk beep panjang (jika kartu yang discan tidak sesuai)
{
  digitalWrite(x, HIGH);
  delay(500);
  digitalWrite(x, LOW);
  delay(200);
  digitalWrite(x, HIGH);
  delay(500);
  digitalWrite(x, LOW);
  delay(200);
  digitalWrite(x, HIGH);
  delay(500);
  digitalWrite(x, LOW);
  delay(200);
}

void beep3(int x) // Program untuk beep pendek (jika kartu yang di scan sesuai)
{
  digitalWrite(x, HIGH);
  delay(50);
  digitalWrite(x, LOW);
  delay(50);
  digitalWrite(x, HIGH);
  delay(50);
  digitalWrite(x, LOW);
  delay(50);
  digitalWrite(x, HIGH);
  delay(50);
  digitalWrite(x, LOW);
  delay(50);
  digitalWrite(x, HIGH);
  delay(50);
  digitalWrite(x, LOW);
  delay(50);
  digitalWrite(x, HIGH);
  delay(50);
  digitalWrite(x, LOW);
  delay(50);
}

