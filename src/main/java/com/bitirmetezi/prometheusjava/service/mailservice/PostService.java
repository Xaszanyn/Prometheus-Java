package com.bitirmetezi.prometheusjava.service.mailservice;

public interface PostService {
    void sendEmailOnAlert(String to, String subject, String body);
}
