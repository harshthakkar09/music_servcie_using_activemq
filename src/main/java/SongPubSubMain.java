import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SongPubSubMain {

    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        Thread songConsumer = new Thread(new SongTopicConsumer(connectionFactory));
        songConsumer.start();

        Thread.sleep(1000);

        Thread songProducer = new Thread(new SongTopicProducer(connectionFactory));
        songProducer.start();

    }
}
