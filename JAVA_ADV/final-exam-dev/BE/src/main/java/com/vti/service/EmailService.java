package com.vti.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
//    @Autowired
//    private MessageProperty messageProperty;
//
//    @Autowired
//    private ServerProperty serverProperty;

    @Override
    public void sendResetPassword(String email, String token) {

    }
}
