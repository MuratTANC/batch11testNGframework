package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

    //bu dosyanın ana vazifesi configration.properties dosyasını okumaktır.
public class ConfigReader {

    // ilk yapacagimiz sey instance olarak properties objesi olusturmak
    // bu objeyi static blok icerisinde de kullanacagimdan static yapmam gerekiyor
    // bu objeyi sadece bu classda kullanacagim icin private yapmamiz onerilir.

    static private Properties properties;
    //okuyacağım dosya .properties diye bitiyor bu yüzden properties objesi oluşturmmam lazım
    //static blokla oluşturacağız. çünkü program çalıştığında ilk olarak static blok çalışır
    // bu yüzden static Properties properties; yapıyoruz.
    //sadece bu dosyada kullanılacağı için private de yapıyoruz.

    static {            //programı çalıştırdığımda ilk önce statik blok çalışır
        //string path tanımlıyoruz
        String path="configuration.properties";
        //bu path -->  FileInputStream(path); e yazıyoruz

        try {
            //dosyayı okumak için FileInput Stream objesini oluşturuyoruz.
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);  //okuma komutu
            fileInputStream.close();            //kapatmak için

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //ben metoda key yollayacağım oda bana o key'in değerini yollayacak
        //String olduğu için string ile yaptık
    public static String getProperty(String key) {
        return properties.getProperty(key);

        //ben string yolluyorum
        //oda bana key yollayacak
    }
}