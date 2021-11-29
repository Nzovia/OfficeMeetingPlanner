package com.nicholas.officemanager.services;

import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.UsersRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.rmi.ServerException;

@Service
@Transactional
public class UserService {
    @Autowired
    private UsersRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;

    public void register(Users users, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(users.getEmpPassword());
        users.setEmpPassword(encodedPassword);

        String randomCode = RandomString.make(64);
        users.setVerificationCode(randomCode);
        users.setEnabled(false);
        repo.save(users);
        sendVerificationEmail(users, siteURL);

    }
    public void sendVerificationEmail(Users users, String siteURL) throws  MessagingException, UnsupportedEncodingException{
        String toAddress = users.getEmployee_email();
        String fromAddress = "nickiemaundu19@gmail.com";
        String senderName = "Seasoned Developer";
        String subject = "Please Verify your registration";
        String content = "Dear [[name]], <br>"
                +"please click the link below to verify your registration: <br>"
                +"<h3><a href=\"[[URL]]\" target=\"_self\"> VERIFY </a></h3>"
                +"Thank you, <br>"
                +"Seasoned Developer.";
        try {
            //used to send the spring email in html format
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);

            content = content.replace("[[name]]", users.getFirstName()+users.getSecondName());
            String verifyURL = siteURL + "/verify?code=" + users.getVerificationCode();
            content = content.replace("[[URL]]", verifyURL);

            helper.setText(content, true);
            mailSender.send(message);
        }
       catch (MailSendException e){
           System.out.println(" system failure");
       }


    }


}
