import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.LocalDate;
import java.util.Properties;

public class Producer {
    private KafkaProducer<String, String> producer;
    private ProducerRecord record;
    public Producer() {
        // Criar as propriedades do produtor
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Criar o produtor
        producer = new KafkaProducer<String, String>(properties);
    }
    public void ProducerSendMessage(String topic, Tweet tweet){
        // Enviar as mensagens


        record = new ProducerRecord<String, String>(topic, tweet.getMessage());
        producer.send(record); // Envio assíncrono
    }
    public void ProducerClose() {
        producer.close();
    }
}
