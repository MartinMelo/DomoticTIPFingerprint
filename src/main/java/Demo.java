import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import static java.lang.Thread.sleep;

/**
 * Created by Martin Alejandro Melo
 * DATE: 20/09/14.
 * Prueba de registro, llegada y partida. Con datos genericos.
 */
public class Demo {
    private String topic= "empleados/huella/";
    private String broker       = "tcp://localhost:1883";
    private final MqttClient client;


    public Demo() throws MqttException {
        client = new MqttClient(broker, "Demo Fingerprint");
        client.connect();
    }
    public void llegada() throws MqttException {
        JSONObject json = new JSONObject();
        json.put("huella", "sdhsadfhmoksdgjaspodyiahpshj");
        //Creo un mensaje.
        MqttMessage message = new MqttMessage();
        //Setteo el contenido del mensaje.
        message.setPayload(json.toString().getBytes());
        //Publico el mensaje.
        client.publish(topic+"llegada", message);
    }
    public void partida() throws MqttException {
        JSONObject json = new JSONObject();
        json.put("huella", "sdhsadfhmoksdgjaspodyiahpshj");
        //Creo un mensaje.
        MqttMessage message = new MqttMessage();

        //Setteo el contenido del mensaje.
        message.setPayload(json.toString().getBytes());
        //Publico el mensaje.
        client.publish(topic + "partida", message);
    }
    public void registrarEmpleadoConHuella() throws MqttException {
        //Creo los datos truchos del empleado en un json.
        JSONObject json = new JSONObject();
        json.put("nombre", "Martin");
        json.put("telefono", "12345678");
        json.put("huella", "sdhsadfhmoksdgjaspodyiahpshj");
        //Creo un mensaje.
        MqttMessage message = new MqttMessage();
        //Setteo el contenido del mensaje.
        message.setPayload(json.toString().getBytes());
        //Publico el mensaje.
        client.publish(topic + "resgistrar", message);
    }

    /**
     * Desconectarse del broker.
     */
    public void desconectar(){
        try {
            this.client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MqttException, InterruptedException {
        Demo demo = new Demo();
        demo.registrarEmpleadoConHuella();
        sleep(1000);
        demo.llegada();
        sleep(1000);
        demo.partida();
        sleep(1000);
        demo.desconectar();
    }
}
