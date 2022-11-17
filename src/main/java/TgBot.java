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
            //sendText если сообщение является командой /start
            Message msg = update.getMessage();
            User user = msg.getFrom();
            String message = "Привет " + user.getFirstName() + "! Как Ваши дела?";
            if(msg.getText().equals("/start")) {
                sendText(msg.getChatId(), message);
            }
        }

        //Метод для отправки сообщения, в качестве параметров передаётся ID отправителя
        //И сообщение которое необходимо отправить
        public void sendText(Long who, String what){
            SendMessage sm = SendMessage.builder()
                    .chatId(who.toString())
                    .text(what).build();
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        public static void main(String[] args) throws TelegramApiException {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            TgBot bot = new TgBot();
            botsApi.registerBot(bot);
        }
    }
