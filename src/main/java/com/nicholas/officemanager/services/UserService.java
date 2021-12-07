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
    public static  final int MAX_FAILED_ATTEMPTS = 3;
    private static  final  long LOCK_TIME_DURATION = 24 * 60 * 1000;//24 hours

    @Autowired
    private UsersRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;

    public Users register(Users users) throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(users.getEmpPassword());
        users.setEmpPassword(encodedPassword);

            //implementing code to generate random codes... we use RandomString provided by the bytebuddy.utility
        try{
            String randomCode = RandomString.make(64);
            users.setVerificationCode(randomCode);
            users.setEnabled(false);
        }catch (Exception exception){
            System.out.println("code not generated");
        }
            return  repo.save(users);
    }
    public void sendVerificationEmail(Users users, String siteURL) throws  MessagingException, UnsupportedEncodingException{
        String toAddress = users.getEmployee_email();
        String fromAddress = "codedspringboot@gmail.com";
        String subject = "Please Verify your registration";
        String senderName = "Seasoned Developer";
        String mailContent = "<p> Dear" + users.getFirstName()+ ",</p>";
        mailContent += "<p> please click the link below to verify your registration: </p>";

        String verifyURL = siteURL + "/verify?code=" + users.getVerificationCode();

        mailContent +="<h3><a href=\" "+ verifyURL+ "target=\"_self\"> VERIFY </a></h3>";
        mailContent +="<p>Thank you,<br> Seasoned Developer</p>";

            //create a MimeMessage for you to send the spring email in html format
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
            helper.setText(mailContent, true);
            //error
            mailSender.send(message);
    }
    //userVerification from their unique codes
    public  boolean verify(String verificationCode){
//        Users users = repo.findByVerificationCode(verificationCode);
        return true;
    }


}
