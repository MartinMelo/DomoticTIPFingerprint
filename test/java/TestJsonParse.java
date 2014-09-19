import junit.framework.Assert;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by Martin Alejandro Melo
 * DATE: 19/09/14.
 * Para testear el parseo de string a Json.
 * No que funcione la libreria, si no como funciona y como tienen que ser los string.
 */
public class TestJsonParse {

    @Test
    public void parsearStringVacio(){
        String vacio= "{}";
        JSONObject json = new JSONObject(vacio);
        Assert.assertEquals(json.toString(), vacio );
    }
    @Test
    public void parsearStringConUnaEntradaYObtenerla(){
        String vacio= "{nombre: tyno}";
        JSONObject json = new JSONObject(vacio);
        Assert.assertEquals(json.get("nombre"), "tyno" );
    }
    @Test
    public void crearJsonVacio(){
        JSONObject json = new JSONObject();
        Assert.assertEquals(json.toString(), "{}");
    }
    @Test
    public void crearJsonVacioYVerificarCantidadDeEntradasSeaIgualACero(){
        JSONObject json = new JSONObject();
        Assert.assertTrue(json.keySet().size() == 0);
    }
    @Test
    public void agregarDatosYVerificarQueAlExtrarSeaElMismo(){
        JSONObject json = new JSONObject();
        json.put("nombre" , "tyno");
        Assert.assertEquals(json.get("nombre") ,  "tyno");
    }
    @Test
    public void agregarDatosYVerificarQueLaCantidadDeEntradasSeaUno(){
        JSONObject json = new JSONObject();
        json.put("nombre" , "tyno");
        Assert.assertTrue(json.keySet().size() == 1);
    }
}
