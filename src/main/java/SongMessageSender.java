import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;


public class SongMessageSender {
    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static final String songQueueName = "SONG_QUEUE";
    static ArrayList<Song> songList;

    public static void main(String[] args) throws Exception {
        System.out.println("URL: " + url);


        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(songQueueName);
        songList = new ArrayList<>();


        MessageProducer producer = session.createProducer(destination);

        Song mySong = new Song();
        mySong.setId(songList.size()+1+"");
        mySong.setSongName("Second Song");
        mySong.setAlbumName("First song Album");
        mySong.setArtistName("First song Artist");

        songList.add(mySong);

        ObjectMessage message = session.createObjectMessage(mySong);
        producer.send(message);

        System.out.println("Message: " + message.getObject() + " sent successfully to the Queue");
        connection.close();
    }
}
