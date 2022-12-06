import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Buttons {
    public static SendMessage startButtons(long chatId){//Метод выводящий стартовые кнопки
        String startMessage = "Это приветственное сообщение, потом здесь будет ещё какая-то картинка," +
                " но пока я не научился её вставлять";

        //Дальше идут кнопки
        //Кнопка "Записаться"
        InlineKeyboardButton buttonRecord = InlineKeyboardButton.builder()
                .text("Записаться на услугу")
                .callbackData("записатьсяНаУслугу")
                .build();

        //Кнопка "Оставить отзыв"
        InlineKeyboardButton buttonFeedback = InlineKeyboardButton.builder()
                .text("Оставть отзыв")
                .callbackData("оставитьОтзыв")
                .build();

        //Кнопка "О Нас"
        InlineKeyboardButton buttonAboutUs = InlineKeyboardButton.builder()
                .text("О Нас")
                .callbackData("оНас")
                .build();

        //Кнопка "Наши Мастера"
        InlineKeyboardButton buttonOurMasters = InlineKeyboardButton.builder()
                .text("Наши мастера")
                .callbackData("нашиМастера")
                .build();

        //Создаём объект разметки клавиатуры
        InlineKeyboardMarkup inlineKeyboardMarkup1 = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(buttonRecord, buttonFeedback))//Первый ряд кнопок
                .keyboardRow(List.of(buttonAboutUs, buttonOurMasters))//Второй ряд кнопок
                .build();

        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(startMessage)
                .replyMarkup(inlineKeyboardMarkup1)
                .build();
        return message;
    }

    //Метод выводящий список услуг
    public static SendMessage servicesButtons(long chatId){
        String servicesMessage = "Здесь вы можете выбрать интересующую услугу";

        //Кнопка "Записаться"
        InlineKeyboardButton buttonService1 = InlineKeyboardButton.builder()
                .text("Услуга 1")
                .callbackData("услуга1")
                .build();

        //Кнопка "Оставить отзыв"
        InlineKeyboardButton buttonService2 = InlineKeyboardButton.builder()
                .text("Услуга 2")
                .callbackData("услуга2")
                .build();

        //Кнопка "О Нас"
        InlineKeyboardButton buttonService3 = InlineKeyboardButton.builder()
                .text("Услуга 3")
                .callbackData("услуга3")
                .build();

        InlineKeyboardButton buttonGoBack = InlineKeyboardButton.builder()
                .text("Назад")
                .callbackData("назад")
                .build();

        //Создаём объект разметки клавиатуры
        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(buttonService1, buttonService2, buttonService3))
                .keyboardRow(List.of(buttonGoBack))
                .build();


        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(servicesMessage)
                .replyMarkup(inlineKeyboardMarkup)
                .build();
        return message;
    }
}
