package com.example.zakupkihakaton.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class YourTelegramBot extends TelegramLongPollingBot {

    final BotConfig botConfig;

    public YourTelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                sendStartMenu(chatId);
            } else if (messageText.equals("Войти")) {
                sendLoginPrompt(chatId);
            } else if (messageText.equals("Зарегистрироваться")) {
                sendRegistrationLink(chatId);
            } else if (messageText.equals("Помощь")) {
                sendHelpMessage(chatId);
            } else {
                sendMessage(chatId, "Извините, я не понял ваш запрос.");
            }
        }
    }

    private void sendStartMenu(Long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Войти");
        row1.add("Зарегистрироваться");
        row1.add("Помощь");
        keyboard.add(row1);
        replyMarkup.setKeyboard(keyboard);
        replyMarkup.setResizeKeyboard(true);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Выберите действие:");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendLoginPrompt(Long chatId) {
        // Здесь вы можете реализовать логику для ввода логина и пароля
        // и взятия данных из вашей базы данных.
        // Пример:
        sendMessage(chatId, "Введите логин:");
    }

    private void sendRegistrationLink(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Для регистрации перейдите по ссылке: https://www.ts.kg/");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendHelpMessage(Long chatId) {
        // Здесь вы можете отправить текст с помощью информацией
        // sendMessage(chatId, "Ваш текст с информацией о помощи.");
    }

    private void sendMessage(Long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
