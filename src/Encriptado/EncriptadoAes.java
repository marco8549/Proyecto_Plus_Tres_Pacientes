/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptado;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Marco Antonio
 */
public class EncriptadoAes {
    private static final String CLAVE = "MiClaveSecreta123"; 

    private static SecretKeySpec getKey() throws Exception {
        byte[] keyBytes = CLAVE.getBytes("UTF-8");
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static String encriptar(String textoPlano) throws Exception {
        SecretKeySpec secretKey = getKey();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encriptado = cipher.doFinal(textoPlano.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encriptado);
    }

    public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec secretKey = getKey();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodificado = Base64.getDecoder().decode(textoEncriptado);
        byte[] desencriptado = cipher.doFinal(decodificado);
        return new String(desencriptado, "UTF-8");
    }
}
