package com.naked.cams.chat

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ChatApplication {

    static void main(String[] args) {
        SpringApplication.run(ChatApplication, args)
    }


    @Bean
    Gson gson() {
        new GsonBuilder().create()
    }
}
