package eu.chargetime.ocpp;

/*
    This class is pretty printer for the SOAP xml messages.
    Used to log SOAP message content in a bit more readable form, could be better though
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;


public class PrettyHelper {
    private static final Logger logger = LogManager.getLogger(PrettyHelper.class);

    public static String getSOAPMessageAsString(SOAPMessage soapMessage) {
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();

            // Set formatting
            //tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            //tf.setOutputProperty(OutputKeys.METHOD, "xml");
            //tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            Source sc = soapMessage.getSOAPPart().getContent();
            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            tf.transform(sc, result);
            return result.getWriter().toString();
        } catch (Exception e) {
            logger.warn("Error when making xml string " + e.getMessage());
            return "Error when making xml string";
        }
    }

    public static String getSOAPMessageAsRow(SOAPMessage soapMessage) {
        /*
            Another version about pretty printer, shorter but not better...
         */
        try {
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            soapMessage.writeTo(s);
            return s.toString();
        } catch (Exception ex) {
            logger.warn("Error converting to String ", ex);
            return "Error converting to String";
        }
    }

}
