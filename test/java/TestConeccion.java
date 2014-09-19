import junit.framework.Assert;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

/**
 * Created by Martin Alejandro Melo
 * DATE: 19/09/14.
 * Estos test se tienen que realizar unicamente con el broker online. Ya que se tiene que conectar al mismo.
 */

public class TestConeccion {

    @Test
    public void testearQueConecte() throws MqttException {
        //URL del broker.
        String broker       = "tcp://localhost:1883";
        //Creo el cliente con la direccion y el puerto donde se encuentra el Broker que escucha los mensajes.
        MqttClient client= new MqttClient(broker, "TestQueConecte");
        //Me conecto.
        client.connect();
        //Verifico que conecte.
        Boolean conecto = client.isConnected();
        //Desconecto.
        client.disconnect();
        //Valido.
        Assert.assertTrue(conecto);
    }
    @Test
    public void testearQueEnviaYPublica() throws MqttException {
        String topic        = "resp/ard1/ambiente/temp";
        String content      = "22";
        String broker       = "tcp://localhost:1883";
        //Creo el cliente con la direccion y el puerto donde se encuentra el Broker que escucha los mensajes.
        MqttClient client= new MqttClient(broker, "TestQueConecteYPublique");
        //Me conecto.
        client.connect();

        //Creo un mensaje.
        MqttMessage message = new MqttMessage();
        //Setteo el contenido del mensaje(Payload es el mensaje).
        message.setPayload(content.getBytes());
        //Publico el mensaje en el topico que quiero que reciba el mensaje.
        client.publish(topic, message);
        //me desconecto, esto ultimo  no es necesario.
        client.disconnect();
        Assert.assertTrue(true);
    }
}
