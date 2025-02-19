//This is a script to set encoded values to properties before using them in a request for the url-encoded message.


import java.util.Properties;
import java.io.InputStream;
import java.net.URLEncoder;

String stringToEncode = ''
String encodedString = ''

for( int i = 0; i < dataContext.getDataCount(); i++ )
{
InputStream is = dataContext.getStream(i);
Properties props = dataContext.getProperties(i);

clientId  = props.getProperty("document.dynamic.userdefined.DDP_clientID");
clientSecret  = props.getProperty("document.dynamic.userdefined.DDP_clientSecret");
userName  = props.getProperty("document.dynamic.userdefined.DDP_userName");
password  = props.getProperty("document.dynamic.userdefined.DDP_password");

encoded_clientId = URLEncoder.encode(clientId, "UTF-8")
encoded_clientSecret = URLEncoder.encode(clientSecret, "UTF-8")
encoded_userName = URLEncoder.encode(userName, "UTF-8")
encoded_password= URLEncoder.encode(password, "UTF-8")

props.setProperty("document.dynamic.userdefined.DDP_clientID", encoded_clientId);
props.setProperty("document.dynamic.userdefined.DDP_clientSecret", encoded_clientSecret);
props.setProperty("document.dynamic.userdefined.DDP_userName", encoded_userName);
props.setProperty("document.dynamic.userdefined.DDP_password", encoded_password);

dataContext.storeStream(is, props);
}