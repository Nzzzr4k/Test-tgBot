import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

    public class TgBot extends TelegramLongPollingBot {

        //Создание переменных с именем созданного бота и его уникального ключа
        private static final String BOT_NAME = "zxcasdbfBot";
        private static final String BOT_TOKEN = "5658132386:AAHG87TjWSms-EuaQFHIyMFata3x0xuShRY";
        @Override
        public String getBotUsername() {
            return BOT_NAME;
        }

        @Override
        public String getBotToken() {
            return BOT_TOKEN;
        }


        @Override
        public void onUpdateReceived(Update update) {
            //При отправке сообщения происходит обновление и вызов метода
            //Из обновления тянется инфа о сообщении типа текста, юзера, хуюзера и всё такое
            if (update.hasMessage()) {
                Message msg = update.getMessage();
                User user = msg.getFrom();
                //String message = "Приветственное сообщение туда-сюда, нужное потом дописать ";
                if(msg.hasText()) {
                    if (msg.getText().equals("/start")) {
                        try {
                            execute(Buttons.startButtons(msg.getChatId()));
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            //Обрабатываем CallbackQuery
            else if(update.hasCallbackQuery()){
                //SendMessage callBack2 = Buttons.servicesButtons(update.getCallbackQuery().getMessage().getChatId());
                switch(update.getCallbackQuery().getData()) {
                    case "записатьсяНаУслугу":
                        try {
                            execute(Buttons.servicesButtons(update.getCallbackQuery().getMessage().getChatId()));
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                }
                /*try {
                    execute(callBack);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }*/
            }
        }

        public static void main(String[] args) throws TelegramApiException {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            TgBot bot = new TgBot();
            botsApi.registerBot(bot);
        }
    }
