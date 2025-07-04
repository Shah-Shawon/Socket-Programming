# 📧 Create a Google App Password for SMTP Email Sending

If you're trying to send emails via Gmail SMTP using your application (Java, Python, etc.), **you cannot use your normal Gmail password.** Instead, you need a special **App Password** provided by Google.

This guide explains how to create a 16-character App Password that can be used for SMTP authentication.

---

## 🔒 Why App Password?

Google blocks "less secure" apps from accessing your account directly. Instead of using your Gmail password in code (which is unsafe), you use an **App Password** that works only with that app.

---

## ✅ Steps to Create an App Password

### 🔹 Step 1: Enable 2-Step Verification

1. Visit: [https://myaccount.google.com/security](https://myaccount.google.com/security)
2. Scroll down to **"Signing in to Google"**
3. Click **2-Step Verification** and set it up (you'll need your phone)
4. Once enabled, you’ll return to the Security page

### 🔹 Step 2: Generate App Password

1. Go to: [https://myaccount.google.com/apppasswords](https://myaccount.google.com/apppasswords)
2. Sign in to your Google account (if asked)
3. Under **“Select the app”**, choose:
   - **Mail**
4. Under **“Select device”**, choose:
   - **Other (Custom name)** and enter something like `JavaSMTP`
5. Click **Generate**

### 🔹 Step 3: Copy the 16-Character App Password

- You will see a yellow box with a password like:
  ```
  abcd efgh ijkl mnop
  ```
- ⚠️ **Copy it immediately** — you will **not see it again**
- Use this password **instead of your Gmail password** in your app

### 🔹 Step 4: Use in Your Code

```java
String user = "your_email@gmail.com";
String pass = "abcdefghijklmnop";  // ✅ Use app password here (no spaces)
```

---

## ✅ SMTP Server Settings for Gmail

| Setting       | Value                    |
|---------------|--------------------------|
| SMTP Server   | `smtp.gmail.com`         |
| Port (SSL)    | `465`                    |
| Port (TLS)    | `587`                    |
| Username      | Your full Gmail address  |
| Password      | Your **App Password**    |

---

## ⚠️ Notes

- App passwords only work if **2FA is enabled**
- Do **not** share your app password
- App passwords can be revoked at any time

---

## 📚 References

- Google App Password Help:  
  [https://support.google.com/accounts/answer/185833](https://support.google.com/accounts/answer/185833)

- JavaMail API for sending emails (recommended for Java):  
  [https://eclipse-ee4j.github.io/mail/](https://eclipse-ee4j.github.io/mail/)
