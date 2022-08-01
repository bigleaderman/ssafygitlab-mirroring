package com.ssafy.mafia.auth.service;


import com.ssafy.mafia.Entity.User;
import com.ssafy.mafia.auth.util.SecurityUtil;
import com.ssafy.mafia.auth.util.makeSecretnumberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EntityManager em;
    private final JavaMailSender mailSender;


    public void sendEmail() throws  Exception {
        int num = Integer.parseInt(makeSecretnumberUtil.numberGen(6,1));
        User user = em.find(User.class, SecurityUtil.getCurrentUserId());
        user.setEmailCode(num);

        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mail, true, "UTF-8");
            mimeMessageHelper.setFrom("socialable@naver.com");
            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setSubject("[ICEWATER 커뮤니티 이메일 인증메일 입니다.]");
            mimeMessageHelper.setText("<h1>메일인증</h1>" +
                    "<br/>모두의싸피에 회원가입해주셔서 감사합니다."+
                    "<br/>아래 [이메일 인증 확인]을 눌러주세요."+
                    "<br/><a href= http://localhost:8080/user/validationUser/" + user.getUserSeq() +
                    "/" + num +
                    ">이메일인증</a>" +
                    "<br/>감사합니다", true);
            mailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}