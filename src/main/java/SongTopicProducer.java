import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Random;

public class SongTopicProducer implements Runnable{
    ActiveMQConnectionFactory connectionFactory = null;
    public static final String songTopic = "Song Topic";

    public SongTopicProducer(ActiveMQConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void run() {
        try{
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic(songTopic);

            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            Song mySong = new Song();
            mySong.setId(new Random().nextInt(100) +"");
            mySong.setSongName("Second Song");
            mySong.setAlbumName("First song Album");
            mySong.setArtistName("First song Artist");

            ObjectMessage message = session.createObjectMessage(mySong);

            producer.send(message);

            System.out.println("Producer has sent the message: " + mySong);

            session.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
