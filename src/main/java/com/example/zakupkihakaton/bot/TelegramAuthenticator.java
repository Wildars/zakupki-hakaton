package com.example.zakupkihakaton.bot;

import com.example.zakupkihakaton.convert.UserElement;
import com.example.zakupkihakaton.repository.UserRepository;
import com.example.zakupkihakaton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import java.util.List;

@Component
public class TelegramAuthenticator {
    @Value("${telegram.bot.token}")
    private String botToken;  // Значение токена бота из application.properties

    @Autowired
    private UserService userService;

    UserRepository userRepository;

    public List<UserElement> authenticateUser(String telegramId) {
        // Подключение к Telegram Bot API и проверка, является ли пользователь ботом
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        List<UserElement> user = userService.findByTelegramId(telegramId);
//        if (user != null) {
//            return user;
//        }
        return null;
    }


    public UserElement registerUser(String telegramId, String username) {
        UserElement user = userRepository.findByTelegramId(telegramId);
        if (user == null) {
            user = new UserElement();
            user.setTelegramId(telegramId);
            user.setUsername(username);
//            userRepository.save(user);
        }
        return user;
    }
}