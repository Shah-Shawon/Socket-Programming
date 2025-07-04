
📧 Create a Google App Password for SMTP Email Sending
If you're trying to send emails via Gmail SMTP using your application (Java, Python, etc.), you cannot use your normal Gmail password. Instead, you need a special App Password provided by Google.

This guide explains how to create a 16-character App Password that can be used for SMTP authentication.

🔒 Why App Password?
Google blocks "less secure" apps from accessing your account directly. Instead of using your Gmail password in code (which is unsafe), you use an App Password that works only with that app.

✅ Steps to Create an App Password
🔹 Step 1: Enable 2-Step Verification
Visit: https://myaccount.google.com/security

Scroll down to "Signing in to Google"

Click 2-Step Verification and set it up (you'll need your phone)

Once enabled, you’ll return to the Security page

🔹 Step 2: Generate App Password
Go to: https://myaccount.google.com/apppasswords

Sign in to your Google account (if asked)

Under “Select the app”, choose:

Mail

Under “Select device”, choose:

Other (Custom name) and enter something like JavaSMTP

Click Generate

🔹 Step 3: Copy the 16-Character App Password
You will see a yellow box with a password like:

nginx
Copy
Edit
abcd efgh ijkl mnop
⚠️ Copy it immediately — you will not see it again

Use this password instead of your Gmail password in your app

🔹 Step 4: Use in Your Code
java
Copy
Edit
String user = "your_email@gmail.com";
String pass = "abcdefghijklmnop";  // ✅ Use app password here (no spaces)
✅ SMTP Server Settings for Gmail
Setting	Value
SMTP Server	smtp.gmail.com
Port (SSL)	465
Port (TLS)	587
Username	Your full Gmail address
Password	Your App Password

⚠️ Notes
App passwords only work if 2FA is enabled

Do not share your app password

App passwords can be revoked at any time

📚 References
Google App Password Help:
https://support.google.com/accounts/answer/185833

JavaMail API for sending emails (recommended for Java):
https://eclipse-ee4j.github.io/mail/
