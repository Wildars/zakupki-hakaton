package com.example.zakupkihakaton.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

@Configuration
@Slf4j
public class BotConfig {

    @Value("${telegram.bot.username}")
    private String botUsername;  // Имя вашего бота
    @Value("${telegram.bot.token}")
    private String botToken;     // Токен вашего бота

    @Bean
    public DefaultBotOptions botOptions() {
        DefaultBotOptions botOptions = new DefaultBotOptions();
        // Здесь вы можете настроить параметры вашего бота, если это необходимо
        return botOptions;
    }

    @Bean
    public LongPollingBot yourTelegramBot() {
        return new YourTelegramBot(botOptions());
    }

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(yourTelegramBot());
        } catch (TelegramApiRequestException e) {
            log.error(e.getMessage(), e);
        }
        return telegramBotsApi;
    }
}