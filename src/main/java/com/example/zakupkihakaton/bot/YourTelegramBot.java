package com.example.zakupkihakaton.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class YourTelegramBot extends TelegramLongPollingBot {

    @Autowired
    private TelegramAuthenticator telegramAuthenticator;
    // Другие сервисы и компоненты, необходимые для обработки команд

    public YourTelegramBot(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    @Override
    public String getBotUsername() {
        return "YourBotUsername";
    }

    @Override
    public String getBotToken() {
        return "YourBotToken";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Здесь вы можете обрабатывать входящие сообщения и команды от пользователей
        // Используйте сервис TelegramAuthenticator для аутентификации пользователей
        // Реализуйте логику обработки команд "влево" и "вправо"
    }
}
