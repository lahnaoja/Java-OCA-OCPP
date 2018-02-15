package eu.chargetime.ocpp;

/*
    This is pretty printer for the SOAP xml messages.
    Used to log SOAP message content in a bit more readable form, could be better.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            Source sc = soapMessage.getSOAPPart().getContent();
            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            tf.transform(sc, result);

            return result.getWriter().toString();
        } catch (Exception e) {
            logger.warn("Exception in getSOAPMessageAsString " + e.getMessage());
            return null;
        }

    }
}

