package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Device;

import view.V_Device;

public class DeviceController implements SerialPortEventListener {

    private V_Device theView;
    private Device theModel;
    private String Card;

    public DeviceController(V_Device View, Device Model) throws SQLException {
        this.theView = View;
        this.theModel = Model;
        this.StartingService();
        this.theView.setVisible(true);
        this.theView.addLoginListener(new LoginListener());
        if (theModel.cekJadwal(Tanggal())) {
            this.theView.setJadwal("--:--");
        } else {
            this.theView.setJadwal(theModel.getJadwal(Tanggal()));
        }
        while (true) {
            theView.setCardId(theModel.getCardId());
            theView.setName(theModel.getName());
            theView.setNumId(theModel.getNumId());
            theView.setJabatan(theModel.getJabatan());
            theView.setStatus(theModel.getStatus());
            //theView.setFoto(theModel.getName());
            theView.setJamAbsen(theModel.getJamAbsen());
            this.theView.setTanggal(Tanggal());
            this.theView.setJam(Jam());
        }
    }

    SerialPort serialPort;
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };

    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;

    public void StartingService() {
        this.initialize();
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException ie) {
                }
            }
        };
        t.start();
        System.out.println("Started");
    }

    public void initialize() {
        System.setProperty("gnu.io.rxtx.SerialPorts", "COM3");
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }

        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        String jam[] = Jam().split(" ");
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();

                if (theModel.cekAbsen(inputLine, Tanggal()) && theModel.cekPengguna(inputLine)) {
                    JOptionPane.showMessageDialog(theView, "Anda sudah absen Hari ini");
                    System.out.println(inputLine + " " + Tanggal() + " " + jam[0] + "Gagal Sudah absen");
                } else if (!theModel.cekPengguna(inputLine) && !inputLine.equals("Unknown")) {
                    theModel.setName("error");
                    theModel.setCardId(inputLine);
                    theModel.setNumId("-");
                    theModel.setJabatan("-");
                    theModel.setJamAbsen("-");
                    theModel.setStatus("-");
                    JOptionPane.showMessageDialog(theView, "Anda tidak terdaftar silahkan hubungi petugas");
                    System.out.println(inputLine + " " + Tanggal() + " " + jam[0] + "Gagal Tidak terdaftar");
                } else {
                    if (theModel.cekJadwal(Tanggal())) {
                        //JOptionPane.showMessageDialog(theView, "Tidak ada jadwal untuk hari ini \n Tanggal : " + Tanggal());
                        theModel.setCardId(inputLine);
                        theModel.setNumId("-");
                        theModel.setJabatan("-");
                        theModel.setJamAbsen("-");
                        theModel.setStatus("-");
                        System.out.println(inputLine + " " + Tanggal() + " " + jam[0] + "Gagal jadwal kosong");
                    } else {
                        System.out.println(inputLine + " " + Tanggal() + " " + jam[0] + "Sukses");
                        theModel.isiData(inputLine, Tanggal(), jam[0]);
                    }
                }

            } catch (Exception e) {
                System.err.println("Loading . . . . [ ok ]");
                System.out.println("Standby");
            }
        }
    }

    private String Tanggal() {
        Date now = new Date();
        String[] parts = (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a")).format(now).split(" ", 2);
        String[] tgl = parts[0].split("/");
        String tanggal = tgl[2] + "-" + tgl[1] + "-" + tgl[0];
        return tanggal;
    }

    private String Jam() {
        Date now = new Date();
        String[] parts = (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a")).format(now).split(" ", 2);
        return parts[1];
    }

    class LoginListener implements MouseListener {

        public LoginListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                main.Main Move = new main.Main();
                Move.Login();
                theView.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DeviceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
