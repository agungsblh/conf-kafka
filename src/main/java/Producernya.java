import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Producernya {

    public static void main(String[] args) throws IOException {
            final Properties props = loadConfig("client.properties");

            Producer<String, String> producer = new KafkaProducer<>(props);
            producer.send(new ProducerRecord<>("confluent_tugas_sbd", "halooo", "apa ini"));
            producer.close();
    }
    public static Properties loadConfig(final String configFile) throws IOException {
        if (!Files.exists(Paths.get(configFile))) {
            throw new IOException(configFile + " not found.");
        }
        final Properties cfg = new Properties();
        try (InputStream inputStream = new FileInputStream(configFile)) {
            cfg.load(inputStream);
        }
        return cfg;
    }




}
