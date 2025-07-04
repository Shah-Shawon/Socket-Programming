import java.io.*;                        // For input/output stream handling
import java.time.LocalDateTime;         // For timestamping the email
import javax.net.ssl.*;                 // For creating SSL socket (secure SMTP connection)
import java.util.Base64;                // For Base64 encoding username and password

class AzMail2 {

  private static DataOutputStream dos;  // Used to send data to SMTP server
  public static BufferedReader br;      // Used to read responses from SMTP server

  public static void main(String argv[]) throws Exception {

    // ✅ Your email credentials (should use Gmail or app password if using Gmail)
    String user = "xxx@ru.ac.bd";       // Replace with your full sender email
    String pass = "XYZ";                // Replace with your app password or real password (not recommended)

    // 🔒 Encode credentials in Base64 (required by SMTP AUTH LOGIN)
    String username = Base64.getEncoder().encodeToString(user.getBytes());
    String password = Base64.getEncoder().encodeToString(pass.getBytes());

    // 🌐 Create a secure SSL socket connection to Gmail's SMTP server (port 465)
    SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
    dos = new DataOutputStream(s.getOutputStream());              // Output stream to send commands
    br = new BufferedReader(new InputStreamReader(s.getInputStream())); // Input stream to read server replies

    // 🔔 Greet the SMTP server with EHLO command
    send("EHLO smtp.gmail.com\r\n");

    // 📥 Read multi-line response from server after EHLO
    for (int i = 0; i < 9; i++) {
      System.out.println("SERVER: " + br.readLine());
    }

    // 🔐 Start authentication process
    send("AUTH LOGIN\r\n");
    System.out.println("SERVER: " + br.readLine());

    // 🧑 Send encoded username
    send(username + "\r\n");
    System.out.println("SERVER: " + br.readLine());

    // 🔑 Send encoded password
    send(password + "\r\n");
    System.out.println("SERVER: " + br.readLine());

    // 📤 Specify sender's email address
    send("MAIL FROM:<xx@ru.ac.bd>\r\n"); // Change to your actual sender address
    System.out.println("SERVER: " + br.readLine());

    // 📩 Specify recipient's email address
    send("RCPT TO:<asifzaman3180@yahoo.com>\r\n"); // Change to your recipient's email
    System.out.println("SERVER: " + br.readLine());

    // 📝 Begin the email data input section
    send("DATA\r\n");
    System.out.println("SERVER: " + br.readLine());

    // ✍️ Write email headers and message body
    send("FROM: xx@ru.ac.bd\r\n");  // Change sender header
    send("TO: asifzaman3180@yahoo.com\r\n"); // Change recipient header
    send("Subject: Email test " + LocalDateTime.now() + "\r\n"); // Add subject with timestamp
    send("\r\n"); // Separate headers from body
    send("THIS IS A TEST EMAIL. THANK YOU\r\n"); // Email body

    // ⛔ End the DATA block with a single period
    send(".\r\n");
    System.out.println("SERVER: " + br.readLine());

    // ❌ End the SMTP session
    send("QUIT\r\n");
    System.out.println("SERVER: " + br.readLine());
  }

  // 📤 Helper function to send command to server with delay and print
  private static void send(String s) throws Exception {
    dos.writeBytes(s);        // Send the command
    Thread.sleep(1000);       // Wait for server response
    System.out.println("CLIENT: " + s.trim()); // Print the sent command
  }
}
