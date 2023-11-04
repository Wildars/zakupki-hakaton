//package com.example.zakupkihakaton.bot;
//
//import com.example.zakupkihakaton.convert.UserElement;
//import com.example.zakupkihakaton.repository.UserRepository;
//import com.example.zakupkihakaton.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Value;
//import org.telegram.telegrambots.meta.TelegramBotsApi;
//
//import java.util.List;
//
//@Component
//public class TelegramAuthenticator {
//    @Value("${telegram.bot.token}")
//    private String botToken;  // Значение токена бота из application.properties
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    UserRepository userRepository;
//
//    public TelegramAuthenticator( UserService userService, UserRepository userRepository) {
//        this.userService = userService;
//        this.userRepository = userRepository;
//    }
//
//    public List<UserElement> authenticateUser(String telegramId) {
//        // Подключение к Telegram Bot API и проверка, является ли пользователь ботом
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        List<UserElement> user = userRepository.findByTelegramId(telegramId);
//        if (user != null) {
//            return user;
//        }
//        return null;
//    }
//
//
//
//}