package com.example.zakupkihakaton.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
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
            } else if (messageText.equals("Связь со специалистом")) {
                sendSpecialist(chatId);
            } else if (messageText.equals("Информация о предприятиях")) {
                sendCompanyInfoMenu(chatId);
            } else if (messageText.equals("Информация о гос закупках")) {
                sendGovernmentProcurementInfo(chatId);
            } else if (messageText.equals("ОСОО")) {
                sendCompanyInfo(chatId, "Информация о ОСОО");
            } else if (messageText.equals("ИП")) {
                sendCompanyInfo(chatId, "Информация о ИП");
            } else if (messageText.equals("Назад в меню")) {
                sendStartMenu(chatId);
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
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Связь со специалистом");
        row1.add("Информация о предприятиях");
        row1.add("Информация о гос закупках");
        row1.add("Назад в меню");
        keyboard.add(row1);
        replyMarkup.setKeyboard(keyboard);
        replyMarkup.setResizeKeyboard(true);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Выберите раздел помощи:");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendSpecialist(long chatId) {
        String contactInfo = "Спасибо за обращение в службу поддержки:\n" +
                "Нащ специалист свяжется с вами в ближайшее время\n";

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(contactInfo);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendGovernmentProcurementInfo(long chatId) {
        String procurementInfo = "Информация о государственных закупках:\n" +
                "Текущие тендеры и процедуры закупок.";

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(procurementInfo);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendCompanyInfoMenu(long chatId) {
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("ОСОО");
        row1.add("ИП");
        row1.add("Назад в меню");
        keyboard.add(row1);
        replyMarkup.setKeyboard(keyboard);
        replyMarkup.setResizeKeyboard(true);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Выберите тип предприятия:");
        message.setReplyMarkup(replyMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendCompanyInfo(long chatId, String companyType) {
        String infoMessage = "Информация о предприятии (" + companyType + "):\n" +
                "Дополнительные сведения о предприятии.";

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(infoMessage);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
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
