package com.epam.TestNG.jaxb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class JAXBExample {

    private static final Logger LOG = LogManager.getLogger(JAXBExample.class.getName());

    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        cookie.setId(1);
        cookie.setName("cookie");

        try {
            File file = new File("target\\cookie.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Cookie.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(cookie, file);
            jaxbMarshaller.marshal(cookie, System.out);

        } catch (JAXBException e) {
            LOG.error("JAXB error occured", e);
        }
    }
}
